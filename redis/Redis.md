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

- `keys *`：查看当前库中所有`key`

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

- `select <数据库号>`：切换数据库（默认库为`0`）
- `dbsize`：查看当前数据库的`key`的数量
- `flushdb`：清空当前库
- `flushall`：通杀全部库

## 对String的操作命令

- `set <key> <value>`：添加键值对到当前库中
  - 当不存在该`key`时，添加该`key`到数据库中
  - 当存在该`key`时，则覆盖原有的`key`
  
- `get <key>`：取到键所对应的值

- `append <key> <value>`：将给定的值追加到原来的值的末尾

  返回追加完以后的值的长度

- `strlen <key>`：获得对应值的长度

- `set <key> <value>`：只有当`key`不存在时，设置`key`的值

- `mset <key1> <value1> <key2> <value2>......`：设置多个键值对

- `mget <key1> <key2> <key3>......`：根据所给键获取多个值

- `msetnx <key1> <value1> <key2> <value2>......`：只有当所有给定的键都不存在时，设置多个键值对

- `getrange <key> <初始位置> <结束位置>`：获取该键指定范围的值（类似于`substring`）

- `setrange <key> <初始位置> <value>`：将`value`从该键的指定位置开始设置到值中，该方法会将从初始位置开始到`value`长度的原始数据覆盖，其他部分不会改变

- `setex <key> <time> <value>`：设置键值对的同时设置过期时间

- `getset <key><value>`：设置新值的同时获取到旧的值

# Redis常用数据类型

## String

- 用于存储字符串，并且是**二进制安全**的，所以可存储各种可转换成字符串的数据（例：一个`jpg`图片或一个已序列化完成的对象）
- `String`类型的`value`最大是`512M`

