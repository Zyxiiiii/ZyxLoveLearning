package oop;

/**
 * @author zyx
 */
public interface Interface1 {
    /**
     * 实现一个接口方法
     */
    public abstract void method1();



    /*jdk8新特性
     * 可见，以下三类方法都不同于普通的接口方法，它们可以具有方法体，
     * 且不需要在每一个实现类下重写方法，而是只在有需要的实现类下进行重写，
     * 而不必在新增了功能后让每一个实现类都重写一遍，这样做提高了接口的可扩展性。
     * */

    /**
     * 默认方法
     */
    default void defaultMethod() {
        /*code*/
    }

    /**
     * 静态方法
     */
    static void staticMethod() {
        /*code*/
    }

    /*私有方法是jdk9才加入的功能，由于接口中静态方法和默认方法的引入，
     * 在写方法体的时候，难免会出现重复的代码块，这个时候引入私有方法，
     * 存放方法中相同的部分，在各方法体中调用该私有方法，就可以避免代码的重复写写入
     * 所以在jdk8下无法执行*/

    /**
     * 私有方法
     */
    /*private void privateMethod() {
        /code/
    }*/
}
