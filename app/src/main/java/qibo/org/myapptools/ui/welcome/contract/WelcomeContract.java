package qibo.org.myapptools.ui.welcome.contract;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import qibo.org.myapptools.ui.bean.UserBean;
import rx.Observable;

/**
 * Created by qibo on 2017/6/23.
 */

public interface WelcomeContract {
    interface Model extends BaseModel{
        Observable<UserBean> loadWelcomeac(String name);
        Observable<UserBean> loadWelcomeacid(long id);
    }
    interface View extends BaseView{
        void returnWelcomeac(UserBean userBean);
        void returnWelcomeacid(UserBean userBean);
    }
    abstract static class Presenter extends BasePresenter<View,Model>{
        public abstract void lodeWelcomeacRequest(String name);
        public abstract void lodeWelcomeacRequestod(long id);
    }
}
