package com.nazoweb.passwordgenerator;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.NoSuchElementException;

public class MainActivity extends AppCompatActivity {

    private EditText charNumber;
    private Button generateButton;
    private Button pButton;
    private int  number=0;
    private EditText generatedPassword;
    private String passwToSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        charNumber = (EditText) findViewById(R.id.charNumber);
        generatedPassword = (EditText) findViewById(R.id.generatedPassword);
        generateButton = (Button) findViewById(R.id.generateButton);

//        generate button in use get input from charNumber(EditText) and use Passw.java, charNumber()
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (charNumber.getText().length() > 1) {
                        number = Integer.parseInt(charNumber.getText().toString());
                        Passw pword = new Passw(number);
                        passwToSave = pword.randomChar();
                        generatedPassword.setText(passwToSave);
                        number=0;
                        charNumber.setText("");

                    } else {
                        Toast.makeText(MainActivity.this, "Please enter bigger  than 1", Toast.LENGTH_SHORT).show();
                    }
            }
        });


//          popUp window when use save button
        pButton =  (Button) findViewById(R.id.popUpButton);
        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Pop.class));
            }
        }

        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
