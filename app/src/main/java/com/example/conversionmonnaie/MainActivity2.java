package com.example.conversionmonnaie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button btnConvert;
    TextView firstCurrency;
    TextView secondCurrency;
    Spinner listCurrency;
    EditText currency;

    private static final double DH_TO_USD_RATE = 0.096;
    private static final double DH_TO_EUR_RATE = 0.090;
    private static final double EUR_TO_USD_RATE = 1.06;
    private static final double EUR_TO_DH_RATE = 11.08;
    private static final double USD_TO_DH_RATE = 10.41;
    private static final double USD_TO_EUR_RATE = 0.94;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnConvert = findViewById(R.id.convertBtn);
        firstCurrency = findViewById(R.id.firstCurrency);
        secondCurrency = findViewById(R.id.secondCurrency);
        listCurrency = findViewById(R.id.listMonnaie);
        currency = findViewById(R.id.currency);

        String[] arraySpinner = new String[] {
                "DH", "EURO", "DOLLAR"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                arraySpinner
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listCurrency.setAdapter(adapter);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    double prix = Double.parseDouble(currency.getText().toString());

                    switch (listCurrency.getSelectedItem().toString()) {
                        case "DH":
                            firstCurrency.setText(String.format("%.2f$", prix * DH_TO_USD_RATE));
                            secondCurrency.setText(String.format("%.2f€", prix * DH_TO_EUR_RATE));
                            break;

                        case "EURO":
                            firstCurrency.setText(String.format("%.2fDH", prix * EUR_TO_DH_RATE));
                            secondCurrency.setText(String.format("%.2f$", prix * EUR_TO_USD_RATE));
                            break;

                        case "DOLLAR":
                            firstCurrency.setText(String.format("%.2fDH", prix * USD_TO_DH_RATE));
                            secondCurrency.setText(String.format("%.2f€", prix * USD_TO_EUR_RATE));
                            break;
                    }
                }
        });
    }
}

