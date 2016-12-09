package com.example.josep.a3a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button añadir, mostrar;
    TextView text2;
    EditText text;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        añadir= (Button)findViewById(R.id.añadir);
        mostrar= (Button)findViewById(R.id.mostrar);
        text = (EditText)findViewById(R.id.text);
        text2 = (TextView)findViewById(R.id.text2);


        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    String contenido = text.getText().toString();

                        fos = openFileOutput("texto.txt", MODE_APPEND);

                    OutputStreamWriter osw = new OutputStreamWriter(fos);
                    Toast.makeText(MainActivity.this, "guardado", Toast.LENGTH_SHORT).show();
                    osw.write("\n");
                    osw.write(contenido);
                    osw.flush();
                    osw.close();



                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        mostrar.setOnClickListener(new View.OnClickListener() {
         @Override
             public void onClick(View view) {
        try
        {
            BufferedReader fin = new BufferedReader(
                            new InputStreamReader(
                                    openFileInput("texto.txt")));

            String texto= fin.readLine();
            String todo="";
            while(texto!=null) {
                todo=todo+texto+"\n";
                texto=fin.readLine();


            }
            fin.close();
            text2.setText(todo);
        }
        catch (Exception ex)
        {

        }
    }
});


    }
}
