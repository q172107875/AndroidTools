package qibo.org.myapptools.ui.main.contract;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

/**
 * Created by qibo on 2017/6/23.
 */

public interface MainContract {
    interface Model extends BaseModel{
        void loadMainac();
    }
    interface View extends BaseView{
        void returnMainac ();
    }
    abstract static class Presenter extends BasePresenter<View,Model>{
        public abstract void lodeMainacRequest();
    }
}
