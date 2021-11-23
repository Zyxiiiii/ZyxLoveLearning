# AOP的简介

* **AOP**是**A**spect **O**riented **P**rogramming（**面向切面编程**）的缩写，是通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术

  AOP是OOP的延续，是软件开发中的一个热点，也是Spring框架中的一个重要内容，是函数式编程的一种衍生范型，利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间耦合度降低，提高程序的可重用性，同时提高了开发的效率

## AOP的作用及优势

* 作用：在程序运行期间，在不修改源码的情况下对方法进行功能增强
* 优势：减少重复代码，提高开发效率，并且便于维护

## AOP的底层实现

* 实际上，AOP的底层是通过`Spring`提供的动态代理技术实现的。在运行期间，`Spring`通过动态代理技术动态地生成代理对象，代理对象方法执行时进行增强功能的接入，再去调用目标对象的方法，从而完成功能的增强
* 常用的动态代理技术
  * `JDK`代理：基于接口的动态代理技术

    利用`Proxy.newProxyInstance`动态创建代理对象

  * `cglib`代理：基于父类的动态代理技术

    利用`cglib`的`Enhancer`对象的回调并创建代理对象

    需要注意的点

    * 设置父类：`setSuperClass`
    * 设置回调：`setCallBack`
    * 创建代理对象：`enhancer.create`

## AOP的相关概念

`Spring`的`AOP`实现底层就是对以上的动态代理进行了封装，封装后我们只需要对关注的部分进行代码编写，并通过配置的方式完成指定目标的方法增强

一些`AOP`相关的常用术语：

- `Target`：代理的目标对象

- `Proxy`：一个类被`AOP`**织入增强**后，就产生一个结果代理类

- `Joinpoint`（连接点）：所谓的连接点是指哪些被拦截到的点，在`Spring`中，**这些点指的是方法**，因为`Spring`只支持方法类型的连接点

- `Pointcut`（切入点）：所谓切入点是指我们要对哪些`Joinpoint`进行拦截的定义

- `Advice`（通知/增强）：所谓通知是指拦截到`Joinpoint`之后所要做的事情就是通知

- `Aspect`（切面）：是切入点和通知（引介）的结合

- `Weaving`（织入）：是指把**增强应用到目标对象来创建新的代理对象**的过程。

  `Spring`采用**动态织入**，而`AspectJ`采用**编译期织入**和**类装载期织入**

## AOP开发的事项

### 需要编写的内容

- 核心业务代码（目标类的目标方法）
- 切面类，切面类中有**通知（增强功能方法）**
- 配置织入关系

### AOP实现的内容

`Spring`监**控切入点方法的执行**，一旦监控到切入点方法被运行，**调用代理机制，动态创建目标对象的代理对象**，根据通知类别，在代理对象的对应位置，将通知对应的功能织入，完成完整的代码逻辑运行

即`Spring`通过动态代理为我们增强方法的过程

### AOP底层使用的代理模式

`Spring`会判断是否实现了接口来决定采用哪种动态代理的方式

- 有接口则使用`JDK`的动态代理模式
- 无接口则使用`cglib`的动态代理模式

# 基于XML的AOP开发

## 快速入门

1. 导入AOP的相关坐标

   ```xml
   <!-- Spring本身的依赖坐标 -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-context</artifactId>
       <version>${spring-version}</version>
   </dependency>
   <!-- 第三方AOP框架AspectJ的依赖坐标 -->
   <dependency>
   	<groupId>org.aspectj</groupId>
       <artifactId>aspectjweaver</artifactId>
       <version>${aspectj-version}</version>
   </dependency>
   ```

2. 创建目标接口和目标类（内部有切点）

3. 创建切面类

4. 将目标类和切面类的对象创建权交给`Spring`

5. 在`applicationContext.xml`中配置织入关系

   ```xml
   <!-- AOP配置织入 -->
   <aop:config>
       <!-- 声明切面 -->
   	<aop:aspect ref="[Spring容器中的目标切面对象(id)]">
           <!-- 切面：切点 + 通知 -->
       	<aop:[增强的类型] method="[类中用于增强的具体方法]" pointcut="execution([[修饰符] 方法返回值 方法全限定名])"/>
       </aop:aspect>
   </aop:config>
   ```

   - 切点表达式的语法

     `execution([修饰符 返回值类型 包名.类名.方法名(参数列表)])`

     - 修饰符可以省略
     - 返回值类型、包名、类名、方法名可以用星号`*`表示**任意**
     - `包名.类名`：表示当前包下的某个类；`包名..`表示当前包及其子包下的类
     - 参数列表可以使用`..`表示任意

