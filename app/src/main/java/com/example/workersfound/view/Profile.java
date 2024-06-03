package com.example.workersfound.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workersfound.MainActivity;
import com.example.workersfound.R;
import com.example.workersfound.adapter.ScheduleAdapter;
import com.example.workersfound.adapter.ServicoAdapter;
import com.example.workersfound.databinding.ActivityProfileBinding;
import com.example.workersfound.fakeDatabases.ScheduleBD;
import com.example.workersfound.fakeDatabases.UserBD;
import com.example.workersfound.model.Schedule;
import com.example.workersfound.model.User;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    private ActivityProfileBinding binding;

    private ScheduleAdapter scheduleAdapter;
    private ArrayList<Schedule> listaSchedules = new ArrayList<>();

    private User user = UserBD.getInstance().getUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        binding.userEmailTxt.setText(user.getEmail());
        binding.userNameTxt.setText(user.getNome());
        binding.userPhoneNumberTxt.setText(user.getPhoneNumber());

        RecyclerView recyclerViewServicos = binding.recyclerViewSchedules;
        recyclerViewServicos.setLayoutManager(new GridLayoutManager(this, 1));
        scheduleAdapter = new ScheduleAdapter(this, listaSchedules);
        recyclerViewServicos.setHasFixedSize(true);
        recyclerViewServicos.setAdapter(scheduleAdapter);
        getSchedules();

        binding.returnButton.setOnClickListener(view ->{
            finish();
        });

        binding.logoutButton.setOnClickListener(view -> {
            Intent intent = new Intent(Profile.this, MainActivity.class);
            startActivity(intent);
        });



    }

    private void getSchedules(){

        ScheduleBD bd = ScheduleBD.getInstance();
        listaSchedules.addAll(bd.getDataList());

    }
}