package com.example.majunpeng.jvnengwan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.majunpeng.jvnengwan.R;
import com.example.majunpeng.jvnengwan.bean.User;
import com.example.majunpeng.jvnengwan.model.LoginModel;
import com.example.majunpeng.jvnengwan.model.LoginModelImpl;
import com.example.majunpeng.jvnengwan.model.OnLoginListener;

public class RegisterActivity extends AppCompatActivity implements View
        .OnClickListener, OnLoginListener {


    private ImageView iv_back_register;
    private EditText editText_userName_register;
    private EditText editText_passWord_register;
    private EditText editText_passWordConfirm_Register;
    private Button btn_register;
    private LoginModel loginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {

        loginModel = new LoginModelImpl();

        iv_back_register = (ImageView) findViewById(R.id.iv_back_register);
        iv_back_register.setOnClickListener(this);

        editText_userName_register = (EditText) findViewById(R.id
                .editText_userName_register);


        editText_passWord_register = (EditText) findViewById(R.id
                .editText_passWord_register);

        editText_passWordConfirm_Register = (EditText) findViewById(R.id
                .editText_passWordConfirm_Register);

        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                submit();

                break;
            case R.id.iv_back_register:
                finish();
                break;

        }
    }

    private void submit() {


        String userName = editText_userName_register.getText().toString().trim();
        String pwd = editText_passWord_register.getText().toString().trim();
        String pwdAgain = editText_passWordConfirm_Register.getText().toString()
                .trim();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(pwd) || TextUtils
                .isEmpty(pwdAgain)) {
            Toast.makeText(this, "空", Toast.LENGTH_LONG).show();
        } else if (!pwd.equals(pwdAgain)) {
            Toast.makeText(this, "密码不一致", Toast.LENGTH_LONG).show();

        } else {
            User user = new User();
            user.setName(userName);

            user.setPwd(pwd);
            loginModel.getRegisterState(user, this, this);
        }


    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_LONG).show();
        finish();

    }

    @Override
    public void loginFailure(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();

    }
}
