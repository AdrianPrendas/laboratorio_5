package com.example.kevca.sistemaderecomendacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevca.sistemaderecomendacion.bl.CarritoBL;
import com.example.kevca.sistemaderecomendacion.bl.UsuarioBL;
import com.example.kevca.sistemaderecomendacion.domain.Carrito;

public class PagoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);

        float total = CarritoBL.Companion.getInstance().read(
                UsuarioBL.Companion.getSession()
        ).getPrecioTotal();
        TextView t = (TextView) findViewById(R.id.total);
        t.setText(String.format("$%.2f",total));

        Button clickButton = (Button) findViewById(R.id.btn_pago);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });
    }
}
