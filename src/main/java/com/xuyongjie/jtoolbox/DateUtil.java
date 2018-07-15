/**
 * created by xuyongjie
 **/
package com.xuyongjie.jtoolbox;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date now() {
        return new Date();
    }

    /**
     * get date string format 'yyyyMMddHHmmss'
     * @param date
     * @return
     */
    public static String getString(Date date) {
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(date);
    }
}
