package lab02;

public class TimingExperiment04 {

  public static void main(String[] args) {
    long lastTime = System.nanoTime();
    int advanceCount = 0;
    long[] advanceAmounts = new long[100];
    while (advanceCount < 100) {
      long currentTime = System.nanoTime();
      if (currentTime == lastTime)
        continue;
      advanceAmounts[advanceCount++] = currentTime - lastTime;
      lastTime = currentTime;
    }

    long avg = 0;
    for (int i = 0; i < 100; i++){
      System.out.println("Time advanced " + advanceAmounts[i] + " nanoseconds.");
      avg += advanceAmounts[i];
    }
    avg /= 100;
    System.out.println(avg);
    long devi = 0;
    for( long el: advanceAmounts ){
      devi += Math.abs(el-avg);
    }
    devi /= advanceAmounts.length;
    System.out.println(devi);
  }
}
