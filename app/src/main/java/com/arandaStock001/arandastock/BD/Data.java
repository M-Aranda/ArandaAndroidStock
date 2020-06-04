package com.arandaStock001.arandastock.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.arandaStock001.arandastock.BD.Producto;

import java.util.ArrayList;


public class Data extends SQLiteOpenHelper {


    private static String nombre_bd="BD_INVENTARIO";
    private static final int version_bd=1;
    private static final String TABLA_PRODUCTO = "CREATE TABLE PRODUCTO(_id INTEGER PRIMARY KEY AUTOINCREMENT ," +
            "_nombre TEXT," +
            "_precio INTEGER," +
            "_stock INTEGER);";


    public Data(@Nullable Context context) {
        super(context, nombre_bd, null
                , version_bd);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_PRODUCTO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("Upgrade");

    }

    public void insert (Producto p){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd != null){
            bd.execSQL("   INSERT INTO PRODUCTO VALUES (NULL, '"+p.getNombre()+"',  "+p.getPrecio()+", "+p.getStock()+"); ");
        }else{
            System.out.println("Error al insertar");
        }bd.close();
    }




    public ArrayList<Producto> getProductos(){

        ArrayList<Producto> listadoDeProductos = new ArrayList<>();
        Producto p = null;

        SQLiteDatabase bd = getReadableDatabase();

        Cursor leer = bd.rawQuery("SELECT * FROM PRODUCTO;",null);

        if(leer.moveToFirst()){
            p = new Producto(leer.getInt(0),leer.getString(1), leer.getInt(2 ),leer.getInt(3));
            listadoDeProductos.add(p);
        }
        bd.close();

        return listadoDeProductos;
    }


}
