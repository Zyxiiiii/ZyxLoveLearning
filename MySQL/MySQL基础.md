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

- `SHOW DATABASES`：展示所有的数据库
  - 其中：`infomation_schema, mysql, performance_schema`这三个是系统自带的有关`MySQL`信息的库，**不可以改动它**
  - `test`是自带的测试库，我们可以直接用它做测试
- `USE <database_name>`：使用名为`database_name`的数据库
- `SHOW TABLES[ FROM <database_name>]`：展示当前库下所有的表，若输入了`[FROM <database_name>]`，则展示名为`<database_name>`的所有表
- `SELECT DATABASE()`：查看当前所在的库
- `CREATE TABLE <table_name>`：创建数据库表
- `DESC <table_name>`：查看表的结构
  - `FIELD`：字段名
  - `TYPE`：字段类型
  - `NULL`：非空约束
  - `KEY`：键
  - `DEFAULT`：默认值
  - `EXTRA`：
- `SELECT`：查询表中的数据
- 查看版本
  - `SELECT version`
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

# SQL语言
## DQL（Data Query Language）

  - `DQL`在SQL中是针对查询的语言，也就是针对`SELECT`语句的语言
###  基础查询
  - 语法：`SELECT <info> FROM <table>`
    
    其中，`<info>`代表待查询的内容，可以是表中的字段、常量值、表达式、函数；`<table>`代表到指定的表中去查询
    
    例如：
    
    ```SQL
    # 1.查询表中的单个字段
    SELECT
      `last_name`
    FROM
      employees;
    
    # 2.查询表中的多个字段，将多个字段名用','间隔开来即可，字段名用飘号'`'括起来可以表示这是一个字段，而不是关键字
    SELECT
      `last_name`,
      `phone_number`,
      `email`
    FROM
      employees;
    # Tips：查询的字段和表中的字段顺序不一定要一致，但和结果显示的顺序一致
    
    # 3.查询表中的所有字段，在SELECT后面接个'*'即可，使用'*'查询数据将会把表中所有的数据都查询出来，按照表中的顺序显示
    SELECT
      *
    FROM
      employees;
      
    # 4.查询常量值、表达式、函数
    
    # 4.1.SELECT后跟一个常量值，会直接得到这个常量值本身(SQL语句中的字符串用单引号括起来即可，并且不区分字符串或字符型)，如这条语句会得到'abc'这个字符串
    SELECT 'abc';
    
    # 4.2.SELECT后面也可以跟一个表达式，查询的结果是该表达式的运算结果
    # Tips：SQL中的'+'只能作为运算符，不能做字符串的拼接运算
    #     而当我们进行了非数字的运算时，MySQL会尝试把它进行类型提升成数字类型
    #     若提升成功，则进行正常的运算；若提升失败，则会将该数据赋为0进行运算
    #     另外，只要运算过程中其中一个数据为NULL，那么得到的结果就一定是NULL
    SELECT 100+100;
    
    # 4.3.SELECT后跟一个函数，结果是该函数的返回值
    SELECT VERSION();
    
    # 5.SELECT后查询的结果默认字段名就是表中的字段名，但这样有时候可能不方便我们理解，所以我们可以通过用取别名的方式修改它的展示方式，以下是取别名的两种方式
    
    # 5.1.使用'AS'关键字对查询结果进行取别名
    SELECT
      `last_name` AS "名字",
      `age` AS "年龄"
    FROM
      employees;
    
    # 5.2.在第一种方法的基础上，省略'AS'关键字，也可以起到起别名的效果
    SELECT 
      `lase_name` "名字",
      `age` "年龄"
    FROM
      employees;
      
    # 6.在某些时候，我们对重复的数据可能只需要列出一次，那么我们就需要对查询的数据进行去重，使用'DISTINCT'关键字，就可以对表中查询到的数据进行去重
    SELECT DISTINCT
      `id`
    FROM
      employees;
    
    # 7.当我们需要将多个字段的值连接在一起显示时，就可以使用'CONCAT(参数列表)'函数进行连接，然后字段的值会以字符串的形式进行拼接后显示
    SELECT
      CONCAT(`first_name`,`last_name`) AS "姓名"
    FROM
      employees;
    
    ```    
    
    以上就是对表中数据的简单查询
    
  - Tips：查询到的结果并不是真实的表，而**是原表的一个临时拷贝**
  - 小结
    - 查询多个字段，在字段与字段之间用`,`连接
    - `*`代表查询所有字段
    - 给表中的字段起别名可以使用`AS`字段，也可以直接在字段名和别名之间直接用空格隔开
    - `SQL`中的`+`会对非数字类型的数据进行类型提升，若提升成功，则按照提升后的数值进行运算，若提升失败，则给这个数值赋值为0进行运算；此外，若在运算过程中（包括任何运算，而不仅仅是加法），只要有其中一个数据的值为`NULL`那么最终的结果一定是`NULL`
    - 由于`+`不能对字符串进行拼接，所以我们要进行字段的拼接的话，就需要使用`CONCAT`函数进行拼接，`CONCAT`函数的参数列表是一个可变参数，它可以接收多个字段进行拼接
### 条件查询
### 排序查询
### 常见函数
### 分组函数
### 分组查询
### 连接查询
### 子查询
### 分页查询
### union联合查询

## DML（Data Manipulation Language）
### 插入语句
### 修改语句
### 删除语句

## DDL（Data Define Language）
### 库和表的管理
### 常见数据类型介绍
### 常见约束

## TCL（Transaction Control Language）
### 事务和事务处理