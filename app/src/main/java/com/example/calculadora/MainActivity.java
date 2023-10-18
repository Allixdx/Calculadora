package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    float result = 0;
    float n1 = 0.0f;
    float n2 = 0.0f;
    String operacion = "";

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = findViewById(R.id.resultado);
    }

    public void clear(View view) {
        resultado.setText("");
        n1 = 0.0f;
        n2 = 0.0f;
        operacion = "";
    }

    public void write(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if (resultado.getText() == "") {
            resultado.setText(buttonText);
        } else {
            resultado.setText(resultado.getText() + buttonText);
        }
    }

    public void operaciones(View view) {
        n1 = Float.parseFloat(resultado.getText().toString());
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        switch (buttonText)
        {
            case "/": operacion = "/"; break;
            case "+": operacion = "+"; break;
            case "-": operacion = "-"; break;
            case "X": operacion = "X"; break;
        }
        resultado.setText("");

    }


    public void igualOP(View view) {
        n2 = Float.parseFloat(resultado.getText().toString());
        switch (operacion)
        {
            case "/":
                if(n2==0.0f){
                    resultado.setText("0");
                    Toast.makeText(this, "Operación inválida", Toast.LENGTH_LONG).show();
                }
                else {
                    result = n1 / n2;
                    n1 = result;
                    resultado.setText(result+" ");
                }
                break;
            case "+":
                float result = n1 + n2;
                n1 = result;
                resultado.setText(result+" ");
                break;
            case "-":
                result = n1 - n2;
                n1 = result;
                resultado.setText(result+" ");
                break;
            case "X":
                result = n1 * n2;
                n1 = result;
                resultado.setText(result+" ");
                break;
        }
    }

    public void cambioSigno(View view) {
        float valorActual = Float.parseFloat(resultado.getText().toString());
        float nuevoValor = -valorActual;
        resultado.setText(String.valueOf(nuevoValor));

    }

}