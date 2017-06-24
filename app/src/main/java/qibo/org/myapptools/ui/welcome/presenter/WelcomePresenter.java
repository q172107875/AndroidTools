package qibo.org.myapptools.ui.welcome.presenter;

import qibo.org.myapptools.ui.welcome.contract.WelcomeContract;
import rx.Subscriber;

/**
 * Created by qibo on 2017/6/23.
 */

public class WelcomePresenter extends WelcomeContract.Presenter {

    @Override
    public void lodeWelcomeacRequest(String type) {
        mRxManage.add(mModel.loadWelcomeac(type).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                mView.returnWelcomeac(s);
            }
        }));
    }
}
