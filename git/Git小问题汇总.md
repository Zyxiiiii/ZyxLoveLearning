[TOC]

# git

## 冲突

* 在云端删除了文件后，再在本地推上去时报错，再拉取时才想起来会产生冲突
  * 拉取强行合并，查看文件无出错后输入“：wq”退出错误弹窗，重新push

## 配置多个公钥

### 解决方法

1. 生成一个公司用的`SSH-Key`

```
$ ssh-keygen -t rsa -C 'xxxxx@company.com' -f ~/.ssh/gitee_id_rsa
```

2. 生成一个`github`用的`SSH-Key`

```
$ ssh-keygen -t rsa -C 'xxxxx@qq.com' -f ~/.ssh/github_id_rsa
```

3. 在 `~/.ssh` 目录下新建一个config文件，添加如下内容（其中`Host`和`HostName`填写git服务器的域名，`IdentityFile`指定私钥的路径）

```
# gitee
Host gitee.com
HostName gitee.com
PreferredAuthentications publickey
IdentityFile ~/.ssh/gitee_id_rsa
# github
Host github.com
HostName github.com
PreferredAuthentications publickey
IdentityFile ~/.ssh/github_id_rsa
```

4.用`ssh`命令分别测试

```
$ ssh -T git@gitee.com
$ ssh -T git@github.com
```