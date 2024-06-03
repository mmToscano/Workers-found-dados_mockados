package com.example.workersfound.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.workersfound.R;
import com.example.workersfound.databinding.ActivityRegisterBinding;
import com.example.workersfound.fakeDatabases.UserBD;
import com.example.workersfound.model.Address;
import com.example.workersfound.model.User;

public class Register extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    private UserBD bd = UserBD.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.registerButton.setOnClickListener(view ->{
            String email = binding.emailTxt.getText().toString();
            String senha = binding.passwordTxt.getText().toString();
            String nome = binding.nameTxt.getText().toString();
            String estado = binding.districtTxt.getText().toString();
            String cidade = binding.cityTxt.getText().toString();
            String bairro = binding.bairroTxt.getText().toString();
            String rua = binding.streetTxt.getText().toString();
            String numeroRua = binding.streetTxt.getText().toString();
            String numeroTelefone = binding.phoneNumberTxt.getText().toString();

            Address address = new Address(1, cidade, bairro, estado, rua, numeroRua);

            User newUser = new User(0, email, senha, nome, address, numeroTelefone);
            bd.replaceUser(newUser);
            finish();
        });

    }
}