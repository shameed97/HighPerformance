package sha.personal.highperformance.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClientInterface() {
        if (retrofit == null) {
            OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .connectTimeout(180, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .cache(null)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(AppURL.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(defaultHttpClient)
                    .build();
        }

        return retrofit;
    }
}
