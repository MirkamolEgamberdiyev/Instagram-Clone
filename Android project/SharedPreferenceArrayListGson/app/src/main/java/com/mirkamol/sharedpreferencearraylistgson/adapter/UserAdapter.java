package com.mirkamol.sharedpreferencearraylistgson.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirkamol.sharedpreferencearraylistgson.R;
import com.mirkamol.sharedpreferencearraylistgson.model.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<User> items = new ArrayList<>();


    public UserAdapter(ArrayList<User> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
      if (holder instanceof UserViewHolder){
          ((UserViewHolder) holder).fullName.setText(items.get(position).getFullName());
          ((UserViewHolder) holder).email.setText(items.get(position).getEmail());
      }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder{

        TextView fullName;
        TextView email;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);


            fullName = itemView.findViewById(R.id.full_name);
            email = itemView.findViewById(R.id.tv_email);
        }
    }
}
