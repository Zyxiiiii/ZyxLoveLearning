# 概述

* **SpringMVC**：`SpringMVC`是一种基于`Java`实现的**MVC设计模型**的请求驱动类型的轻量级`Web`框架，属于`SpringFrameWork`的后续产品，已经融合在**Spring Web Flow**中
* `SpringMVC`是目前最主流的**MVC框架**之一，并且随着`Spring3.0`的发布，全面超越`Structs2`，成为最优秀的MVC框架。它通过一套注解，让一个简单的`Java`类称为处理请求的控制器，而无需实现任何接口，同时它还支持`RESTful`编程风格的请求

# SpringMVC快速入门

* 使用`SpirngMVC`的开发步骤

  1. 导入`SpringMVC`的相关坐标

  2. 配置`SpringMVC`核心控制器**`DispatcherServlet`**

  3. 创建`Controller`类和视图页面

  4. 使用注解配置`Controller`类中业务方法的映射地址

  5. 配置`SpringMVC`核心文件`spring-mvc.xml`

```xml
<!-- 在web.xml中配置SpringMVC的核心控制器 -->
<servlet>
    <servlet-name>DispatcherServlet</servlet-name>
    <servlet-class>org.springframework......DispatcherServlet</servlet-class>
    <!--  配置springMVC的核心文件  -->
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring-mvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>DispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```

# SpringMVC组件解析

* 在`SpringMVC`中，每一个功能的实现都有具体的模块或组件来完成，前端控制器只是其中的一部分
* `SpringMVC`的相关组件
  * 前端控制器：`DisapatcherServlet`
  * 处理器映射器：`HandlerMapping`
  * 处理器适配器：`HandlerAdapter`
  * 处理器：`Handler`
  * 视图解析器：`ViewResolver`
  * 视图：`View`

## SpringMVC的执行流程

1. **前端控制器`DispatcherServlet`**接收前端请求
2. 前端控制器请求查询**处理器映射器`Handler`**
3. 处理器映射器给前端控制器返回**处理器执行链`HandlerExecutionChain`**
4. 前端控制器请求执行**处理器适配器`HandlerAdapter`**
5. 处理器适配器根据处理器执行链请求**处理器`Handler`**，即我们写的`Controller`
6. 处理器响应一个**`ModelAndView`对象**并返回给前端控制器
7. 前端控制器请求**视图解析器`ViewResolver`**解析`ModelAndView`对象
8. 视图解析器解析并返回**`View`对象**
9. 最后将`view`对象渲染并响应到前端页面

## SpringMVC的XML配置解析

* `SpringMVC`有默认的组件配置，默认组件都是`DispatcherServlet.porperties`中配置的，该文件地址是`org/springframework/web/servlet/DispatcherServlet.properties`

### 视图解析器

* `SpringMVC`默认的组件配置中默认的视图解析器为

  `org.springframework.web.servlet.ViewResolver=org.springframework.web.servlet.view.InternalResourceResolver`

* 翻看该解析器源码，可以看到该解析器的默认设置，如下：

```java
REDIRECT_URL_PREFIX = "redirect:"; // 重定向前缀
FORWORD_URL_PREFIX = "forward:"; // 转发前缀（默认值）
prefix = ""; // 视图名称前缀
suffix = ""; // 视图名称后缀
```

# SpringMVC注解解析

* `MVC`命名空间引入

  * 命名空间：

    `xmlns:context="http://www.springframework.org/schema/context"`

    `xmlns:mvc="http://www.springframework.org/schema/mvc"`

  * 约束地址：

    `http://www.springframework.org/schema/context`

    `http://www.springframework.org/schema/context/spring-context.xsd`

    `http://www.springframework.org/schema/mvc`

    `http://www.springframework.org/schema/mvc/spring-mvc.xsd`

* 组件扫描

  `SpringMVC`基于`Spring`容器，所以在进行`SpringMVC`操作时，需要将`Controller`存储到`Spring`容器中，如果使用`@Controller`注解进行标注的话，就需要进行组件扫描

  组件扫描的两种`xml`文件配置格式

