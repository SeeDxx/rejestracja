package com.example.rejestracja;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText haslo;
    private EditText powt;
    private Button zatw;
    private TextView napis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        haslo = findViewById(R.id.haslo);
        powt = findViewById(R.id.powt);
        zatw = findViewById(R.id.zatw);
        napis = findViewById(R.id.napis);

        zatw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toEmail = email.getText().toString().trim();
                String toHaslo = haslo.getText().toString().trim();
                String toPowt = powt.getText().toString().trim();
                Pattern pattern = Pattern.compile(".+@.+");
                if (!pattern.matcher(toEmail).matches()){
                    napis.setText("Nieprawidłowy adres e-mail");
                } else if (!toHaslo.equals(toPowt)){
                    napis.setText("Hasła się różnią");
                } else {
                    napis.setText("Witaj " + toEmail);
                }
            }
        });
    }
}