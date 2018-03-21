package com.example.saadkhan.retrofitrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private EditText username,password;
    private static final String TAG = "Main Activity";
    private Button signin;
    private static final String PGC_LOGIN_URL = "http://cms.pgc.edu.pk/elearnloginhandler.ashx/";

    private static LoginUser instance;
    private PGCService pgcService;
    private Subscription subscription;
    PGC_TokenRequest tokenRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        signin = (Button) findViewById(R.id.signin);
        tokenRequest = new PGC_TokenRequest();
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tokenRequest.setUserName(username.getText().toString());
                tokenRequest.setUserPassword(password.getText().toString());
                tokenRequest.setUserMacAddress("12345");
                getStarredRepos(tokenRequest);
            }
        });

    }

    private void getStarredRepos(PGC_TokenRequest tokenRequest) {
//        Call<PGCModel> tokenResponseCall  = pgcService.getLogin(tokenRequest);
//        tokenResponseCall.enqueue(new Callback<PGCModel>() {
//            @Override
//            public void onResponse(Call<PGCModel> call, Response<PGCModel> response) {
//                int statusCode = response.code();
//
//                PGCModel pgcModel = response.body();
//                Log.d(TAG,"Login Response" + statusCode);
//            }
//
//            @Override
//            public void onFailure(Call<PGCModel> call, Throwable t) {
//                Log.d(TAG,"OnFailure" + t.getMessage());
//            }
//        });

        subscription = LoginUser.getInstance()
                .getStarredRepos(tokenRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PGCModel>>() {
                    @Override public void onCompleted() {
                        Log.d(TAG, "In onCompleted()");
                    }

                    @Override public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d(TAG, "In onError()");
                    }

                    @Override public void onNext(List<PGCModel> pgcModels) {
                        Log.d(TAG, "In onNext()");
                        //adapter.setGitHubRepos(gitHubRepos);
                    }
                });

    }
}