```xml
<!--  直接配置响应的包  -->
<context:component-scan base-package="com.xxx.controller" />

<!--  在指定的包下配置需要扫描的详细内容  -->
<context:component-scan base-package="com.xxx">
    <!--  这个include标签表明需要扫描这个包下的所有Controller注解  -->
	<context:include-filter type="annotation" expression="org.springframework......Controller" />
    <!--  这个exclude标签表明需要扫描这个包下除Controller之外的所有注解  -->
    <context:exclude-filter type="annotation" expression="org.springframework......Controller" />
</context:component-scan>
```



* `RequestMapping`

  * 作用：用于建立请求`URL`和处理请求方法之间的对应关系

  * 位置

    * 类上，请求`URL`的第一级访问目录，默认为应用的根
    * 方法上，请求`URL`的第二级访问目录，与类上的`@RequestMapping`一起组成访问虚拟路径

  * 属性

    * `value`：用于指定请求的`URL`。它和`path`属性的作用是一样的

    * `method`：用于指定请求的方式

    * `params`：用于指定限制请求参数的条件。它支持简单的表达式，要求请求参数的`key`和`value`必须和配置的一模一样

      例：

      * `params={"accountName"}`：表示请求参数中必须有`accountName`
      * `params={"money!=100"}`：表示请求参数中`money`的值不能是100
  
* `ResponseBody`

  * 作用：用于告知`SpringMVC`该方法的返回值用于直接回写数据
  * 位置：方法上，该方法的返回值就是本次请求对应的响应体数据

# SpringMVC的数据响应

## SpringMVC的数据响应方式

* 页面跳转
  * 直接返回字符串：此种方式会将返回的字符串与视图解析器的前后缀拼接后跳转

    * 前缀：`prefix`

    * 后缀：`suffix`

    * 配置视图解析器的方法：在`spring-mvc.xml`文件中用注入的方法将前后缀配置完成

        ```xml
            <!--  spring-mvc.xml  -->
            <!--  配置内部资源视图解析器  -->
            <bean id="viewResolver" class="org......InternalResourceViewResolver">
            <property name="prefix" value="/page/"></property>
            <property name="suffix" value=".html"></property>
            </bean>
        ```
    
    * 通过`ModelAndView`对象返回
  
        * `Model`：作用是封装数据
        * `View`：作用是展示数据
  
      Tips：我们可以在使用`ModelAndView`方法时将`ModelAndView`作为方法的形参，`SpringMVC`会自动的把这个对象注入到方法中去，不需要我们手动创建对象（其实，并不止局限于`ModelAndView`，包括`Model`、`web`原生的`request`对象，`SpringMVC`都可以帮助我们注入）
  
      ```java
      public ModelAndView save(ModelAndView modelAndView) {
          modelAndView.addObject("key", "value");
          return modelAndView;
      }
      ```
  
      
  
* 回写数据
  * 直接返回字符串
    * 可以通过在方法中写出我们所需要的`response`对象，让`SpringMVC`帮助我们注入，我们只需要负责调用`response`的相关方法就可以了
    * 可以直接将需要回写的字符串返回，但此时需要通过`ResponseBody`注解告知`SpringMVC`框架，方法返回的字符串不是用于跳转页面，而是直接在`http`响应体中返回
    
  * 返回对象或集合

    * 利用`spring-mvc.xml`配置文件配置处理器映射器

      1. 配置命名空间（如果是手动配置，可以不需要配置命名空间）

         ```xml
         xmlns:mvc="http://www.springframework.org/schema/mvc"
         http://www.springframework.org/schema/mvc
         http://www.springframework.org/schema/mvc/spring-mvc.xsd
         ```

         

      2. 配置处理器映射器

         1. 手动配置

            ```xml
            <!--  配置处理器映射器  -->
            <bean class="org......RequestMappingJackson2HttpMessageConverter">
                <property name="messageConverters">
                    <list>
                        <bean class="org......MappingJackson2HttpMessageConverter" />
                    </list>
                </property>
            </bean>
            ```
            
         2. 注解配置

            `<mvc:annotation-driven />`

    

