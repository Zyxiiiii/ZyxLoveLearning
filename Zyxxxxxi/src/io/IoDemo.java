package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zyx
 */
public class IoDemo {
    public static void main(String[] args) throws IOException {
        /*创建文件输入输出流*/
        FileInputStream is = new FileInputStream(new File("C:\\Users\\zyx\\Desktop\\Java\\JavaLearn\\Zyxxxxxi\\ioTest.txt"));
//        FileOutputStream os = new FileOutputStream(new File("C:\\Users\\zyx\\Desktop\\Java\\JavaLearn\\Zyxxxxxi\\ioTest.txt"));

//        /*创建一组字节数据*/
//        byte[] bys1 = "****print1\r\n".getBytes();
//        byte[] bys2 = "****print2\r\n".getBytes();
//        byte[] bysLn = "\r\n".getBytes();
//        /*写入数据*/
//
//        /*方法一*/
//        /*这种输入方法输入的是字符的ASCII码，并不是真实的数字*/
//        os.write(97);
//        os.write(bysLn);
//
//        /*方法二*/
//        os.write(bys1);
//
//        /*方法三*/
//        os.write(bys2, 4, 6);


//        /*在末尾写入数据*/
//        FileOutputStream fos = new FileOutputStream("C:\\Users\\zyx\\Desktop\\Java\\JavaLearn\\Zyxxxxxi\\ioTest.txt", true);
//        fos.write("Lqq is stupid\r\n".getBytes());
//        fos.write("Lqq is stupid\r\n".getBytes());
//
//        /*os.flush();*/
//
//        /*close方法会自动先flush，再关闭流*/
//        os.close();

        /*读取数据*/

    }


}

