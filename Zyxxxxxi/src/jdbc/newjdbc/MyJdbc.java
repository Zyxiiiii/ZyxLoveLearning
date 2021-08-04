package jdbc.newjdbc;

import java.sql.*;

/**
 * @author zyx
 */
public class MyJdbc {
    /**
     * 数据库url
     */
    private static final String URL = "jdbc:mysql://localhost:3306/mysqlTest";

    /**
     * 数据库用户名
     */
    private static final String USER = "root";

    /**
     * 数据库密码
     */
    private static final String PASSWORD = "010425";

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    private MyJdbc() {
    }

    static {
        try {
            DriverManager.getConnection(URL, USER, PASSWORD);

            // 可选：
            // connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("创建数据库连接失败");
        }
    }

    public void update(String sql, String[] args) {
        try {
            // 预编译
            preparedStatement = connection.prepareStatement(sql);

            //传参
            for (int i = 1; i < 2; i++) {
                preparedStatement.setString(i, args[i - 1]);
            }

            // 执行
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            // 回滚
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }finally {
                // 释放资源
                try {
                    connection.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

}
