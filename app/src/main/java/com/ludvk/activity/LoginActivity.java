package com.ludvk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ludvk.utils.T;

public class LoginActivity extends Activity implements OnClickListener {

    private Button login_button, bottom_login_btn;
    private TextView name, pws;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        T.showShort(this,"增量更新成功");
    }

    private void init() {
        name = (TextView) findViewById(R.id.edit_username);
        pws = (TextView) findViewById(R.id.edit_password);
        login_button = (Button) findViewById(R.id.login_button);
        bottom_login_btn = (Button) findViewById(R.id.bottom_login_btn);
        login_button.setOnClickListener(this);
        bottom_login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getId()) {
            case R.id.login_button:

                if (canSave()) {
                    if (name.getText().toString().equals("luhang")
                            && pws.getText().toString().equals
                            ("123456")) {
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    }

                }
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);

                break;

            case R.id.bottom_login_btn:
                intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", "https://www.baidu.com/");
                startActivity(intent);
                break;
            default:
                break;
        }


    }

    private boolean canSave() {
        if (TextUtils.isEmpty(name.getText())) {
            Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(pws.getText())) {
            Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


}
