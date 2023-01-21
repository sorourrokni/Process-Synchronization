import java.util.LinkedList;
import java.util.Queue;

public class Semaphore {

    int value;
    boolean []flag;
    Queue<String> queue;

    public Semaphore() {
        value = 1;
        flag = new boolean[4];
        queue = new LinkedList<>();
    }

    public void semWait(String name) {
        value--;

        if(value < 0) {
            queue.add(name);
            int id = getId(name);
            while (!flag[id]) {
                // wait
            }
        }


    }

    public void semSignal() {
        value++;

        if(value <= 0) {

        }
        String next = queue.peek();
        int id = getId(next);

        flag[id] = true;
    }

    public int getId(String name) {
        return switch (name) {
            case "add" -> 0;
            case "sub" -> 1;
            case "mul" -> 2;
            case "div" -> 3;
            default -> throw new RuntimeException();
        };
    }

}
