package br.com.borges.julio.ankosamples;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    private void toast(){

        Toast.makeText(this, "Mensagem curta", Toast.LENGTH_SHORT);
        Toast.makeText(this, "Mensagem longa", Toast.LENGTH_LONG);
    }

    private void alertDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(JavaMainActivity.this, "Ok", Toast.LENGTH_SHORT);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(JavaMainActivity.this, "Ok", Toast.LENGTH_SHORT);
                dialog.dismiss();
            }
        });

        builder.setCancelable(false);
        builder.setTitle("Dialog de alerta");
        builder.setMessage("Clique em OK para confirmar, Cancelar para cancelar.");

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
