package com.ttkien;

import com.ttkien.model.Rectangle;
import com.ttkien.utils.RectangleUtil;
import com.ttkien.utils.Utils;

import java.util.Scanner;

/**
 * A java program to experiment the features of two rectangles
 *
 * @author ttkien 10-31-2021
 */
public class Application {
    public static void main(String[] args) {

        //Print the startup banner
        Utils.printStartupBanner();

        Scanner scanner = new Scanner(System.in);

        //The program will continue until user confirms to exit
        while (true) {

            Utils.printMsg("rectangle.create.msg", new Object[]{Integer.MIN_VALUE, Integer.MAX_VALUE});

            Rectangle[] rectangles = new Rectangle[2];

            //Ask user to input the value to create two rectangles
            for (int i = 0; i < 2; i++) {

                Utils.printMsg("rectangle.create.ask.msg", i);

                int[] value = RectangleUtil.readInput(scanner);

                rectangles[i] = new Rectangle(value[0], value[1], value[2], value[3]);
            }

            Utils.printMsg("program.result.msg", new Object[]{rectangles[0], rectangles[1]});

            //Analyze the features among rectangles
            Utils.printStr(RectangleUtil.analyzeFeatures(rectangles[0], rectangles[1]));

            //Visualize rectangles on console if it is possible
            Utils.printStr(RectangleUtil.visualizeOnConsole(rectangles[0], rectangles[1]));

            if (Utils.confirmExit(scanner)) continue;

            break;
        }

        Utils.printMsg("program.exit.msg");

        scanner.close();
    }
}