# SpringMVC获得请求参数

* 客户端请求参数的数据格式是：`name=value&name=value......`

* 服务端要获得以上的请求参数，有时还需要进行数据的封装，`SpringMVC`可以接收一下数据类型

  * 基本数据类型

    `Controller`中的业务方法的参数名称要与请求参数的**name**一致，参数值会自动映射匹配

    例：

    `http....../request?username=zhangsan&age=18`

    以上请求参数在实际访问到`Controller`时，会被封装到名字相同的形参中，如下：

    ```java
    @RequestMapping("/request")
    @Responsebody
    public void request(String username, int age){
        System.out.println(username + "," + age);
        // 以上打印的结果即为zhangsan,18
    }
    ```

  * `POJO`类型参数（即简单`Java Bean`对象）

    `Controller`中的业务方法的`POJO`参数的**属性**名称与请求参数的**name**一致，参数值会自动映射匹配

    例：

    `http....../request?username=zhangsan&age=18`

    以上请求参数在实际访问到`Controller`时，会封装到形参中`bean`对象属性名相同的属性值中，如下：

    ```java
    // bean的内容
    public class User {
        private String username;
        
        private int age;
        // 重写了toString方法
        ......
    }
    // Controller
    @RequestMapping("request")
    @ResponseBody
    public void request(User user) {
    	// 打印出user的姓名和年龄
        System.out.println(user);
    }
    ```

    

  * 数组类型参数

    `Controller`中的业务方法数组名称与请求参数的**name**一致，参数值会自动映射匹配

    `http......?strs=aaa&strs=bbb&strs=ccc`

    以上请求参数在实际访问到`Controller`时，会封装到形参中形参名为`strs`的数组当中，如下： 

    ```java
    @RequestMapping("request")
    @ResponseBody
    public void request(String[] strs) {
        // 打印这个数组的内容
        System.out.println(Arrays.asList(strs));
    }
    ```

  * 集合类型参数

    * 将集合参数封装到一个`POJO`中，将请求参数注入到`POJO`的属性中

      ```java
      // 创建一个VO对象（Value/view Object：用于存放数据）
      public class VO {
          private List<User> userList;
          // get/set方法、toString方法
          ......
      }
      
      // Controller
      @RequestMapping("request")
      @ResponseBody
      public void request(VO vo) {
          System.out.println(vo);
      }
      ```

      ```html
      <!--  前端数据  -->
      <form>
          <input type="text" name="userList[0].username">
      	<input type="text" name="userList[0].age">
      	<input type="text" name="userList[1].username">
      	<input type="text" name="userList[1].age">
      	<!--  输入的数据在表单提交后会由SpringMVC自动映射到集合中对应对象的属性中  -->
      </form>
      ```

    * 当使用`ajax`提交请求时，可以指定`contentType`为`json`形式，那么在**方法参数位置**使用`@RequestBody`可以直接接收集合数据而无需使用`POJO`进行包装
    
      `js`部分代码：
    
      ```javascript
      var userList = new Array();
      userList.push({username:"zhangsan", age:18});
      userName.push({username:"lisi", age:28});
      
      $.ajax({
          type:"POST",
          url:"${pageContext.request.contextPath}/user/request",
          data:JSON.stringify(userList),
          contextType:"application/json;charset=utf-8"   
      })
      ```
    
      Tips：使用`JQuery`发送`ajax`请求时会出现映射地址错误的现象，这是因为我们配置了缺省的前端控制器，而我们访问`Jquery`文件来使用相应的`Jquery`代码时，相应的地址映射不能在`SpringMVC`前端控制器中找到匹配的路径，所以导致资源无法找到。为了能够正常访问到静态资源，那么我们就需要使用以下代码，开放静态资源的访问权限：
    
      `<mvc:resources mapping="">`
    
      或者使用：`<mvc:default-servlet-handler/>`，来让`SpringMVC`在找不到相应的静态资源时，将这个请求交由**原始容器**来处理（即`Tomcat`）

## 请求数据乱码问题

