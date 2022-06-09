[TOC]

# 日志框架

- 在开发的过程中，我们免不了要对项目的一些操作、或是用户的操作进行一些日志记录，这时候我们就需要一些日志框架来简化我们的操作
- 常用的日志框架有`slf4j`、`log4j2`、`logback`，其中`slf4j`与其他两个不太一样，下面就讲讲他们有啥不同

## slf4j

- `slf4j`对自己的日志框架内容只提供了简单的实现，并没有很强大的日志功能，但它强大的点在于它是一个简单的**`Java`日志门面**，所有第三方的日志框架都可以通过实现它的`API`来完成自己各自的功能，这样程序员们写的内容只是对`slf4j`的接口进行了操作，而实现交给了其他框架，减少了程序员的学习成本
- 此外，`slf4j`还提供了桥接的技术，它可以将老项目中功能较少较旧的日志框架屏蔽，转而使用更新更强大的日志框架，提高了日志框架后期迭代需要的成本

### 日志绑定

- 由于该框架只作为一个日志门面，通常来说我们不会去使用它，所以我们需要将相应的日志框架绑定到`slf4j`上，再由`slf4j`来完成调用

- `slf4j`的日志绑定非常简单，只要导入了`slf4j`和相应的日志框架的坐标即可，`slf4j`会自动将框架绑定，同时`slf4j`也提供了一个简单的实现，但通常我们不会去使用它

  例：

  ```xml
  <!-- slf4j -->
  <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>${slf4j}</version>
  </dependency>
  <!-- logback -->
  <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>${logback}</version>
  </dependency>
  
  <!-- 这样就绑定完成了 -->
  ```
  
  Tips：在导入时不要导入多个实现框架，否则`slf4j`会自动将第一个框架绑定到`slf4j`上

### 桥接器

- 桥接器是用来将不同框架的日志记录统一给`slf4j`的一个技术，下面是桥接器的简单使用

- 使用桥接器不需要做过多的操作，只需要将不同日志框架的桥接器的坐标导入即可，桥接器的命名一般为`<旧框架名-over-slf4j>`

  例：

  ```xml
  <!-- 在做了以下操作以后，slf4j就会自动屏蔽log4j，并将日志内容交给新的框架进行输出 -->
  <dependency>
  	<groupId>org.slf4j</groupId>
      <artifactId>log4j-over-slf4j</artifactId>
      <version>${log4j}</version>
  </dependency>
  ```

  Tips：桥接器和适配器不允许同时引入，否则会构成死循环，导致栈内存溢出

## logback

- `logback`是针对`log4j`优化后的一个日志框架，它通过配置文件的方式方便的可以实现许多功能

### logback的配置文件

- `logback`的配置文件以`xml`的形式存储信息，具体内容如下：

  ```xml
  <!-- logback的配置文件 -->
  <?xml version="1.0" encoding="UTF-8"?>
  <configuration>
      <!--
          自定义日志输出格式的格式占位符：
              %-5level 输出级别(-5表示对齐为5位字符)
              %d{yyyy-MM-dd HH:mm:ss.SSS} 日期(年-月-日 时-分-秒-毫秒)
              %c 类的完整名称
              %M 为方法名
              %L 为行号
              %thread 线程名称
              %m或者%msg 为信息
              %n 换行
      -->
  	<property name="pattern" value="<自定义输出的格式>"></property>
      <!-- 配置为控制台输出 -->
      <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
  	    <!-- 控制输出流对象，默认为System.out改为err -->
          <target>System.err</target>
          <!-- 日志消息格式配置 -->
          <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
          	<pattern>${pattern}</pattern>
          </encoder>
      </appender>
      <!-- 文件输出 -->
      <appender name="file" class="ch.qos.logback.core.FileAppender">
          <file>${path}ChatSystem.log</file>
          <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
              <pattern>${pattern2}</pattern>
          </encoder>
      </appender>
      <root level="ALL">
      	<appender-ref ref="console"></appender-ref>
      </root>
  </configuration>
  ```
  
  

