package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Recherche extends AppCompatActivity {
    Button res ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);

        res = (Button) findViewById(R.id.btnRes);

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Recherche.this);
                builder.setCancelable(true);
                builder.setTitle("Reserver");
                builder.setMessage("Felicitation vous êtes reserver");
                builder.show();
            }
        });
    }
}
