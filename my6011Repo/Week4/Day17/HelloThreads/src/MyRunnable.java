public class MyRunnable implements Runnable{
    int count = 0;

    @Override
    public void run() {
        while( count < 100 ){
            System.out.println("hello number " + count++ + " from thread number " + Thread.currentThread().threadId() );
        }
    }
}
