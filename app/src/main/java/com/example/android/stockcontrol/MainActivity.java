package com.example.android.stockcontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username_text_view);
        password = findViewById(R.id.password_text_view);
        login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
//                    Intent login = new Intent(MainActivity.this, Menu.class);
//                    Toast.makeText(getApplicationContext(), "Signed In", Toast.LENGTH_SHORT).show();
//                    startActivity(login);
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
//                }

                Intent login = new Intent(MainActivity.this, Menu.class);
                   Toast.makeText(getApplicationContext(), "Signed In", Toast.LENGTH_SHORT).show();
                   startActivity(login);
            }
        });


    }
}
