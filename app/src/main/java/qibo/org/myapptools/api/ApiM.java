package qibo.org.myapptools.api;

import android.content.Context;

import okhttp3.RequestBody;
import qibo.org.myapptools.utils.SPUtilsUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by qibo on 2017/6/23.
 */
public class ApiM {
    /**
     * 懒汉：单例
     */
    private static ApiM apiM;

    private ApiM() {
    }

    public synchronized static ApiM getInstance() {
        if (apiM == null) {
            apiM = new ApiM();
        }
        return apiM;
    }

    /**
     * 获取Token
     */
    public String getToken(Context context) {
        String UserSession = "" + SPUtilsUser.get(context, "UserToken", "");
        return UserSession;
    }
    public interface ApiService {

        /**
         * 通用接口
         */
        @POST("/")
        Call<String> apiPost(
                @Header("platform") String platform,
                @Header("version") String version,
                @Body RequestBody body
        );
    }
}
