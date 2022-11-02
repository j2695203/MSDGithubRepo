package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean firstClick_ = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleClick( View view ){
        Log.i("Jj: MainActivity", "button was pressed" );

        if ( firstClick_ ){
            TextView textView = findViewById( R.id.roomNameTxt );
            textView.setText("Enter a Room Name");
            firstClick_ = false;
        }else{
            // switch to 2nd activity
            Intent intent = new Intent( this, ChatActivity1.class );
            startActivity( intent );


        }

    }
}