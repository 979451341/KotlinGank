package com.zzw.componentbase.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    /**
     * 描述：获取表示当前日期时间的字符串.
     *
     * @param format 格式化字符串，如："yyyy-MM-dd HH:mm:ss"
     * @return String String类型的当前日期时间
     */
    public static String getCurrentDate(String format) {


        String curDateTime = null;
        try {
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);

            curDateTime = mSimpleDateFormat.format(getDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return curDateTime;

    }

    public static Date getDate() {
        Calendar c = new GregorianCalendar();

        return c.getTime();

    }


    /**
     * 时间戳转字符串
     * @param time
     * @return
     */
    public static String longTimetoStr(Long time){
        String reStrTime=null;

        SimpleDateFormat mSimpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        reStrTime=mSimpleDateFormat.format(new Date(time));
        return reStrTime;
    }

    /**
     * 时间戳转字符串
     * @param time
     * @return
     */
    public static String longTimetoStr(Long time, String format){
        String reStrTime=null;

        SimpleDateFormat mSimpleDateFormat=new SimpleDateFormat(format);
        reStrTime=mSimpleDateFormat.format(new Date(time));
        return reStrTime;
    }

    /**
     * 本周星期一至今日时间范围
     * long[0] 今天时间戳
     * long[1] 星期一零点时间戳
     */
    public static long[] getThisWeekStamp(){
        long[] timestamp = new long[2];
        Calendar cal = Calendar.getInstance();
        timestamp[0] = cal.getTimeInMillis();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 获取本周一的日期
        cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH),0,0,0);
        timestamp[1] = cal.getTimeInMillis();
        return  timestamp;
    }

    /**
     * long[0] 月的第一天
     * long[1] 月的最后一天
     * @param flag flag=0为本月，
     */
    public static long[] getMonthStamp(int flag){
        long[] timestamp = new long[2];
        Calendar cal = Calendar.getInstance();
//        Calendar ca = Calendar.getInstance();
        cal.add(Calendar.MONTH, flag);
        cal.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH),0,0,0);
        timestamp[0] = cal.getTimeInMillis();

        // 获取当前月最后一天
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH,
                cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH),23,59,59);
        timestamp[1] = cal.getTimeInMillis();
        return timestamp;
    }

    /**获取某月共多少天*/
    public static int getMaxDayOfMonth(int year,int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,0);
        return  calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**获取某月共多少天*/
    public static int getMaxDayOfMonth(long timestamp){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        return  calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取本年
     */
    public static int getThisYear(){
        Calendar calendar = Calendar.getInstance();
        return  calendar.get(Calendar.YEAR);
    }

    /**
     * 字符串转Long时间戳
     * @param str 字符串 格式：yyyy年MM月dd日HH时mm分ss秒
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static Long strToLongTime(String str){
        SimpleDateFormat mSimpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date ;
        long l=0;
        try {
            date=mSimpleDateFormat.parse(str);
            l=date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return l;
    }

    /**
     * 获取某天的零点时间戳
     * @param timestamp
     * @return
     */
    public static Long GetDayOfminTimestamp(long timestamp){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),0,0,0);
        return calendar.getTimeInMillis();
    }

}
