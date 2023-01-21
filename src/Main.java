
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Phase1 phase1 = new Phase1();

        Thread t1 = new Thread(() -> {
            try {
                phase1.add(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                phase1.sub(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                phase1.div(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                phase1.mul(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread show = new Thread(() -> {
            try {
                phase1.show();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.sleep(1000);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        show.start();

    }


}
