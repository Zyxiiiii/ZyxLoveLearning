package ConnectionDemo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyx
 */
public class ConnectionTest {
    public static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            threads.add(new GetThread());
        }
        for (int i = 0; i < 1000; i++){
            threads.get(i).start();
        }
    }

}

class GetThread extends Thread {
    public Connection connection = null;

    @Override
    public void run() {
        try {
            connection = ConnectionPool.getConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            ConnectionPool.giveBack(connection);
        }else{
            System.out.println("无");
        }
    }
}