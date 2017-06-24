package qibo.org.myapptools.app;

import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.LogUtils;

import static qibo.org.myapptools.config.AppConfig.LOGUTILS_CONFIG;

/**
 * Created by qibo on 2017/6/23.
 */

public class MyApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.logInit(LOGUTILS_CONFIG);
    }
}
