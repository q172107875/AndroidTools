package qibo.org.myapptools.api;


import com.jaydenxiao.common.baseapp.BaseApplication;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import qibo.org.myapptools.api.basehttp.RetrofitManager;
import qibo.org.myapptools.utils.BaseUtil;
import retrofit2.Response;

/**
 * Created by jmm on 2016/12/21.
 */

public class ApiUtil {
    // json
    private static final MediaType UTF_8 = MediaType.parse("application/json;charset=UTF-8");
    public static String retResult(String param) {
        Response<String> result = null;
        RequestBody body = RequestBody.create(UTF_8, param);
        try {
            result = RetrofitManager
                    .getInstance()
                    .createService(ApiM.ApiService.class)
                    .apiPost(
                            "Android",
                            BaseUtil.getVersionCode(BaseApplication.getAppContext()) + "",
                            body
                    )
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.body().toString();
    }

}