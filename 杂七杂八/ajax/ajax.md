# Ajax

要使用Ajax，需要使用浏览器内置的XMLHttpRequest对象，以下是获取这个对象的方法。

```javascript
<script type="text/javascript">
var xmlhttp;
function loadXMLDoc(url){
	xmlhttp=null;
	if (window.XMLHttpRequest){
  		// 新版的浏览器可以直接获取XMLHttpRequest对象
  		xmlhttp=new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		// 旧版的浏览器可以通过这种方式获取XMLHttpRequest对象
  		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (xmlhttp!=null){
        // 设置回调函数
	  	xmlhttp.onreadystatechange=state_Change;
        // 设置对象的请求参数(请求的类型'GET'/'POST',请求的url,设置请求为异步或同步，true为异步，false为同步)
	  	xmlhttp.open("GET",url,true);
        // 如果需要像 HTML 表单那样 POST 数据，请使用 setRequestHeader() 来添加 HTTP 头。
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        // send为真正发送请求的函数，参数为请求的请求体，GET请求一般不需要填写请求体，POST请求需要填写
	  	xmlhttp.send(null);
	} else {
        // 输出错误提示，表示没有获取到XMLHttpRequest对象
	  	alert("Your browser does not support XMLHTTP.");
	}
}

// 回调函数具体内容
function state_Change() {
    // readyState为XMLHttpRequest的状态值，状态值所示的意义如下表①所示
	if (xmlhttp.readyState === 4){
  		if (xmlhttp.status === 200) {
        	// status为服务器状态码，
			/*这里填写操作的具体代码*/
	    } else {
    		alert("Problem retrieving XML data");
    	}
  	}
}
</script>
```



| 状态 | 名称          | 描述                                                         |
| :--- | :------------ | :----------------------------------------------------------- |
| 0    | Uninitialized | 初始化状态。XMLHttpRequest 对象已创建或已被 abort() 方法重置。 |
| 1    | Open          | open() 方法已调用，但是 send() 方法未调用。请求还没有被发送。 |
| 2    | Sent          | Send() 方法已调用，HTTP 请求已发送到 Web 服务器。未接收到响应。 |
| 3    | Receiving     | 所有响应头部都已经接收到。响应体开始接收但未完成。           |
| 4    | Loaded        | HTTP 响应已经完全接收。                                      |

*表①*

