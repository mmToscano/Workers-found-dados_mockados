package com.example.workersfound.fakeDatabases;

import android.graphics.Color;

import com.example.workersfound.R;
import com.example.workersfound.model.Professional;
import com.example.workersfound.model.Service;

import java.util.ArrayList;
import java.util.Objects;

public class ServicoBD {

    private ArrayList<Service> dataList;
    private static ServicoBD instance;


    private ServicoBD() {
        dataList = new ArrayList<>();
        ProfessionalBD professionalBD = ProfessionalBD.getInstance();

        Service service1 = new Service(0,R.drawable.beard_ic, "BARBEIRO", Color.parseColor("#2F528F"));
        Service service2 = new Service(1,R.drawable.hairmaker_ic, "CABELEIREIRO", Color.parseColor("#FF09DC"));
        Service service3 = new Service(2,R.drawable.dressmaker_ic, "COSTUREIRO", Color.parseColor("#FFD966"));
        Service service4 = new Service(3,R.drawable.makeup_ic, "MANICURE", Color.parseColor("#00D0B2"));

        service1.getProfessionals().add(professionalBD.getProfessionalById(1));
        service2.getProfessionals().add(professionalBD.getProfessionalById(2));
        service3.getProfessionals().add(professionalBD.getProfessionalById(3));
        service4.getProfessionals().add(professionalBD.getProfessionalById(4));
        service1.getProfessionals().add(professionalBD.getProfessionalById(5));
        service2.getProfessionals().add(professionalBD.getProfessionalById(6));
        service3.getProfessionals().add(professionalBD.getProfessionalById(7));
        service4.getProfessionals().add(professionalBD.getProfessionalById(8));

        dataList.add(service1);
        dataList.add(service2);
        dataList.add(service3);
        dataList.add(service4);

    }

    public static synchronized ServicoBD getInstance() {
        if (instance == null) {
            instance = new ServicoBD();
        }
        return instance;
    }

    public ArrayList<Service> getDataList() {
        return dataList;
    }

    public ArrayList<Professional> getProfessionals(){
        ArrayList<Professional> professionals = new ArrayList<>();

        for(Service item: dataList){
            professionals.addAll(item.getProfessionals());
        }

        return professionals;
    }

    public ArrayList<Professional> getProfessionalsByType(String type){
        ArrayList<Professional> professionals = new ArrayList<>();

        for(Service item: dataList){
            if(Objects.equals(item.getName(), type)){
                professionals.addAll(item.getProfessionals());
            }

        }

        return professionals;
    }

    public void addData(Service data) {
        dataList.add(data);
    }

    public void removeData(Service data) {
        dataList.remove(data);
    }

}
