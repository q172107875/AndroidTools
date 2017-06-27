package qibo.org.myapptools.api.basehttp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import qibo.org.myapptools.api.ApiConstant;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * author:jmm
 * date:2016/12/20 16:47
 * e-mail:jianmingmi@foxmail.com
 */

//        @GET("book/search")
//        Call<String> getString(@Query("q") String name);
//        @GET("book/search")
//        Observable<String> getAAA(@Query("q") String name);
//
// 使用方法1：异步
//        RetrofitManager
//                .getInstance()
//                .createService(Test.BlueService.class)
//                .getAAA("")
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//
//                    }
//                });
//
// 使用方法1：同步
//            Response<String> response = RetrofitManager
//                    .getInstance()
//                    .createService(BlueService.class)
//                    .getString("")
//                    .execute();

public class RetrofitManager {
    private static RetrofitManager mRetrofitManager;
    private static RetrofitManager mRetrofitManagers;
    private Retrofit mRetrofit;
    private static String BASE_URL = ApiConstant.BASE_URL;
    private static String BASE_URLS="";

    private RetrofitManager() {
        initRetrofit();
    }

    public static synchronized RetrofitManager getInstance() {
        if (mRetrofitManager == null) {
            mRetrofitManager = new RetrofitManager();
        }
        return mRetrofitManager;
    }


    private void initRetrofit() {
        // 消息拦截器
        HttpLoggingInterceptor LoginInterceptor = new HttpLoggingInterceptor();
        LoginInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 连接操作
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(8, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .sslSocketFactory(SSLContextUtil.getSSLContext().getSocketFactory())
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





//    private RetrofitManager(String url) {
//        initRetrofit(url);
//    }
//
//    public static synchronized RetrofitManager getInstance(String url) {
//        if (mRetrofitManagers == null) {
//            mRetrofitManagers = new RetrofitManager(url);
//        }
//        return mRetrofitManagers;
//    }
//
//
//    private void initRetrofit(String url) {
//        this.BASE_URLS = url;
//        // 消息拦截器
//        HttpLoggingInterceptor LoginInterceptor = new HttpLoggingInterceptor();
//        LoginInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        // 连接操作
//        OkHttpClient client = new OkHttpClient.Builder()
//                .connectTimeout(8, TimeUnit.SECONDS)
//                .readTimeout(10, TimeUnit.SECONDS)
//                .writeTimeout(10, TimeUnit.SECONDS)
//                .retryOnConnectionFailure(true)
////                .sslSocketFactory(SSLContextUtil.getSSLContext().getSocketFactory())
//                .build();
//
//        mRetrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URLS)
//                // 增加Bean支持返回
////                .addConverterFactory(GsonConverterFactory.create())
//                // 增加String返回支持
//                .addConverterFactory(ScalarsConverterFactory.create())
//                // RxJava适配
////                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .client(client)
//                .build();
//    }

    public <T> T createService(Class<T> reqServer) {
        return mRetrofit.create(reqServer);
    }
}