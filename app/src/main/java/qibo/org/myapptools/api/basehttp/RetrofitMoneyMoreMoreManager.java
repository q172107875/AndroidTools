package qibo.org.myapptools.api.basehttp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

//import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * author:jmm
 * date:2017/1/5 16:36
 * e-mail:jianmingmi@foxmail.com
 */


public class RetrofitMoneyMoreMoreManager {
    private static RetrofitMoneyMoreMoreManager mRetrofitManager;
    private Retrofit mRetrofit;
    private static final String BASE_URL = "http://127.0.0.1/";

    private RetrofitMoneyMoreMoreManager() {
        initRetrofit();
    }

    public static synchronized RetrofitMoneyMoreMoreManager getInstance() {
        if (mRetrofitManager == null) {
            mRetrofitManager = new RetrofitMoneyMoreMoreManager();
        }
        return mRetrofitManager;
    }


    private void initRetrofit() {
        // 消息拦截器
        HttpLoggingInterceptor LoginInterceptor = new HttpLoggingInterceptor();
        LoginInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 连接操作
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                // 增加Bean支持返回
//                .addConverterFactory(GsonConverterFactory.create())
                // 增加String返回支持
                .addConverterFactory(ScalarsConverterFactory.create())
                // RxJava适配
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
    }

    public <T> T createService(Class<T> reqServer) {
        return mRetrofit.create(reqServer);
    }
}