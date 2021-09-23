# JdbcTemplate概述

* 它是`Spring`框架中提供的一个对象，是对原始繁琐的`JDBC`API对象的简单封装。`Spring`框架为我们提供了很多的操作模板类。例如：操作关系型数据的`JdbcTemplate`和``HibernateTemplate`，操作`nosql`数据库的`RedisTemplate`，操作消息队列的`JmsTemplate`等等

# JdbcTemplate开发步骤

1. 导入`spring-jdbc`和`spring-tx`坐标

2. 创建数据库表和实体

3. 创建`JdbcTemplate`对象

   在使用模板对象之前，必须设置数据源：`public void setDataSource();`

4. 执行数据库操作

## Spring产生模板对象

* 在`Spring`容器中，我们可以先把数据源`DataSource`的创建权交给`Spring`，再把模板`JdbcTemplate`的创建权也交给`Spring`，在`Spring`内部将数据源注入到模板中，这样就实现了`Spring`帮助我们产生模板对象了

  ```xml
  <!--  xml  -->
  <!--  数据源配置  -->
  <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
  	<property name="driverClass" value="com.mysql.jdbc.Driver"></property>
      <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/test"></property>
      <property name="user" value="root"></property>
      <property name="password" value="root"></property>
  </bean>
  
  <!--  JdbcTemplate  -->
  <bean id="jdbcTemplate" class="org......JdbcTemplate">
  	<property name="dataSource" ref="dataSource"></property>
  </bean>
  ```

# JdbcTemplate常用操作

* 更新操作（包括*增删改*）

  `public int update(String sql, Object... args)`

* 查询操作

  * 利用`BeanPropertyRowMapping`建立映射关系

  API：

  ```java
  // 查询多个对象
  public List<T> query(String sql, RowMapper<T> rowMapper);
  // 查询单个对象
  public T queryForObject(String sql, RowMapper<T> rowMapper, Object... args);
  // 查询某个基本类型数据（如总条数）
  public T queryForObject(String sql, Class<T> requiredType);
  ```

  

