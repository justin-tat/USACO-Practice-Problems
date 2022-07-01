package cowQueue;
import java.io.*;
import java.util.*;

public class cowQueue {
  public static void main(String[] args) {
    System.out.println("Final Time: " + cowQueueMethod());
  }

  public static int cowQueueMethod() {
    Scanner scanner;
    int length;
    PriorityQueue<Cow> entries = new PriorityQueue<>();
    try {
      scanner = new Scanner(new File("./cowQueue/cowQueue.in"));
      length = scanner.nextInt();
      scanner.nextLine();
      while(scanner.hasNextLine()) {
        String[] entry = scanner.nextLine().split(" ");
        int arrival = Integer.parseInt(entry[0]);
        int duration = Integer.parseInt(entry[1]);
        entries.add(new Cow(arrival, duration));
      }
      scanner.close();
    } catch(Exception e) {
      System.out.println("cowQueue method broke: " + e);
    }
    Cow first = entries.poll();
    int currentTime = first.arrival + first.duration;
    while(!entries.isEmpty()) {
      Cow current = entries.poll();
      if (currentTime < current.arrival) {
        currentTime = current.arrival;
      }
      currentTime += current.duration;
    }
    return currentTime;
  }
}
