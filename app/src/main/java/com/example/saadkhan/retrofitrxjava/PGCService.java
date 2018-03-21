package com.example.saadkhan.retrofitrxjava;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Saad Khan on 20/03/2018.
 */

public interface PGCService {
    @FormUrlEncoded
    @POST("./")
    Observable<List<PGCModel>> getLogin(@Field("UserName") String UserName, @Field("UserPassword") String UserPassword, @Field("UserMacAddress") String UserMacAddress);
   // Call<PGCModel> getLogin(@Body PGC_TokenRequest tokenRequest);
    //Observable<PGCModel> getLogin(@Body PGC_TokenRequest tokenRequest);
}
