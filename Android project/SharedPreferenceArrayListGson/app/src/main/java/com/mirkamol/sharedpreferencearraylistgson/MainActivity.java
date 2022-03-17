package com.mirkamol.sharedpreferencearraylistgson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mirkamol.sharedpreferencearraylistgson.adapter.UserAdapter;
import com.mirkamol.sharedpreferencearraylistgson.model.User;

import java.lang.reflect.Type;
import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<User> myUser;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildRecyclerView();
        setInsertButton();
        loadData();
        Button buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 saveData();

            }
        });
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefernce", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(myUser);
        editor.putString("task usersList", json);
        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefernce", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task usersList", null);

        Type type = new TypeToken<ArrayList<User>>() {}.getType();
        myUser = gson.fromJson(json, type);

        if (myUser == null){
            myUser = new ArrayList<>();
        }
    }

    private void setInsertButton() {
        Button buttonInsert = findViewById(R.id.button_insert);
        EditText editText = findViewById(R.id.edittext_line1);
        EditText editText1 = findViewById(R.id.edittext_line2);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myUser.add(new User(editText.getText().toString(), editText1.getText().toString()));
                editText.setText(null);
                editText1.setText(null);

            }
        });
    }

    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        userAdapter = new UserAdapter(myUser);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);

    }
}