* 当`POST`请求时，数据会出现乱码，我们可以设置一个过滤器来进行全局编码的过滤

  ```xml
  <!--  web.xml  -->
  <filter>
  	<filter-name>CharacterEncodingFilter</filter-name>
      <filter-class>org......CharacterEncodingFilter</filter-class>
      <init-param>
      	<param-name>encoding</param-name>
          <param-value>UTF-8</param-value>
      </init-param>
  </filter>
  <filter-mapping>
  	<filter-name>CharacterEncodingFilter</filter-name>
      <url-pattern>/*</url-pattern>
  </filter-mapping>
  ```

## 参数绑定

* 当请求的参数名称与`Controller`的业务方法参数名称不一致时，就需要通过`@RequestParam`注解进行显示的绑定
* `@RequestParam`
  * `value`：请求参数名
  * `required`：在此指定的请求参数是否必须包括，默认是`true`，提交时如果没有此参数则报错
  * `defaultValue`：当没有指定请求参数时，则使用指定的默认值赋值

## 获取Restful风格的参数

* **Restful**是一种**软件架构风格**、**设计风格**而不是标准，只是提供了一组设计原则和约束条件。主要用于客户端和服务器交互类的软件，基于这个风格设计的软件可以更加简洁，更有层次，更易于实现缓存机制等
* **Restful**风格的请求是使用`url+请求方式`表示一次请求目的的，`HTTP`协议里四个表示操作方式的动词如下：
  * `GET`：用于获取资源

  * `POST`：用于新建资源

  * `PUT`：用于更新资源

  * `DELETE`：用于删除资源

    例如：

    * `/user/1 GET`：得到`id=1`的`user`
    * `/user/1 DELETE`：删除`id=1`的`user`
    * `/user/1 GET`：更新`id=1`的`user`
    * `/user GET`：新增`user`

    上述`url`地址中`/user/1`中的`1`就是要获得的请求参数，在`SpringMVC`中可以使用占位符进行参数绑定。地址`/url/1`可以写成`/user/{id}`，占位符`{id}`所对应的就是`1`的值，在业务方法中可以使用`@PathVariable`进行占位符的匹配获取工作

    例：

    ```java
    // 请求url：http://localhost:8080/project/request/zhangsan
    // 以上的url中的zhangsan会被SpringMVC自动赋值到下面方法的形参中
    @RequestMapping("/request/{name}")
    @ResponseBody
    public void request(@PathVariable(value = "name", required = true) String name) {
        // @PathVariable中value的值必须和占位符中的值匹配，参数才能正确赋值到形参
        System.out.println(name);
    }
    ```

## 自定义类型转换器

* `SpringMVC`默认已经提供了一些常用的类型转换器，但不是所有数据类型都提供了转换器，所以某些时候我们需要自定义类型转换器

* 自定义类型转换器的步骤

  1. 定义转换器实现`Converter`接口

     Tips：该接口有一堆泛型需要我们指定，第一个指的是转换前的数据类型，即字符串；而第二个则是转换过后我们所需要的数据类型。

     在实现`Converter`接口的`convert`方法中，我们把形参按照我们想要的逻辑转换完以后，直接作为返回值返回即可

  2. 在配置文件中**声明**转换器

  3. 在`<annotation-driven>`中引用转换器

     ```xml
     <!--  spring-mvc.xml  -->
     <bean id="conversionService" class="org......ConversionServiceFactoryBean">
     	<property>
         	<list>
                 <!--  将自定义的xxxConverter注入到SpringMVC的转换器工厂中  -->
             	<bean class="com......xxxConverter"></bean>
             </list>
         </property>
     </bean>
     <!--  在annotation-driven中引用转换器  -->
     <annotation-driven conversion-service="conversionService" />
     ```

## 获得Servlet相关API

* `SpringMVC`中获得原始的`Servlet`API对象可以直接将API作为形参，`SpringMVC`会自动的将它们注入到方法中，常用的对象如下：

  * `HttpServletRequest`
  * `HttpServletResponse`
  * `HttpSession`

  例：

  ```java
  @RequestMapping("/request")
  @ResponseBody
  public void request(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
      System.out.println(request);
      System.out.println(response);
      System.out.println(session);
  }
  ```

