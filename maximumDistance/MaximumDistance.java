package maximumDistance;

import java.util.*;
import java.io.*;

public class MaximumDistance {
  public static void main(String[] args) {
    System.out.println(maximumDistance());
  }

  public static int maximumDistance() {
    String[] stringXCors;
    String[] stringYCors;
    int[] xCors;
    int[] yCors;
    try {
      Scanner scanner = new Scanner(new File("maximumDistance.in"));
      int length = scanner.nextInt();
      scanner.nextLine();
      xCors = new int[length];
      yCors = new int[length];
      stringXCors = scanner.nextLine().split(" ");
      stringYCors = scanner.nextLine().split(" ");
      for(int i = 0; i < stringXCors.length; i++) {
        xCors[i] = Integer.parseInt(stringXCors[i]);
        yCors[i] = Integer.parseInt(stringYCors[i]);
      }
      System.out.println(Arrays.toString(xCors));
      scanner.close();
      int max = 0;
      System.out.println("Successfully read in files");
      for(int i = 0; i < xCors.length; i++) {
        for(int j = 0; j < xCors.length; j++) {
          if(i != j) {
            int currDistance = distance(xCors[i], xCors[j], yCors[i], yCors[j]);
            if( currDistance > max) {
              max = currDistance;
            }
          }
        }
      }
      return max;
    } catch(Exception e) {
      System.out.println("Failed while reading file: " + e);
      return -1;
    }
  }

  public static int distance(int x1, int x2, int y1, int y2) {
    int length = Math.abs(x1 - x2);
    int height = Math.abs(y1 - y2);
    return length * length + height * height;
  }
}
