package com.arandaStock001.arandastock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arandaStock001.arandastock.BD.Data;
import com.arandaStock001.arandastock.BD.Producto;

public class Registro extends AppCompatActivity {


    private Button btnRegistrar, btnVolver;
    private EditText txtNombre, nmbPrecio, nmbStock ;
    private Data d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        init();
        d = new Data(getApplicationContext());


    }

    private void init() {
        btnRegistrar = findViewById(R.id.btnRegistrarMain);
        btnVolver = findViewById(R.id.btnVolver);

        txtNombre = findViewById(R.id.txtNombre);
        nmbPrecio = findViewById(R.id.nmbPrecio);
        nmbStock = findViewById(R.id.nmbStock);




        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver();
            }
        });


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarProducto();
            }
        });
    }










    // métodos para los botones
    private void registrarProducto (){

        String nombre = txtNombre.getText().toString();
        int precio = Integer.parseInt(nmbPrecio.getText().toString());
        int stock = Integer.parseInt(nmbStock.getText().toString());

        if(nombre.matches("")){
            Toast.makeText(this, "Debe nombrar al producto", Toast.LENGTH_LONG).show();
        }else{

                Producto p = new Producto(0, nombre, precio, stock);
                d.insert(p);
                Toast.makeText(this, "Producto registrado con éxito!", Toast.LENGTH_LONG).show();

                txtNombre.setText("");
                nmbPrecio.setText("0");
                nmbStock.setText("0");

                System.out.println("Producto registrado");
        }




    }

    private void volver(){
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }







}
