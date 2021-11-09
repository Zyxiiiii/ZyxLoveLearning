package aop.jdk_proxy;

import java.lang.reflect.Proxy;

/**
 * @author zyx
 */
public class ProxyTest {
    public static void main(String[] args) {
        // 目标对象
        Target target = new Target();

        // 增强对象
        Enhance enhance = new Enhance();

        TargetInterface targetProxy = (TargetInterface) Proxy.newProxyInstance(
                // target对象的类加载器
                target.getClass().getClassLoader(),
                // target对象的接口数组
                target.getClass().getInterfaces(),
                // target对象的InvocationHandler
                (proxy, method, args1) -> {
                    // 前置增强
                    enhance.beforeEnhance();
                    // 调用函数
                    Object invoke = method.invoke(target, args1);
                    // 后置增强
                    enhance.afterEnhance();
                    return invoke;
                });
        targetProxy.save();
    }
}
