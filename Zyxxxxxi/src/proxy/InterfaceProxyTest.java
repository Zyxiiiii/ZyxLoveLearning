package proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zyx
 */
public class InterfaceProxyTest implements Interface {
    @Override
    @Test
    public void add() {
        Interface impl = new InterfaceImpl();
        Interface interfaceProxy = (Interface) Proxy.newProxyInstance(impl.getClass().getClassLoader(), impl.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("invoke method is running ...");
                return method.invoke(impl, args);
            }
        });
        System.out.println();
        interfaceProxy.add();
        System.out.println("========================================");
        interfaceProxy.delete();
    }

    @Override
    public void delete() {

    }
}
