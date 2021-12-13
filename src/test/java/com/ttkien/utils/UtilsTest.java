package com.ttkien.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * UnitTest class for {@link Utils} class
 *
 * @author ttkien 10-31-2021
 */
public class UtilsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));

    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);

    }

    @Test
    public void testConfirmExit() {
        assertTrue(Utils.confirmExit(new Scanner("y")));
        assertFalse(Utils.confirmExit(new Scanner("n")));
    }

    @Test
    public void testConfirmExitWrongInput() {
        assertTrue(Utils.confirmExit(new Scanner("ad\ny")));
        assertTrue(outContent.toString().contains("Please enter y or n"));

    }

    @Test
    public void testPrintMsg() {
        Utils.printMsg("program.exit.confirm.error.msg");
        assertEquals("Please enter y or n\n", outContent.toString());
    }

    @Test
    public void testPrintStartupBanner() {
        Utils.printStartupBanner();
        assertEquals("================================================================================\n" +
                "         ____           _                    _           \n" +
                "        |  _ \\ ___  ___| |_ __ _ _ __   __ _| | ___  ___ \n" +
                "        | |_) / _ \\/ __| __/ _` | '_ \\ / _` | |/ _ \\/ __|\n" +
                "        |  _ <  __/ (__| || (_| | | | | (_| | |  __/\\__ \\\n" +
                "        |_| \\_\\___|\\___|\\__\\__,_|_| |_|\\__, |_|\\___||___/\n" +
                "                                       |___/             \n" +
                "================================================================================\n" +
                "A Rectangle is an area in a coordinate space that is presented by its lower-left\n" +
                "point (x,y) in the coordinate space, its width, and its height. This program help\n" +
                "creating two rectangles based on user input values then analyze the features that \n" +
                "exist among them and visualizing them on the coordinate space if it is possible\n" +
                "================================================================================\n" +
                "\n", outContent.toString());
    }

    @Test
    public void testPrintStr() {
        Utils.printStr("Hello");
        assertEquals("Hello\n", outContent.toString());
    }

    @Test
    public void testPrintMsgWithAnArgument() {
        Utils.printMsg("rectangle.adjacency.title", "Proper");
        assertEquals("- Adjacency           : Proper adjacency\n\n", outContent.toString());
    }

    @Test
    public void testPrintMsgWithArguments() {
        Utils.printMsg("rectangle.containment.title", new Object[]{1, "A", "B"});
        assertEquals("- Containment         : A contains B\n\n", outContent.toString());
    }
}

