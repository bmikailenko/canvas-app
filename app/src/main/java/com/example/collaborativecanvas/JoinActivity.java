package com.example.collaborativecanvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.auth.result.AuthSignUpResult;
import com.amplifyframework.core.Amplify;

import java.util.Random;

public class JoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
    }

    public void onPressJoinPressed(View view) {
        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtPassword = findViewById(R.id.txtPassword);

        Amplify.Auth.signUp(
                txtEmail.getText().toString(),
                txtPassword.getText().toString(),
                AuthSignUpOptions.builder().userAttribute(
                        AuthUserAttributeKey.email(), txtEmail.getText().toString()
                ).build(),
                this::onSuccess,
                this::onError
        );
    }

    private void onError(AuthException e) {
        this.runOnUiThread(() ->
                Toast.makeText(getApplicationContext(),  e.getMessage(), Toast.LENGTH_LONG).show()
        );
    }

    private void onSuccess(AuthSignUpResult authSignUpResult) {
        // redirect to email confirmation screen
        Intent intent = new Intent(this, EmailConfirmationActivity.class);

        EditText txtEmail = findViewById(R.id.txtEmail);
        intent.putExtra("email", txtEmail.getText().toString());
        EditText txtPassword = findViewById(R.id.txtPassword);
        intent.putExtra("password", txtPassword.getText().toString());
        EditText txtName = findViewById(R.id.txtName);
        intent.putExtra("name", txtName.getText().toString());
        String room = randomString(5);
        intent.putExtra("room", room);

        startActivity(intent);
    }

    public String randomString(Integer size) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = size;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}