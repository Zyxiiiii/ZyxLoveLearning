[TOC]

#  JavaScript 简介

## 为什么学 JavaScript 

JavaScript 是 web 开发者必学的三种语言之一：

- *HTML* 定义网页的内容
- *CSS* 规定网页的布局
- <font style="color:red;font-weight:900">而 *JavaScript*  对网页行为进行编程</font>

##  JavaScript 与 Java ？

* JavaScript 和 Java 是完全不同的语言，不论是概念还是设计。

* JavaScript 在 1995 年由 Brendan Eich 发明，并于 1997 年成为一部 ECMA 标准。

* JavaScript前身叫LiveScript改成了Java是因为当时Java盛行，搭了Java的顺风车

##  JavaScript 有什么用？能做什么？

* <font style="color:red;font-weight:600">JavaScript 能够改变 HTML 内容</font>

* <font style="color:red;font-weight:600">JavaScript 能够改变 HTML 属性</font>

* <font style="color:red;font-weight:600">JavaScript 能够改变 HTML 样式 (CSS)</font>

* <font style="color:red;font-weight:600">JavaScript 能够隐藏 HTML 元素</font>

* <font style="color:red;font-weight:600">JavaScript 能够显示 HTML 元素</font>

#  JavaScript 的使用

## \<script> 标签

* 在 HTML 中，JavaScript 代码必须位于 `<script>`与`</script> `标签之间。
* 引入 JavaScript 代码有两种方式：**在HTML中直接引用**、**引入外部脚本文件**
* `<script>`标签在`<head>`或`<body>`中都可以引用

```html
<!-- 直接引用 -->
<script>
document.getElementById("demo").innerHTML = "我的第一段 JavaScript";
</script>

<!-- 引入外部脚本文件 -->
<script src="myScript.js"></script>
```

## 外部引用的优势

在外部文件中放置脚本有如下优势：

- 分离了 HTML 和代码
- 使 HTML 和 JavaScript 更易于阅读和维护
- 已缓存的 JavaScript 文件可加速页面加载
- **可通过完整的 URL 或相对于当前网页的路径引用外部脚本**

```html
<script src="https://www.w3school.com.cn/js/myScript1.js"></script>
```

#  JavaScript 基本语法

*  JavaScript 的注释和Java无区别

## 变量

由于 JavaScript 是**弱类型**的语言，所以变量名不需要在定义时给定类型，通常使用`var`来声明一个变量

```javascript
// 如何声明变量
var x, y;
var a = 3;

x = 7; y = 8;	// 如何赋值
z = x + y;	// 如何计算值
```

## 标识符

## JavaScript 标识符

* 标识符是一个变量的名称。

* 在 JavaScript 中，标识符用于命名变量（以及关键词、函数和标签）。

* 在 JavaScript 中，首字符必须是字母、下划线（_）或美元符号（$）。

* 连串的字符可以是字母、数字、下划线或美元符号。

* **提示：**数值不可以作为首字符。这样，JavaScript 就能轻松区分标识符和数值。

## 值

* JavaScript 值

  JavaScript 语句定义两种类型的值：混合值和变量值。

  混合值被称为**字面量（literal）**。变量值被称为**变量**。

### JavaScript 字面量

书写混合值最重要的规则是：写数值**有无小数点均可**

例：

```javascript
15.90

10011
```

**字符串**是文本，由双引号或单引号包围

例：

```javascript
"Bill Gates"

'Bill Gates' 
```

##  JavaScript 运算符

*  JavaScript 的算术、赋值和比较运算符与Java基本一致，但多一个全等号 `===`

  ​		该等号成立的条件为左右两边的数据不仅仅要数值相等，还要求类型一致（和JavaScript的弱类型特性有关）

* JavaScript的字符串运算符
  * JavaScript 中 `+` 可用于字符串的相加，也叫**级联运算符**
  * ` ＋` 用于字符串和数字相加，结果？

```javascript
"hello world" + 1 == "hello world1"

1 + "3" == "13"

1 + 3 + "hello world" == "4hello world"
```

* JavaScript 中的类型运算符

  * typeof运算符

    