# JavaEE环境搭建

  所需要的软件（均安装到`/opt/`下）
  * MySQL（数据库）
  * JDK
  * Eclipse/IDEA（IDE）
  * Tomcat（服务器）

## 安装JDK
  * 安装步骤
    1. 通过`xftp5`上传到`Linux`的`/opt/`下
    2. 解压缩到`/opt/`
    3. 配置环境：修改环境变量的配置文件——`/etc/profile`
      * `JAVA_HOME=xxxxx`
      * `export PATH=xxxxx/bin:$PATH`
      * `export JAVA_HOME`
        
        Tips：
        * 以上的`xxxxx`均为`JDK`的文件夹路径
        * `JDK`的环境变量需要重新登录才能生效
        
  * 测试安装是否成功：
    
    在任何一个目录下均可以使用`java`和`javac`命令即可
    
## 安装Tomcat
  * 安装步骤
    1. 上传`Tomcat`软件包到`/opt/`下
    2. 解压缩到`/opt/`
    3. 启动`Tomcat`（`./startup.sh`）
    4. 开放端口（`/etc/sysconfig/iptables`）

## 安装Eclipse