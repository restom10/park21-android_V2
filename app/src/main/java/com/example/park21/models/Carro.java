package com.example.park21.models;

public class Carro {

    private String placa;

    public Carro(String placa) {
        this.placa = placa;
    }

    public Carro(){}


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
