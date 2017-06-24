package qibo.org.myapptools.ui.welcome.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.LogUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import qibo.org.myapptools.R;
import qibo.org.myapptools.ui.bean.UserBean;
import qibo.org.myapptools.ui.welcome.contract.WelcomeContract;
import qibo.org.myapptools.ui.welcome.model.WelcomeModel;
import qibo.org.myapptools.ui.welcome.presenter.WelcomePresenter;

public class WelComeActivity extends BaseActivity<WelcomePresenter, WelcomeModel> implements WelcomeContract.View {

    @Bind(R.id.name_et)
    EditText nameEt;
    @Bind(R.id.select_name_bt)
    Button selectNameBt;
    @Bind(R.id.user_text)
    TextView userText;
    @Bind(R.id.select_id_bt)
    Button selectIdBt;

    @Override
    public int getLayoutId() {
        return R.layout.activity_wel_come;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        selectNameBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.lodeWelcomeacRequest(nameEt.getText().toString());
            }
        });
        selectIdBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.lodeWelcomeacRequestod(Long.parseLong(nameEt.getText().toString()));
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
    public void returnWelcomeac(UserBean userBean) {
        userText.setText(new Gson().toJson(userBean));
    }

    @Override
    public void returnWelcomeacid(UserBean userBean) {
        userText.setText(new Gson().toJson(userBean));
    }

}
