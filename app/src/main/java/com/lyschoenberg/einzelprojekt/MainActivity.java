package com.lyschoenberg.einzelprojekt;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber;
    private TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        answerTextView = findViewById(R.id.answerTextView);
    }

    public void sendMessage(View view) {
        String matrikelnummer = editTextNumber.getText().toString();
        TcpClientThread thread = new TcpClientThread(answerTextView, matrikelnummer);
        thread.start();
    }

    public void calculatePrimzahl(View view) {
        String matrikelnummer = editTextNumber.getText().toString();
        PrimzahlThread thread = new PrimzahlThread(answerTextView, matrikelnummer);
        thread.start();
    }
}