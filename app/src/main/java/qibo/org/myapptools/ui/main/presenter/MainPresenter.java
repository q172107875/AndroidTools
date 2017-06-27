package qibo.org.myapptools.ui.main.presenter;

import com.jaydenxiao.common.commonutils.LogUtils;

import qibo.org.myapptools.ui.bean.UserBean;
import qibo.org.myapptools.ui.bean.UserInfoBean;
import qibo.org.myapptools.ui.main.contract.MainContract;
import rx.Subscriber;

/**
 * Created by qibo on 2017/6/23.
 */

public class MainPresenter extends MainContract.Presenter {

    @Override
    public void lodeMainacRequest(UserBean userBean) {
        mRxManage.add(mModel.loadMainac(userBean).subscribe(new Subscriber<UserInfoBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.loge(e.getMessage()+e.toString());
            }

            @Override
            public void onNext(UserInfoBean userBean) {
                mView.returnMainac(userBean);
            }
        }));
    }
}
