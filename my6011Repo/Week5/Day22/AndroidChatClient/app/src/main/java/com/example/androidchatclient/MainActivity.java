package com.example.androidchatclient;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

//    private boolean switchActivities_ = false;
//    private WebSocket ws_ = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ws_ = new WebSocket();
//        ws_.connectAsynchornously();

    }
    public void handleClick(View view){
        Log.i("Jj: MainActivity", "button was pressed" );
        EditText etUser = findViewById(R.id.userNameInput);
        EditText etRoom = findViewById(R.id.roomNameInput);

        // if not valid user/ room name
        if( etUser.getText().toString().equals("") || etRoom.getText().toString().equals("") ){
            Toast.makeText(this, "Please input User/Room name", Toast.LENGTH_LONG).show();
        }else{
            // switch to 2nd activity
            Intent intent = new Intent( this, ChatActivity.class );
            intent.putExtra("roomNameInput", etRoom.getText().toString() );
            startActivity( intent );
        }



    }
}