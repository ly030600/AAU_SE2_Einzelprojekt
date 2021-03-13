package com.lyschoenberg.einzelprojekt;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TcpClientThread extends Thread {
    private TextView textView;
    private String sentence;

    public TcpClientThread(TextView textView, String sentence) {
        this.textView = textView;
        this.sentence = sentence;
    }

    @Override
    public void run() {
        try {
            Socket clientSocket = new Socket("se2-isys.aau.at", 53212);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.writeBytes(sentence + '\n');
            String modifiedSentence = inFromServer.readLine();
            textView.setText(modifiedSentence);

            clientSocket.close();
        } catch (Exception ignored) {
        }
    }
}
