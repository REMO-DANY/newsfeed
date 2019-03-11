package com.example.newsfeed;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    EditText email, password, cellno, name, college, confirm;
    Spinner degree, stream;
    Button signup;
    FirebaseAuth mAuth;

    String mail, pass, cell_no, uname, clg, deg, strm, confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.signup_username);
        password = findViewById(R.id.signup_password);
        cellno = findViewById(R.id.cellno);
        name = findViewById(R.id.username);
        college = findViewById(R.id.college);
        signup = findViewById(R.id.signup);
        confirm = findViewById(R.id.confirm_pass);
        degree = findViewById(R.id.degree);
        stream = findViewById(R.id.stream);
        mAuth = FirebaseAuth.getInstance();

        degree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                deg = (String) degree.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        stream.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strm = (String) stream.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mail = email.getText().toString();
                pass = password.getText().toString();
                cell_no = cellno.getText().toString();
                uname = name.getText().toString();
                clg = college.getText().toString();
                confirm_password = confirm.getText().toString();

                if(mail.isEmpty() || pass.isEmpty() || cell_no.isEmpty() || uname.isEmpty() || clg.isEmpty() || confirm_password.isEmpty() || deg.isEmpty() || strm.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                }else if(pass.length() < 8){
                    Toast.makeText(getApplicationContext(), "Password length is too short", Toast.LENGTH_SHORT).show();
                }else if(cell_no.length() < 10 || cell_no.length() > 10){
                    Toast.makeText(getApplicationContext(), "Inavlid mobile number", Toast.LENGTH_SHORT).show();
                }
                else if(!mail.contains("@")){
                    Toast.makeText(getApplicationContext(), "invalid email", Toast.LENGTH_SHORT).show();
                }else if(!pass.equals(confirm_password)){
                    Toast.makeText(getApplicationContext(), "password and confirm password not identical", Toast.LENGTH_SHORT).show();
                }
                else{
                    mAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(getApplicationContext(), "registration successful", Toast.LENGTH_SHORT).show();

                            Intent mIntent = new Intent(getApplicationContext(), home.class);
                            startActivity(mIntent);

                            if(!task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
