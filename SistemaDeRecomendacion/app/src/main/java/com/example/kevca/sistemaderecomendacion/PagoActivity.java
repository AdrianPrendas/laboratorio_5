package com.example.kevca.sistemaderecomendacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevca.sistemaderecomendacion.bl.CarritoBL;
import com.example.kevca.sistemaderecomendacion.bl.UsuarioBL;
import com.example.kevca.sistemaderecomendacion.domain.Carrito;

public class PagoActivity extends AppCompatActivity {
    private RadioButton rbtarjetas;
    private RadioButton rbpaypall;
    private EditText editText; //Numero
    private EditText editText2; //Nombre tarjeta
    private EditText editText3;
    private EditText editText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
        rbtarjetas = findViewById(R.id.radioButton_tarjets);
        rbpaypall = findViewById(R.id.radioButton_paypal);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        float total = CarritoBL.Companion.getInstance().read(
                UsuarioBL.Companion.getSession()
        ).getPrecioTotal();
        TextView t = (TextView) findViewById(R.id.total);
        t.setText(String.format("$%.2f",total));

        Button clickButton = (Button) findViewById(R.id.btn_pago);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(espaciosVerificados()){

                Carrito c = CarritoBL.Companion.getInstance().read(
                        UsuarioBL.Companion.getSession()
                );
                Toast.makeText(
                        getApplicationContext(),
                        "Se realizo el pago correctamente por un monto de:"+ c.getPrecioTotal(),
                        Toast.LENGTH_LONG)
                .show();
                c.pagar();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                }else{
                    Toast.makeText(
                            getApplicationContext(),
                            "Rellene todos los espacios",
                            Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
    private boolean espaciosVerificados() {
        if ((!rbtarjetas.isChecked() && !rbpaypall.isChecked()) || editText.getText().toString().trim().equals("") || editText2.getText().toString().trim().equals("") || editText3.getText().toString().trim().equals("") || editText4.getText().toString().trim().equals("")) {
            return false;
        }
        return true;
    }
}