## 获得请求头

* 通过在形参上标注`@RequestHeader`可以直接获得请求头的信息，相当于`web`阶段学习的`request.getHeader(name)`

  `@RequestHeader`注解的属性如下

  * `value`：请求头的名称
  * `required`：是否必须携带此请求头

* 其中有个特殊的请求头叫**Cookie**，获取`Cookie`的值得的注解可以使用`@CookieValue`

  `@CookieValue`的属性如下

  * `value`：指定`Cookie`的名称
  * `required`：是否必须携带此`Cookie`

## 文件上传

* 进行文件上传有三要素

  * 表单项`type="file"`

  * 表单的提交方式为`POST`

  * 表单的`enctype`属性为多部分表单形式（`enctype="multipart/form-data"`）

    ```html
    <!--  一个简单的表单，重点在于表单属性中method和enctype的属性  -->
    <form action="/request" method="post" enctype="multipart/form-data">
        名称：<input type="text" name="name"><br/>
        文件：<input type="file" name="upload"><br/>
    	<input type="submit" name="提交"><br/>
    </form>
    ```

### 文件上传原理

* 当表单修改为多部分表单时，`request.getParameter()`将失效
* `enctype="application/x-www-form-urlencoded"`时，表单的正文内容格式是：**`key=value&key=value`**
* 当表单的`enctype`取值为`Multipart/form-data`时，请求正文内容就变成多部分形式

### 单文件上传步骤

1. 导入`fileupload`和`io`坐标

2. 配置文件上传解析器

   ```xml
   <bean id="multipartResolver" class="org......CommonsMultipartResolver">
       <!--  上传文件的总大小  -->
   	<property name="maxUploadSize" value="5242800"/>
       <!--  上传文件的单个文件大小  -->
       <property name="maxUploadSizePerFile" value="5242800"/>
       <!--  上传文件的编码类型  -->
       <property name="defaultEncoding" value="UTF-8"/>
   </bean>
   ```

3. 编写文件上传代码

   ```java
   @RequesetMapping("/request")
   @ResponseBody
   public void request(String name, MultipartFile upload) {
       /*
       	注意：形参中的变量名必须和表单中的标签名一致
       	如：表单中有<input type="file" name="upload">
       	则在服务端获取文件时，上述MultipartFile的形参变量名必须和上述标签中的name属性一致
       */
       upload.transferTo(new File("C:/upload/" + upload.getOriginalFilename));
   }
   ```

### 多文件上传

* 多文件上传基本和单文件上传一致，需要上传多个不同文件时，指定不同的名字，并用响应的形参名接收即可，但是当文件数量较多，或文件数量不一定时，我们可以通过将多个文件的名字定为同一名字，并在形参中用相同名字的`MultipartFile`**数组**来接收这些文件

## SpringMVC请求参数小结

* SpringMVC获取请求参数有4种类型
  * 基本类型参数
    * 请求参数的`key`的名称要和方法的形参名一致，SpringMVC会自动封装到变量中
  * `POJO`类型参数
    * 请求参数的`key`的名称与`POJO`实体中的属性名一致，SpringMVC会自动封装到对象中
  * 数组类型参数
    * 请求参数的名称和数组的名称一致，SpringMVC会自动封装到数组中
  * 集合类型参数
    1. 将请求参数封装到`VO`对象当中
    2. 当请求通过`ajax`方式发送时，并且`contentType`为`application/json`时，可以将集合直接封装到方法的形参位置，但此时的参数需要一个`@RequestBody`注解进行标注
* 中文乱码问题
  * 设置一个`Filter`，过滤全局编码，解决全局的乱码问题
* `@RequestParam`和`@PathVariable`
  * `@RequestParam`：当请求参数的名称和方法的形参名不一致时，可以通过这个注解指定请求参数的名称来获取请求参数
  * `@PathVariable`：当请求参数不是以`?key=value&kevalue`的形式传过来，而是直接跟在url后面时，可以通过占位符`{}`结合这个注解来获取到请求参数（*Restful风格*）