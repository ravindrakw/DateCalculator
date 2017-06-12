package com.ravindra.dayscalculator;

/**
 * Created by Ravindra on 6/10/2017.
 */
public class DaysCalculator {
    /**
     * no of days elapsed still last month
     */
    int[] elapsedMonthDays = {0,31,59,90,120,151,181,212,243,273,304,334};


    /**
     * @param firstDate 8 char string
     * @param secondDate 8 char string
     * @return no of days between two dates
     */
    public long daysBetween(String firstDate, String secondDate) {
        String startDate;
        String endDate;
        if (firstDate.compareTo(secondDate) < 0) {
            startDate = firstDate;
            endDate = secondDate;
        } else {
            startDate = secondDate;
            endDate = firstDate;
        }
        int dayofStart = Integer.parseInt(startDate.substring(6));
        int monthofstart = Integer.parseInt(startDate.substring(4,6));
        int yearofstart = Integer.parseInt(startDate.substring(0,4));
        int dayofend = Integer.parseInt(endDate.substring(6));
        int monthofend = Integer.parseInt(endDate.substring(4,6));
        int yearofend = Integer.parseInt(endDate.substring(0,4));
        long daysOffset =  yearsInDaysOffset(yearofstart, yearofend)
                + monthInDaysOffset(monthofstart, monthofend)
                + daysOffset(dayofStart, dayofend);

        if(isLeap(yearofend) && monthofstart == 2 && dayofStart < 29 && monthofend > 2) {
            daysOffset++;
        }

        return (daysOffset < 0) ? 0 : daysOffset;
    }

    /**
     * @param dayofstart just day of startdate
     * @param dayofend just day of endDate
     * @return no of days difference between these two dates
     */
    public int daysOffset(int dayofstart, int dayofend) {
        return (dayofend - dayofstart - 1);
    }

    public int monthInDaysOffset(int monthofstart, int monthofend) {
        return elapsedMonthDays[monthofend - 1] - elapsedMonthDays[monthofstart - 1];
    }

    /**
     * @param yearofstart
     * @param yearofend
     * @return if same year return zero. Else calculate the days in elapsed years
     * excluding the years. Find out no of leap years till then and add one day per each
     * leap year.
     */
    public long yearsInDaysOffset(int yearofstart, int yearofend) {
        if (yearofend == yearofstart) {
            return 0;
        } else {
            int actualYearStart = yearofstart - 1;
            int actualYearEnd = yearofend - 1;
            long daysoffsetStartYear = (int) (actualYearStart / 4) + (actualYearStart * 365);
            long daysoffsetEndYear = (int) (actualYearEnd / 4) + (actualYearEnd * 365);
            return daysoffsetEndYear - daysoffsetStartYear;
        }
    }

    private boolean isLeap(int leap) {
        return ((leap % 4 == 0 && leap % 100 != 0) || leap % 400 == 0);
    }
}
