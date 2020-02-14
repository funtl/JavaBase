package com.funtl.wuxing;

/**
 * 八字与五行
 *
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @see com.funtl
 * @since 2020-02-10 15:35:02
 */
public class WuXingTest1 {
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

        // 根据编号返回干支年
        if (gzNum == 0) {
            return "甲子";
        } else if (gzNum == 1) {
            return "乙丑";
        } else if (gzNum == 2) {
            return "丙寅";
        } else if (gzNum == 3) {
            return "丁卯";
        } else if (gzNum == 4) {
            return "戊辰";
        } else if (gzNum == 5) {
            return "己巳";
        } else if (gzNum == 6) {
            return "庚午";
        } else if (gzNum == 7) {
            return "辛未";
        } else if (gzNum == 8) {
            return "壬申";
        } else if (gzNum == 9) {
            return "癸酉";
        } else if (gzNum == 10) {
            return "甲戌";
        } else if (gzNum == 11) {
            return "乙亥";
        } else if (gzNum == 12) {
            return "丙子";
        } else if (gzNum == 13) {
            return "丁丑";
        } else if (gzNum == 14) {
            return "戊寅";
        } else if (gzNum == 15) {
            return "己卯";
        } else if (gzNum == 16) {
            return "庚辰";
        } else if (gzNum == 17) {
            return "辛巳";
        } else if (gzNum == 18) {
            return "壬午";
        } else if (gzNum == 19) {
            return "癸未";
        } else if (gzNum == 20) {
            return "甲申";
        } else if (gzNum == 21) {
            return "乙酉";
        } else if (gzNum == 22) {
            return "丙戌";
        } else if (gzNum == 23) {
            return "丁亥";
        } else if (gzNum == 24) {
            return "戊子";
        } else if (gzNum == 25) {
            return "己丑";
        } else if (gzNum == 26) {
            return "庚寅";
        } else if (gzNum == 27) {
            return "辛卯";
        } else if (gzNum == 28) {
            return "壬辰";
        } else if (gzNum == 29) {
            return "癸巳";
        } else if (gzNum == 30) {
            return "甲午";
        } else if (gzNum == 31) {
            return "乙未";
        } else if (gzNum == 32) {
            return "丙申";
        } else if (gzNum == 33) {
            return "丁酉";
        } else if (gzNum == 34) {
            return "戊戌";
        } else if (gzNum == 35) {
            return "己亥";
        } else if (gzNum == 36) {
            return "庚子";
        } else if (gzNum == 37) {
            return "辛丑";
        } else if (gzNum == 38) {
            return "壬寅";
        } else if (gzNum == 39) {
            return "癸卯";
        } else if (gzNum == 40) {
            return "甲辰";
        } else if (gzNum == 41) {
            return "乙巳";
        } else if (gzNum == 42) {
            return "丙午";
        } else if (gzNum == 43) {
            return "丁未";
        } else if (gzNum == 44) {
            return "戊申";
        } else if (gzNum == 45) {
            return "己酉";
        } else if (gzNum == 46) {
            return "庚戌";
        } else if (gzNum == 47) {
            return "辛亥";
        } else if (gzNum == 48) {
            return "壬子";
        } else if (gzNum == 49) {
            return "癸丑";
        } else if (gzNum == 50) {
            return "甲寅";
        } else if (gzNum == 51) {
            return "乙卯";
        } else if (gzNum == 52) {
            return "丙辰";
        } else if (gzNum == 53) {
            return "丁巳";
        } else if (gzNum == 54) {
            return "戊午";
        } else if (gzNum == 55) {
            return "己未";
        } else if (gzNum == 56) {
            return "庚申";
        } else if (gzNum == 57) {
            return "辛酉";
        } else if (gzNum == 58) {
            return "壬戌";
        } else if (gzNum == 59) {
            return "癸亥";
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
        // 干支年标记，用于确定干支年的第一个字
        String gzYearStr = gzYear.substring(0, 1);

        // 定义一个默认的干支年标记
        int gzYearFlag = 0;

        // 若遇甲或己的年份 ，正月是丙寅
        if ("甲".equals(gzYearStr) || "己".equals(gzYearStr)) {
            gzYearFlag = 0;
        }

        // 遇上乙或庚之年，正月为戊寅
        else if ("乙".equals(gzYearStr) || "庚".equals(gzYearStr)) {
            gzYearFlag = 1;
        }

        // 遇上丙或辛之年，正月为庚寅
        else if ("丙".equals(gzYearStr) || "辛".equals(gzYearStr)) {
            gzYearFlag = 2;
        }

        // 遇上丁或壬之年，正月为壬寅
        else if ("丁".equals(gzYearStr) || "壬".equals(gzYearStr)) {
            gzYearFlag = 3;
        }

        // 遇上戊或癸之年，正月为甲寅
        else if ("戊".equals(gzYearStr) || "癸".equals(gzYearStr)) {
            gzYearFlag = 4;
        }

        // 根据干支年 + 农历月份返回干支月
        switch (gzYearFlag) {
            case 0:
                if (month == 1) {
                    return "丙寅";
                } else if (month == 2) {
                    return "丁卯";
                } else if (month == 3) {
                    return "戊辰";
                } else if (month == 4) {
                    return "己巳";
                } else if (month == 5) {
                    return "庚午";
                } else if (month == 6) {
                    return "辛未";
                } else if (month == 7) {
                    return "壬申";
                } else if (month == 8) {
                    return "癸酉";
                } else if (month == 9) {
                    return "甲戌";
                } else if (month == 10) {
                    return "乙亥";
                } else if (month == 11) {
                    return "丙子";
                } else if (month == 12) {
                    return "丁丑";
                }
                break;
            case 1:
                if (month == 1) {
                    return "戊寅";
                } else if (month == 2) {
                    return "己卯";
                } else if (month == 3) {
                    return "庚辰";
                } else if (month == 4) {
                    return "辛巳";
                } else if (month == 5) {
                    return "壬午";
                } else if (month == 6) {
                    return "癸未";
                } else if (month == 7) {
                    return "甲申";
                } else if (month == 8) {
                    return "乙酉";
                } else if (month == 9) {
                    return "丙戌";
                } else if (month == 10) {
                    return "丁亥";
                } else if (month == 11) {
                    return "戊子";
                } else if (month == 12) {
                    return "己丑";
                }
                break;
            case 2:
                if (month == 1) {
                    return "庚寅";
                } else if (month == 2) {
                    return "辛卯";
                } else if (month == 3) {
                    return "壬辰";
                } else if (month == 4) {
                    return "癸巳";
                } else if (month == 5) {
                    return "甲午";
                } else if (month == 6) {
                    return "乙未";
                } else if (month == 7) {
                    return "丙申";
                } else if (month == 8) {
                    return "丁酉";
                } else if (month == 9) {
                    return "戊戌";
                } else if (month == 10) {
                    return "己亥";
                } else if (month == 11) {
                    return "庚子";
                } else if (month == 12) {
                    return "辛丑";
                }
                break;
            case 3:
                if (month == 1) {
                    return "壬寅";
                } else if (month == 2) {
                    return "癸卯";
                } else if (month == 3) {
                    return "甲辰";
                } else if (month == 4) {
                    return "乙巳";
                } else if (month == 5) {
                    return "丙午";
                } else if (month == 6) {
                    return "丁未";
                } else if (month == 7) {
                    return "戊申";
                } else if (month == 8) {
                    return "己酉";
                } else if (month == 9) {
                    return "庚戌";
                } else if (month == 10) {
                    return "辛亥";
                } else if (month == 11) {
                    return "壬子";
                } else if (month == 12) {
                    return "癸丑";
                }
                break;
            case 4:
                if (month == 1) {
                    return "甲寅";
                } else if (month == 2) {
                    return "乙卯";
                } else if (month == 3) {
                    return "丙辰";
                } else if (month == 4) {
                    return "丁巳";
                } else if (month == 5) {
                    return "戊午";
                } else if (month == 6) {
                    return "己未";
                } else if (month == 7) {
                    return "庚申";
                } else if (month == 8) {
                    return "辛酉";
                } else if (month == 9) {
                    return "壬戌";
                } else if (month == 10) {
                    return "癸亥";
                } else if (month == 11) {
                    return "甲子";
                } else if (month == 12) {
                    return "乙丑";
                }
                break;
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

        int iGan = (4 * c + c / 4 + 5 * y + y / 4 + 3 * (m + 1) / 5 + d - 3) % 10;
        int iZhi = (8 * c + c / 4 + 5 * y + y / 4 + 3 * (m + 1) / 5 + d + 7 + i) % 12;

        String gan = "";
        String zhi = "";

        switch (iGan) {
            case 1:
                gan = "甲";
                break;
            case 2:
                gan = "乙";
                break;
            case 3:
                gan = "丙";
                break;
            case 4:
                gan = "丁";
                break;
            case 5:
                gan = "戊";
                break;
            case 6:
                gan = "己";
                break;
            case 7:
                gan = "庚";
                break;
            case 8:
                gan = "辛";
                break;
            case 9:
                gan = "壬";
                break;
            default:
                gan = "癸";
                break;
        }

        if (iZhi == 1) {
            zhi = "子";
        } else if (iZhi == 2) {
            zhi = "丑";
        } else if (iZhi == 3) {
            zhi = "寅";
        } else if (iZhi == 4) {
            zhi = "卯";
        } else if (iZhi == 5) {
            zhi = "辰";
        } else if (iZhi == 6) {
            zhi = "巳";
        } else if (iZhi == 7) {
            zhi = "午";
        } else if (iZhi == 8) {
            zhi = "未";
        } else if (iZhi == 9) {
            zhi = "申";
        } else if (iZhi == 10) {
            zhi = "酉";
        } else if (iZhi == 11) {
            zhi = "戌";
        } else {
            zhi = "亥";
        }

        return gan + zhi;
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

        String gan = "";
        String zhi = "";

        if (time >= 23 || time < 1) {
            zhi = "子";
        } else if (time >= 1 && time < 3) {
            zhi = "丑";
        } else if (time >= 3 && time < 5) {
            zhi = "寅";
        } else if (time >= 5 && time < 7) {
            zhi = "卯";
        } else if (time >= 7 && time < 9) {
            zhi = "辰";
        } else if (time >= 9 && time < 11) {
            zhi = "巳";
        } else if (time >= 11 && time < 13) {
            zhi = "午";
        } else if (time >= 13 && time < 15) {
            zhi = "未";
        } else if (time >= 15 && time < 17) {
            zhi = "申";
        } else if (time >= 17 && time < 19) {
            zhi = "酉";
        } else if (time >= 19 && time < 21) {
            zhi = "戌";
        } else if (time >= 21 && time < 23) {
            zhi = "亥";
        }

        if ("子".equals(zhi)) {
            if ("甲".equals(gzDay) || "己".equals(gzDay)) {
                return "甲子";
            } else if ("乙".equals(gzDay) || "庚".equals(gzDay)) {
                return "丙子";
            } else if ("丙".equals(gzDay) || "辛".equals(gzDay)) {
                return "戊子";
            } else if ("丁".equals(gzDay) || "壬".equals(gzDay)) {
                return "庚子";
            } else if ("戊".equals(gzDay) || "癸".equals(gzDay)) {
                return "壬子";
            }
        } else if ("丑".equals(zhi)) {
            if ("甲".equals(gzDay) || "己".equals(gzDay)) {
                return "乙丑";
            } else if ("乙".equals(gzDay) || "庚".equals(gzDay)) {
                return "丁丑";
            } else if ("丙".equals(gzDay) || "辛".equals(gzDay)) {
                return "己丑";
            } else if ("丁".equals(gzDay) || "壬".equals(gzDay)) {
                return "辛丑";
            } else if ("戊".equals(gzDay) || "癸".equals(gzDay)) {
                return "癸丑";
            }
        } else if ("寅".equals(zhi)) {
            if ("甲".equals(gzDay) || "己".equals(gzDay)) {
                return "丙寅";
            } else if ("乙".equals(gzDay) || "庚".equals(gzDay)) {
                return "戊寅";
            } else if ("丙".equals(gzDay) || "辛".equals(gzDay)) {
                return "庚寅";
            } else if ("丁".equals(gzDay) || "壬".equals(gzDay)) {
                return "壬寅";
            } else if ("戊".equals(gzDay) || "癸".equals(gzDay)) {
                return "甲寅";
            }
        } else if ("卯".equals(zhi)) {
            if ("甲".equals(gzDay) || "己".equals(gzDay)) {
                return "丁卯";
            } else if ("乙".equals(gzDay) || "庚".equals(gzDay)) {
                return "己卯";
            } else if ("丙".equals(gzDay) || "辛".equals(gzDay)) {
                return "辛卯";
            } else if ("丁".equals(gzDay) || "壬".equals(gzDay)) {
                return "癸卯";
            } else if ("戊".equals(gzDay) || "癸".equals(gzDay)) {
                return "乙卯";
            }
        } else if ("辰".equals(zhi)) {
            if ("甲".equals(gzDay) || "己".equals(gzDay)) {
                return "戊辰";
            } else if ("乙".equals(gzDay) || "庚".equals(gzDay)) {
                return "庚辰";
            } else if ("丙".equals(gzDay) || "辛".equals(gzDay)) {
                return "壬辰";
            } else if ("丁".equals(gzDay) || "壬".equals(gzDay)) {
                return "甲辰";
            } else if ("戊".equals(gzDay) || "癸".equals(gzDay)) {
                return "丙辰";
            }
        } else if ("巳".equals(zhi)) {
            if ("甲".equals(gzDay) || "己".equals(gzDay)) {
                return "己巳";
            } else if ("乙".equals(gzDay) || "庚".equals(gzDay)) {
                return "辛巳";
            } else if ("丙".equals(gzDay) || "辛".equals(gzDay)) {
                return "癸巳";
            } else if ("丁".equals(gzDay) || "壬".equals(gzDay)) {
                return "乙巳";
            } else if ("戊".equals(gzDay) || "癸".equals(gzDay)) {
                return "丁巳";
            }
        } else if ("午".equals(zhi)) {
            if ("甲".equals(gzDay) || "己".equals(gzDay)) {
                return "庚午";
            } else if ("乙".equals(gzDay) || "庚".equals(gzDay)) {
                return "壬午";
            } else if ("丙".equals(gzDay) || "辛".equals(gzDay)) {
                return "甲午";
            } else if ("丁".equals(gzDay) || "壬".equals(gzDay)) {
                return "丙午";
            } else if ("戊".equals(gzDay) || "癸".equals(gzDay)) {
                return "戊午";
            }
        } else if ("未".equals(zhi)) {
            if ("甲".equals(gzDay) || "己".equals(gzDay)) {
                return "辛未";
            } else if ("乙".equals(gzDay) || "庚".equals(gzDay)) {
                return "癸未";
            } else if ("丙".equals(gzDay) || "辛".equals(gzDay)) {
                return "乙未";
            } else if ("丁".equals(gzDay) || "壬".equals(gzDay)) {
                return "丁未";
            } else if ("戊".equals(gzDay) || "癸".equals(gzDay)) {
                return "己未";
            }
        } else if ("申".equals(zhi)) {
            if ("甲".equals(gzDay) || "己".equals(gzDay)) {
                return "壬申";
            } else if ("乙".equals(gzDay) || "庚".equals(gzDay)) {
                return "甲申";
            } else if ("丙".equals(gzDay) || "辛".equals(gzDay)) {
                return "丙申";
            } else if ("丁".equals(gzDay) || "壬".equals(gzDay)) {
                return "戊申";
            } else if ("戊".equals(gzDay) || "癸".equals(gzDay)) {
                return "庚申";
            }
        } else if ("酉".equals(zhi)) {
            if ("甲".equals(gzDay) || "己".equals(gzDay)) {
                return "癸酉";
            } else if ("乙".equals(gzDay) || "庚".equals(gzDay)) {
                return "乙酉";
            } else if ("丙".equals(gzDay) || "辛".equals(gzDay)) {
                return "丁酉";
            } else if ("丁".equals(gzDay) || "壬".equals(gzDay)) {
                return "己酉";
            } else if ("戊".equals(gzDay) || "癸".equals(gzDay)) {
                return "辛酉";
            }
        } else if ("戌".equals(zhi)) {
            if ("甲".equals(gzDay) || "己".equals(gzDay)) {
                return "甲戌";
            } else if ("乙".equals(gzDay) || "庚".equals(gzDay)) {
                return "丙戌";
            } else if ("丙".equals(gzDay) || "辛".equals(gzDay)) {
                return "戊戌";
            } else if ("丁".equals(gzDay) || "壬".equals(gzDay)) {
                return "庚戌";
            } else if ("戊".equals(gzDay) || "癸".equals(gzDay)) {
                return "壬戌";
            }
        } else if ("亥".equals(zhi)) {
            if ("甲".equals(gzDay) || "己".equals(gzDay)) {
                return "乙亥";
            } else if ("乙".equals(gzDay) || "庚".equals(gzDay)) {
                return "丁亥";
            } else if ("丙".equals(gzDay) || "辛".equals(gzDay)) {
                return "己亥";
            } else if ("丁".equals(gzDay) || "壬".equals(gzDay)) {
                return "辛亥";
            } else if ("戊".equals(gzDay) || "癸".equals(gzDay)) {
                return "癸亥";
            }
        }

        return null;
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
