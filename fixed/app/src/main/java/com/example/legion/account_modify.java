package com.example.legion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class account_modify extends AppCompatActivity {

    String pass_0, pass_1,pass_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_modify);
        Intent intent =getIntent();
        pass_0 = intent.getStringExtra("ori_password1");
        Log.d("password1",pass_0 );
        Button button = findViewById(R.id.ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 =  findViewById(R.id.original_password_1);
                String s_original = et1.getText().toString();//获取编辑框里面的内容
                Log.d("password2",s_original );
                EditText et2 =  findViewById(R.id.modify_password_1);
                pass_1 = et2.getText().toString();//获取编辑框里面的内容
                EditText et3 =  findViewById(R.id.verify_password_1);
                pass_2 = et3.getText().toString();//获取编辑框里面的内容
                if (s_original.equals(pass_0)&&pass_1.equals(pass_2)) {
                    Toast.makeText(account_modify.this, "密码修改成功", Toast.LENGTH_SHORT).show();
                    MainActivity.pass_0= pass_1;
                }
                else {
                    if (!s_original.equals(pass_0)){
                        Toast.makeText(account_modify.this, "原始密码错误", Toast.LENGTH_SHORT).show();
                    }
                    if (!pass_1.equals(pass_2)){
                        Toast.makeText(account_modify.this, "确认密码错误", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
