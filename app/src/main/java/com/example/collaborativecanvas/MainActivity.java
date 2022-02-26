package com.example.collaborativecanvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.core.Amplify;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AuthUser currentUser = Amplify.Auth.getCurrentUser();
        Intent intent;

        if ( currentUser == null ) {
            // Go to login
            intent = new Intent(getApplicationContext(), LoginActivity.class);
        } else {
            // Go to join room
            intent = new Intent(getApplicationContext(), JoinRoomActivity.class);
        }

        // setContentView(R.layout.activity_main);

        // start activity
        startActivity(intent);
        finish();
    }
}