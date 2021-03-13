package com.lyschoenberg.einzelprojekt;

import android.widget.TextView;

public class PrimzahlThread extends Thread {
    private TextView textView;
    private String sentence;

    public PrimzahlThread(TextView textView, String sentence) {
        this.textView = textView;
        this.sentence = sentence;
    }

    @Override
    public void run() {
        StringBuilder modifiedSentence = new StringBuilder();
        byte[] sentenceArray = sentence.getBytes();
        for (int i = 0; i < sentenceArray.length; i++) {
            char c = (char) sentenceArray[i];
            if (c == '2' || c == '3' || c == '5' || c == '7') {
                modifiedSentence.append(c);
            }
        }

        textView.setText(modifiedSentence.toString());
    }
}
