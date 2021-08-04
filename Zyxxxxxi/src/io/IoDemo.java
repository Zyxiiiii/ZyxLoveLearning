package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author zyx
 */
public class IoDemo {
    public static void main(String[] args) throws IOException {

    }

    /**
     * 字节输出流（从文件开头开始写入）
     */
    public static void writeAtFirst() throws IOException {
        /*无参构造器创建对象，这种对象写入的数据只会从文件的开头开始写入*/
        FileOutputStream os = new FileOutputStream("C:\\Users\\zyx\\Desktop\\Java\\JavaLearn\\Zyxxxxxi\\ioTest.txt");

        /*创建一组字节数据*/
        byte[] bys1 = "****print1\r\n".getBytes();
        byte[] bys2 = "****print2\r\n".getBytes();
        byte[] bysLn = "\r\n".getBytes();

        /*写入数据*/

        /*方法一*/
        /*这种输入方法输入的是字符的ASCII码，并不是真实的数字*/
        os.write(97);
        os.write(bysLn);

        /*方法二*/
        os.write(bys1);

        /*将数据按偏移量和数据长度写入到字符数组中,
         * 注意，不是按照数据偏移多少开始写入，而是从data数组中的第几个下标开始写入数据，
         * length设定了读取的数据长度*/

        /*方法三*/
        os.write(bys2, 4, 6);
        os.write(bysLn);


        /*os.flush();*/

        /*close方法会自动先flush，再关闭流*/
        os.close();
    }

    /**
     * 字节输出流（从文件末尾开始写入）
     */
    public static void writeAtLast() throws IOException {
        /*在末尾写入数据*/

        /*这种方法写入数据需要构造器的第二个参数的布尔值位true，才能完成从数据最后一个开始写入，
         * 否则和无参构造器的写入方法相同。*/
        FileOutputStream fos = new FileOutputStream("C:\\Users\\zyx\\Desktop\\Java\\JavaLearn\\Zyxxxxxi\\ioTest.txt", true);
        fos.write("Lqq is stupid\r\n".getBytes());
        fos.write("Lqq is stupid\r\n".getBytes());

        /*os.flush();*/

        /*close方法会自动先flush，再关闭流*/
        fos.close();
    }

    /**
     * 字节输入流（读取文件全部内容，忽略了无参的read方法）
     */
    public static void readAll() throws IOException {
        /*创建输入流对象*/
        FileInputStream is = new FileInputStream(new File("C:\\Users\\zyx\\Desktop\\Java\\JavaLearn\\Zyxxxxxi\\ioTest.txt"));

        /*建立一个字节数组用于存放获取到的数据*/
        byte[] data = new byte[1024];

        /*用read(byte[])方法一次性读取一个字符数组*/
        is.read(data);

        /*释放流*/
        is.close();

        /*把获取到的数据存放到一个字符串中，并解码*/
        String s = new String(data, StandardCharsets.UTF_8);

        /*输出获得的数据*/
        System.out.println(s);
    }

    /**
     * 字节输入流（从数组的第几位开始读取数据）
     */
    public static void readOffset() throws IOException {
        /*创建输入流对象*/
        FileInputStream is = new FileInputStream("C:\\Users\\zyx\\Desktop\\Java\\JavaLearn\\Zyxxxxxi\\ioTest.txt");

        /*创建一个字符数组用于获取读取到的数据*/
        byte[] data = new byte[1024];
        data[0] = 92;
        data[1] = 'j';
        data[2] = '3';
        data[3] = 'm';
        data[4] = 'l';

        /*将数据按偏移量和数据长度存放到字符数组中,
         * 注意，不是按照数据偏移多少开始读取，而是从data数组中的第几个下标开始读取数据，
         * length设定了读取的数据长度*/

        /* read(byte[] data, int offset, int len)*/
        is.read(data, 5, 100);

        /*将字符数据解码并存放进字符串中*/
        String s = new String(data, StandardCharsets.UTF_8);

        /*释放流*/
        is.close();

        /*输出*/
        System.out.println(s);
    }

    /*以下是较常用的字节缓冲流，
     * 使用它们可以提高读写效率。*/

    /**
     * 字节输出缓冲流
     */
    public static void bfWriter() throws IOException {
        /*BufferedWriter只是一个缓冲流，其底层还是输出流，所以构造器需要传入一个文件输出流对象,
         * 而FileWriter构造器通过查源码可知，它返回的就是一个文件输出流对象*/
        BufferedWriter bfWrite = new BufferedWriter(new FileWriter("C:\\Users\\zyx\\Desktop\\Java\\JavaLearn\\Zyxxxxxi\\ioTest.txt", true));

        /*写一行行分隔符。注意:这里的newLine方法可以自动适配不同操作系统不同的分行符*/
        bfWrite.newLine();

        /*将数据写入文件对象，缓冲流不需要将字符串转换为字节数组*/
        bfWrite.write("abc");

        bfWrite.newLine();

        /*释放流*/
        bfWrite.close();

    }


}

