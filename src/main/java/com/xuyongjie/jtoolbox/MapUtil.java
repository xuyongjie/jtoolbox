/**
 * created by xuyongjie
 **/
package com.xuyongjie.jtoolbox;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class MapUtil {
    public static String mapToQueryString(Map<String, String> map) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                builder.append(URLEncoder.encode(entry.getKey(), "UTF-8")).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (builder.length() > 0) {
            //remove the last '&' character
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }
}
