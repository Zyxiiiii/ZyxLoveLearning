[TOC]

# Ubuntu的安装（略）

# 用户权限

  * 由于在`Ubuntu`中，默认安装好后都是普通用户权限，没有`root`权限，如果要用`root`权限，通常会在命令前加上`sudo`关键字，但这样的操作比较麻烦
  
  * 我们一般使用`su`指令直接切换到`root`用户，但是如果没有给`root`用户设置初始密码，就会抛出*认证失败*的提示，所以我们需要给`root`用户**设置密码**
    1. 输入`sudo password`命令，输入**一般用户密码**并设定`root`用户密码
    2. 设置`root`密码成功后，输入`su`命令，并输入刚设定的`root`密码，就可以切换成`root`（`$`表示一般用户，`#`表示`root`用户）
    
    Tips：输入`exit`命令，退出`root`并返回一般用户

# APT软件包管理

  `APT`是一款安装包管理工具。在Ubuntu下，我们可以使用`apt`命令来进行软件包的安装（类似于`Windows`的软件管理工具）

  * `APT`软件获取原理：
    和`YUM`类似，`APT`在运行时也会连接到软件仓库去获取相应的软件包，配置软件仓库地址的文件在`/etc/apt/source.list`*（默认指定了官方的软件地址位于美国，连接速度比较慢）*
  
  * 有关软件的操作指令：
    * **`sudo apt update`：更新源**
    * **`sudo apt-get install package`：安装包**
    * **`sudo apt-get remove package`：删除包**
    * `sudo apt-cache search package`：搜索软件包
    * **`sudo apt-cache show package`：获取包的相关信息（如说明、大小、版本）**
    * `sudo apt-get install package --reinstall`：重新安装包
    * `sudo apt-get -f install`：修复安装
    * `sudo apt-get remove package --purge`：删除包，包括配置文件等
    * `sudo apt-get build-dep package`：安装相关的编译环境
    * `sudo apt-get upgrade`：更新已安装的包
    * `sudo apt-get dust-upgrade`：升级系统
    * `sudo apt-cache depends package`：了解使用该包需要依赖哪些包
    * `sudo apt-cache rdepends package`：查看该包被哪些包依赖
    * **`sudo apt-get source package`：下载该包的源代码**

  * 由于国外的软件仓库连接起来会导致传输缓慢，所以一般我们会到配置文件中改变它指向的软件仓库（ ==> 清华的`Ubuntu`软件镜像源）

# SSH远程登录Ubuntu

  由于`Ubuntu`上并没有自带`SSH`，所以我们要先安装并启动这个服务，才能使用`XShell5`远程登录到`Ubuntu`

  1. 安装`SSH`服务（包括服务端和客户端）：`sudo apt-get install openssh-server`
  2. 启用`sshd`服务（监听22号端口）：`service sshd restart`

## 从Linux客户机远程连接到Linux服务机

  1. 客户机需要安装`SSH`
  2. `ssh 用户名@IP地址`：使用`SSH`远程连接到`Linux`服务机

  Tips：如出现错误，查看是否有`~/.ssh/known_ssh`，尝试删除该文件解决

  * 远程登出：`exit`或`logout`指令