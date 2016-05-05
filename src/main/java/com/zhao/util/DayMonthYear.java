package com.zhao.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by zhao on 2016/4/22.
 */
public class DayMonthYear {
    public String getDayDate(String beginTime, String endTime) throws Exception {
        List<String> list = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long sTime = sdf.parse(beginTime).getTime();
        long eTime = sdf.parse(endTime).getTime();
        String day = "";
        for (long i = sTime; i <= eTime;) {
            String temp = sdf.format(new Date(i));
//			list.add(temp);
            day +="'"+temp+"'";
            i += 24 * 3600 * 1000;
        }
        return day;
    }

    public String getMonthDate(String beginTime, String endTime)throws Exception {
        List<String> list = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date SDate = sdf.parse(beginTime); // 结束时间-起始时间
        Date EDate = sdf.parse(endTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(SDate);
        int sYear = calendar.get(Calendar.YEAR);
        int sMonth = calendar.get(Calendar.MONTH);
        calendar.setTime(EDate);
        int eYear = calendar.get(Calendar.YEAR);
        int eMonth = calendar.get(Calendar.MONTH);
        int esmonth = eYear * 12 + eMonth - sYear * 12 - sMonth;
        String month = "";
        for (int i = 0; i <= esmonth; i++) {
            sMonth = sMonth + 1;
            if (sMonth == 13) {
                sMonth = 1;
                sYear = sYear + 1;
            }
            if (sMonth < 10) {
                month += "'"+sYear + "-0" + sMonth+"'," ;
            } else {
                month += "'"+sYear + "-" + sMonth+"'," ;
            }
        }
        return month.substring(0, month.length()-1);
    }
    public String getYearDate(String beginTime, String endTime)throws Exception {
        List<String> list = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date SDate = sdf.parse(beginTime); // 结束时间-起始时间
        Date EDate = sdf.parse(endTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(SDate);
        int sYear = calendar.get(Calendar.YEAR);
        calendar.setTime(EDate);
        int eYear = calendar.get(Calendar.YEAR);
        int esmonth = eYear  - sYear ;
        String year = "";
        for (int i = 0; i <= esmonth; i++) {
            list.add(sYear+"");
            year += "'"+sYear+"',";
            sYear = sYear + 1;
        }
        return year.substring(0, year.length()-1);
    }

}
