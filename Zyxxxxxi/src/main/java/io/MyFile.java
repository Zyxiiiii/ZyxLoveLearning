package io;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author zyx
 */
public class MyFile {

    public static File file1 = new File("C:\\Users\\zyx\\Desktop\\Java\\JavaLearn\\Zyxxxxxi\\fileTest.txt");
    public static File file2 = new File("C:\\Users\\zyx\\Desktop\\Java\\JavaLearn\\Zyxxxxxi\\dirTest");
    public static File file3 = new File("C:\\Users\\zyx\\Desktop\\Java\\JavaLearn\\Zyxxxxxi\\dirs\\dirsTest");
    public static File file4 = new File("C:\\Users\\zyx\\Desktop\\Java\\JavaLearn\\Zyxxxxxi\\dirs");



    public static void createFile() throws IOException {
        file1.createNewFile();
    }

    public static boolean createDir() {
        return file2.mkdir();
    }

    public static boolean createDirs() {
        return file3.mkdirs();
    }

    public static boolean delFile() {
        return file1.delete();
    }

    public static boolean delDir() {
        return file2.delete();
    }

    public static boolean delDirs() {
        return file4.delete();
    }


}
