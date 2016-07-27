package com.example.majunpeng.jvnengwan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.bean.User;
import com.example.majunpeng.jvnengwan.model.LoginModel;
import com.example.majunpeng.jvnengwan.model.LoginModelImpl;
import com.example.majunpeng.jvnengwan.model.OnLoginListener;

public class LoginActivity extends AppCompatActivity implements View
        .OnClickListener, OnLoginListener {


    private ImageView iv_back_login;
    private TextView tv_intoRegister_login;
    private EditText editText_userName_login;
    private ImageView imageView_cha1_login;
    private EditText editText_passWord_login;
    private ImageView imageView_cha2_login;
    private Button btn_login;
    private ImageView iv_loginByQQ;
    private LoginModel loginModel;
    private TextInputLayout textInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();


    }

    private void initView() {

        loginModel = new LoginModelImpl();


        iv_back_login = (ImageView) findViewById(R.id.iv_back_login);
        iv_back_login.setOnClickListener(this);

        tv_intoRegister_login = (TextView) findViewById(R.id.tv_intoRegister_login);
        tv_intoRegister_login.setOnClickListener(this);

        editText_userName_login = (EditText) findViewById(R.id
                .editText_userName_login);


        imageView_cha1_login = (ImageView) findViewById(R.id.imageView_cha1_login);
        imageView_cha1_login.setOnClickListener(this);

        editText_passWord_login = (EditText) findViewById(R.id
                .editText_passWord_login);


        imageView_cha2_login = (ImageView) findViewById(R.id.imageView_cha2_login);
        imageView_cha2_login.setOnClickListener(this);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        iv_loginByQQ = (ImageView) findViewById(R.id.iv_loginByQQ);
        iv_loginByQQ.setOnClickListener(this);
        textInputLayout = (TextInputLayout) findViewById(R.id.textInputLayout_login);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                submit();

                break;
            case R.id.imageView_cha1_login:
                editText_userName_login.setText("");
                break;
            case R.id.imageView_cha2_login:
                editText_passWord_login.setText("");

                break;
            case R.id.tv_intoRegister_login:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);

                break;
            case R.id.iv_back_login:

                break;

            case R.id.iv_loginByQQ:

                break;
        }
    }

    private void submit() {

        String userName = editText_userName_login.getText().toString().trim();
        String pwd = editText_passWord_login.getText().toString().trim();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(pwd)) {

            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError("输入不能为空");
        } else {

            textInputLayout.setErrorEnabled(false);
            User user = new User();
            user.setName(userName);
            user.setPwd(pwd);

            // TODO: 2016/7/26 等待登录验证的返回值
            loginModel.getLoginState(user, this, this);

        }


    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
        finish();

    }

    @Override
    public void loginFailure(String str) {

        Toast.makeText(this, str, Toast.LENGTH_LONG).show();

    }
}
