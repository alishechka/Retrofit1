package com.example.recyclerviewretrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewretrofit.model.GithubResponseModel;

import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.myViewHolder> {
    private List<GithubResponseModel> githubResponseModels;
    private OnItemClick onItemClick;

    public UserAdapter(List<GithubResponseModel> githubResponseModels, OnItemClick onItemClick) {
        this.githubResponseModels = githubResponseModels;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.activity_user_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        //should only get name
        GithubResponseModel githubResponseModel = githubResponseModels.get(position);

        holder.bind(githubResponseModel);

        String name = githubResponseModels.get(position).getName();
        String login = githubResponseModels.get(position).getOwner().getLogin();
        holder.userName.setText(name + " " + login);
    }

    @Override
    public int getItemCount() {
        return githubResponseModels.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView userName;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.tv_displayUser);

        }

        public void bind(GithubResponseModel githubResponseModel) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick.onClick(githubResponseModel);
                }
            });
        }
    }
}
