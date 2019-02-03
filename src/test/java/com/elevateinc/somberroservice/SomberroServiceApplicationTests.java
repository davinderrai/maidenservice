package com.elevateinc.somberroservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SomberroServiceApplicationTests {

    @LocalServerPort
    int randomServerPort;

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
        String message = "Hello world";
        assertEquals(message, "Hello world");
    }

    @Test
    public void test3() {
        String message = "Hello world Unit test";
        assertEquals(message, "Hello world Unit test");
    }

    @Test
    public void test4() {
        Integer sum = new Integer(10);
        assertEquals(sum.intValue(), 10);
    }
}

