package com.example.collaborativecanvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.result.AuthSignInResult;
import com.amplifyframework.core.Amplify;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onPressLogin(View view) {
        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtPassword = findViewById(R.id.txtPassword);

        Amplify.Auth.signIn(
                txtEmail.getText().toString(),
                txtPassword.getText().toString(),
                this::onSuccess,
                this::onError
        );
    }

    private void onError(AuthException e) {
        this.runOnUiThread(() ->
                Toast.makeText(getApplicationContext(),  e.getMessage(), Toast.LENGTH_LONG).show()
        );
    }

    private void onSuccess(AuthSignInResult authSignInResult) {
        // redirect to chat screen
        Intent intent = new Intent(this, JoinRoomActivity.class);
        startActivity(intent);
    }

    public void onJoinPressed(View view) {
        // redirect to chat screen
        Intent intent = new Intent(this, JoinActivity.class);
        startActivity(intent);
    }
}