package kukila.backindapps.Networking;

import kukila.backindapps.Model.BaseResponse;
import kukila.backindapps.Model.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Mindha on 15/10/2017.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("/oauth/token")
    Call<LoginResponse> login(@Field("grant_type") String grantType,
                              @Field("client_id") int clientId,
                              @Field("client_secret") String clientSecret,
                              @Field("username") String username,
                              @Field("password") String password,
                              @Field("scope") String scope);

    @Headers({"Content-Type: application/json"})
//    @GET("/api/back")
//    Call<BackindResponse> getAllBackind(@Header("Authorization") String auth);


    @FormUrlEncoded
    @POST("/api/register")
    Call<BaseResponse> register(@Field("name") String name,
                                @Field("email") String email,
                                @Field("password") String password);
}
