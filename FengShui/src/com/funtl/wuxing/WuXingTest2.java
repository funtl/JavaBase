package com.funtl.wuxing;

public class WuXingTest2 {
    private static final String TG[] = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    private static final String DZ[] = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};

    public static void main(String[] args) {
        // 公元后某年
        int year = 2020;
        // 农历某月
        int nMonth = 1;
        // 阳历某月
        int yMonth = 2;
        // 阳历某日
        int day = 10;
        // 时间
        int time = 15;

        // 获取干支年
        String gzYear = getYear(year);
        System.out.println(year + " 年为 \"" + gzYear + "\" 年");

        // 获取干支月
        String gzMonth = getMonth(gzYear, nMonth);
        System.out.println(year + " 年农历 " + nMonth + " 月为 \"" + gzMonth + "\" 月");

        // 获取干支日
        String gzDay = getDay(year, yMonth, day);
        System.out.println(year + " 年阳历 " + yMonth + " 月 " + day + " 日为 \"" + gzDay + "\" 日");

        // 获取干支时
        String gzTime = getTime(gzDay, time);
        System.out.println(year + " 年阳历 " + yMonth + " 月 " + day + " 日 " + time + " 时为 \"" + gzTime + "\" 时");

        // 生辰八字
        System.out.println("您的生辰八字为：" + gzYear + gzMonth + gzDay + gzTime);

        // 生辰八字算五行
        wuxing(gzYear, gzMonth, gzDay, gzTime);
    }

    /**
     * 获取干支年 <br />
     * 根据公元后某年换算出干支年 <br />
     *
     * <p>
     * 说明：假设公元后某年为 X 则先用 X 除以 60 得出余数再减去 4，根据所得结果查表中对应的编号即可算出该年的干支 <br />
     * 如果减 4 不够减则加上 60 之后再减即可
     * </p>
     *
     * @param year {@code int} 公元后的某一年
     * @return {@code String} 干支年
     */
    public static String getYear(int year) {
        // 假设公元后某年为 X 则先用 X 除以 60 得出余数
        int gzNum = year % 60;

        // 用余数减 4 不够减则加上 60 之后再减得出编号
        if (gzNum - 4 < 0) {
            gzNum = gzNum + 60 - 4;
        } else {
            gzNum = gzNum - 4;
        }

        // 遍历天干地支
        for (int i = 0; i < 60; i++) {
            int itg = i % TG.length; // 取余数防止数组越界
            int idz = i % DZ.length; // 同上
            if (gzNum == i) {
                // 根据天干地支的索引进行匹配
                return TG[itg] + DZ[idz];
            }
        }

        return null;
    }

    /**
     * 获取干支月 <br />
     * 根据干支年换算出干支月 <br />
     *
     * <p>
     * 说明：若遇甲或己的年份 ，正月是丙寅；遇上乙或庚之年，正月为戊寅；遇上丙或辛之年，正月为庚寅；遇上丁或壬之年，正月为壬寅；遇上戊或癸之年，正月为甲寅
     * </p>
     *
     * @param gzYear {@code String} 干支年
     * @param month  {@code int} 农历的月份
     * @return {@code String} 干支月
     */
    public static String getMonth(String gzYear, int month) {
        String stg = gzYear.substring(0, 1);

        int itgFlag = 0;
        // 如果干支年的天干位为 “甲” 或 “己”，则从 TG 数组下标的第 2 位开始
        if ("甲".equals(stg) || "己".equals(stg)) {
            itgFlag = 2;
        } else if ("乙".equals(stg) || "庚".equals(stg)) {
            itgFlag = 4;
        } else if ("丙".equals(stg) || "辛".equals(stg)) {
            itgFlag = 6;
        } else if ("丁".equals(stg) || "壬".equals(stg)) {
            itgFlag = 8;
        }

        for (int i = 0; i < 12; i++) {
            int itg = (i + itgFlag) % TG.length;
            int idz = (i + 2) % DZ.length;

            if (i == month - 1) {
                return TG[itg] + DZ[idz];
            }
        }

        return null;
    }

    /**
     * 获取干支日 <br />
     * 根据阳历年月日换算出干支日 <br />
     * 天干 = (4 * c + c / 4 + 5 * y + y / 4 + 3 * (m + 1) / 5 + d - 3) % 10 <br />
     * 地支 = (8 * c + c / 4 + 5 * y + y / 4 + 3 * (m + 1) / 5 + d + 7 + i) % 12 <br />
     *
     * <ul>
     *     <li>c 为年份前两位，比如 2019 年则 c 为 20</li>
     *     <li>y 为年份后两位，比如 2019 年则 y 为 19</li>
     *     <li>m 为月份，1 月和 2 月按上一年的 13 月和 14 月来算</li>
     *     <li>d 为日数</li>
     *     <li>奇数月 i 为 0</li>
     *     <li>偶数月 i 为 6</li>
     * </ul>
     *
     * @param year  {@code int} 阳历年
     * @param month {@code int} 阳历月
     * @param day   {@code int} 阳历日
     * @return {@code String} 干支日
     */
    public static String getDay(int year, int month, int day) {
        String yearStr = String.valueOf(year);
        int c = Integer.parseInt(yearStr.substring(0, 2));
        int y = Integer.parseInt(yearStr.substring(2));
        // 嵌套的三元表达式，1 月和 2 月按上一年的 13 月和 14 月来算
        int m = month == 1 ? 13 : month == 2 ? 14 : month;
        if (m == 13 || m == 14) {
            y--;
        }
        int d = day;
        // 三元表达式，月份除以 2 余 0 则为偶数否则为奇数
        int i = m % 2 != 0 ? 0 : 6;

        int itg = (4 * c + c / 4 + 5 * y + y / 4 + 3 * m / 5 + d - 3) % 10;
        int idz = (8 * c + c / 4 + 5 * y + y / 4 + 3 * m / 5 + d + 7 + i) % 12;

        return TG[itg] + DZ[idz];
    }

    /**
     * 获取干支时 <br />
     *
     * <p>
     * 说明：根据十二时辰只能得出支，想要得到干，需要配合干支日换算
     * </p>
     *
     * @param gzDay {@code String} 干支日
     * @param time  {@code int} 24 小时制的时间
     * @return {@code String} 干支时
     */
    public static String getTime(String gzDay, int time) {
        // 取出干支日的第一个字
        gzDay = gzDay.substring(0, 1);

        // 换算出时间对应地支的下标位置
        int idz = 0;
        if (time >= 23 || time < 1) {
            idz = 0;
        } else if (time >= 1 && time < 3) {
            idz = 1;
        } else if (time >= 3 && time < 5) {
            idz = 2;
        } else if (time >= 5 && time < 7) {
            idz = 3;
        } else if (time >= 7 && time < 9) {
            idz = 4;
        } else if (time >= 9 && time < 11) {
            idz = 5;
        } else if (time >= 11 && time < 13) {
            idz = 6;
        } else if (time >= 13 && time < 15) {
            idz = 7;
        } else if (time >= 15 && time < 17) {
            idz = 8;
        } else if (time >= 17 && time < 19) {
            idz = 9;
        } else if (time >= 19 && time < 21) {
            idz = 10;
        } else if (time >= 21 && time < 23) {
            idz = 11;
        }

        int itgFlag = 8;
        // 如果干支年的天干位为 “甲” 或 “己”，则从 TG 数组下标的第 0 位开始
        if ("甲".equals(gzDay) || "己".equals(gzDay)) {
            itgFlag = 0;
        } else if ("乙".equals(gzDay) || "庚".equals(gzDay)) {
            itgFlag = 2;
        } else if ("丙".equals(gzDay) || "辛".equals(gzDay)) {
            itgFlag = 4;
        } else if ("丁".equals(gzDay) || "壬".equals(gzDay)) {
            itgFlag = 6;
        }

        return TG[(idz + itgFlag) % 10] + DZ[idz];
    }

    /**
     * 通过八字算五行
     *
     * @param gzYear  {@code String} 干支年
     * @param gzMonth {@code String} 干支月
     * @param gzDay   {@code String} 干支日
     * @param gzTime  {@code String} 干支时
     */
    public static void wuxing(String gzYear, String gzMonth, String gzDay, String gzTime) {
        // 天干年
        String gYear = gzYear.substring(0, 1);
        if ("甲".equals(gYear) || "乙".equals(gYear)) {
            gYear = "木";
        }
        if ("丙".equals(gYear) || "丁".equals(gYear)) {
            gYear = "火";
        }
        if ("戊".equals(gYear) || "己".equals(gYear)) {
            gYear = "土";
        }
        if ("庚".equals(gYear) || "辛".equals(gYear)) {
            gYear = "金";
        }
        if ("壬".equals(gYear) || "癸".equals(gYear)) {
            gYear = "水";
        }

        // 天干月
        String gMonth = gzMonth.substring(0, 1);
        if ("甲".equals(gMonth) || "乙".equals(gMonth)) {
            gMonth = "木";
        }
        if ("丙".equals(gMonth) || "丁".equals(gMonth)) {
            gMonth = "火";
        }
        if ("戊".equals(gMonth) || "己".equals(gMonth)) {
            gMonth = "土";
        }
        if ("庚".equals(gMonth) || "辛".equals(gMonth)) {
            gMonth = "金";
        }
        if ("壬".equals(gMonth) || "癸".equals(gMonth)) {
            gMonth = "水";
        }

        // 天干日
        String gDay = gzDay.substring(0, 1);
        if ("甲".equals(gDay) || "乙".equals(gDay)) {
            gDay = "木";
        }
        if ("丙".equals(gDay) || "丁".equals(gDay)) {
            gDay = "火";
        }
        if ("戊".equals(gDay) || "己".equals(gDay)) {
            gDay = "土";
        }
        if ("庚".equals(gDay) || "辛".equals(gDay)) {
            gDay = "金";
        }
        if ("壬".equals(gDay) || "癸".equals(gDay)) {
            gDay = "水";
        }

        // 天干时
        String gTime = gzTime.substring(0, 1);
        if ("甲".equals(gTime) || "乙".equals(gTime)) {
            gTime = "木";
        }
        if ("丙".equals(gTime) || "丁".equals(gTime)) {
            gTime = "火";
        }
        if ("戊".equals(gTime) || "己".equals(gTime)) {
            gTime = "土";
        }
        if ("庚".equals(gTime) || "辛".equals(gTime)) {
            gTime = "金";
        }
        if ("壬".equals(gTime) || "癸".equals(gTime)) {
            gTime = "水";
        }

        // 地支年
        String zYear = gzYear.substring(1);
        if ("寅".equals(zYear) || "卯".equals(zYear)) {
            zYear = "木";
        }
        if ("巳".equals(zYear) || "午".equals(zYear)) {
            zYear = "火";
        }
        if ("辰".equals(zYear) || "丑".equals(zYear) || "戌".equals(zYear) || "未".equals(zYear)) {
            zYear = "土";
        }
        if ("申".equals(zYear) || "酉".equals(zYear)) {
            zYear = "金";
        }
        if ("亥".equals(zYear) || "子".equals(zYear)) {
            zYear = "水";
        }

        // 地支月
        String zMonth = gzMonth.substring(1);
        if ("寅".equals(zMonth) || "卯".equals(zMonth)) {
            zMonth = "木";
        }
        if ("巳".equals(zMonth) || "午".equals(zMonth)) {
            zMonth = "火";
        }
        if ("辰".equals(zMonth) || "丑".equals(zMonth) || "戌".equals(zMonth) || "未".equals(zMonth)) {
            zMonth = "土";
        }
        if ("申".equals(zMonth) || "酉".equals(zMonth)) {
            zMonth = "金";
        }
        if ("亥".equals(zMonth) || "子".equals(zMonth)) {
            zMonth = "水";
        }

        // 地支日
        String zDay = gzDay.substring(1);
        if ("寅".equals(zDay) || "卯".equals(zDay)) {
            zDay = "木";
        }
        if ("巳".equals(zDay) || "午".equals(zDay)) {
            zDay = "火";
        }
        if ("辰".equals(zDay) || "丑".equals(zDay) || "戌".equals(zDay) || "未".equals(zDay)) {
            zDay = "土";
        }
        if ("申".equals(zDay) || "酉".equals(zDay)) {
            zDay = "金";
        }
        if ("亥".equals(zDay) || "子".equals(zDay)) {
            zDay = "水";
        }

        // 地支时
        String zTime = gzTime.substring(1);
        if ("寅".equals(zTime) || "卯".equals(zTime)) {
            zTime = "木";
        }
        if ("巳".equals(zTime) || "午".equals(zTime)) {
            zTime = "火";
        }
        if ("辰".equals(zTime) || "丑".equals(zTime) || "戌".equals(zTime) || "未".equals(zTime)) {
            zTime = "土";
        }
        if ("申".equals(zTime) || "酉".equals(zTime)) {
            zTime = "金";
        }
        if ("亥".equals(zTime) || "子".equals(zTime)) {
            zTime = "水";
        }

        // 输出五行
        String wuxing = gYear + zYear + gMonth + zMonth + gDay + zDay + gTime + zTime;
        System.out.println("您的八字五行为：" + wuxing);

        // 算出五行缺啥
        String que = "您的五行缺：";
        if (!wuxing.contains("金")) {
            que += "金";
        }
        if (!wuxing.contains("木")) {
            que += "木";
        }
        if (!wuxing.contains("水")) {
            que += "水";
        }
        if (!wuxing.contains("火")) {
            que += "火";
        }
        if (!wuxing.contains("土")) {
            que += "土";
        }
        System.out.println(que.equals("您的五行缺：") ? "恭喜，您的五行不缺" : que);
    }
}
