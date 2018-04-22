package com.example.vishal.vneedfood;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences ah = getSharedPreferences("userdata",Context.MODE_PRIVATE);
        if (ah.getBoolean("loggedin",false) )
        {

            Intent i = new Intent(this,CoverActivity.class);
            startActivity(i);

        }


        final TextView welcome = (TextView) findViewById(R.id.welcome);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final TextView tvRegisterLink = (TextView) findViewById(R.id.tvRegisterHere);
        final Button bLogin = (Button) findViewById(R.id.bLogin);

        tvRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                Intent intent = new Intent(MainActivity.this, LogoutActivity.class);
                MainActivity.this.startActivity(intent);

                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            Intent intent = new Intent(MainActivity.this, LogoutActivity.class);
                            if (success) {
                                /*String name = jsonResponse.getString("name");
                                int age = jsonResponse.getInt("age");
                                SharedPreferences ahs = getSharedPreferences("userdata", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = ahs.edit();
                                editor.putBoolean("loggedin",true);
                                editor.commit();*/
                              //  Intent intent = new Intent(MainActivity.this, LogoutActivity.class);
                               /* intent.putExtra("name", name);
                                intent.putExtra("age", age);
                                intent.putExtra("password", password);
                                intent.putExtra("username", username);*/
                                //MainActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Incorrect Username or Password")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}