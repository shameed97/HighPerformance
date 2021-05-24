package sha.personal.highperformance.retrofit;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RetrofitCallback<T> implements Callback<T>{
    private static final String TAG = RetrofitCallback.class.getSimpleName();

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        int statusCode = response.code();
        if (response.body() == null || !response.isSuccessful()) {
            String message = null;
            try {
                message = response.errorBody().string();
                Log.e(TAG, "onSuccess Retrofit failure callback response... " + message + " code ---> " + statusCode + " isSuccess ---> " + response.isSuccessful());
                if (statusCode == 404 || statusCode == 500 || message.isEmpty()) {
                    onFailureCallback(call, null, "Could not connect to server, please try again.", statusCode);
                    return;
                }

                JSONObject jsonObject = new JSONObject(message);
                //TODO HANDLE THE ERROR MESSAGE ACCORDING TO THE RESPONSE LIKE BELOW
                if (jsonObject.has("meta")) {
                    JSONObject meta = jsonObject.optJSONObject("meta");
                    assert meta != null;
                    int code = meta.optInt("code");
                    try {
                        JSONArray error = meta.optJSONArray("errorMessage");
                        assert error != null;
                        onFailureCallback(call, null, error.get(0).toString(), code);
                    } catch (Exception e) {
                        String errorMessage = meta.optString("errorMessage");
                        onFailureCallback(call, null, errorMessage, code);
                    }
                    return;
                } else {
                    if (jsonObject.has("error_description")) {
                        message = jsonObject.optString("error_description");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(message)) {
                message = "Could not connect to server, please try again.";
            }
            onFailureCallback(call, null, message, statusCode);
            return;
        }

        String responseString;
        try {
            ResponseBody body = (ResponseBody) response.body();
            responseString = body.string();
            Log.e(TAG, "onSuccess Retrofit callback response... " + responseString + " code ---> " + statusCode + " isSuccess ---> " + response.isSuccessful());
            onSuccessCallback(call, responseString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        String message = null;
        try {
            message = t.getMessage();
            if (TextUtils.isEmpty(message)) {
                message = "Could not connect to server, please try again.";
            }
            Log.e(TAG, "onFailure Retrofit callback message... " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        onFailureCallback(call, t, message, 0);
    }

    public void onSuccessCallback(Call<T> call, String content) {
    }

    public void onFailureCallback(Call<T> call, Throwable t, String message, int code) {
    }

}
