# Redis

- `Redis`是一项`NoSQL`的技术，它可以解决性能问题
- `redis`采取了**单线程+多路`IO`复用**的方式，使得`CPU`的效率大大提高

# NoSQL

- `NoSQL`数据库的好处
  - `NoSQL`数据库的数据存储在内存中，减轻`CPU`和内存的读写压力
  - 可以将常用的数据放到缓存数据库中，减少直接对数据库的`io`操作，减轻数据库的`IO`压力

- 经典`NoSQL`举例
  - `Redis`、`MangoDB`、`Memcached`

# 安装

## 注意事项

- 要到官网下载最新的源码包，解压缩后用`gcc`的`make`和`make install`指令来进行编译安装

# Redis的启动

- 前台启动

  直接通过`redis-server`命令启动即可前台启动，但这样启动以后我们的终端一旦关闭，`redis`服务也会随之关闭，所以这种方式一般不被推荐

- 后台启动（推荐）

  后台启动会在后台静默的启动`redis`服务，不会因为终端的关闭而关闭，所以我们更推荐使用后台启动，步骤如下：

  1. 把`redis`解压出来的目录中的`redis.conf`文件`cp`一份到`/etc`中
  2. 修改其中的`daemonize no`为`daemonize yes`
  3. 进入到`/usr/local/bin`目录下，执行`redis-server /etc/redis.conf`，就可以使用我们修改过的配置文件来启动`redis`
  4. 输入`redis-cli`测试是否能正确连上`redis`，如正常，则会显示`127.0.0.1:6379>`这时候我们输入`ping`并回车，就会弹出`pong`字样，说明我们`redis`已经完成启动了，用`exit`命令可以退出`redis`客户端

# Redis命令

## Redis键

- `key *`：查看当前库中所有`key`

  按列的形式输出所有的`key`

- `exist key`：判断某个`key`是否存在

  若存在该`key`，则输出`1`；若不存在该`key`，则输出`0`

- `type key`：查看`key`的类型

  输出该`key`的类型

- `del key`：删除指定的`key`数据

  删除成功后，会返回`1`

- `unlink key`：根据`value`选择**非阻塞删除**

  效果也是删除`key`，但不是立刻删除该`key`，而是在后续异步删除该`key`

- `expire key <time>`：为给定的`key`设置过期时间（单位为秒）

  设置成功后会返回`1`，设置`key`的有效时间为`<time>`，当经过了`<time>`秒后，该`key`会自动变为过期

- `ttl key`：查看还有多少秒过期（`-1`表示永不过期，`-2`表示已过期）

  返回剩余时间

## Redis库命令

- `select`：切换数据库
- `dbsize`：查看当前数据库的`key`的数量
- `flushdb`：清空当前库
- `flushall`：通杀全部库

