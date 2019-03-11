package com.example.newsfeed;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;

    String email, pass;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.login_name);
        password = findViewById(R.id.login_password);
        login = findViewById(R.id.login_btn);
        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = username.getText().toString();
                pass = password.getText().toString();

                if(email.isEmpty() || pass.isEmpty()){
                    Toast.makeText(getApplicationContext(), "details not filled", Toast.LENGTH_SHORT).show();
                }else {
                    mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(getApplicationContext(), "Sign in complete", Toast.LENGTH_SHORT).show();
                            Intent mIntent = new Intent(getApplicationContext(), home.class);
                            startActivity(mIntent);
                        }
                    });
                }
            }
        });
    }

    public void gotoSignup(View view) {
        Intent mIntent = new Intent(getApplicationContext(), signup.class);
        startActivity(mIntent);
    }
}
