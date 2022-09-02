package com.riska.validasi_login;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class register extends AppCompatActivity {

    EditText editUsername, editPassword, editEmail, editNamaLengkap, editAsalSekolah, editAlamat;
    Button btnSimpan;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Register");

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editEmail = findViewById(R.id.editEmail);
        editNamaLengkap = findViewById(R.id.editNamaLengkap);
        editAsalSekolah = findViewById(R.id.editAsalSekolah);
        editAlamat = findViewById(R.id.editAlamat);
        btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidation()){
                    simpanFileData();
                } else {
                    Toast.makeText(register.this, "Mohon Lengkapi Seluruh Data ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    boolean isValidation() {
        if (editUsername.getText().toString().length() == 0){
            editUsername.setError("Masukkan username");
        } else if (editPassword.getText().toString().length() == 0){
            editPassword.setError("Harus diisi");
        } else if (editEmail.getText().toString().length() == 0){
            editEmail.setError("harus diisi");
        } else if (editNamaLengkap.getText().toString().length() == 0){
            editNamaLengkap.setError("Harus diisi");
        } else if (editAsalSekolah.getText().toString().length() == 0){
            editAsalSekolah.setError("harus diisi");
        } else if (editAlamat.getText().toString().length() == 0) {
            editAlamat.setError("harus diisi");
        }
        return false;
    }

    void simpanFileData(){
        String isiFile = editUsername.getText().toString() + ";" +
                editPassword.getText().toString() + ";" +
                editEmail.getText().toString() + ";" +
                editNamaLengkap.getText().toString() + ";" +
                editAsalSekolah.getText().toString() + ";" +
                editAlamat.getText().toString();
        File file = new File(String.valueOf(getFilesDir())),editUsername;

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this,"Register Berhasil", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }
}