package com.example.workersfound.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.workersfound.R;
import com.example.workersfound.databinding.ActivityMakeAppointmentBinding;
import com.example.workersfound.fakeDatabases.ScheduleBD;
import com.example.workersfound.fakeDatabases.UserBD;
import com.example.workersfound.model.Professional;
import com.example.workersfound.model.Schedule;

public class MakeAppointment extends AppCompatActivity {

    private ActivityMakeAppointmentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMakeAppointmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Professional professional = getIntent().getExtras() != null ? (Professional) getIntent().getSerializableExtra("which_professional") : null;

        binding.buttonAgendar.setOnClickListener(view -> {
            ScheduleBD bd = ScheduleBD.getInstance();

            int year = binding.datePicker.getYear();
            int month = binding.datePicker.getMonth();
            int day = binding.datePicker.getDayOfMonth();

            int hour = binding.timePicker.getHour();
            int minutes = binding.timePicker.getMinute();

            bd.addData(new Schedule(0, professional, UserBD.getInstance().getUser(), day, month, year, hour, minutes));
            finish();
        });

        binding.returnButton.setOnClickListener(view ->{
            finish();
        });

    }
}