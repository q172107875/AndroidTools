package qibo.org.myapptools.ui.main.activity;

import android.view.View;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.ToastUitl;

import butterknife.Bind;
import qibo.org.myapptools.R;
import qibo.org.myapptools.ui.bean.UserBean;
import qibo.org.myapptools.ui.bean.UserInfoBean;
import qibo.org.myapptools.ui.main.contract.MainContract;
import qibo.org.myapptools.ui.main.model.MainModel;
import qibo.org.myapptools.ui.main.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainContract.View {


    @Bind(R.id.user_register)
    TextView userRegister;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);

    }

    @Override
    public void initView() {
        userRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserBean userBean = new UserBean();
                userBean.setUserName("张永富");
                userBean.setUserPhone("15244784570");
                userBean.setUserEmail("297340134@qq.com");
                userBean.setUserPwd("123456");
                mPresenter.lodeMainacRequest(userBean);
                showLoading("正在加载..");
            }
        });

    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }


    @Override
    public void returnMainac(UserInfoBean userInfoBean) {
        stopLoading();
        if (userInfoBean.getResult().equals("0")) {
            userRegister.setText(userInfoBean.toString());
            ToastUitl.showLong(userInfoBean.getMsg());
        }

    }

}
