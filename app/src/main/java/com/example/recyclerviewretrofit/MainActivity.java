package com.example.recyclerviewretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText userName;
    private Button clickHere;
    public static final String KEY_USER_NAME = "userKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.et_userName);
        clickHere = findViewById(R.id.btn_click);

        clickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameInput = userName.getText().toString();
                if (userNameInput.isEmpty()) {
                    Toast.makeText(MainActivity.this, "empty credentials", Toast.LENGTH_LONG)
                            .show();
                }
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                intent.putExtra(KEY_USER_NAME, userNameInput);
                startActivity(intent);
            }
        });
    }


}
