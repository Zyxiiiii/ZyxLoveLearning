# C语言函数记录

## I/O

### File



```c
/*
	打开一个文件（流）
		参数：
			path:文件的路径
			mode:打开的模式
*/
FILE* fopen(const char * restrict path,const char * restrict mode);
/*
	关闭一个文件（流）
		参数：stream:待关闭的文件流
*/
int fclose(FILE *stream);
/*
	写入内容到文件中
*/
fscanf(FILE*, ...);
/*
	从文件中读取内容
*/
fprintf(FILE*, ...);
```

- `fileMode`的一些参数
  - `r`：打开只读
  - `r+`：打开读写，从文件头开始
  - `w`：打开只写。如果不存在则新建，如果存在则清空
  - `w+`：打开读写。如果不存在则新建，如果存在则清空
  - `a`：打开追加。如果不存在则新建，如果存在则从文件尾开始
  - `..x`：只新建，如果文件已存在则不能打开

### 二进制

```c
size_t fread(void * restrict ptr, size_t size,size_t nitems,FILE * restrict stream);
size_t fwrite(const void * restrict ptr, size_t size, size_t nitems, FILE * restrict stream);
```

