# 数据库概念及MySQL安装（略）

# MySQL的一些前置说明

## MySQL配置文件

- `MySQL`根目录下 -> `my.ini`

  - `[mysql]`：客户端配置
    - `defalut-character-set=utf8`：指定字符集
  - `[mysqld]`：服务端配置
    - `port=3306`：指定端口号为3306
    - `basedir="xxx"`：安装目录
    - `datadir="xxx"`：数据存放目录
    - `character-set-server=utf8`：指定字符集
    - `default-storage-engine=INNODB`：指定默认的存储引擎
    - `sql-mode="STRICT_TRANS_TABLES, NO_AUTO_CREATE_USER, NO_ENGINE_SUBSTITUTION"`：数据库的语法模式
    - `max_connection`：最大连接数

  Tips：更改了配置文件以后，数据库服务需要重新启动，否则更改没有效果

## MySQL的启动和停止

- 直接在计算机管理 -> 服务和应用程序 -> 服务中找到自己`MySQL`服务的名字并启动
- 在命令行（需要使用管理员权限打开）下
  - `net stop 服务名`：关闭服务
  - `net start 服务名`：启动服务

## MySQL服务的登录和登出

- 直接使用`MySQL`自带的命令行软件进行启动，直接输入密码登录（不建议，因为这样使用的是`root`用户）

- 在命令行中使用命令登录

  - `mysql [-h localhost -P 3306] -u root -proot`

    其中

    - `-h`：后跟主机地址（空格可有可无）

    - `-P`（P大写）：后跟端口号（空格可有可无）

    - `-u`：后跟用户名（空格可有可无）

    - `-p`（p小写）：后跟密码（**不能有空格**，并且可以不跟密码，会跳转到下一行隐式输入密码）

      Tips：如果连接的是本机，且端口号为默认端口号的`MySQL`数据库，直接输入`-u`和`-p`之后的内容即可

## 配置环境变量

1. 复制`MySQL`的`bin`目录的路径
2. 打开系统 -> 高级 -> 环境变量 -> 用户变量 -> `path` -> 编辑
3. 将复制好的路径黏贴到字符串的**最前面**，并用**英文模式**下的`;`将它与后一个变量隔开
4. 最后一路确定即可

# MySQL命令

## 常用MySQL命令

- `show databases`：展示所有的数据库
  - 其中：`infomation_schema, mysql, performance_schema`这三个是系统自带的有关`MySQL`信息的库，**不可以改动它**
  - `test`是自带的测试库，我们可以直接用它做测试
- `use <database_name>`：使用名为`database_name`的数据库
- `show tables[ from <database_name>]`：展示当前库下所有的表，若输入了`[from <database_name>]`，则展示名为`<database_name>`的所有表
- `select database()`：查看当前所在的库
- `create table <table_name>`：创建数据库表
- `desc <table_name>`：查看表的结构
  - `Field`：字段名
  - `Type`：字段类型
  - `Null`：非空约束
  - `Key`：键
  - `Default`：默认值
  - `Extra`：
- `select`：查询表中的数据
- 查看版本
  - `select version`
  - 在`dos`窗口下，输入`mysql --version`

## MySQL语法规范

- 不区分大小写，但**建议关键字大写，表明、列名小写**
- 每条命令最好以`;`结尾
- 每条命令根据需要，可以进行**缩进或者换行**，建议**关键字单独一行**
- 注释
  - 单行注释
    - `# 注释内容`
    - `-- 注释内容`（Tips：`--`和注释内容之间有空格）
  - 多行注释：`/* 注释内容 */`

