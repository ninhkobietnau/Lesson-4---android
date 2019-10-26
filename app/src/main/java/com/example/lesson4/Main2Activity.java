package com.example.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    protected EditText editTextUserName , editTextPassword , editTextConfirmPassword;
    protected Button buttonSignUp ;
    protected TextView textViewLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setUp();
        control();
    }

    private void control() {
        textViewLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this , MainActivity.class);
                startActivity(intent);
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextUserName.getText().toString().trim();
                String pass = editTextPassword.getText().toString().trim();

                if (name.length() != 0 && pass.length() != 0 && editTextConfirmPassword.getText().length() != 0) {

                    if (editTextConfirmPassword.getText().toString().trim().equals(pass)) {
                        Toast.makeText(Main2Activity.this , "Dang ky thanh cong" , Toast.LENGTH_SHORT).show();
                        Intent intentSignUp = new Intent(Main2Activity.this , MainActivity.class);
                        intentSignUp.putExtra("name" , name);
                        intentSignUp.putExtra("pass" , pass);
                        startActivity(intentSignUp);
                    } else {
                        Toast.makeText(Main2Activity.this , "Password khong khop nhau !" , Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(Main2Activity.this , "Nhap du thong tin" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setUp() {
        editTextUserName = findViewById(R.id.edtUserNameSignUp);
        editTextPassword = findViewById(R.id.edtPasswordSignUp);
        editTextConfirmPassword = findViewById(R.id.edtConfPassSignUp);
        buttonSignUp = findViewById(R.id.btSignUp);
        textViewLogIn = findViewById(R.id.tvLogInSignUp);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart", "On Start ?");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onRestart", "On Restart ?");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume", "On Resume ?");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause", "On Pause ?");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop", "On Stop ?");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy", "On Destroy ?");
    }
}
