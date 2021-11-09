package io;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author zyx
 */
public class IoTest2 {
    @Test
    public void ioTest() throws FileNotFoundException {
        System.out.println(new FileReader("ioTest.txt"));
        System.out.println("===========================================");
        System.out.println("以下是io流中的路径");
        System.out.print("当相对路径不以'/'开头时:");
        File file1 = new File("");
        System.out.println(file1.getAbsolutePath());
        System.out.print("当相对路径以'/'时为开头:");
        File file2 = new File("/");
        System.out.println(file2.getAbsolutePath());
        System.out.println("===========================================");
        System.out.println("以下是getResource方法的路径");
        System.out.print("当相对路径不以'/'开头时:");
        System.out.println(getClass().getResource("").getPath());
        System.out.print("当相对路径以'/'时为开头:");
        System.out.println(getClass().getResource("/").getPath());
    }
}
