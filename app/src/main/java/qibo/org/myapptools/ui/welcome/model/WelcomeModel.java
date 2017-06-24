package qibo.org.myapptools.ui.welcome.model;

import com.jaydenxiao.common.baseapp.AppCache;
import com.jaydenxiao.common.baserx.RxSchedulers;
import com.jaydenxiao.common.commonutils.LogUtils;

import qibo.org.myapptools.ui.welcome.contract.WelcomeContract;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by qibo on 2017/6/23.
 */

public class WelcomeModel implements WelcomeContract.Model {

    @Override
    public Observable<String> loadWelcomeac(final String type) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext(AppCache.getInstance().getIcon());
                subscriber.onCompleted();
                LogUtils.logd("result"+type.toString());
            }
        }).compose(RxSchedulers.<String>io_main());
    }
}
