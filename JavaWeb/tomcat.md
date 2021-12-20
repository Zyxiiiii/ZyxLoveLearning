# 小问题

- `DispatcherServlet cannot be cast to class jakarta.servlet.Servlet`

  这个问题是由于在`Tomcat10`以后，Servlet用的都是`JakartaEE`规范的一个实现，与原来的不匹配，而`SpringMVC`提供的还是原来的实现，这就导致一个类转换的异常

  解决办法，降级到`Tomcat9`即可