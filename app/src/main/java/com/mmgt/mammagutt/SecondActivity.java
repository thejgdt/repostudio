package com.mmgt.mammagutt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    EditText editText;

    public static final String EXTRA_MESSAGE = "MESSAGE";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = findViewById(R.id.text_message_second);
        editText = findViewById(R.id.editTextPerson);
        Intent intent = getIntent();
        String pesan2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView.setText(pesan2);
    }

    public void User2(View view) {
        String pesan = editText.getText().toString().trim(); // Menghapus spasi dari pesan

        if (!pesan.isEmpty()) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, pesan);
            startActivity(intent);
        } else {
            // Menampilkan toast peringatan jika kolom pesan kosong
            Toast.makeText(this, "Kolom pesan tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
    }

}