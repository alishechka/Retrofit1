package com.example.recyclerviewretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import com.example.recyclerviewretrofit.model.GithubResponseModel;

import static com.example.recyclerviewretrofit.RecyclerViewActivity.KEY_OBJ;

public class DetailedView extends AppCompatActivity {
    private TextView detailedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);

        detailedView = findViewById(R.id.tv_detailedView);
        GithubResponseModel githubResponseModel = getIntent().getParcelableExtra(KEY_OBJ);
        assert githubResponseModel != null;
        String nameStr = githubResponseModel.getName();

        String i = githubResponseModel.getOwner().getAvatarUrl();
        detailedView.setText(nameStr);

    }
}
