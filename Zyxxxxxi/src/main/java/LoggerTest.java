import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author zyx
 */
public class LoggerTest {
    private static final Logger logger = Logger.getLogger("abc");
    private static final List<Thread> threadList = new ArrayList<>();

    @BeforeClass
    public static void init() {
        logger.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        for (int i = 0; i < 100; i++) {
            threadList.add(new Thread(() -> logger.info(Thread.currentThread().getName() + "=========Logger=======")));
        }
    }

    @Test
    public void loggerTest() {
        for (Thread t : threadList) {
            t.start();
        }
    }
}
