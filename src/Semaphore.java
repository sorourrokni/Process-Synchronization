import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Semaphore {

    int value;
    boolean[] flag;
    Queue<String> queue;

    public Semaphore() {
        value = 1;
        flag = new boolean[4];
        Arrays.fill(flag, false);
        queue = new LinkedList<>();
    }

    public void semWait(String name) throws InterruptedException {
        value--;

        if (value < 0) {
            queue.add(name);
            int id = getId(name);
            flag[id] = false;

            while (!flag[id]) {
                Thread.sleep(1000);
                // wait
            }
        }
    }

    public void semSignal() {
        value++;

        if (queue.isEmpty()) {
            value = 1;
        } else {
            String name = queue.poll();
            int id = getId(name);
            flag[id] = true;
        }
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

    @Override
    public String toString() {
        return "Semaphore{" +
                "value=" + value +
                ", flag=" + Arrays.toString(flag) +
                ", queue=" + queue +
                '}';
    }
}
