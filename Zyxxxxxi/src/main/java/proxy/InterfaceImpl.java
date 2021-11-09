package proxy;

/**
 * @author zyx
 */
public class InterfaceImpl implements Interface {
    @Override
    public void add() {
        System.out.println("add method is running ...");
    }

    @Override
    public void delete() {
        System.out.println("delete method is running ...");
    }
}
