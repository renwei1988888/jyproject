package com.merchant.utils;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/710:20
 * desc   : 字符串管理类
 * version: 1.0
 */
public class TextUtil {

    /**
     * 加粗
     */
    public static CharSequence getBoldString(String str, int start, int end) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
//		CharacterStyle span=new UnderlineSpan();
        style.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return style;
    }

    /**
     * 红色字符串
     */
    public static CharSequence getRedString(String str, int start, int end) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
//		CharacterStyle span=new UnderlineSpan();
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#CC9900")), start, end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return style;
    }

    /**
     * 变色
     */
    public static CharSequence getColorString(int rId, String str, int start, int end) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
//		CharacterStyle span=new UnderlineSpan();
        style.setSpan(new ForegroundColorSpan(rId), start, end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return style;
    }

    public static CharSequence getColorandSizeString(int rID, String str, int start, int end, float size) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
//		CharacterStyle span=new UnderlineSpan();
        style.setSpan(new ForegroundColorSpan(rID), start, end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new RelativeSizeSpan(size), start, end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return style;
    }

    /**
     * 设置文字相对大小，指相对于文本设定的大小的相对比例
     */
    public static CharSequence getRelativeSize(String str, int start, int end, float size) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new RelativeSizeSpan(size), start, end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return style;
    }

    /**
     * 设置文字相对大小，指相对于文本设定的大小的相对比例,并把其设置为红色
     */
    public static CharSequence getRelativeSizeandRedS(String str, int start, int end, float size) {
        SpannableStringBuilder style = new SpannableStringBuilder(str);
        style.setSpan(new RelativeSizeSpan(size), start, end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#CC9900")), start, end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return style;
    }

    /***
     *  获取html格式的字符串数据
     * @param htmlstr html格式字符串
     * @return
     */
    public static Spanned getHtmlText(String htmlstr) {
        if (htmlstr == null) {
            htmlstr = "";
        }
        return Html.fromHtml(htmlstr);
    }

    /**
     * 是否为空或者长度为0
     *
     * @param str
     * @return true表示为空或者长度为0
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 获取保护格式电话号码
     *
     * @param phoneNumber
     * @return
     */
    public static String getSpePhoneNumber(String phoneNumber) {
        String lastNumber = "";
        if (phoneNumber != null) {
            if (phoneNumber.length() >= 11) {
                lastNumber = phoneNumber.substring(0, 3) + "****" + phoneNumber.substring(7, 11);
            }
            return lastNumber;
        } else {
            return lastNumber;
        }
    }

    /**
     * 获取保护格式身份证号
     *
     * @param idNumber
     * @return
     */
    public static String getSpeIdNumber(String idNumber) {
        String lastNumber = "";
        if (lastNumber != null) {
            if (idNumber.length() == 18) {
                lastNumber = idNumber.substring(0, 3) + "***********" + idNumber.substring(14, 18);
            }
        }
        return lastNumber;
    }

    /**
     * 生成克重区间
     *
     * @param MinWeight
     * @param MaxWeight
     * @return
     */
    public static String getWeightStr(String MinWeight, String MaxWeight) {
        if (MinWeight == null)
            MinWeight = "0";

        if (MaxWeight == null)
            MaxWeight = "0";

        return MinWeight + "g~" + MaxWeight + "g";
    }

    /**
     * 生成价格区间
     *
     * @param MinWeight
     * @param MaxWeight
     * @return
     */
    public static String getPriceStr(String MinWeight, String MaxWeight) {
        if (MinWeight == null)
            MinWeight = "0";

        if (MaxWeight == null)
            MaxWeight = "0";

        return MinWeight + "元~" + MaxWeight + "元";
    }

    /**
     * 获取两位小数
     *
     * @param price
     * @return
     */
    public static String getDoubleTwoPoint(double price) {
        DecimalFormat df = new DecimalFormat(",###,##0.00");
        return df.format(price);
    }

    /**
     * 获取两位小数不四舍五入
     *
     * @param price
     * @return
     */
    public static String getDoubleTwoPointNoLeave(double price) {
        NumberFormat nf = NumberFormat.getNumberInstance();

        // 保留两位小数
        nf.setMaximumFractionDigits(2);

        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.DOWN);

        String lastPrice = nf.format(price);
        String prices[] = lastPrice.split("\\.");
        if (prices != null && prices.length == 2 && prices[1].length() == 1) {
            lastPrice = lastPrice + "0";
        }

        return lastPrice;
    }

    /**
     * 获取三位小数
     *
     * @param price
     * @return
     */
    public static String getDoubleThreePoint(double price) {
        DecimalFormat df = new DecimalFormat("#0.000");
        return df.format(price);
    }

    /**
     * 获取四位小数
     *
     * @param price
     * @return
     */
    public static String getDoubleFourPoint(double price) {
        DecimalFormat df = new DecimalFormat("#0.0000");
        return df.format(price);
    }

    /**
     * 获取四位小数
     *
     * @param price
     * @return
     */
    public static String getDoubleSevenPoint(double price) {
        DecimalFormat df = new DecimalFormat("#0.0000000");
        return df.format(price);
    }

    /**
     * 获取四位小数无四舍五入
     *
     * @param price
     * @return
     */
    public static String getDoubleFourPointNoLeave(double price) {
        NumberFormat nf = NumberFormat.getNumberInstance();

        // 保留两位小数
        nf.setMaximumFractionDigits(4);

        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.DOWN);

        String lastPrice = nf.format(price);
        String prices[] = lastPrice.split("\\.");
        if (prices != null && prices.length == 2) {
            int a = prices[1].length();
            if (a == 1) {
                lastPrice = lastPrice + "00";
            } else if (a == 2) {
                lastPrice = lastPrice + "0";
            } else if (a == 3) {
            }
        } else if (prices.length == 1) {
            lastPrice = lastPrice + ".000";
        }
        return lastPrice;
    }

    /**
     * 获取三位小数,不四舍五入
     *
     * @param price
     * @return
     */
    public static String getDoubleThreePointNoLeave(double price) {
        NumberFormat nf = NumberFormat.getNumberInstance();

        // 保留两位小数
        nf.setMaximumFractionDigits(3);

        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.DOWN);

        String lastPrice = nf.format(price);
        String prices[] = lastPrice.split("\\.");
        if (prices != null && prices.length == 2) {
            int a = prices[1].length();
            if (a == 1) {
                lastPrice = lastPrice + "00";
            } else if (a == 2) {
                lastPrice = lastPrice + "0";
            } else if (a == 3) {
            }
        } else if (prices.length == 1) {
            lastPrice = lastPrice + ".000";
        }
        return lastPrice;
    }

    /**
     * 去掉小数点
     *
     * @param price
     * @return
     */
    public static String getDoubleZeroPoint(double price) {
        DecimalFormat df = new DecimalFormat("#0");
        return df.format(price);
    }

    /**
     * 去掉小数点后面的位数，没有四舍五入
     *
     * @param price
     * @return
     */
    public static String getDoubleZeroPointNoLeave(double price) {
        double temPrice = Math.floor(price);
        DecimalFormat df = new DecimalFormat("#0");
        return df.format(temPrice);
    }
}
