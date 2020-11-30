package com.example.apphuevos;

import android.text.Editable;

public class registroHuevos {
        private String fechaHuevo;
    private String color;
        private int numeroHuevo;
        private double peso;
        private double diametroAltura;
        private double diametroAncho;
    public registroHuevos() {

    }

    public registroHuevos(String fechaHuevo, String color, int numeroHuevo, double peso, double diametroAltura, double diametroAncho) {
        this.fechaHuevo = fechaHuevo;
        this.color=color;
        this.numeroHuevo = numeroHuevo;
        this.peso = peso;
        this.diametroAltura = diametroAltura;
        this.diametroAncho = diametroAncho;
    }

    public String getFechaHuevo() {
        return fechaHuevo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getNumeroHuevo() {
        return numeroHuevo;
    }

    public double getPeso() {
        return peso;
    }

    public double getDiametroAltura() {
        return diametroAltura;
    }

    public double getDiametroAncho() {
        return diametroAncho;
    }

}
