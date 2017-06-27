package qibo.org.myapptools.api;

import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import qibo.org.myapptools.ui.bean.UserBean;
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
    public String userRegister(UserBean user){
        Gson gson = new Gson();
        return gson.toJson(user);
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
}
