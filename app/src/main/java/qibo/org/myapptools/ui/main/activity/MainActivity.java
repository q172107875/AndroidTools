package qibo.org.myapptools.ui.main.activity;

import com.jaydenxiao.common.base.BaseActivity;

import qibo.org.myapptools.R;
import qibo.org.myapptools.ui.main.contract.MainContract;
import qibo.org.myapptools.ui.main.model.MainModel;
import qibo.org.myapptools.ui.main.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter,MainModel> implements MainContract.View {


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {

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
    public void returnMainac() {

    }
}
