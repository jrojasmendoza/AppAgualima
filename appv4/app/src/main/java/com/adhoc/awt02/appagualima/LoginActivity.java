package com.adhoc.awt02.appagualima;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.adhoc.awt02.appagualima.DB_HELPER.SqliteHelper;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final EditText usuario = (EditText) findViewById(R.id.txtUsuario);
        final EditText clave = (EditText) findViewById(R.id.txtClave);
        Button btnIngresar =  findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (usuario.getText().toString().length()<1){
                    Toast.makeText(getApplicationContext(), "Ingrese el Usuario", Toast.LENGTH_LONG).show();
                    return ;
                }
                if (clave.getText().toString().length()<1){
                    Toast.makeText(getApplicationContext(), "Ingrese la clave", Toast.LENGTH_LONG).show();
                }else {
                    logeo(usuario,clave);

                }

            }
        });

    }

    public  void logeo(EditText log, EditText pas){
        final SqliteHelper cnn = new SqliteHelper(this, "BD",  null,1);

        try {
            Cursor cursor =cnn.Logeo(
                    log.getText().toString(),pas.getText().toString());

            if(cursor.getCount() > 0){

                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Bien", Toast.LENGTH_LONG).show();

                log.setText("");
                pas.setText("");
                log.findFocus();

            }else {
                Toast.makeText(getApplicationContext(), "Usuario y/o clave incorrecto",
                        Toast.LENGTH_LONG).show();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
