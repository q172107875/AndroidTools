package qibo.org.myapptools.ui.main.model;

import com.alibaba.fastjson.JSON;
import com.jaydenxiao.common.commonutils.LogUtils;

import qibo.org.myapptools.api.ApiM;
import qibo.org.myapptools.api.ApiUtil;
import qibo.org.myapptools.api.basehttp.DoSchedule;
import qibo.org.myapptools.ui.bean.UserBean;
import qibo.org.myapptools.ui.bean.UserInfoBean;
import qibo.org.myapptools.ui.main.contract.MainContract;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

import static qibo.org.myapptools.api.ApiConstant.USER_REGISTER;

/**
 * Created by qibo on 2017/6/23.
 */

public class MainModel implements MainContract.Model {

    @Override
    public Observable loadMainac(final UserBean userBean) {
       return Observable.create(new Observable.OnSubscribe<String>() {
           @Override
           public void call(Subscriber<? super String> subscriber) {
               String reqPara = ApiM.getInstance().userRegister(userBean);
               LogUtils.loge(reqPara);
               subscriber.onNext(ApiUtil.retResult(USER_REGISTER,reqPara));
           }
        }).map(new Func1<String,UserInfoBean>() {
           @Override
           public UserInfoBean call(String s) {
               LogUtils.loge(s);
               return JSON.parseObject(s,UserInfoBean.class);
           }

       }).compose(DoSchedule.<UserInfoBean>applySchedulers());
    }
}
