package qibo.org.myapptools.ui.main.contract;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import qibo.org.myapptools.ui.bean.UserBean;
import qibo.org.myapptools.ui.bean.UserInfoBean;
import rx.Observable;

/**
 * Created by qibo on 2017/6/23.
 */

public interface MainContract {
    interface Model extends BaseModel{
        Observable loadMainac(UserBean userBean);
    }
    interface View extends BaseView{
        void returnMainac (UserInfoBean userInfoBean);
    }
    abstract static class Presenter extends BasePresenter<View,Model>{
        public abstract void lodeMainacRequest(UserBean userBean);
    }
}
