package com.example.recyclerviewretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.recyclerviewretrofit.model.GithubResponseModel;
import com.example.recyclerviewretrofit.network.GithubClient;
import com.example.recyclerviewretrofit.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.recyclerviewretrofit.MainActivity.KEY_USER_NAME;

public class RecyclerViewActivity extends AppCompatActivity implements OnItemClick{
    public static final String KEY_OBJ = "object";
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private static final String TAG = "RecyclerViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.rv_displayUser);

        String userName = getIntent().getStringExtra(KEY_USER_NAME);

        GithubClient client = RetrofitClient.getClient();
        Call<List<GithubResponseModel>> call = client.getRepositories(userName);
        call.enqueue(new Callback<List<GithubResponseModel>>() {
            @Override
            public void onResponse(Call<List<GithubResponseModel>> call, Response<List<GithubResponseModel>> response) {
                List<GithubResponseModel> list = response.body();
                userAdapter = new UserAdapter(list,RecyclerViewActivity.this);

                recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this));
                recyclerView.setAdapter(userAdapter);
                Log.i(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<List<GithubResponseModel>> call, Throwable t) {
                Log.i(TAG, "onFailure: ");
            }
        });
    }


    @Override
    public void onClick(GithubResponseModel githubResponseModel) {
        Intent intent=new Intent(this, DetailedView.class);
        intent.putExtra(KEY_OBJ, githubResponseModel);
        startActivity(intent);
    }
}
