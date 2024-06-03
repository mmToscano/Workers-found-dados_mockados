package com.example.workersfound.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workersfound.databinding.ScheduleItemBinding;
import com.example.workersfound.model.Schedule;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>{

    private final Context context;
    private final ArrayList<Schedule> listaSchedules;


    public ScheduleAdapter(Context context, ArrayList<Schedule> listaSchedules) {
        this.context = context;
        this.listaSchedules = listaSchedules;
    }

    @NonNull
    @Override
    public ScheduleAdapter.ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ScheduleItemBinding listItem;
        listItem = ScheduleItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ScheduleAdapter.ScheduleViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapter.ScheduleViewHolder holder, int position) {
        Schedule schedule = listaSchedules.get(position);
        String dateTime = schedule.getDay() + "/" + schedule.getMonth() + "/" + schedule.getYear() + " - " + schedule.getProfessional().getName() + "(" + schedule.getProfessional().getTypeOfService() + ")";

        holder.binding.scheduleInfoTxt.setText(dateTime);
        //holder.binding.cardView.setCardBackgroundColor(alguma coisa que eu tenho que fazer depois);

    }

    @Override
    public int getItemCount() {
        return listaSchedules.size();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder{

        ScheduleItemBinding binding;

        public ScheduleViewHolder(ScheduleItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
