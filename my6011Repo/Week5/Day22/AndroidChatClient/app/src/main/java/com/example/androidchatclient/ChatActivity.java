package com.example.androidchatclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // get the room name from intent
        String roomName = getIntent().getStringExtra("roomNameInput");
        // change the text view
        TextView textView = findViewById(R.id.roomName);
        textView.setText(roomName);

//        Bundle extras = getIntent().getExtras();
//        if( extras != null ){
//            String roomName = extras.getString("roomNameInput");
//            textView.setText(roomName);
//        }

    }

    public void handleClick(View view){
        Log.i("Jj: ChatActivity", "button was pressed" );
        // switch to 1st activity
        Intent intent = new Intent( this, MainActivity.class );
        startActivity( intent );
    }
}