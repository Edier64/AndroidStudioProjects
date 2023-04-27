package com.example.crudparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;
import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import com.example.crudparcial.Conex.conex;
public class MainActivity extends AppCompatActivity {
    //Declaramos nuestra variable de conexion
    private static conex con=new conex();
    Variables va=Variables.getInstance();

    Button btniniciar;
    EditText txtusuario,txtclave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btniniciar=findViewById(R.id.login);
        txtusuario=findViewById(R.id.txtusuario);
        txtclave=findViewById(R.id.txtclave);

        btniniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Incio_Sesion(txtusuario.getText().toString(),txtclave.getText().toString());
            }
        });
    }

    public  void Incio_Sesion(String usuario, String clave){
        try{
            String storeProcedureCall="{CALL usuarios(?,?,?,?)}";
            CallableStatement cStmt=con.conexionBD().prepareCall(storeProcedureCall);
            //Estos dos primeros parametros son los de entrada
            cStmt.setString(1,usuario);
            cStmt.setString(2,clave);

            // y estos  6 ultimos son los de salida aqui solo le indicamos que tipo de parametro se
            cStmt.registerOutParameter(3, Types.INTEGER);
            cStmt.registerOutParameter(4, Types.VARCHAR);
            cStmt.registerOutParameter(5, Types.VARCHAR);


            cStmt.executeUpdate();

            Integer codigo=cStmt.getInt(3);
            String telefono=cStmt.getString(4);
            String nombre=cStmt.getString(5);
String _msj = "acceso incorrecto";

            if(usuario.equals(txtusuario) && clave.equals(txtclave)){
                va.set_codigousuario(codigo);
                va.set_nombre(nombre);
                va.set_telefono(telefono);

//Luego Abrimos el activity menu
                Intent menu=new Intent(this,MainActivity.class);
                startActivity(menu);

            }else{
                Toast.makeText(getApplicationContext(),_msj,Toast.LENGTH_SHORT).show();
            }

        }catch (Exception er){
            Toast.makeText(getApplicationContext(),er.toString(),Toast.LENGTH_SHORT).show();
        }

    }
}
