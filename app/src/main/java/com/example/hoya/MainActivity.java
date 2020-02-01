package com.example.hoya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("hahahahahahahahahahahahahahahahah");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initiateMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
        String message = "Success";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
