package com.example.workersfound;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.workersfound.databinding.ActivityMainBinding;
import com.example.workersfound.fakeDatabases.ProfessionalBD;
import com.example.workersfound.fakeDatabases.ScheduleBD;
import com.example.workersfound.fakeDatabases.ServicoBD;
import com.example.workersfound.fakeDatabases.UserBD;
import com.example.workersfound.model.User;
import com.example.workersfound.view.Home;
import com.example.workersfound.view.Register;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    public UserBD bd = UserBD.getInstance();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); //NÃO PODE ESQUECER. A PARTIR DO MOMENTO QUE DECLARAR UM BINDING, TEM QUE FAZER ISSO AQUI

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        binding.txtEmail.setText("");
        binding.txtPassword.setText("");

        binding.buttonLogin.setOnClickListener(view -> {
            String email = binding.txtEmail.getText().toString();
            String senha = binding.txtPassword.getText().toString();

            if(email.isEmpty()){
                mensagem(view, "Coloque seu nome");
            }

            if(senha.isEmpty()){
                mensagem(view, "Coloque sua senha");
            }

            if(senha.length() <= 5){
                mensagem(view, "A senha é muito curta");
            }

            if(verificarSeExiste(email, senha) != null){
                navegarParaHome(bd.getUser());
            }else{
                mensagem(view, "O email ou a senha estão incorretos");
            }
        });

        binding.buttonRegister.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);
        });

        //instanciar instâncias para usar no resto da aplicação
        UserBD UserBd = UserBD.getInstance();
        ProfessionalBD professionalBD = ProfessionalBD.getInstance();
        ServicoBD servicoBD = ServicoBD.getInstance();
        ScheduleBD scheduleBD = ScheduleBD.getInstance();

    }

    private User verificarSeExiste(String email, String senha){
        return bd.getUserBy(email, senha);
    }

    //mensagem de erro caso o usuário não insira o email ou a senha
    private void mensagem(View view, String mensagem){
        Snackbar snackbar = Snackbar.make(view, mensagem, BaseTransientBottomBar.LENGTH_SHORT);
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"));
        snackbar.setTextColor(Color.parseColor("#FFFFFF"));
        snackbar.show();
    }

    private void navegarParaHome(User user){
        Intent intent = new Intent(MainActivity.this, Home.class); //cria a intent para mudar de página
        intent.putExtra("user", user.getNome()); //coloca na intent uma info que vai ser enviada para a outra activity
        startActivity(intent);
    }
}