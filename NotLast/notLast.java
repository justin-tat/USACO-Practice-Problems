package NotLast;
import java.util.*;
import java.io.*;
public class notLast {
  public static void main(String[] args) {
    System.out.println(notlast());
  }

  public static String notlast() {
    HashMap<String, Integer> milkCounts = new HashMap<>();
    try {
      	Scanner scanner = new Scanner(new File("./NotLast/notlast.in"));
      	int length = scanner.nextInt();
      	scanner.nextLine();
      	for(int i = 0; i < length; i++) {
      	  String[] entry = scanner.nextLine().split(" ");
      	  if(milkCounts.containsKey(entry[0])) {
      	    milkCounts.put(entry[0], milkCounts.get(entry[0]) + Integer.parseInt(entry[1]));
      	  } else {
      	    milkCounts.put(entry[0], Integer.parseInt(entry[1]));
      	  }
      	}
      	scanner.close();
      	int min = Integer.MAX_VALUE;
      	int lowestCount = 0;
      	String nameSecondLowest = "";
      	int secondLowest = Integer.MAX_VALUE;
      	/*please output the name of the cow whose total production is minimal among all cows that produce more than M units of milk. */
      	if (milkCounts.keySet().size() < 7) {
      	  min = 0;
      	} else {
      	  for(String name : milkCounts.keySet()) {
        	  if(milkCounts.get(name) < min) {
        	    min = milkCounts.get(name);
        	  }
      	  }
      	}
      	for(String name : milkCounts.keySet()) {
      	  int current = milkCounts.get(name);
      	  if(current > min && current < secondLowest) {
      	    secondLowest = current;
      	  }
      	}
      	for(String name : milkCounts.keySet()) {
      	  int current = milkCounts.get(name);
      	  if(current == secondLowest) {
      	    lowestCount++;
      	    nameSecondLowest = name;
      	  }
      	  if (lowestCount == 2) {
      	    return "Tie";
      	  }
      	}
      	if(lowestCount != 1) {
      	  return "Tie";
      	}
      	return nameSecondLowest;
      	//Account for missing cows. If only 6 are present, then look for the lowest milk producer, if only 5 or less are present, then return tie. Return tie if there are two who tie for the second lowest producer
      } catch(Exception e) {
        System.out.println("Program errored: " + e);
        return "";
      }
    
  }
}
