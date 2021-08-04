# 安装CentOS（略）

* `CentOS`
* `VMware`
* <font style="color:gray">`VMware Tools`</font>
  * 共享文件夹

# Linux目录结构

`Linux`的目录结构是树状的，有且只有一个根目录。

* <font style="color:red;font-weight:bolder">Linux中，一切皆为文件</font>

## Linux的根目录（"/"）

不同于`windows`，`Linux`只有一个根，那就是"/"，根下面有许多子目录（例如`usr`,`root`,`bin`等等），它是Linux系统下的顶级目录

## bin

* **`Binary`**，存放Linux的常用命令

## sbin

* **`Super User`**，存放系统管理员使用的应用程序

## home

* **存放普通用户的主目录**，在Linux中，每一个用户都有一个自己的目录，一般这个目录会以该用户的账号命名

## root

* **系统管理员的主目录**

## lib

* **系统启动所需的动态连接共享库**，几乎所有的应用程序都需要用到这个库

## lost+found

* 一般为空，当系统非法关机时，这里就会自动存放一些文件

## etc

* **所有的系统管理所需要的配置文件**和子目录（环境变量的配置）

## usr

* **用户的应用程序和文件都在这个目录下**

## boot

* 启动Linux时使用的一些核心文件，包括连接文件和镜像文件

## proc

* 这是一个虚拟目录，它是系统内存的映射，访问这个目录获取系统信息

## srv

* **`service`**目录，该目录存放一些服务启动后需要提取的数据

## sys

* Linux内核2.6以后新增的文件系统

<font style="color:red;font-weight:bolder">`proc`,`srv`,`sys`这三个目录涉及到Linux的内核，一般不允许轻易改动它们</font>

## tmp

* 用于存放一些临时文件

## dev

* **硬件目录**，类似于设备管理器，Linux把所有的硬件映射成文件，存储到这个目录下

## media

* **Linux识别到的U盘或光驱等媒体**，Linux会把这些设备挂载到这个目录下

## mnt

* **允许用户挂载别的文件系统的目录**，例如`VMware`的共享文件夹

## opt

* **给Linux额外安装软件存放的目录**，如`MySQL`、`Oracle`数据库

## usr/local

* **另一个给主机额外安装软件所安装的目录**，一般是通过编译源码安装的程序

## var

* **存放经常性被修改的文件**，例如日志

## selinux

**security-enhanced linux**

* `SELinux`是一种安全子系统，它能控制程序只能访问特定文件

# Linux的常用命令

* 对文件和目录的操作的一部分路径规则

  * `.`表示当前目录

  * `../`表示上级目录

  * `/`表示根目录

  * 路径的开头为`/`表示以根目录为起始

    路径的开头不为`/`表示以当前目录为起始

  * `*`表示配对一切文件及目录

## 对文件和目录的操作

### cd

表示进入某一目录

* `cd /home`：进入`/home`目录
* `cd ..`：返回上级目录
* `cd -`：返回上次所在目录

### cp

表示复制某一目录或文件夹

格式：

文件：`cp file1 file2`

目录：`cp -a dir1 dir2`

例：

复制一个目录到当前目录：`cp -a dir .`

### ls

查看目录中的文件

TIPS：直接使用`ls`，即可查看当前目录中的文件（不包括隐藏的文件）

`ls -a`：同时显示隐藏文件

`ls -l`：显示详细信息

`ls -lrt`：按时间显示文件（l表示详细列表，r表示反向排序，t表示按时间排序）

### pwd

显示工作路径	:question:

### mkdir

创建一个文件夹

* `mkdir dir1 dir2`：同时创建两个目录（列出多少个创建多少个）
* `mkdir -p /xxx/aaa/xxx/aaa`：创建一个**目录树**

### mv

移动或重命名一个目录

* `mv dir1 dir2`：将一个目录`(dir1)`移动到另一个目录`(dir2)`下，并重命名为所给的目录`(dir2)`名

### rm

* `rm -f file1`：删除文件`file1`
* `rm -rf dir1`：删除目录`dir1`

## 查看文件的内容

* `cat`：从第一个**字节**开始正向查看文件的内容

  `cat file`

* `head`：查看一个文件的n行

  `head -2 file1`：查看一个文件的2行

* `more`：查看一个长文件的内容

  `more file`

* `tac`：从最后一行开始反向查看一个文件的内容

  `tac file`

* `tail`：查看一个文件的最后n行

  `tail -3 file`：查看一个文件的最后3行

## 文本处理

### grep

* `grep str /tmp/test`：在文件`/tmp/test`中查找`str`
* `grep ^str /tmp/test`：在文件`/tmp/test`中查找以`str`开始的行
* `grep /正则表达式/ /tmp/test`：在文件`/tmp/test`中查找与所给正则吻合的行

* `grep str -r /tmp/*`：表示在目录`/tmp`及其子目录中查找`str`

### diff & sdiff

* `diff file1 file2`：找出两个文件的不同处

* `sdiff file1 file2`：以对比的方式显示两个文件的不同

## 查找

### find

* `find / -name file1`：从`/`开始进入文件系统查找名字匹配的文件和目录

* `find / -user user1`：从`/`开始进入文件系统查找属于用户`user1`的文件和目录

* `find /home/user1 -name \*.bin`：在目录 `/ home/user1`中查找以`.bin`结尾的文件
* `find /usr/bin -type f -atime +100`：查找在过去100天内未被使用过的执行文件
* `find /usr/bin -type f -mtime -10`：查找在10天内被创建或者修改过的文件
* locate \*.ps：寻找以`.ps`结尾的文件，先运行`updatedb`命令
* `find -name '*.[ch]' | xargs grep -E 'expr'`：在当前目录及其子目录所有`.c`和`.h`文件中查找`expr`
* `find -type f -print0 | xargs -r0 grep -F 'expr'`：在当前目录及其子目录的常规文件中查找`expr`
* `find -maxdepth 1 -type f | xargs grep -F 'expr'`：在当前目录中查找`expr`

## 压缩和解压

### bz2

* `bzip2 file1`：压缩file1
* `bunzip2 file1.bz2`：解压file1.bz2
* `gzip file1`：压缩file1
* `gzip -9 file1`：最大程度压缩file1
* `gunzip file1.gz`：解压file1.gz