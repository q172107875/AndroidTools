package qibo.org.myapptools.ui.welcome.activity;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.LogUtils;

import qibo.org.myapptools.R;
import qibo.org.myapptools.ui.welcome.contract.WelcomeContract;
import qibo.org.myapptools.ui.welcome.model.WelcomeModel;
import qibo.org.myapptools.ui.welcome.presenter.WelcomePresenter;

public class WelComeActivity extends BaseActivity<WelcomePresenter,WelcomeModel> implements WelcomeContract.View {

    @Override
    public int getLayoutId() {
        return R.layout.activity_wel_come;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {
        mPresenter.lodeWelcomeacRequest("男男女女女女女女女女女女");
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
    public void returnWelcomeac(String type) {
        LogUtils.loge(type);
    }
}
