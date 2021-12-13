package com.ttkien.utils;

import com.ttkien.model.Rectangle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * UnitTest class for {@link RectangleUtil}
 *
 * @author ttkien 10-31-2021
 */
public class RectangleUtilTest {

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
    public void testAnalyzeFeatures_thenExpectContainmentAndProperAdjacency() {
        Rectangle r1 = new Rectangle();
        assertEquals("- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                + "- Containment         : Rectangle {x=0, y=0, w=0, h=0} contains Rectangle {x=0, y=0, w=0, h=0}\n"
                + "- Adjacency           : PROPER adjacency\n", RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneOfFeaturesExist() {
        Rectangle r1 = new Rectangle(2, 3, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneOfFeaturesExist1() {
        Rectangle r1 = new Rectangle();
        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneOfFeaturesExist2() {
        Rectangle r1 = new Rectangle(0, 3, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneOfFeaturesExis3() {
        Rectangle r1 = new Rectangle(-1, 3, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneOfFeaturesExist4() {
        Rectangle r1 = new Rectangle(2, 0, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneOfFeaturesExist5() {
        Rectangle r1 = new Rectangle(2, -1, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneOfFeaturesExist6() {
        Rectangle r1 = new Rectangle(2, 3, 1, 1);

        assertEquals(
                "- Intersection        : There is intersection\n" + "- Intersection Points : [(2,3), (2,4), (3,4), (3,3)]\n"
                        + "- Containment         : Rectangle {x=2, y=3, w=1, h=1} contains Rectangle {x=2, y=3, w=1, h=1}\n"
                        + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectContainmentAndSublineAdjacency() {
        Rectangle r1 = new Rectangle(0, 0, 1, 1);

        assertEquals("- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                + "- Containment         : Rectangle {x=0, y=0, w=1, h=1} contains Rectangle {x=0, y=0, w=0, h=0}\n"
                + "- Adjacency           : SUB_LINE adjacency\n", RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectContainmentAndSublineAdjacency2() {
        Rectangle r1 = new Rectangle(0, -1, 1, 1);

        assertEquals("- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                + "- Containment         : Rectangle {x=0, y=-1, w=1, h=1} contains Rectangle {x=0, y=0, w=0, h=0}\n"
                + "- Adjacency           : SUB_LINE adjacency\n", RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectContainmentAndSublineAdjacency3() {
        Rectangle r1 = new Rectangle(-1, -1, 1, 1);

        assertEquals("- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                + "- Containment         : Rectangle {x=-1, y=-1, w=1, h=1} contains Rectangle {x=0, y=0, w=0, h=0}\n"
                + "- Adjacency           : SUB_LINE adjacency\n", RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneOfFeaturesExist7() {
        Rectangle r1 = new Rectangle(2, 0, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectContainmentAndProperAdjacency1() {
        Rectangle r1 = new Rectangle(1, 3, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : PROPER adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneOfFeaturesExist8() {
        Rectangle r1 = new Rectangle(Integer.MIN_VALUE, 3, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneOfFeaturesExist9() {
        Rectangle r1 = new Rectangle(2, Integer.MIN_VALUE, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectContainmentAndProperAdjacency2() {
        Rectangle r1 = new Rectangle(2, 3, 0, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : Rectangle {x=2, y=3, w=1, h=1} contains Rectangle {x=2, y=3, w=0, h=1}\n"
                        + "- Adjacency           : PROPER adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectIntersectionAndContainment() {
        Rectangle r1 = new Rectangle(2, 3, 4, 1);

        assertEquals(
                "- Intersection        : There is intersection\n" + "- Intersection Points : [(2,3), (2,4), (3,4), (3,3)]\n"
                        + "- Containment         : Rectangle {x=2, y=3, w=4, h=1} contains Rectangle {x=2, y=3, w=1, h=1}\n"
                        + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectPartialAdjacency2() {
        Rectangle r1 = new Rectangle(1, 3, 1, 0);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : PARTIAL adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectIntersectionAndContainment1() {
        Rectangle r1 = new Rectangle(2, 3, 4, 4);

        assertEquals("- Intersection        : There is intersection\n" + "- Intersection Points : [(2,3), (2,4), (3,3)]\n"
                + "- Containment         : Rectangle {x=2, y=3, w=4, h=4} contains Rectangle {x=2, y=3, w=1, h=1}\n"
                + "- Adjacency           : NONE adjacency\n", RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectSublineAdjacency() {
        Rectangle r1 = new Rectangle(1, 3, 1, 0);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : SUB_LINE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(0, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectSublineAdjacency1() {
        Rectangle r1 = new Rectangle(3, 3, 4, 4);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : SUB_LINE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectPartialAdjacency() {
        Rectangle r1 = new Rectangle(3, -1, 4, 4);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : PARTIAL adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectContainmentANdProperAdjacency() {
        Rectangle r1 = new Rectangle();
        assertEquals("- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                + "- Containment         : Rectangle {x=0, y=0, w=0, h=0} contains Rectangle {x=0, y=0, w=0, h=0}\n"
                + "- Adjacency           : PROPER adjacency\n", RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneFeaturesExist() {
        Rectangle r1 = new Rectangle(2, 3, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneFeaturesExist2() {
        Rectangle r1 = new Rectangle();
        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneFeaturesExist3() {
        Rectangle r1 = new Rectangle(0, 3, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneFeaturesExist4() {
        Rectangle r1 = new Rectangle(-1, 3, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneFeaturesExist5() {
        Rectangle r1 = new Rectangle(2, 0, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneFeaturesExist6() {
        Rectangle r1 = new Rectangle(2, -1, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectIntersectionAndContainment2() {
        Rectangle r1 = new Rectangle(2, 3, 1, 1);

        assertEquals(
                "- Intersection        : There is intersection\n" + "- Intersection Points : [(2,3), (2,4), (3,4), (3,3)]\n"
                        + "- Containment         : Rectangle {x=2, y=3, w=1, h=1} contains Rectangle {x=2, y=3, w=1, h=1}\n"
                        + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectContainmentAndSublineAdjacency4() {
        Rectangle r1 = new Rectangle(0, 0, 1, 1);

        assertEquals("- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                + "- Containment         : Rectangle {x=0, y=0, w=1, h=1} contains Rectangle {x=0, y=0, w=0, h=0}\n"
                + "- Adjacency           : SUB_LINE adjacency\n", RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectContainmentAndSublineAdjacency5() {
        Rectangle r1 = new Rectangle(0, -1, 1, 1);

        assertEquals("- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                + "- Containment         : Rectangle {x=0, y=-1, w=1, h=1} contains Rectangle {x=0, y=0, w=0, h=0}\n"
                + "- Adjacency           : SUB_LINE adjacency\n", RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectContainmentAndSublineAdjacency6() {
        Rectangle r1 = new Rectangle(-1, -1, 1, 1);

        assertEquals("- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                + "- Containment         : Rectangle {x=-1, y=-1, w=1, h=1} contains Rectangle {x=0, y=0, w=0, h=0}\n"
                + "- Adjacency           : SUB_LINE adjacency\n", RectangleUtil.analyzeFeatures(r1, new Rectangle()));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneFeaturesExist7() {
        Rectangle r1 = new Rectangle(2, 0, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectProperAdjacency() {
        Rectangle r1 = new Rectangle(1, 3, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : PROPER adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneFeaturesExist8() {
        Rectangle r1 = new Rectangle(Integer.MIN_VALUE, 3, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectNoneFeaturesExist9() {
        Rectangle r1 = new Rectangle(2, Integer.MIN_VALUE, 1, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectContainmentAndProperAdjacency3() {
        Rectangle r1 = new Rectangle(2, 3, 0, 1);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : Rectangle {x=2, y=3, w=1, h=1} contains Rectangle {x=2, y=3, w=0, h=1}\n"
                        + "- Adjacency           : PROPER adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectIntersectionAndContainment3() {
        Rectangle r1 = new Rectangle(2, 3, 4, 1);

        assertEquals(
                "- Intersection        : There is intersection\n" + "- Intersection Points : [(2,3), (2,4), (3,4), (3,3)]\n"
                        + "- Containment         : Rectangle {x=2, y=3, w=4, h=1} contains Rectangle {x=2, y=3, w=1, h=1}\n"
                        + "- Adjacency           : NONE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectPartialAdjacencyOnly() {
        Rectangle r1 = new Rectangle(1, 3, 1, 0);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : PARTIAL adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectIntersectionAndContainment4() {
        Rectangle r1 = new Rectangle(2, 3, 4, 4);

        assertEquals("- Intersection        : There is intersection\n" + "- Intersection Points : [(2,3), (2,4), (3,3)]\n"
                + "- Containment         : Rectangle {x=2, y=3, w=4, h=4} contains Rectangle {x=2, y=3, w=1, h=1}\n"
                + "- Adjacency           : NONE adjacency\n", RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectSublineAdjacencyOnly() {
        Rectangle r1 = new Rectangle(1, 3, 1, 0);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : SUB_LINE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(0, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectSublineAdjacencyOnly2() {
        Rectangle r1 = new Rectangle(3, 3, 4, 4);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : SUB_LINE adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAnalyzeFeatures_thenExpectPartialAdjacencyOnly2() {
        Rectangle r1 = new Rectangle(3, -1, 4, 4);

        assertEquals(
                "- Intersection        : No intersection\n" + "- Intersection Points : []\n"
                        + "- Containment         : No containment\n" + "- Adjacency           : PARTIAL adjacency\n",
                RectangleUtil.analyzeFeatures(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testVisualizeOnConsole_thenExpectVisualizableStringReturn() {
        Rectangle r1 = new Rectangle();
        assertEquals(
                "                                        \u001b[31m^ (y)\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m|\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_(x)\u001b[0m\n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n",
                RectangleUtil.visualizeOnConsole(r1, new Rectangle()));
    }

    @Test
    public void testVisualizeOnConsole_thenExpectVisualizableStringReturn2() {
        Rectangle r1 = new Rectangle(2, 3, 1, 1);

        assertEquals(
                "                                        \u001b[31m^ (y)\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m \u001b[32m_\u001b[0m\u001b[32m_\u001b[0m                            "
                        + "         \n"
                        + "                                        \u001b[31m|\u001b[0m \u001b[32m|\u001b[0m\u001b[32m|\u001b[0m                            "
                        + "         \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m|\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_(x)\u001b[0m\n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n",
                RectangleUtil.visualizeOnConsole(r1, new Rectangle()));
    }

    @Test
    public void testVisualizeOnConsole_thenExpectVisualizableStringReturn3() {
        Rectangle r1 = new Rectangle();
        assertEquals(
                "                                        \u001b[31m^ (y)\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m \u001b[32m_\u001b[0m\u001b[32m_\u001b[0m                            "
                        + "         \n"
                        + "                                        \u001b[31m|\u001b[0m \u001b[32m|\u001b[0m\u001b[32m|\u001b[0m                            "
                        + "         \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m|\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_(x)\u001b[0m\n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n",
                RectangleUtil.visualizeOnConsole(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testVisualizeOnConsole_thenExpectVisualizableStringReturn4() {
        Rectangle r1 = new Rectangle(0, 3, 1, 1);

        assertEquals(
                "                                        \u001b[31m^ (y)\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m\u001b[32m_\u001b[0m                              "
                        + "         \n"
                        + "                                        \u001b[32m|\u001b[0m\u001b[32m|\u001b[0m                              "
                        + "         \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m|\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_(x)\u001b[0m\n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n",
                RectangleUtil.visualizeOnConsole(r1, new Rectangle()));
    }

    @Test
    public void testVisualizeOnConsole_thenExpectVisualizableStringReturn5() {
        Rectangle r1 = new Rectangle(-40, 3, 1, 1);

        assertEquals(
                "                                        \u001b[31m^ (y)\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m                                      \u001b[31m|\u001b[0m                               "
                        + "         \n"
                        + "\u001b[32m|\u001b[0m\u001b[32m|\u001b[0m                                      \u001b[31m|\u001b[0m                               "
                        + "         \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m|\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_(x)\u001b[0m\n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n",
                RectangleUtil.visualizeOnConsole(r1, new Rectangle()));
    }

    @Test
    public void testVisualizeOnConsoleWithLargeRectangles_thenExpectWarningReturn() {
        Rectangle r1 = new Rectangle(40, 3, 1, 1);

        assertEquals(
                "\u001b[31mRectangles are too large to visualize on 80x80 coordinate space of the console.\n"
                        + "Try smaller rectangles to see their visualization on x y coordinate grids\u001b[0m",
                RectangleUtil.visualizeOnConsole(r1, new Rectangle()));
    }

    @Test
    public void testVisualizeOnConsoleWithLargeRectangles_thenExpectWarningReturn2() {
        Rectangle r1 = new Rectangle(Integer.MIN_VALUE, 3, 1, 1);

        assertEquals(
                "\u001b[31mRectangles are too large to visualize on 80x80 coordinate space of the console.\n"
                        + "Try smaller rectangles to see their visualization on x y coordinate grids\u001b[0m",
                RectangleUtil.visualizeOnConsole(r1, new Rectangle()));
    }

    @Test
    public void testVisualizeOnConsole_thenExpectVisualizableStringReturn6() {
        Rectangle r1 = new Rectangle(2, 3, 1, 1);

        assertEquals(
                "                                        \u001b[31m^ (y)\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m \u001b[32m_\u001b[0m\u001b[32m_\u001b[0m                            "
                        + "         \n"
                        + "                                        \u001b[31m|\u001b[0m \u001b[32m|\u001b[0m\u001b[32m|\u001b[0m                            "
                        + "         \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m|\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_(x)\u001b[0m\n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n",
                RectangleUtil.visualizeOnConsole(r1, new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testVisualizeOnConsole_thenExpectVisualizableStringReturn7() {
        Rectangle r1 = new Rectangle(0, 3, 40, 1);

        assertEquals(
                "                                        \u001b[31m^ (y)\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m"
                        + "\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m"
                        + "\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m"
                        + "\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m"
                        + "\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\n"
                        + "                                        \u001b[32m|\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m"
                        + "\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m"
                        + "\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m"
                        + "\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m"
                        + "\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m_\u001b[0m\u001b[32m|\u001b[0m\n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m|\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m\u001b[31m_\u001b[0m"
                        + "\u001b[31m_(x)\u001b[0m\n"
                        + "                                        \u001b[31m|\u001b[0m                                        \n",
                RectangleUtil.visualizeOnConsole(r1, new Rectangle()));
    }

    @Test
    public void testReadInputWithPositiveValues() {
        int[] result = RectangleUtil.readInput(new Scanner("1 2 3 4"));
        assertEquals(result.length, 4);
        assertEquals(result[0], 1);
        assertEquals(result[1], 2);
        assertEquals(result[2], 3);
        assertEquals(result[3], 4);
    }

    @Test
    public void testReadInputWithNegativeValues() {
        int[] result = RectangleUtil.readInput(new Scanner("1 -2 -3 4"));
        assertEquals(result.length, 4);
        assertEquals(result[0], 1);
        assertEquals(result[1], -2);
        assertEquals(result[2], -3);
        assertEquals(result[3], 4);
    }

    @Test
    public void testReadInputWithInvalidValues() {
        RectangleUtil.readInput(new Scanner("1 -2 -3\n1 2 3 4"));
        assertTrue(outContent.toString().contains("Error: The provided values are invalid"));
    }

    @Test
    public void testReadInputWithInvalidValues2() {
        RectangleUtil.readInput(new Scanner("1 -2 -3 a\n1 2 3 4"));
        assertTrue(outContent.toString().contains("Error: The provided values are invalid"));
    }
}

