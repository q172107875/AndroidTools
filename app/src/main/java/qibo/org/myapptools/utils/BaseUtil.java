package qibo.org.myapptools.utils;

import android.content.Context;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * author:jmm
 * date:2017/1/5 20:34
 * e-mail:jianmingmi@foxmail.com
 */
public class BaseUtil {
    /**
     * 将map型转为请求参数型
     */
    public static String map2str(Map<String, String> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.substring(0, sb.length() - 1);
    }


    /**
     * getVersionCode
     */
    public static int getVersionCode(Context context) {
        int result = 0;
        try {
            String pkName = context.getPackageName();
            int versionCode = context.getPackageManager().getPackageInfo(pkName, 0).versionCode;
            result = versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
