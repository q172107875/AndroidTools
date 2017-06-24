package qibo.org.myapptools.ui.welcome.contract;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import rx.Observable;

/**
 * Created by qibo on 2017/6/23.
 */

public interface WelcomeContract {
    interface Model extends BaseModel{
        Observable<String> loadWelcomeac(String type);
    }
    interface View extends BaseView{
        void returnWelcomeac(String type);
    }
    abstract static class Presenter extends BasePresenter<View,Model>{
        public abstract void lodeWelcomeacRequest(String type);
    }
}
