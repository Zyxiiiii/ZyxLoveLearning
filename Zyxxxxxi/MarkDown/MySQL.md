# MySQL

## 什么是MySQL？

MySQL是一款数据库**管理系统**软件

## SQL、DB、DBMS

* DB
  * DataBase（**数据库**，以文件方式存在）
* DBMS
  * DataBase Management System（数据库管理**系统**，常见的有MySQL、Oracle、DB2、Sybase、sqlServer……）
* SQL
  * 结构化查询**语言**，是一门标准通用于数据库产品的语言

# table（表）

table是数据库的基本组成单元，所有的数据以表格形式组织，可读性强

* 行：数据/记录（data）
* 列：字段（column），*字段应包含字段名，数据类型，相关的约束*

# SQL

## SQL语句的分类

DQL（数据查询语言）：查询语句，凡是select语句都是DQL

DML（数据操作语言）：insert、delete、update，对表中数据进行增删改

DDL（数据定义语言）：create（创建表/库）、drop（删除表/库）、alter，对表的结构进行增删改

TCL（事务控制语言）：commit提交事务、rollback回滚事务。

DCL（数据控制语言）：grant授权、revoke撤销权限

## SQL语句

### DQL

#### 条件语句

|      运算符      |                        说明                         |
| :--------------: | :-------------------------------------------------: |
|        =         |                        等于                         |
|     <> or !=     |                       不等于                        |
|        <         |                        小于                         |
|        <=        |                      小于等于                       |
|        >         |                        大于                         |
|        >=        |                      大于等于                       |
| between...and... |                两个值之间（闭区间）                 |
|     is null      |                        为空                         |
|       and        |                         与                          |
|        or        |                         或                          |
|        in        |                包含（**不是区间**）                 |
|       not        |             非，可与 is 和 in 搭配使用              |
|       like       | 模糊查询（ '%' 代表占多个字符；'_' 代表占一个字符） |

#### 排序语句：order by

​	默认按asc（升序）排列，可使用desc字段使它变为倒序排列

​	**可以按照两个字段排序，排序优先级与输入的语句中字段的先后顺序有关**

#### 分组查询

group by：用于将表格按group by后跟的字段进行分组

*可以使用多个字段进行分组，**但使用了group by的语句select后只能跟分组函数或分组条件字段***

having：对分组后的字段进行进一步过滤（不能不使用group by直接使用having

distinct（去重）：去除重复记录

​		*distinct只能出现在所有字段的最前方*

* 分组函数

  * 自动忽略null
  * 只能在group by后使用（切忌在where后使用）

  count()：计算表中某字段有多少个

  sum()：求某字段下的数据的总和

  avg()：求某字段下数据的平均值

  max()：求某字段下数据的最大值

  min()：求某字段下数据的最小值

#### 连接查询

实际开发中经常需要多张表联合查询并取出最终的结果

若所有数据都呈现在一张表上，必然少不了大量的数据冗余

##### 内连接

* 等值连接

  ​		连接条件中的关系为等量关系

* 非等值连接

  ​		连接条件中的关系为非等量关系

* 自连接

  ​		表格自己连接本身

##### 外连接

* 左（外）连接
* 右（外）连接

*全连接（较少使用）*

##### 笛卡尔积现象

当两张表进行连接查询的时候，没有任何条件进行限制，最终的查询结果条数是两张表记录条数的乘积。

* 别名：

  ​		select **e**.ename, **d**.dname from emp **e**, dept **d**;

  ​		*以上深色字体，即为表的别名的应用*

  * 优点：

    第一：执行效率高

    第二：可读性高

* 加条件避免笛卡尔积现象

  /* SQL92 */

  select e.ename, d.dname from emp e, dept d **where e.ename = d.dname**;

  /* SQL99 */

  select e.ename, d.dname from emp e **inner join** dept d **on** e.ename = d.dname (where ...);

  *SQL99把表连接条件和where条件分离，结构更清晰*

  *注意！加条件避免笛卡尔积现象并不能减少数据的比对次数，即无法提高运行效率*

  ----

  * 完整的DQL语句的执行顺序*(序号表示执行顺序，从小到大执行)*

select(5)

​		...

from(1)

​		...

where(2)

​		...

group by(3)

​		...

having(4)

​		...

order by(6)

​		...（asc/desc）

---

# MySQL命令

show databases：查看所有数据库

show tables (from anotherTable)：查看当前库中的表（或从另一个数据库查看相应的表）

show create table < table >：查看创建表时使用的SQL语句

desc < table >：查看表的**结构**

create database < database >：创建名为< database >的数据库

use < database >：使用< database >数据库

source + （拉取文件）：初始化数据库

select database()：查看当前使用的数据库名

select version()：查看MySQL的版本号

\c：结束当前语句

Ctrl+C：强行终止

exit：退出MySQL

