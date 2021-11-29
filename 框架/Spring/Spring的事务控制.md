# 编程式事务控制

## Platform Transaction Manager

`PlatformTransactionManager`接口是`Spring`的事务管理器，它提供了我们常用的操作事务的方法

|                             方法                             |        说明        |
| :----------------------------------------------------------: | :----------------: |
| `TransactionStatus getTransaction(TransactionDefination defination)` | 获取事务的状态信息 |
|           `void commit(TransactionStatus status)`            |      提交事务      |
|          `void rollback(TransactionStatus status)`           |      回滚事务      |

Tips：`PlatformTransactionManager`只是一个接口，我们需要根据我们的使用场景调用不同的实现类

## Transaction Definition

`TransactionDEfinition`是事务的定义信息对象，它提供了方法供我们获取事务的相关信息

|             方法             |        说明        |
| :--------------------------: | :----------------: |
|   `int getIsolationLevel`    | 获取事务的隔离级别 |
| `int getPropogationBehavior` | 获取事务的传播行为 |
|       `int getTimeout`       |    获取超时时间    |
|     `boolean isReadOnly`     |      是否只读      |

- 隔离级别：略
- 传播行为：