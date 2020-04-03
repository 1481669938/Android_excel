package com.example.legion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class activity_part1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.modify:
                Toast.makeText(this, "您可以修改密码了", Toast.LENGTH_SHORT).show();
                Intent intent = getIntent();
                String ori_password = intent.getStringExtra("ori_password");
                Log.d("password",ori_password );
                Intent intent1=new Intent(activity_part1.this,account_modify1.class);
                intent1.putExtra("ori_password1", ori_password);
                startActivity(intent1);
                break;
//            case R.id.Del_item:
//                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
//                break;
            default:
        }
        return true;
    }
}
