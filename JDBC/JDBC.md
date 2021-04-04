# JDBC

## 配置环境变量

.;< jar文件 >

## JDBC编程六步

1. 注册驱动：声明要连接的是哪家的数据库
2. 获取连接：表示打开JVM和数据库之间的进程连接，这个连接属于进程之间的通信，是重量级别的，一定要在使用完毕后关闭
3. 获取数据库操作对象（专门执行SQL语句的对象）
4. 执行SQL语句：主要执行DQL、DML
5. （处理查询结果集：只有在第四步执行了select语句的时候才有这一步）
6. 释放资源

JDBC编程六步实操：

```java
public class JDBCTest(){
    Connection conn = null;
    Statement stmt = null;
    public static void main(String[] args){
		try{
        	//1.注册驱动（方法一）
        	Driver driver = new com.mysql.jdbc.Driver();
        	DriverManager.registerDriver(driver);
        	/*将Driver对象传入DriverManager静态的注册方法*/
            
            //注册驱动（方法二，较常用，需要学习反射）
            /*
            	参数是一个字符串，可以写入“.prooerties”文件当中
            	以下方法不需要接收返回值，我们只需要它的类加载动作
            */
            Class.forName("com.mysql.jdbc.Driver");
            
            //2.获取连接
            /*
            	url：统一资源定位符(网络中某个资源的绝对路径)
            		e.g:https://www.baidu.com
            	url包括：协议，IP，Port，资源名。
            	e.g:https://182.61.200.7:80/index.html
	            	格式：协议://IP地址:Port端口/资源名
            		即：协议 = https://
            			IP地址:182.61.200.7
            			Port端口:80
            			资源名:index.html
            */
            String url = "jdbc:mysql://IP地址(localhost)：端口号/<数据库名/资源名>";
            /*
            	jdbc:mysql//  协议
            */
            String user = "root";
            String password = "<你的用户名>";
			conn = DriverManager.getConnection(url,user,password);
            
            //3.获取数据库操作对象
            stmt = conn.CreateStatement();
            /*利用连接中的方法实例化了一个Statement对象*/
            
            //4.执行SQL
            String sql = "<对数据库进行操作的SQL语句>";
            /*JDBC中的sql语句不需要写分号*/

            //专门用于执行DML语句
            //返回值是“影响数据库中的结果条数”
            int count = stmt.excuteUpdate(sql);
            System.out.println(cout == 1 ? "保存成功" : "保存失败");
            
            //5.处理查询结果集
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            //6.释放资源
            /*
            	在finally块中关闭资源，以保证资源一定被释放
            	1.资源要按照从小到大的顺序依次释放
            	2.每一个资源都要分别进行try...catch...释放
            */
            try{
                if(stmt != null){
                    stmt.close;
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn != null){
                    conn.close;
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
```

