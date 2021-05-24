package sha.personal.highperformance;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import sha.personal.highperformance.databinding.ActivityMainBinding;
import sha.personal.highperformance.retrofit.ApiClient;
import sha.personal.highperformance.retrofit.ApiInterface;
import sha.personal.highperformance.retrofit.RetrofitCallback;

public class ViewActivity extends AppCompatActivity {

    private ViewPatientAdapter patientAdapter;
    private final ArrayList<Patient.UserDetail> patientDetails = new ArrayList<>();
    private ApiInterface apiInterface;
    ActivityMainBinding activityMainBinding;
    private String Token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEiLCJ1c2VybmFtZSI6InJhamVzaCIsImlhdCI6MTYyMTg4MDcwNCwiZXhwIjoxNjIxODk4NzA0fQ._Ut-SvQh2_fTYcrn1bgPCxVwkmuFaA_8jG3wL3_dQJY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        RecyclerView recyclerView = findViewById(R.id.recycler);

        apiInterface = ApiClient.getClientInterface().create(ApiInterface.class);

        patientAdapter = new ViewPatientAdapter(getApplicationContext(), patientDetails);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(patientAdapter);

        getPatientDetails();


    }

    //Method for getting patient details
    private void getPatientDetails() {
        apiInterface.getPatientDetails(Token).enqueue(new RetrofitCallback<ResponseBody>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSuccessCallback(@Nullable Call<ResponseBody> call, @Nullable String content) {
                super.onSuccessCallback(call, content);
                try {
                    assert content != null;
                    JSONObject jsonObject = new JSONObject(content);
                    String status = jsonObject.getString("status");
                    if (status.equals("true")) {
                        Patient search = new Gson().fromJson(content, Patient.class);
                        patientDetails.addAll(search.getData().getUserDetails());
                        patientAdapter.updateList(patientDetails);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailureCallback(@Nullable Call<ResponseBody> call, @Nullable Throwable t, @Nullable String message, int code) {
                super.onFailureCallback(call, t, message, code);

            }
        });
    }
}