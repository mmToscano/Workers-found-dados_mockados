package com.example.workersfound.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workersfound.databinding.ServicoItemBinding;
import com.example.workersfound.model.Service;
import com.example.workersfound.view.ProfessionalsListing;

import java.util.ArrayList;

public class ServicoAdapter extends RecyclerView.Adapter<ServicoAdapter.ServicoViewHolder> {

    private final Context context;
    //O home irá renderizar sempre a listaFiltradaServicos. Sempre. O listaServicos serve apenas para guardar mesmo todas as
    //informações dos servicos. Ele serve apenas como banco de dados.
    private final ArrayList<Service> listaServices;
    private final ArrayList<Service> listaFiltradaServices;

    public ServicoAdapter(Context context, ArrayList<Service> listaServices) {
        this.context = context;
        this.listaServices = listaServices;
        this.listaFiltradaServices = new ArrayList<>(listaServices);
    }

    @NonNull
    @Override
    public ServicoAdapter.ServicoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ServicoItemBinding listItem = ServicoItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ServicoViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicoAdapter.ServicoViewHolder holder, int position) {
        Service currentService = listaFiltradaServices.get(position);
        holder.binding.imageIcon.setImageResource(currentService.getImg());
        holder.binding.serviceTypeTxt.setText(currentService.getName());
        holder.binding.cardView.setCardBackgroundColor(currentService.getColor());
        holder.binding.professionalsQuantityTxt.setText(String.valueOf(currentService.getProfessionals().size()) + " profissionais em Uberlândia - MG");
    }

    @Override
    public int getItemCount() {
        return listaFiltradaServices.size();
    }

    public void filter(String searchText) {
        listaFiltradaServices.clear();
        if (searchText.isEmpty()) {
            listaFiltradaServices.addAll(listaServices);
        } else {
            searchText = searchText.toLowerCase();
            for (Service service : listaServices) {
                if (service.getName().toLowerCase().contains(searchText)) {
                    listaFiltradaServices.add(service);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ServicoViewHolder extends RecyclerView.ViewHolder {
        ServicoItemBinding binding;

        public ServicoViewHolder(ServicoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(view -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(binding.getRoot().getContext(), ProfessionalsListing.class);
                    intent.putExtra("service_type", listaFiltradaServices.get(position).getName());
                    binding.getRoot().getContext().startActivity(intent);
                }
            });
        }
    }
}
