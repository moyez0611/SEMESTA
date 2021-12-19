package com.example.semesta;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.semesta.apihelper.ResObj;
import com.example.semesta.apihelper.RetrofitClient;
import com.example.semesta.apihelper.UserService;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    EditText txtMail;
    EditText txtPassword;
    Button btnLogin;
    ProgressDialog loading;
    Context mContext;
    UserService userService;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();
        mContext = this;
        initComponents();
        sharedPrefManager = new SharedPrefManager(this);
        String Token = sharedPrefManager.getSPStrings("spToken", "DEFAULT");
        if (Token != "" && Token != null && Token != "DEFAULT"){
            startActivity(new Intent(LoginActivity.this,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
    }

    @Override
    public boolean setOnItemSelectedListener(MenuItem item) {
        return false;
    }

    private void initComponents() {
            txtMail = findViewById(R.id.txt_email);
            txtPassword = findViewById(R.id.txt_password);
            btnLogin = findViewById(R.id.btn_login);
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String username = txtMail.getText().toString();
                    String password = txtPassword.getText().toString();
                    //validate form
                    if(validateLogin(username, password)){
                        //do login
                        doLogin(username, password);
                    }
                }
            });
    }

    private void doLogin(String username, String password) {
        String url_api = getString(R.string.api_server);
        userService = RetrofitClient.getClient(url_api+"user/").create(UserService.class);
        Call<ResObj> call = userService.login(username,password);
        call.enqueue(new Callback<ResObj>() {
            @Override
            public void onResponse(Call<ResObj> call, Response<ResObj> response) {
                if(response.isSuccessful()){
                    if(response.body() != null){
                        Toast.makeText(LoginActivity.this, "Success menghubungi server", Toast.LENGTH_SHORT).show();
                        if(response.body().getStatus().equals("success")){
                            //login start main activity
                            Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            sharedPrefManager.saveSPString(SharedPrefManager.SP_TOKEN, response.body().getToken());
                            sharedPrefManager.saveSPString(SharedPrefManager.SP_UNAME, response.body().getData().getUname());
                            sharedPrefManager.saveSPString(SharedPrefManager.SP_GID, response.body().getData().getGid());
                            sharedPrefManager.saveSPString(SharedPrefManager.SP_UID, response.body().getData().getUid().toString());
                            sharedPrefManager.saveSPString(SharedPrefManager.SP_EID, response.body().getData().getEid());
                            sharedPrefManager.saveSPString(SharedPrefManager.SP_AVATAR, response.body().getData().getAvatar());
                            startActivity(intent);

                        } else {
                            Toast.makeText(LoginActivity.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateLogin(String username, String password) {
        if(username == null || username.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}