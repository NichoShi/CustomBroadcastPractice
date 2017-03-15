package com.example.nichoshi.custombroadcastpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    private Button LoginBtn;
    private EditText nameEditText;
    private EditText pswEditText;
    private CheckBox rememberPsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginBtn = (Button) findViewById(R.id.Login_Btn);
        nameEditText = (EditText) findViewById(R.id.Login_name);
        pswEditText = (EditText) findViewById(R.id.Login_psw);
        rememberPsw = (CheckBox)findViewById(R.id.rememberPsw);
        getUser();


        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String psw = pswEditText.getText().toString();
                if(name.equals("") || psw.equals("")){
                    Toast.makeText(MainActivity.this,"用户名和密码不能为空",Toast.LENGTH_SHORT).show();
                }
                else if(name.equals("admin") && psw.equals("admin")){
                    SharedPreferences.Editor editor = getSharedPreferences("user",MODE_PRIVATE).edit();
                    if(rememberPsw.isChecked()){

                        editor.putString("name",name);
                        editor.putString("psw",psw);
                        editor.putBoolean("remember",true);
                        editor.commit();
                    }
                    else{
                        editor.clear();
                        editor.commit();
                    }

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

    public void getUser(){
        SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");
        String psw = sharedPreferences.getString("psw","");
        boolean isRemember = sharedPreferences.getBoolean("remember",false);
        if(!name.equals("") && !psw.equals("") && isRemember){
            nameEditText.setText(name);
            pswEditText.setText(psw);
            rememberPsw.setChecked(true);
        }


    }
}
