package cowQueue;

public class Cow implements Comparable<Cow>{
  public int duration;
  public int arrival;

  public Cow(int arrival, int duration) {
    this.arrival = arrival;
    this.duration = duration;
  }

  public int compareTo(Cow c) {
    if (this.arrival < c.arrival) {
      return -1;
    } else if (this.arrival > c.arrival) {
      return 1;
    } else {
      return 0;
    }
  }
  public String toString() {
    return " Arrival: " + arrival + " | Duration: " + duration;
  }
}
