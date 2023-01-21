public class Phase1 {

    double num = 0.0;
    Semaphore s = new Semaphore();

    void add(int value) throws InterruptedException {

        double tmp = 0.0;

        while (true) {
            s.semWait("add");
            System.out.println("add");
            num += value;
            tmp = num;
            Thread.sleep(1000);
            if (num != tmp) {
                System.out.println("conflict");
            }
            s.semSignal();
        }

    }

    void sub(int value) throws InterruptedException {

        double tmp = 0.0;

        while (true) {
            s.semWait("sub");
            System.out.println("sub");
            num -= value;
            tmp = num;
            Thread.sleep(1500);
            if (num != tmp) {
                System.out.println("conflict");
            }
            s.semSignal();
        }

    }

    void div(int value) throws InterruptedException {

        double tmp = 0.0;

        while (true) {
            s.semWait("div");
            System.out.println("div");
            num /= value;
            tmp = num;
            Thread.sleep(2000);
            if (num != tmp) {
                System.out.println("conflict");
            }
            s.semSignal();
        }

    }

    void mul(int value) throws InterruptedException {

        double tmp = 0.0;

        while (true) {
            s.semWait("mul");
            System.out.println("mul");
            num *= value;
            tmp = num;
            Thread.sleep(3000);
            if (num != tmp) {
                System.out.println("conflict");
            }
            s.semSignal();
        }

    }

    void show() throws InterruptedException {
        while (true) {
            Thread.sleep(500);
            System.out.println("num: " + num);
            System.out.println(s.toString());
        }
    }

}
