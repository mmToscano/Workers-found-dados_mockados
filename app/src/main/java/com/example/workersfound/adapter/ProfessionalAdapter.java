package com.example.workersfound.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workersfound.databinding.ProfessionalItemBinding;
import com.example.workersfound.model.Address;
import com.example.workersfound.model.Professional;
import com.example.workersfound.model.ProfessionalService;
import com.example.workersfound.model.Professional;
import com.example.workersfound.view.MakeAppointment;
import com.example.workersfound.view.ProfessionalsListing;

import java.util.ArrayList;

public class ProfessionalAdapter extends RecyclerView.Adapter<ProfessionalAdapter.ProfessionalViewHolder> {

    private final Context context;
    private final ArrayList<Professional> listaProfessionals;
    private final ArrayList<Professional> listaFiltradaProfessionals;


    public ProfessionalAdapter(Context context, ArrayList<Professional> listaProfessionals) {
        this.context = context;
        this.listaProfessionals = listaProfessionals;
        this.listaFiltradaProfessionals = new ArrayList<>(listaProfessionals);
    }

    @NonNull
    @Override
    public ProfessionalAdapter.ProfessionalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProfessionalItemBinding listItem;
        listItem = ProfessionalItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ProfessionalViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessionalAdapter.ProfessionalViewHolder holder, int position) {

        String Professionals = "";
        for(ProfessionalService item: listaFiltradaProfessionals.get(position).getServicos()){
            Professionals += item.getType() + " - R$ " + item.getPrice() + "\n";
        }
        Address address = listaFiltradaProfessionals.get(position).getAddres();

        holder.binding.userIcon.setImageResource(listaFiltradaProfessionals.get(position).getImg());
        holder.binding.userNameTxt.setText(listaFiltradaProfessionals.get(position).getName());
        holder.binding.userAddressTxt.setText(address.getDistrict() + " - " + address.getStreetName() + ", " + address.getHouseNumber());
        holder.binding.userCompanyNameTxt.setText(listaFiltradaProfessionals.get(position).getCompanyName());
        holder.binding.serviceListTxt.setText(Professionals);
    }

    @Override
    public int getItemCount() {
        return listaFiltradaProfessionals.size();
    }

    public void filter(String searchText) {
        listaFiltradaProfessionals.clear();
        if (searchText.isEmpty()) {
            listaFiltradaProfessionals.addAll(listaProfessionals);
        } else {
            searchText = searchText.toLowerCase();
            for (Professional professional : listaProfessionals) {
                if (professional.getName().toLowerCase().contains(searchText)) {
                    listaFiltradaProfessionals.add(professional);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ProfessionalViewHolder extends RecyclerView.ViewHolder{

        ProfessionalItemBinding binding;

        public ProfessionalViewHolder(ProfessionalItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(view ->{

                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    Intent intent = new Intent(context, MakeAppointment.class);
                    intent.putExtra("which_professional", listaFiltradaProfessionals.get(position));
                    context.startActivity(intent);
                }
            });
        }
    }
}
