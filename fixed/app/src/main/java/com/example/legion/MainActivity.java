package com.example.legion;

import android.app.DownloadManager;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
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

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    protected static String num_0="杨志平";
    protected static String num_1="杨洋";
    protected static String pass_0="123456";
    protected static String pass_part1="123456";

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
//    private String handleImageOnKitKat(Intent data) {
//        String imagePath = null;
//        Uri uri = data.getData();
//        Log.d("yy", "handleImageOnKitKat: uri is " + uri);
//        if (DocumentsContract.isDocumentUri(this, uri)) {
//            Log.d("yy", "isDocumentUri" );
//            // 如果是document类型的Uri，则通过document id处理
//            String docId = DocumentsContract.getDocumentId(uri);
//            if("com.android.providers.media.documents".equals(uri.getAuthority())) {
//                Log.d("yy", "documents" );
//                String id = docId.split(":")[1]; // 解析出数字格式的id
//                String selection = MediaStore.Images.Media._ID + "=" + id;
//                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
//            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
//                Log.d("yy", "downloads" );
//                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
//                imagePath = getImagePath(contentUri, null);
//            }
//        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
//            Log.d("yy", "getScheme" );
//            Log.d("yy", "imagePath" );
//            // 如果是content类型的Uri，则使用普通方式处理
////            getFPUriToPath(uri)
//            imagePath = getImagePath(uri, null);
//
//            Log.d("yy", imagePath );
//        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
//            Log.d("yy", "file" );
//            // 如果是file类型的Uri，直接获取图片路径即可
//            imagePath = uri.getPath();
//        }
//        return imagePath; // 根据图片路径显示图片
//    }
//    private String getImagePath(Uri uri, String selection) {
//        String name = null;
//        String path = null;
//        // 通过Uri和selection来获取真实的图片路径
//        Log.d("yy", "getImagePath" );
//        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
//        if (cursor != null) {
//            if (cursor.moveToFirst()) {
//                name = cursor.getColumnName(100000);
////                path = cursor.getString(10000);
//                Log.d("yy", DownloadManager.COLUMN_LOCAL_URI );
//                Log.d("yy", path );
//            }
//            cursor.close();
//        }
//        return path;
//    }





}
