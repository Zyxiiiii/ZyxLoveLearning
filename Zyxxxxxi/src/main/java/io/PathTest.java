package io;

import org.junit.Test;

import java.util.Objects;

/**
 * @author zyx
 */
public class PathTest {
    @Test
    public void pathTest(){
        String path = Objects.requireNonNull(getClass().getResource("src/ioTest.txt")).getPath();
        System.out.println(path);
    }
}
