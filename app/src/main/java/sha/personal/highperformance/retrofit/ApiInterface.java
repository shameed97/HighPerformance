package sha.personal.highperformance.retrofit;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST(AppURL.VERSION_CHECK)
    Call<ResponseBody> getVersionCheck(@Body JsonObject param);

    @POST(AppURL.USER_LOGIN)
    Call<ResponseBody> userLogin(@Header("Authorization") String token, @Body JsonObject jsonObject);

    @POST(AppURL.BOARD_CASES)
    Call<ResponseBody> getDashBoardCases(@Header("Authorization") String token, @Body JsonObject jsonObject);

    @GET(AppURL.BOARD_CASES + "{input}")
    Call<ResponseBody> getDashBoardCases(@Header("Authorization") String token, @Path("input") String param);

    @POST(AppURL.PATIENT_ENTRY)
    Call<ResponseBody> insertPatientDetails(@Header("Authorization") String token, @Body JsonObject jsonObject);

    @POST(AppURL.CONSENT_SHEET)
    Call<ResponseBody> sendContentSheet(@Header("Authorization") String token, @Body JsonObject jsonObject);

    @POST(AppURL.DEMOGRAPHIC_DATA)
    Call<ResponseBody> addDemographicData(@Header("Authorization") String token, @Body JsonObject jsonObject);

    @POST(AppURL.KAP_QUESTIONS)
    Call<ResponseBody> addKapQuestions(@Header("Authorization") String token, @Body JsonObject jsonObject);

    @POST(AppURL.SEEKING_BEHAVIOUR)
    Call<ResponseBody> seekingBehaviour(@Header("Authorization") String token, @Body JsonObject jsonObject);

    @GET(AppURL.VIEW_PATIENT)
    Call<ResponseBody> getPatientDetails(@Header("Authorization") String token);

    @POST(AppURL.PREVELANCE_ADVANCE)
    Call<ResponseBody> addAdvanceData(@Header("Authorization") String token, @Body JsonObject jsonObject);

    @POST(AppURL.CLINICAL_EXAMINATION)
    Call<ResponseBody> addClinicalExaminations(@Header("Authorization") String token, @Body JsonObject jsonObject);

    @POST(AppURL.VIEW_PROFILE)
    Call<ResponseBody> viewProfile(@Header("Authorization") String token, @Body JsonObject jsonObject);

    @POST(AppURL.UPDATE_PROFILE)
    Call<ResponseBody> updateProfile(@Header("Authorization") String token, @Body JsonObject jsonObject);

    @POST(AppURL.FORGET_PASSWORD)
    Call<ResponseBody> forgetPassword(@Header("Authorization") String token, @Body JsonObject jsonObject);
}
