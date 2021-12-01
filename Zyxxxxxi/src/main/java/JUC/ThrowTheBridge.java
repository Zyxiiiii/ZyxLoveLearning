package JUC;

import java.util.LinkedList;
import java.util.List;

/**
 * ThrowTheBrige
 * Description:
 * You should write some description to introduce it
 *
 * @author zyx
 * 2021/12/1 16:16
 */
public class ThrowTheBridge {
    private static List<Thread> eastPeoples = new LinkedList<>();
    private static List<Thread> westPeoples = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        Bridge bridge = new Bridge(eastPeoples, westPeoples);
        for (int i = 0; i < 10; i++) {
            synchronized ("cgy") {
                System.out.println("第" + (i + 1) + "次");
                for (int j = 0; j < 20; j++) {
                    eastPeoples.add(new Thread(new People(bridge), "east" + (j + 1)));
                    westPeoples.add(new Thread(new People(bridge), "west" + (j + 1)));
                }
                for (int j = 0; j < 20; j++) {
                    eastPeoples.remove(0).start();
                    westPeoples.remove(0).start();
                    "cgy".wait();
                }
            }
        }
    }
}

class Bridge {
    List<Thread> eastPeoples;
    List<Thread> westPeoples;

    public Bridge(List<Thread> eastPeoples, List<Thread> westPeoples) {
        this.eastPeoples = new LinkedList<>(eastPeoples);
        this.westPeoples = new LinkedList<>(westPeoples);
    }

    public synchronized void throwTheBridge() throws InterruptedException {
        this.wait(300);
        System.out.print(Thread.currentThread().getName() + "正在过河, ");
    }
}

class People implements Runnable {
    private final Bridge BRIDGE;

    public People(Bridge bridge) {
        this.BRIDGE = bridge;
    }


    @Override
    public void run() {
        try {
            BRIDGE.throwTheBridge();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
