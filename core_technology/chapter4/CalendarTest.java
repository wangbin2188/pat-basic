package core_technology.chapter4;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by wangbin10 on 2019/1/3.
 * 打印当月日历
 */
public class CalendarTest {
    public static void main(String[] args) {
        GregorianCalendar d = new GregorianCalendar();
        /**
         * 获取当前日期的月份和日子
         * 月份是0~11
         */
        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);
        /**
         * 将d设置为当前月份的第一天
         * 并获取这一天是一周中的第几天，一周的第一天
         */
        d.set(Calendar.DAY_OF_MONTH, 1);
        int weekDay = d.get(Calendar.DAY_OF_WEEK);
        int firstDayOfWeek = d.getFirstDayOfWeek();

        int intent = 0;
        while (weekDay != firstDayOfWeek) {
            intent++;
            //日子减一，一直减到当日是一周的第一天，得到缩进
            d.add(Calendar.DAY_OF_MONTH, -1);
            weekDay = d.get(Calendar.DAY_OF_WEEK);
        }
        /**
         * 获取表头——日期缩写
         */
        String[] weekdays = new DateFormatSymbols().getShortWeekdays();

        do {
            System.out.printf("%4s", weekdays[weekDay]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekDay = d.get(Calendar.DAY_OF_WEEK);
        } while (weekDay != firstDayOfWeek);
        System.out.println();
        /**
         * 打印1号之前的空白
         */
        for (int i = 1; i < intent; i++) {
            System.out.print("              ");
        }
        d.set(Calendar.DAY_OF_MONTH, 1);

        /**
         * 只要不出当月，则继续打印
         */
        do {
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day);
            if (day == today) {
                System.out.print("*  ");
            } else {
                System.out.print("    ");
            }
            /**
             * 日期增加1天后，如果是周一，则进行换行
             */
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekDay = d.get(Calendar.DAY_OF_WEEK);
            if (weekDay == firstDayOfWeek) {
                System.out.println();
            }
        } while (d.get(Calendar.MONTH) == month);
        if (weekDay != firstDayOfWeek) {
            System.out.println();
        }
    }
}
