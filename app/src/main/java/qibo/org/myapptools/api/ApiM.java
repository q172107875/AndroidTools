package qibo.org.myapptools.api;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import qibo.org.myapptools.utils.SPUtilsUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

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
    public String sekectUser(Object UserName){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("userName",UserName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
    public String sekectUserid(Object id){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id",id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
    public interface ApiService {
        /**
         * 通用接口
         */
        @POST("/user/{show}")
        Call<String> apiPost(
                @Header("platform") String platform,
                @Header("version") String version,
                @Path("show") String show,
                @Body RequestBody body

        );
    }
    //    请求地址 : http://ip.taobao.com/service/getIpInfo.php?ip=202.202.32.202
    //    1.3.post请求：通过@FormUrlEncoded、和@POST注解，指明访问的地址
//        (★注意：千万别忘了@FormUrlEncoded)
//    @FormUrlEncoded
//    @POST("getIpInfo.php")
//    1.4.通过@Field来指定key，后面跟上value
//    Call<IP> postIP(@Field("ip") String ip)
}
