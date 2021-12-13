package com.ttkien.utils;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * The Utils class provide supportive methods to manipulate with localized string and printing of strings to console
 *
 * @author ttkien - 10-31-2021
 */
public class Utils {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages");

    private static final String[] BANNER = {
            "================================================================================",
            "         ____           _                    _           ",
            "        |  _ \\ ___  ___| |_ __ _ _ __   __ _| | ___  ___ ",
            "        | |_) / _ \\/ __| __/ _` | '_ \\ / _` | |/ _ \\/ __|",
            "        |  _ <  __/ (__| || (_| | | | | (_| | |  __/\\__ \\",
            "        |_| \\_\\___|\\___|\\__\\__,_|_| |_|\\__, |_|\\___||___/",
            "                                       |___/             ",
            "================================================================================"};

    /**
     * Get a string from messages property file for the provided key and injected with the values contained in the parameter
     *
     * @param key  the key to get message string
     * @param args the array that contains values to inject to the result string
     * @return the result string
     */
    public static String getMessage(String key, Object[] args) {
        return MessageFormat.format(bundle.getString(key), args);
    }

    /**
     * Get a string from messages property file for the provided key
     *
     * @param key the key to get message string
     * @return the result string
     */
    public static String getMessage(String key) {
        return MessageFormat.format(bundle.getString(key), new Object[]{});
    }

    /**
     * Print a message string represented by a key to the console which also injected with multiple values contained in
     * the input parameter
     *
     * @param key  the key to get message string
     * @param args the array that contains values to inject to the string
     */
    public static void printMsg(String key, Object[] args) {
        printStr(getMessage(key, args));
    }

    /**
     * Print a message string represented by a key to the console which injected with a parameter
     *
     * @param key the key to get message string
     * @param arg the value to inject to the string
     */
    public static void printMsg(String key, Object arg) {
        printMsg(key, new Object[]{arg});
    }

    /**
     * Print a message string represented by a key to the console
     *
     * @param key the key to get message string
     */
    public static void printMsg(String key) {
        printMsg(key, new Object[0]);
    }

    public static void printStr(String str) {
        System.out.println(str);
    }

    /**
     * Confirm with user to exit the program.
     *
     * @param in the {@link Scanner}
     * @return true if user want to exit program, otherwise, return false
     */
    public static boolean confirmExit(Scanner in) {
        printMsg("program.exit.confirm.msg");
        while (true) {
            String value = in.nextLine();
            if (value.equals("y")) {
                return true;
            } else if (value.equals("n")) {
                return false;
            } else {
                printMsg("program.exit.confirm.error.msg");
            }
        }
    }

    /**
     * Print the startup banner to the console
     */
    public static void printStartupBanner() {

        for (String line : BANNER) {
            printStr(line);
        }

        printMsg("rectangle.introduction.msg", new Object[0]);
        printMsg("utils.separate.line", new Object[0]);
        printStr("");

    }
}
