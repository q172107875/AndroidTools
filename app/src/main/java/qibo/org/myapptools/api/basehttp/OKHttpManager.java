package qibo.org.myapptools.api.basehttp;

import android.os.Build;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by jmm on 2016/8/26.
 */
public class OKHttpManager {
    // okHttpClient 实例
    private OkHttpClient mOkHttpClient;
    private String JSESSIONID;
    private String k95;

    /**
     * 初始化RequestManager
     */
    private static OKHttpManager OKHttpManager;

    public OKHttpManager(String JSESSIONID, String k95) {
        this.JSESSIONID = JSESSIONID;
        this.k95 = k95;
        // 设置写入超时时间
        mOkHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 统一为请求添加头信息
     */
    private Request.Builder addHeaders() {
        Request.Builder builder = new Request.Builder()
                .addHeader("Connection", "keep-alive")
                .addHeader("user-agent", "99CaiFu/20160826 CFNetwork/758.5.3 Darwin/15.6.0")
                .addHeader("systemVersion", Build.VERSION.RELEASE)
                .addHeader("cookie", "JSESSIONID=" + JSESSIONID + ";95k=" + k95 + ";");
        return builder;
    }

    /**
     * okHttp post
     */
    public Call post(String url, Map<String, String> paramsMap) {
        FormBody.Builder builder = new FormBody.Builder();
        if (paramsMap != null) {
            for (String key : paramsMap.keySet()) {
                builder.add(key, paramsMap.get(key));
            }
        }
        RequestBody formBody = builder.build();

        // 创建一个请求
        Request request = addHeaders().url(url).post(formBody).build();
        Call call = mOkHttpClient.newCall(request);
//        call.enqueue(new Callback() {});
        return call;
    }
}
