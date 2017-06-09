package com.ravindra.dayscalculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class DaysCalculatorTest {
    @Test
    public void testStartEndEqual() throws Exception {
        DaysCalculator daysCalculator = new DaysCalculator();
        assertThat(daysCalculator.daysBetween("19721107", "19721107"), is(0L));
    }

    @Test
    public void testStartEndOneDayApart() throws Exception {
        DaysCalculator daysCalculator = new DaysCalculator();
        assertThat(daysCalculator.daysBetween("19721107", "19721108"), is(0L));
    }

    @Test
    public void testStartEndLeap() throws Exception {
        DaysCalculator daysCalculator = new DaysCalculator();
        assertThat(daysCalculator.daysBetween("19840201", "19840301"), is(28L));
    }

    @Test
    public void testStartEndTestData1() throws Exception {
        DaysCalculator daysCalculator = new DaysCalculator();
        assertThat(daysCalculator.daysBetween("19830602", "19830622"), is(19L));
    }

    @Test
    public void testStartEndTestData2() throws Exception {
        DaysCalculator daysCalculator = new DaysCalculator();
        assertThat(daysCalculator.daysBetween("19840704", "19841225"), is(173L));
    }

    @Test
    public void testStartEndTestData3() throws Exception {
        DaysCalculator daysCalculator = new DaysCalculator();
        assertThat(daysCalculator.daysBetween("19890103", "19830803"), is(1979L));
    }


}