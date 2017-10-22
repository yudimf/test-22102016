package yudimf.id.prelo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yudimf.id.prelo.R;
import yudimf.id.prelo.models.SuccessResponse;
import yudimf.id.prelo.models.User;
import yudimf.id.prelo.retrofit.APIService;
import yudimf.id.prelo.retrofit.ApiUtils;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    private String username;
    private String password;

    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAPIService = ApiUtils.getAPIService();
        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        Button loginBtn = (Button) findViewById(R.id.login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isUsernameValid() && isPasswordValid()){
                    login();
                }
            }
        });
    }

    private void login(){
        User user = new User(username,password);
        mAPIService.login(user).enqueue(new Callback<SuccessResponse>() {
            @Override
            public void onResponse(Call<SuccessResponse> call, Response<SuccessResponse> response) {
                if (response.isSuccessful()){
                    Log.d("Sukses",response.body().getData().getEmail());
                    startActivity(new Intent(getApplicationContext(),LovelistActivity.class));
                    finish();
                }
                else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(getApplicationContext(), jObjError.getString("_message"), Toast.LENGTH_LONG).show();
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<SuccessResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private boolean isUsernameValid(){
        username = usernameEditText.getText().toString().trim();
        if (username.length() == 0){
            usernameEditText.setError("Username can't empty");
            return false;
        }
        else if(username.length() < 4){
            usernameEditText.setError("Username minimum 4 character");
            return false;
        }
        else{
            return true;
        }
    }

    private boolean isPasswordValid(){
        password = passwordEditText.getText().toString();
        if (password.length() < 6){
            passwordEditText.setError("Password minimum 6 character");
            return false;
        }
        else{
            return true;
        }
    }
}
