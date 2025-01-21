package com.example.DigitalLibrary.Services;

import com.example.DigitalLibrary.Models.Holder;
import com.example.DigitalLibrary.Utils.Validations;

public class HolderService {

    public void registerHolder(Holder newHolder){

        if(!Validations.isEmail(newHolder.getEmail())) throw new IllegalArgumentException("Email de usuário inválido");
        if(!Validations.isPersonalIDValid(newHolder.getIdNumber())) throw new IllegalArgumentException("Número de CPF Inválido");

        try{
            int a = 2;
            System.out.println(a);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
