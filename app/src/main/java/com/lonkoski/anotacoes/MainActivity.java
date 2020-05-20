package com.lonkoski.anotacoes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.gravar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText anotacao = findViewById(R.id.anotacao);
                SharedPreferences sharedPreferences = getSharedPreferences("ANOTACOES", MODE_PRIVATE);
                SharedPreferences.Editor editorText = sharedPreferences.edit();
                editorText.putString("ANOTACAO", anotacao.getText().toString());
                editorText.apply();
                Snackbar.make(view, "Anotação salva!", Snackbar.LENGTH_LONG).setAction("OK!", null).show();
            }
        });
        EditText texto = findViewById(R.id.anotacao);
        SharedPreferences sharedPreferences = getSharedPreferences("ANOTACOES", MODE_PRIVATE);
        if (sharedPreferences.contains("ANOTACAO")) {
            String anotacao = sharedPreferences.getString("ANOTACAO", "");
            texto.setText(anotacao);
        }
    }


}












