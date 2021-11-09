package jdbc;

import java.sql.SQLException;

/**
 * @author zyx
 */
public class JdbcTest {
    public static void main(String[] args) throws SQLException {
        JdbcDemo jdbc = new JdbcDemo();
        jdbc.dmlExecutor("insert into tbl_test1(StudentName,ClassNumber) values('abc',6)");

        jdbc.close();
    }
}
