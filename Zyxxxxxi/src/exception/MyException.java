package exception;

/**
 * @author zyx
 */
public class MyException extends Exception {
    private String s;
    /*通过Ctrl+B翻阅Exception构造器和Throwable的getMessage方法可知，
     * MyException方法的字符串参数一直传到Throwable的getMessage方法中，
     * 最后在toString方法中输出异常信息*/

    public MyException(String s) {
        super("MyException被调用了");
        this.s = s;
    }


    @Override
    public String toString() {
        return s + "," + this.getMessage();
    }
}
