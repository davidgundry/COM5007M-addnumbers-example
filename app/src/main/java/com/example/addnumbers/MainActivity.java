package com.example.addnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

interface NumberEvent
{
    double calculate(double a, double b);
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAddButtonPress(View view)
    {
        this._calculate((double a, double b) -> { return a + b; });
    }

    public void onSubButtonPress(View view)
    {
        this._calculate((double a, double b) -> { return a - b; });
    }

    public void onMultButtonPress(View view)
    {
        this._calculate((double a, double b) -> { return a * b; });
    }

    public void onDivButtonPress(View view)
    {
        this._calculate((double a, double b) -> { return a / b; });
    }

    private void _calculate(NumberEvent callback)
    {
        EditText num1 = findViewById(R.id.number1Input);
        EditText num2 = findViewById(R.id.number2Input);

        boolean parsed = false;
        double n1 = 0;
        double n2 = 0;
        try {
            n1 = Double.parseDouble(num1.getText().toString());
            n2 = Double.parseDouble(num2.getText().toString());
            parsed = true;
        }
        catch (NumberFormatException e)
        {
            parsed = false;
        }

        TextView outputText = findViewById(R.id.outputText);

        if (parsed)
        {
            double sum = callback.calculate(n1,n2);
            outputText.setText(String.valueOf(sum));
        }
        else
            outputText.setText(R.string.parseFailText);
    }

}