package com.example.t00055219.kawaii_converter;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.R.attr.button;
import static android.R.attr.onClick;
import static com.example.t00055219.kawaii_converter.R.string.c;
import static com.example.t00055219.kawaii_converter.R.string.f;

public class MainActivity extends AppCompatActivity {
    //Declare Global Variables
    Double results;
    Button convertBtn;
    Spinner spin1, spin2;
    TextView output;
    EditText input;
    Double temp;
    String a, b, f, c, i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize all variables
        convertBtn = (Button) findViewById(R.id.convertButton);
        spin1 = (Spinner)findViewById(R.id.unitASpinner);
        spin2 = (Spinner) findViewById(R.id.unitBSpinner);
        output = (TextView) findViewById(R.id.resultsLabel);
        input = (EditText) findViewById(R.id.editText1);

        //Turn Input Into Double
        f = spin1.getItemAtPosition(0).toString();
        c = spin1.getItemAtPosition(1).toString();

//        ada1 = spin1.setAdapter();

        //On Click Listen
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResults();
            }
        });

        //On text change listener
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                updateResults();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //On Spinner Change Listener
//        spin1.setOnItemSelectListener(new Ada)
    }

    public void updateResults(){
        i = input.getText().toString();
        a = spin1.getSelectedItem().toString();//First Spinner Value
        b = spin2.getSelectedItem().toString();//Second Spinner Value
        //If empty input
        if (i.isEmpty()) {
            if (a.equals(b)) {
                Toast.makeText(getApplicationContext(), "No Calculations Needed!", Toast.LENGTH_LONG).show();
                output.setText("");
            } else if (!a.equals(b)) {
                Toast.makeText(getApplicationContext(), "Please Enter A Value!", Toast.LENGTH_LONG).show();
                output.setText("null");
            }
        } else {
            if (a.equals(b)) {
                Toast.makeText(getApplicationContext(), "Both Values Are The Same!", Toast.LENGTH_LONG).show();
                results = Double.parseDouble(i);
                output.setText(results.toString());
            }
            else if (a.equals(f)) {
                temp = Double.parseDouble(i);
                results = (temp - 32) * 5 / 9;
                output.setText(results.toString());
            }
            else if (a.equals(c)) {
                temp = Double.parseDouble(i);
                results = (temp * 9 / 5) + 32;
                output.setText(results.toString());
            }
            else {
                Toast.makeText(getApplicationContext(), "Something Went Wrong.", Toast.LENGTH_LONG).show();
            }
        }
    };
}
