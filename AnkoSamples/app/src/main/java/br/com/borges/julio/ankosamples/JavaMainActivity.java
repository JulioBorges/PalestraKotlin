package br.com.borges.julio.ankosamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JavaMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final TextView txtHello = (TextView)findViewById(R.id.txtHello);
        txtHello.setText("Hello");

        Button btnTeste = (Button) findViewById(R.id.btnTeste);
        btnTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHello.setText("Clicou !");
            }
        });
    }
}
