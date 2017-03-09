package com.example.nichoshi.custombroadcastpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    private Button LoginBtn;
    private EditText nameEditText;
    private EditText pswEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginBtn = (Button) findViewById(R.id.Login_Btn);
        nameEditText = (EditText) findViewById(R.id.Login_name);
        pswEditText = (EditText) findViewById(R.id.Login_psw);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String psw = pswEditText.getText().toString();
                if(name.equals("") || psw.equals("")){
                    Toast.makeText(MainActivity.this,"用户名和密码不能为空",Toast.LENGTH_SHORT).show();
                }
                else if(name.equals("admin") && psw.equals("admin")){
                    Intent myIntent = new Intent(MainActivity.this,SendBroadcastActivity.class);
                    startActivity(myIntent);
                }
                else{
                    Toast.makeText(MainActivity.this,"用户名或密码错误，请重新输入",Toast.LENGTH_SHORT).show();
                    nameEditText.setText("");
                    pswEditText.setText("");
                }
            }
        });




    }
}
