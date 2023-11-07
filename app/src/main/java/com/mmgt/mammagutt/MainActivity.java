package com.mmgt.mammagutt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    TextView textView;

    public static final String EXTRA_MESSAGE = "MESSAGE";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextName);
        Intent intent = getIntent();
        String pesan1 = intent.getStringExtra(SecondActivity.EXTRA_MESSAGE);
        textView = findViewById(R.id.text_message);
        textView.setText(pesan1);
    }

    public void User1(View view) {
        String pesan = editText.getText().toString().trim();

        if (!pesan.isEmpty()) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, pesan);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Kolom pesan tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
    }
}