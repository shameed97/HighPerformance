package sha.personal.highperformance;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import sha.personal.highperformance.databinding.ActivityMainBinding;
import sha.personal.highperformance.receiver.MyReceiver;
import sha.personal.highperformance.retrofit.ApiClient;
import sha.personal.highperformance.retrofit.ApiInterface;
import sha.personal.highperformance.retrofit.RetrofitCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding activityMainBinding;
    private MyReceiver myReceiver;
    private IntentFilter intentFilter;
    private ApiInterface apiInterface;
    private String Token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEiLCJ1c2VybmFtZSI6InJhamVzaCIsImlhdCI6MTYyMTg4MDcwNCwiZXhwIjoxNjIxODk4NzA0fQ._Ut-SvQh2_fTYcrn1bgPCxVwkmuFaA_8jG3wL3_dQJY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        myReceiver = new MyReceiver();
        intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(myReceiver, intentFilter);

        apiInterface = ApiClient.getClientInterface().create(ApiInterface.class);

//        getVersion();
        viewProfile(Token);

        activityMainBinding.buttonStatus.setOnClickListener(this);
    }

    private void getVersion() {
        JsonObject user_data = new JsonObject();
        user_data.addProperty("username", "rajesh");
        user_data.addProperty("password", "1");
        user_data.addProperty("app_platform", "android");
        user_data.addProperty("app_version", BuildConfig.VERSION_NAME);
        Objects.requireNonNull(apiInterface.getVersionCheck(user_data)).enqueue(new RetrofitCallback<ResponseBody>() {
            @Override
            public void onSuccessCallback(@Nullable Call<ResponseBody> call, @Nullable String content) {
                super.onSuccessCallback(call, content);
                try {
                    assert content != null;
                    JSONObject jsonObject = new JSONObject(content);
                    String status = jsonObject.getString("status");
                    JSONObject data = jsonObject.getJSONObject("data");
                    if (status.equals("true")) {
                        String token = jsonObject.getString("token");
                        String version = data.getString("version");
                        String force = data.getString("force");
                        String service = data.getString("service_status");

//                        activityMainBinding.setMyVariable(token);

                        viewProfile(token);


                    } else {
                        Log.e("TAG", "onSuccessCallback: " + status);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailureCallback(@Nullable Call<ResponseBody> call, @Nullable Throwable t, @Nullable String message, int code) {
                super.onFailureCallback(call, t, message, code);
                getVersion();
            }
        });
    }

    private void viewProfile(String token) {
        try {
            JsonObject userData = new JsonObject();
            userData.addProperty("mobile", "2019-3629-11113");
            userData.addProperty("app_platform", "android");
            userData.addProperty("app_version", BuildConfig.VERSION_NAME);
            apiInterface.viewProfile(token, userData).enqueue(new RetrofitCallback<ResponseBody>() {
                @Override
                public void onSuccessCallback(Call<ResponseBody> call, String content) {
                    super.onSuccessCallback(call, content);

                    ViewProfile viewProfile = new Gson().fromJson(content, ViewProfile.class);
                    activityMainBinding.setConsent(viewProfile.data.userDetails);


                }

                @Override
                public void onFailureCallback(Call<ResponseBody> call, Throwable t, String message, int code) {
                    super.onFailureCallback(call, t, message, code);

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        try {
            if (myReceiver != null)
                unregisterReceiver(myReceiver);
        } catch (Exception ignored) {
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.e("TAG", "onDestroy: ,");
        try {
            if (myReceiver != null)
                unregisterReceiver(myReceiver);
        } catch (Exception ignored) {
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonStatus) {
            startActivity(new Intent(this, ViewActivity.class));
//            Toast.makeText(this, "" + activityMainBinding.buttonStatus.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}