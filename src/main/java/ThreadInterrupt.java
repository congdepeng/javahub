
public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("in ...");
                try {
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("in ...");
            }
        });
        thread.start();
        System.out.println(thread.isAlive());
        System.out.println(thread.isDaemon());
        System.out.println(thread.isInterrupted());
        thread.interrupt();

        System.out.println("===========");
        System.out.println(thread.isAlive());
        System.out.println(thread.isDaemon());
        System.out.println(thread.isInterrupted());
    }
}
