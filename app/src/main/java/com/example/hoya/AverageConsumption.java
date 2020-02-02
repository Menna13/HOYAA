package com.example.hoya;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;


public class AverageConsumption extends AppCompatActivity {
    String state;
    EditText stateInput;
    Button submitButton;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_average_consumption );
        stateInput=(EditText) findViewById( R.id.stateInput);
        submitButton=(Button) findViewById( R.id.submitState);
        textView=(TextView) findViewById( R.id.textView );
        submitButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state=stateInput.getText().toString();
                System.out.println("STATE IS: " + state);
                InputStream is = getResources().openRawResource( R.raw.energy );
                ConsumptionReader test = new ConsumptionReader(is);
                //set string from edittext to textview
                textView.setText("Rank is: " + test.consumptionMap.get(state)[0] + "\n"
                + "Average Consumption is: " + test.consumptionMap.get(state)[1] );

//                System.out.println("Rank is: " + test.consumptionMap.get(state)[0]);
//                System.out.println("Average Consumption is: " + test.consumptionMap.get(state)[1]);
            }
        } );
    }
}
