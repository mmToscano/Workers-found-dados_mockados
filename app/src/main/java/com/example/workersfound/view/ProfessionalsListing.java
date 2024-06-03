package com.example.workersfound.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workersfound.R;
import com.example.workersfound.adapter.ProfessionalAdapter;
import com.example.workersfound.adapter.ServicoAdapter;
import com.example.workersfound.databinding.ActivityProfessionalsListingBinding;
import com.example.workersfound.fakeDatabases.ProfessionalBD;
import com.example.workersfound.fakeDatabases.ServicoBD;
import com.example.workersfound.model.Professional;

import java.util.ArrayList;

public class ProfessionalsListing extends AppCompatActivity {

    private ActivityProfessionalsListingBinding binding;
    private ProfessionalAdapter professionalAdapter;
    private ArrayList<Professional> listaProfessionals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfessionalsListingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        //cria o recyclerView e habilita ele para receber elementos
        RecyclerView recyclerViewProfessionals = binding.recyclerViewProfessionals;
        recyclerViewProfessionals.setLayoutManager(new GridLayoutManager(this, 1));
        professionalAdapter = new ProfessionalAdapter(this, listaProfessionals);
        recyclerViewProfessionals.setHasFixedSize(true);
        recyclerViewProfessionals.setAdapter(professionalAdapter);
        getProfessionals();

        binding.returnButton.setOnClickListener(view ->{
            finish();
        });

        binding.userButton.setOnClickListener(view ->{
            Intent intent = new Intent(ProfessionalsListing.this, Profile.class);
            startActivity(intent);
        });

        SearchView searchView = binding.pesquisa;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                professionalAdapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                professionalAdapter.filter(newText);
                return true;
            }
        });
    }

    private void getProfessionals(){
        String type = getIntent().getExtras() != null ? getIntent().getExtras().getString("service_type") : null;

        ProfessionalBD bd = ProfessionalBD.getInstance();
        listaProfessionals.addAll(bd.getProfessionalsByType(type));
        professionalAdapter.filter("");
    }
}