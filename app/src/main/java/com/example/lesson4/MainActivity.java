package com.example.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected EditText editTextUserName , editTextPassword;
    protected Button buttonLogin ;
    protected TextView textViewSignUp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();
        control();
    }

    private void control() {
        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Main2Activity.class);
                startActivity(intent);
            }
        });

        Intent intent = this.getIntent();
        final String name = intent.getStringExtra("name");
        final String pass = intent.getStringExtra("pass");

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextUserName.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (userName.length() != 0 && password.length() !=0) {
                    if (userName.equals(name) && password.equals(pass)) {
                        Toast.makeText(MainActivity.this , "Congratulations!\nBan da dang nhap thanh cong" , Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this , "Sai ten tai khoan hoac mat khau !" , Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this , "Nhap du thong tin !" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setUp() {
        editTextUserName = findViewById(R.id.edtUserName);
        editTextPassword = findViewById(R.id.edtPassword);
        buttonLogin = findViewById(R.id.btLogIn);
        textViewSignUp = findViewById(R.id.tvSignUp);
    }
}
