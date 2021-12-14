[TOC]

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

  - `mysql [-h localhost -P 3306] -u <username> -p<password>`

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
      `employees`;
    # Tips：查询的字段和表中的字段顺序不一定要一致，但和结果显示的顺序一致
    
    # 3.查询表中的所有字段，在SELECT后面接个'*'即可，使用'*'查询数据将会把表中所有的数据都查询出来，按照表中的顺序显示
    SELECT
      *
    FROM
      `employees`;
      
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
      `employees`;
    
    # 5.2.在第一种方法的基础上，省略'AS'关键字，也可以起到起别名的效果
    SELECT 
      `lase_name` "名字",
      `age` "年龄"
    FROM
      `employees`;
      
    # 6.在某些时候，我们对重复的数据可能只需要列出一次，那么我们就需要对查询的数据进行去重，使用'DISTINCT'关键字，就可以对表中查询到的数据进行去重
    SELECT DISTINCT
      `id`
    FROM
      `employees`;
    
    # 7.当我们需要将多个字段的值连接在一起显示时，就可以使用'CONCAT(参数列表)'函数进行连接，然后字段的值会以字符串的形式进行拼接后显示
    SELECT
      CONCAT(`first_name`,`last_name`) AS "姓名"
    FROM
      `employees`;
    
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

- 语法：`SELECT <查询列表> FROM <表名> WHERE <筛选条件>`

- 执行顺序

  1. `FROM <表名>`
  2. `WHERE <筛选条件>`

- 分类

  - 按条件表达式筛选

    条件运算符

    - `>`：大于
    - `<`：小于u
    - `==`：等于
    - `!=/<>`：不等于 :star2: 较为特殊，有一个与常规语言中不一样的符号`<>`，用于表示前后两式不相等，效果等价于`!=`，但`SQL`推荐使用`<>`
    - `>=`：大于等于
    - `<=`：小于等于

  - 按逻辑表达式筛选

    逻辑运算符

    - `&& / AND`：与
    - `|| / OR`：或
    - `! / NOT`：非

    `SQL`中的逻辑运算符都有封装，有更贴近人类语言的描述，可以避免使用大量的符号，更便于初学者理解，并且**`SQL`中也建议使用`and, or, not`来代替抽象的符号**

  - 模糊查询

    关键字
  
    - `LIKE`
    - `BETWEEN AND`
    - `IN`
    - `IS NULL`

#### 按条件表达式筛选

即利用条件运算符构建返回值为`bool`类型的表达式，通过这个表达式来进行筛选

例：

```sql
# 查询employees表中，salary大于12000的所有数据
SELECT
	*
FROM
	`employees`
WHERE
	`salary` > 12000;
	
# 查询department_id不等于90的员工名和部门编号
SELECT
	`name`,
	`department_id`
FROM 
	`employees`
WHERE
	`department-id`<>90;
```

#### 按逻辑表达式筛选

利用逻辑运算符返回的`bool`类型进行筛选，通常结合条件表达式使用

逻辑运算符

- `&&`或`AND`：表示前后连接的两个表达式都为`true`，结果才为`true`，只要其中一个为`false`，结果就为`false`
- `||`或`OR`：表示前后两个表达式只要有一个为`true`，结果就为`true`
- `!`或`NOT`：表示后面所跟的表达式的`bool`值的取反，即若表达式的值为`true`，则结果为`false`；若表达式的值为`false`，则结果为`true`

例：

```SQL
# 查询工资在10000到20000之间的员工名、工资及奖金
SELECT
	`last_name`,
	`salary`,
	`commission_pct`
FROM
	`employees`
WHERE
	`salary` >= 10000
AND
	`salary` <= 20000;
	
# 查询部门编号不在90到110之间的，或工资高于15000的员工信息
SELECT
	*
FROM
	`employees`
WHERE NOT(
	`department_id` >= 90
AND
	`department_id` <= 110)
OR
	`salary` > 15000;
```

#### 模糊查询

利用模糊查询的一些关键字可以完成模糊匹配，主要的关键字有：

- **`LIKE`**：模糊查询最重要的关键字，用于匹配不确定的值，表示是否有包含某些字符

  为了能匹配各种各样的字符串值，`LIKE`关键字还有两个独特的通配符

  - 百分号`%`：匹配**任意个数的任意字符**

  - 下划线`_`：匹配**一个任意字符**

    Tips：若要匹配`%`或者`_`作为字符串中的字符，则需要使用转义符号`\`

    如：`'_\_%'`，该表达式表示的是第二个字符为`_`的值

    另外还有一种转义方式：`<任意字符>`和`ESCAPE`的搭配使用也可以达到转义的效果，如：`'_$_' ESCAPE '$'`，表示`$`作为一个转义字符使用，可以是任意字符，只要和`ESCAPE`关键字后跟的字符一致即可，效果同`\`

- `BETWEEN AND`：表示是否在一个区间之中

  该表示方法等价于用`AND`连接的两个子式的**闭区间**

  如：

  ```salary` BETWEEN 10000 AND 15000``

  等价于

  ```salary`>=10000 AND `salary`<=15000``

  Tips：`BETWEEN AND`不可以颠倒次序，必须小的在前，大的在后

- `IN`：表示是否在一个集合之中

  该表示方法可以查询出所有字段值存在于所给的集合中的数据

  如：```job_id` IN ('IT_PROT','AD_VP','AD_PRES')``，该表达式查询表示字段`job_id`中值**等于**`'IT_PROT'`或`'AD_CP'`或`'AD_PRES'`的值

  Tips：这里的**小括号代表一个集合**，而不是一个区间

- `IS NULL | IS NOT NULL`：表示`是|否`为空

  该表示方法可以查询出字段值为`NULL`或不为`NULL`的数据

  如：```commission_pct` IS NULL``，表示字段`commission_pct`中所有值为`NULL`的数据

  Tips：**`IS`关键字不能用于判断相等，等于号也不能等价于`IS`**，所以等于号不能判断数据是否为空，`IS`关键字也不能判断数据之间是否相等

<font color="red">模糊查询中，较重要的关键字为`LIKE`和`IS [NOT] NULL`两组，这两组关键字不能被取代，而另外两组关键字仅仅只是为了提高普通逻辑的可读性，对系统性能没有影响</font>

#### 安全等于<=>

除了以上的这些写法之外，还有一种特殊的写法：`<=>`，被称为安全等于，它既可以判断`NULL`，又可以判断普通的数值，它等价于`IS NULL`和`=`的结合

如：

```salary`<=>12000``，表示字段`salary`中值为12000的数据

```salary`<=>NULL``，表示字段`salary`中值为`NULL`的数据

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