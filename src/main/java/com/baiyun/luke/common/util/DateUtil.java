package com.baiyun.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

        /**
         * 格式化 输入当前日期
         * @return
         */
        public static String getFormatDate(String format) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(new Date());
        }

        /**
         * 格式化 输入当前日期
         * @return
         */
        public static String getFormatTime(String format) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(new Date());
        }

        /**
         * 格式化 输入当前日期时间yyyy-MM-dd HH:mm:ss
         * @return
         */
        public static String getFormatDateTime(String format) {
            DateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(new Date());
        }

        /**
         * 格式化 输入当前日期
         *
         * @param date
         * @param format
         *            yyyy-MM-dd
         * @return
         */
        public static String getDateFormat(Date date, String format) {
            if (date == null)
                return "";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }

        /**
         * 日期默认格式化
         *
         * @param date
         *            日期
         * @return 格式化字符串，格式:yyyy-MM-dd hh:mm:ss
         */
        public static String getDefaultFormat(Date date) {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.CHINA);
            return df.format(date);
        }

        public static Date getStringTime1(String dateStr) throws Exception {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = sdf.parse(dateStr);
            } catch (ParseException e) {
                throw new RuntimeException("格式化转换日期失败");
            }
            return date;
        }

        /**
         * 获取当前日期的日期字符串 如：20111201
         *
         * @return
         */
        public static String getDateString() {
            StringBuffer dateStr = new StringBuffer();
            Calendar now = Calendar.getInstance();
            Integer year = now.get(Calendar.YEAR);
            dateStr.append(year);
            Integer month = now.get(Calendar.MONTH) + 1;
            if (month.toString().length() == 1) {
                dateStr.append("0");
                dateStr.append(month);
            } else {
                dateStr.append(month);
            }
            Integer day = now.get(Calendar.DAY_OF_MONTH);
            if (day.toString().length() == 1) {
                dateStr.append("0");
                dateStr.append(day);
            } else {
                dateStr.append(day);
            }
            return dateStr.toString();
        }

        /**
         * 获取当前日期的时间字符串 如：0100
         *
         * @return
         */
        public static String getTimeString() {
            StringBuffer dateStr = new StringBuffer();
            Calendar now = Calendar.getInstance();
            Integer hour = now.get(Calendar.HOUR_OF_DAY);
            if (hour.toString().length() == 1) {
                dateStr.append("0");
                dateStr.append(hour);
            } else {
                dateStr.append(hour);
            }
            Integer minute = now.get(Calendar.MINUTE);
            if (minute.toString().length() == 1) {
                dateStr.append("0");
                dateStr.append(minute);
            } else {
                dateStr.append(minute);
            }
            return dateStr.toString();
        }

        /**
         * 日期数据转换为默认格式的字符串 日期格式"yyyy-MM-dd HH:mm:ss"
         *
         * @param DateStr
         * @return
         * @throws ParseException
         */
        public static String dataToString(Date DateStr) throws ParseException {
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(DateStr);
            return date;
        }

        /**
         * 字符串转换为默认格式的日期 日期格式"yyyy-MM-dd HH:mm:ss"
         *
         * @param dateStr
         * @return
         * @throws ParseException
         */
        public static Date stingTODate(String dateStr) throws ParseException {
            Date date = null;
            if (dateStr != null && (!dateStr.equals(""))) {
                if (dateStr.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {

                    dateStr = dateStr + " 00:00";

                } else if (dateStr.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}")) {

                    dateStr = dateStr + ":00";

                } else {
                    return null;
                }
            }
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = format.parse(dateStr);
            return date;

        }

        /**
         * 字符串转换为指定格式的字符串
         *
         * @param dateStr
         * @param arg
         *            日期格式
         * @return
         * @throws ParseException
         */
        public static Date stingTODate(String dateStr, String arg) throws ParseException {
            if (dateStr != null && (!dateStr.equals(""))) {
                DateFormat format = new SimpleDateFormat(arg);
                Date date = format.parse(dateStr);
                return date;
            }
            return null;
        }

        /**
         * sqlDa.据转换为util.Date数据
         *
         * @param sqlData
         * @return
         */
        public static java.util.Date sqlToUntil(java.sql.Date sqlData) {
            java.util.Date untilDate = new java.util.Date(sqlData.getTime());
            return untilDate;
        }

        /**
         * util.Date数据转换为sql.Date数据
         *
         * @param utilData
         * @return
         */
        public static java.sql.Date untilToSql(java.util.Date utilData) {
            java.sql.Date sqllDate = new java.sql.Date(utilData.getTime());
            return sqllDate;
        }

        /**
         * 根据起始日期和相差天数获取日期
         *
         * @param startDate
         *            起始日期 例如：18991231
         * @param dayCount
         *            相差天数
         * @return
         * @throws ParseException
         */
        public static Date getDateByDayCount(String startDate, int dayCount) throws ParseException {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(new SimpleDateFormat("yyyyMMdd").parse(startDate).getTime()));
            calendar.add(Calendar.DAY_OF_MONTH, dayCount);
            return calendar.getTime();
        }

        /**
         * 根据起始日期和结束日期获得相隔天数
         *
         * @param startDate
         *            起始日期 例如：18991231
         * @param endDate
         *            结束日期 例如：20121231
         * @return
         * @throws ParseException
         */
        public static Long getRemainingdays(String startDate, String endDate) throws Exception {
            long start = new SimpleDateFormat("yyyyMMdd").parse(startDate).getTime();
            long end = new SimpleDateFormat("yyyyMMdd").parse(endDate).getTime();

            long day = (end - start) / 1000 / 60 / 60 / 24;
            return day;
        }

    }

