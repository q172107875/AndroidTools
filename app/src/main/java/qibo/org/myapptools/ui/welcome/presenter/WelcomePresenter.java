package qibo.org.myapptools.ui.welcome.presenter;

import com.jaydenxiao.common.commonutils.LogUtils;

import qibo.org.myapptools.ui.welcome.bean.ShowUserBean;
import qibo.org.myapptools.ui.welcome.contract.WelcomeContract;
import rx.Subscriber;

/**
 * Created by qibo on 2017/6/23.
 */

public class WelcomePresenter extends WelcomeContract.Presenter {

    @Override
    public void lodeWelcomeacRequest(String name) {
        mRxManage.add(mModel.loadWelcomeac(name).subscribe(new Subscriber<ShowUserBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.loge(e.getMessage()+e.toString());
            }

            @Override
            public void onNext(ShowUserBean showUserBean) {
                mView.returnWelcomeac(showUserBean);
            }
        }));
    }

    @Override
    public void lodeWelcomeacRequestod(long id) {
        mRxManage.add(mModel.loadWelcomeacid(id).subscribe(new Subscriber<ShowUserBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.loge(e.getMessage()+e.toString());
            }

            @Override
            public void onNext(ShowUserBean showUserBean) {
                mView.returnWelcomeacid(showUserBean);
            }
        }));
    }
}
