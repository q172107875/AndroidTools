package qibo.org.myapptools.ui.welcome.model;

import com.alibaba.fastjson.JSON;
import com.jaydenxiao.common.commonutils.LogUtils;

import qibo.org.myapptools.api.ApiM;
import qibo.org.myapptools.api.ApiUtil;
import qibo.org.myapptools.api.basehttp.DoSchedule;
import qibo.org.myapptools.ui.welcome.bean.ShowUserBean;
import qibo.org.myapptools.ui.welcome.contract.WelcomeContract;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

import static qibo.org.myapptools.api.ApiConstant.USER_USERNAMEW;

/**
 * Created by qibo on 2017/6/23.
 */

public class WelcomeModel implements WelcomeContract.Model {

    @Override
    public Observable<ShowUserBean> loadWelcomeac(final String name) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                String reqPara = ApiM.getInstance().sekectUser(name);
                LogUtils.logd(reqPara);
                subscriber.onNext(ApiUtil.retResult(USER_USERNAMEW,reqPara));
            }
        }).map(new Func1<String, ShowUserBean>() {
            @Override
            public ShowUserBean call(String s) {
                LogUtils.loge(s);
                return JSON.parseObject(s,ShowUserBean.class);
            }
        }).compose(DoSchedule.<ShowUserBean>applySchedulers());
    }

    @Override
    public Observable<ShowUserBean> loadWelcomeacid(final long id) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                String reqPara = ApiM.getInstance().sekectUserid(id);
                subscriber.onNext(ApiUtil.retResult(USER_USERNAMEW,reqPara));

            }
        }).map(new Func1<String, ShowUserBean>() {
            @Override
            public ShowUserBean call(String s) {
                LogUtils.loge(s);
                return JSON.parseObject(s,ShowUserBean.class);
            }
        }).compose(DoSchedule.<ShowUserBean>applySchedulers());
    }
}
