package jdbc;

/*  JDBC编程六步：
 *      1.注册驱动
 *      2.获取连接
 *      3.获取数据库操作对象
 *      4.执行SQL语句
 *      5处理查询结果集
 *      6.释放资源
 * */

import java.sql.*;



/**
 * @author zyx
 */
public class JdbcDemo {
    /**
     * 创建连接对象
     */
    private Connection connection = null;

    /**
     * 创建操作对象
     */
    private Statement statement = null;

    /**
     * 创建查询结果集
     */
    private ResultSet resultSet = null;

    /**
     * 数据库url
     */
    private static final String URL = "jdbc:mysql://192.168.3.23:3306/mysqlTest";

    /**
     * 数据库用户名
     */
    private static final String USER = "root";

    /**
     * 数据库密码
     */
    private static final String PASSWORD = "010425";

    public JdbcDemo() {
        try {
            /*注册驱动*/
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            /*获取连接*/
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            /*获取操作对象*/
            statement = connection.createStatement();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void dmlExecutor(String dml){
        try {
            statement.executeUpdate(dml);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet dqlExecutor(String dql){
        try{
            resultSet = statement.executeQuery(dql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    public void close(){
        try{
            if (resultSet != null){
                resultSet.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            if (statement != null){
                statement.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            if (connection != null){
                connection.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
