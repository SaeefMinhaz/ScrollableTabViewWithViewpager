package com.example.user.scrollabletabview.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.scrollabletabview.R;

public class MainActivity extends AppCompatActivity {

    Button allServicesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allServicesBtn = findViewById(R.id.allServicesBtn);
        allServicesBtn.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.allServicesBtn:
                    startActivity(new Intent(MainActivity.this, ScrollableTabsActivity.class));
            }
        }
    };
}
