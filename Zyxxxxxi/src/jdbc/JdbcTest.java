package jdbc;

/**
 * @author zyx
 */
public class JdbcTest {
    public static void main(String[] args) {
        JdbcDemo jdbc = new JdbcDemo();
        jdbc.dmlExecutor("insert into tbl_test1(StudentName,ClassNumber) values('zyx',5),('lqq',5)");
        jdbc.close();
    }
}
