package org.lvy.avocado.java8;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by livvy (livvyguo@gmail.com) on 16/1/22.
 */
public class MainTest {


    @Test
    public void testJoin() {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer integer = integers.stream().map((x) -> x * x).reduce((x, y) -> {
            int z = y - x;
            return z * (x + y);
        }).get();

        System.out.println(integer);

    }
}
