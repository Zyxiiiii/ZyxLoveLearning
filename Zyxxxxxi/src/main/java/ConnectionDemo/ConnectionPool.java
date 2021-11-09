package ConnectionDemo;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author zyx
 * 自定义连接池
 * 测试高并发情况下，连接的获取和归还情况
 */
public class ConnectionPool implements DataSource {
    static final GetThread lock1 = new GetThread();
    static final GetThread lock2 = new GetThread();
    public static Connection temp = new ConnectionImplement();
    public static int connCount = 0;

    /**
     * 连接被获取的次数
     */
    public static int count = 0;
    public static int countBack = 0;
    /**
     * 连接池的最大连接数量
     */
    private static final int POOL_MAX_CAPACITY = 10;

    /**
     * 一个集合用于存放连接对象
     */
    private static final List<Connection> connectionsPool = new LinkedList<>();

    static {
        for (int i = 0; i < POOL_MAX_CAPACITY; i++) {
            connectionsPool.add(new ConnectionImplement());
            System.out.println("创建了" + ++connCount + "个连接对象");
        }
    }

    /**
     * 获取连接池中的空闲连接
     */
    public synchronized static Connection getConn() throws SQLException {
//        判断连接池是否有闲置的连接，若有，则传出这个连接
        if (connCount > 0) {
            System.out.println("连接池被获取了" + ++ConnectionPool.count + "次");
            System.out.println(connCount);
            connCount--;
            return temp;
        } else {
//        若连接池无闲置的连接，则返回空值，后期要在调用的类对空值进行处理
            return null;
        }

    }

    /**
     * 归还连接到连接池中
     */
    public synchronized static void giveBack(Connection connection) {

        if (connCount < POOL_MAX_CAPACITY) {
            connectionsPool.add(connection);
            connCount++;
            System.out.println("归还了" + ++countBack + "个连接");
            System.out.println(connCount);
        } else {
            System.out.println("连接池已满");
        }

    }

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }


    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
