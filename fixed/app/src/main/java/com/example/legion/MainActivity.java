package com.example.legion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String num_0="杨志平";
    public static String num_1="杨洋";
    public static String pass_0="123456";
    public static String pass_part1="123456";
//    String num_0="杨志平",num_1="杨洋",num_2,num_3,num_4,num_5,num_6,num_7,num_8,num_9,num_10,num_11;
//    String pass_0="123456",pass_1="123456",pass_2,pass_3,pass_4,pass_5,pass_6,pass_7,pass_8,pass_9,pass_10,pass_11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("PASS_1", pass_part1);
        Log.d("PASS_0", pass_0);
        Button button = findViewById(R.id.login);
        Button button1 =  findViewById(R.id.quit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 =  findViewById(R.id.name);
                String s_num = et1.getText().toString();//获取编辑框里面的内容
                EditText et2 =  findViewById(R.id.password);
                String s_pass = et2.getText().toString();//获取编辑框里面的内容
                if (s_num.equals(num_0)&&s_pass.equals(pass_0)) {
                    Toast.makeText(MainActivity.this, s_num+"管理员登陆成功", Toast.LENGTH_SHORT).show();
                    String ori_password = pass_0;
                    Intent intent=new Intent(MainActivity.this,activity_select.class);
                    intent.putExtra("ori_password", ori_password);
                    startActivity(intent);
                }
                if(s_num.equals(num_1)&&s_pass.equals(pass_part1)) {
                    Toast.makeText(MainActivity.this, s_num+"用户1登陆成功", Toast.LENGTH_SHORT).show();
                    String ori_password = pass_part1;
                    Intent intent=new Intent(MainActivity.this,activity_part1.class);
                    intent.putExtra("ori_password", ori_password);
                    startActivity(intent);
                }
                if(!((s_num.equals(num_0)&&s_pass.equals(pass_0))||(s_num.equals(num_1)&&s_pass.equals(pass_part1)))) {
                    Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 =  findViewById(R.id.name);
                et1.setText(null);//将用户名一栏清空
                EditText et2 =  findViewById(R.id.password);
                et2.setText(null);//将密码栏清空
            }
        });
    }



}
