package com.tutorialesprogramacionya.proyecto003;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2;
    private TextView tv1;
    private RadioButton r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        tv1=findViewById(R.id.tv1);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);
        r4=findViewById(R.id.r4);
    }

    //Este método se ejecutará cuando se presione el botón
    public void operar(View view) {

        String valor1=et1.getText().toString();
        String valor2=et2.getText().toString();
        int nro1=Integer.parseInt(valor1);
        int nro2=Integer.parseInt(valor2);
        if (valor1.equals("0") || valor2.equals("0")){
                String resu = "No es posible realizar una operacion con 0";
                tv1.setText(resu);
        }else if (valor1.isEmpty() || valor2.isEmpty()){
            String resu = "Debes escribir 2 numeros para operar";
            tv1.setText(resu);
        }else{
            if (r1.isChecked() == true) {
                int suma = nro1 + nro2;
                String resu = String.valueOf(suma);
                tv1.setText(resu);
            } else if (r2.isChecked() == true) {
                int resta = nro1 - nro2;
                String resu = String.valueOf(resta);
                tv1.setText(resu);
            } else if (r3.isChecked() == true) {
                int multiplicar = nro1 * nro2;
                String resu = String.valueOf(multiplicar);
                tv1.setText(resu);
            } else if (r4.isChecked() == true) {
                int dividir = nro1 / nro2;
                String resu = String.valueOf(dividir);
                tv1.setText(resu);
            }
        }
    }
}