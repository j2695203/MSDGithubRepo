public class Main {

    static void sayHello() throws InterruptedException {
        // Create an array of threads (start with 10 or so).
        Thread[] threads = new Thread[10];

        for( int i = 0; i < threads.length; i++ ){
            // Set each thread to run a function that counts to 100, print
            Thread myThread = new Thread( new Runnable() {
                int count = 0;
                @Override
                public void run() {
                    while( count < 100 ){
                        System.out.println("hello number " + count++ + " from thread number " + Thread.currentThread().threadId() );
                    }
                }
            });
            threads[i] = myThread;
        }

        // Start all the threads in your array.
        // Join all the threads in your array.
        for( int i = 0; i < threads.length; i++ ){
            threads[i].start();
            threads[i].join();
        }

    }
    public static void main(String[] args) throws InterruptedException {
//        sayHello();
        badSum();
    }

    static int answer;
    static void badSum() throws InterruptedException {
        answer = 0;
        int maxValue = 40000;
        int numThreads = 10;
        Thread[] threads = new Thread[numThreads];
        for( int i = 0; i < threads.length; i++ ){
            final int finalI = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for( int j = finalI * maxValue / numThreads; j < Math.min((finalI+1)*maxValue/numThreads, maxValue); j++ ){
                        answer += j;
                    }
                }
            });
            threads[i] = thread;
            threads[i].start();
//            threads[i].join(); // if it doesn't put join here, it will interfere each other

        }
        for( int i = 0; i < threads.length; i++ ){
            threads[i].join();
        }
        System.out.println( "thread answer:" + answer);
        System.out.println( "correct answer: " + (maxValue * (maxValue - 1) / 2) );
    }

}
