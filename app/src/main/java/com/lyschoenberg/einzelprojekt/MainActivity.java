package com.lyschoenberg.einzelprojekt;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber;
    private TextView labelTextView;
    private TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        labelTextView = findViewById(R.id.labelTextView);
        answerTextView = findViewById(R.id.answerTextView);
    }

    public void sendMessage(View view) {
        String matrikelnummer = editTextNumber.getText().toString();
        labelTextView.setText("Antwort vom Server");
        TcpClientThread thread = new TcpClientThread(answerTextView, matrikelnummer);
        thread.start();
    }

    public void calculatePrimzahl(View view) {
        String matrikelnummer = editTextNumber.getText().toString();
        labelTextView.setText("Berechnung Primzahl");
        PrimzahlThread thread = new PrimzahlThread(answerTextView, matrikelnummer);
        thread.start();
    }
}