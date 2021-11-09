package exception;

/**
 * @author zyx
 */
public class ExceptionTest {
    public static void main(String[] args) throws MyException {
        throw new MyException("我的异常");
    }
}
