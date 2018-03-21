package com.example.saadkhan.retrofitrxjava;

import android.support.annotation.NonNull;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Saad Khan on 20/03/2018.
 */

public class LoginUser {
    private static final String PGC_LOGIN_URL = "http://cms.pgc.edu.pk/elearnloginhandler.ashx/";

    private static LoginUser instance;
    private PGCService pgcService;

    private LoginUser() {
        final Gson gson =
                new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(PGC_LOGIN_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        pgcService = retrofit.create(PGCService.class);
    }

    public static LoginUser getInstance() {
        if (instance == null) {
            instance = new LoginUser();
        }
        return instance;
    }

    public Observable<List<PGCModel>>getStarredRepos(@NonNull PGC_TokenRequest tokenRequest) {
        return pgcService.getLogin(tokenRequest.getUserName(),tokenRequest.getUserPassword(),tokenRequest.getUserMacAddress());
    }
}
