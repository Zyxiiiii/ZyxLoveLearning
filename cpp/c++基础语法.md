# c++的第一个程序

```c++
#include <iostream>
using namespace std;

int main() 
{
	cout << "hello world" << endl;

	system("pause");
	return 0;
}
```

# 变量

## 创建变量的语法

* 数据类型 变量名 = 变量初始化值；	例：`int a = 0;`

```c++
#include <iostream>
using namespace std;

int main()
{
	int a = 10;
	cout << "a = " << a << endl;

	return 0;
}
```

# 常量

## 宏常量

* #define 常量名 常量值;	例：`#define DAY 7`

## `const`修饰的变量

* `const` 变量类型 变量名 = 变量值；	例：`const int MONTH = 12;`

```c++
#include <iostream>
using namespace std;

// 定义一个宏常量
#define DAY 7

int main()
{
	// 定义一个const修饰的变量
	const int MONTH = 12;
	cout << "一周有：" << DAY << "天" << endl;
	cout << "一年有：" << MONTH << "月" << endl;
	return 0;
}
```

# 标识符

* 标识符不得与关键字相同
* 标识符只能由字母、下划线"`_`"、数字组成
* 第一个字符必须是字母或下划线
* 区分大小写

<font style="color:gray">Tips：在取名时，要尽量做到见名知意，避免`a = 123;`这种让人不能一下子知道它是什么的变量名</font>

# 数据类型

## sizeof关键字

* 作用：统计变量/变量类型所占的内存空间的大小
* 语法：`sizeof(变量名/变量类型)`

<font style="color:gray">Tips具体例子在具体使用时会体现</font>

## 整型

| 数据类型  |                          占用空间                          |
| :-------: | :--------------------------------------------------------: |
|   short   |                           2 byte                           |
|    int    |                           4 byte                           |
|   long    | windows下为4 byte，Linux中为4 byte（32位）或8 byte（64位） |
| long long |                           8 byte                           |

* 以下为测试c++中各整型的长度（利用`sizeof`关键字）

```c++
#include <iostream>
using namespace std;

int main()
{
	// 短整型
	short a = 0;
	// 整型
	int b = 0;
	// 长整型
	long c = 0;
	// 长长整型
	long d = 0;

	cout << "short 类型的长度为：" << sizeof(a) << endl;
	cout << "int 类型的长度为：" << sizeof(b) << endl;
	cout << "long 类型的长度为：" << sizeof(c) << endl;
	cout << "long long 类型的长度为：" << sizeof(d) << endl;

	return 0;
}
```



![整型的数据长度](整型的数据长度.png)

## 浮点型（实型）

* 浮点型可以用于表示小数

| 数据类型 | 占用空间 | 有效数字范围 |
| :------: | :------: | :----------: |
|  float   |  4 byte  |     7位      |
|  double  |  8 byte  |   15~16位    |

* 以下为c++中各浮点型的使用以及所占内存空间的测试

``` c++
#include <iostream>
using namespace std;

int main()
{
	// 单精度浮点型
	float a = 123.12;
	// 双精度浮点型
	double b = 12.234;

	cout << "a = " << a << endl;
	cout << "b = " << b << endl;
	cout << "float 所占的内存空间大小为：" << sizeof(float) << endl;
	cout << "double 所占的内存空间大小为：" << sizeof(double) << endl;

	return 0;
}
```

![浮点型的使用和所占的内存空间大小](浮点型的使用和所占的内存空间大小.png)

