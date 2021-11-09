package aop.cglib_proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zyx
 */
public class ProxyTest {
    public static void main(String[] args) {
        Target target = new Target();

        Enhance enhance = new Enhance();


        Enhancer enhancer = new Enhancer();
        // 设置父类(目标)
        enhancer.setSuperclass(Target.class);
        // 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                enhance.before();
                Object invoke = method.invoke(target, objects);
                enhance.after();
                return invoke;
            }
        });

        Target proxy = (Target) enhancer.create();
        proxy.save();
    }


}
