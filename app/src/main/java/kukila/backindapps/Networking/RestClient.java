package kukila.backindapps.Networking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import kukila.backindapps.Constant;
import kukila.backindapps.OnboardingActivity;
import kukila.backindapps.R;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mindha on 15/10/2017.
 */

public class RestClient {
    public static ApiService service;
    public static RestClient restClient;

    public RestClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        service = retrofit.create(ApiService.class);
    }

    public static ApiService getService() {
        if (restClient == null){
            restClient = new RestClient();
        }
        return service;
    }

    public static class SplashActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_splash);

            Thread myThread = new Thread(){
                @Override
                public void run() {
                    try{
                        sleep(2000);
                        Intent intent = new Intent(getApplicationContext(),OnboardingActivity.class);
                        startActivity(intent);
                        finish();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            myThread.start();
        }
    }
}
