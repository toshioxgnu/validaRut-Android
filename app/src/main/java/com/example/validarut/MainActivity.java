package com.example.validarut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void valida(View view){
        String rut;
        EditText txtrut =  findViewById(R.id.txtrut);
        TextView resultado =  findViewById(R.id.resultado);
        int[] constantesValidacion = {3,2,7,6,5,4,3,2};
        float suma = 0 ;

        rut = txtrut.getText().toString();

        if(rut.length() == 9) {
            rut = "0" + rut;
        }

        for(int j = 0; j < constantesValidacion.length; j++) {
            suma += ( Integer.parseInt(Character.toString(rut.charAt(j))) * constantesValidacion[j]);
        }

        float division = suma/11;
        int divisionentero = (int) division ;
        float resto = division - divisionentero;
        float resta = 11 - (11 * resto);
        int digito = Math.round(resta);

        String digitorut = Character.toString(rut.charAt(9));

        if (digitorut.equals("k")) {
            digitorut = "9";
        }else if(digitorut == "0") {
            digitorut = "11";
        }

        if (Integer.toString(digito).equals(digitorut))
        {
            resultado.setText("RUT CORRECTO ");
        }
        else
        {
            if (Integer.toString(digito).equals("9")) {
                resultado.setText("Rut incorrecto, el digito debe ser : k");
            }
            else if (digito == 11) {
                resultado.setText("Rut incorrecto, el digito debe ser :" + 0);
            }
            else {
                resultado.setText("Rut incorrecto, el digito debe ser : " + digito +" "+ suma +" "+ resto +" "+resta );
            }
        }
    }

}
