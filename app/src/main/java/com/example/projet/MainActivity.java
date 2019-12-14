package com.example.projet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog.Builder;


import androidx.appcompat.app.AppCompatActivity;

import static java.sql.Types.VARCHAR;


public class MainActivity extends AppCompatActivity {
    private EditText dest,a,ret,al,n;
    private Button rech;
    SQLiteDatabase bd;
    Cursor c1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dest = (EditText) findViewById(R.id.edtRet);
        a = (EditText) findViewById(R.id.edtRet1);
        ret = (EditText) findViewById(R.id.edtRet);
        al = (EditText) findViewById(R.id.edtNom);
        n =(EditText) findViewById(R.id.edtNum);
        rech =(Button) findViewById(R.id.btnajouter);

        bd = openOrCreateDatabase("voyage", Context.MODE_PRIVATE,null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS voyage(num integer primary key autoincrement, dest VARCHAR,a VARCHAR , rest VARCHAR , al VARCHAR , n VARCHAR);");
        rech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ajouter();
            }
        });
    }

    public void ajouter(){
        if(a.getText().toString().trim().isEmpty()||
                dest.getText().toString().trim().isEmpty() ||
                   ret.getText().toString().trim().isEmpty() ||
                      al.getText().toString().trim().isEmpty() ||
                         n.getText().toString().trim().isEmpty() ) {
            AfficheMessage("Erreur", "Entrer toutes les valeurs");
            return;
        }

        bd.execSQL("INSERT INTO voyage(dest,a,rest,al,n) VALUES('" + dest.getText().toString() +
                "','" + a.getText().toString() +  "','" + ret.getText().toString() +  "','" + al.getText().toString() +   "','" + n.getText().toString() + "');");
        Intent intent = new Intent(getApplicationContext(),Recherche.class);
        startActivity(intent);
        AfficheMessage("Succès", "Information ajouter");
        videTexte();

    }
    public void AfficheMessage(String titre,String message) {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(titre);
        builder.setMessage(message);
        builder.show();
    }
    public void videTexte() {
        dest.setText("");
        a.setText("");
        ret.setText("");
        al.setText("");
        n.setText("");
    }


}