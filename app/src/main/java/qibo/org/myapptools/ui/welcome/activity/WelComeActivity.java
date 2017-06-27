package qibo.org.myapptools.ui.welcome.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.ToastUitl;

import butterknife.Bind;
import qibo.org.myapptools.R;
import qibo.org.myapptools.ui.bean.UserBean;
import qibo.org.myapptools.ui.main.activity.MainActivity;
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
                if (nameEt.getText().length() > 0) {
                    mPresenter.lodeWelcomeacRequest(nameEt.getText().toString());
                } else {
                    ToastUitl.showLong("不能为空ID 或 Name");
                }

            }
        });
        selectIdBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameEt.getText().length() > 0) {
                    mPresenter.lodeWelcomeacRequestod(Long.parseLong(nameEt.getText().toString()));
                } else {
                    ToastUitl.showLong("不能为空ID 或 Name");
                }

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
        userText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MainActivity.class);
            }
        });
    }

}
