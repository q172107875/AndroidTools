package qibo.org.myapptools.ui.welcome.model;

import com.alibaba.fastjson.JSON;
import com.jaydenxiao.common.commonutils.LogUtils;

import qibo.org.myapptools.api.ApiM;
import qibo.org.myapptools.api.ApiUtil;
import qibo.org.myapptools.api.basehttp.DoSchedule;
import qibo.org.myapptools.ui.bean.UserBean;
import qibo.org.myapptools.ui.welcome.contract.WelcomeContract;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by qibo on 2017/6/23.
 */

public class WelcomeModel implements WelcomeContract.Model {

    @Override
    public Observable<UserBean> loadWelcomeac(final String name) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                String reqPara = ApiM.getInstance().sekectUser(name);
                LogUtils.logd(reqPara);
                subscriber.onNext(ApiUtil.retResult("show",reqPara));
            }
        }).map(new Func1<String, UserBean>() {
            @Override
            public UserBean call(String s) {
                LogUtils.logd(s);
                return JSON.parseObject(s,UserBean.class);
            }
        }).compose(DoSchedule.<UserBean>applySchedulers());
    }

    @Override
    public Observable<UserBean> loadWelcomeacid(final long id) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                String reqPara = ApiM.getInstance().sekectUserid(id);
                LogUtils.logd(reqPara);
                subscriber.onNext(ApiUtil.retResult("showUser",reqPara));
            }
        }).map(new Func1<String, UserBean>() {
            @Override
            public UserBean call(String s) {
                LogUtils.logd(s);
                return JSON.parseObject(s,UserBean.class);
            }
        }).compose(DoSchedule.<UserBean>applySchedulers());
    }
}
