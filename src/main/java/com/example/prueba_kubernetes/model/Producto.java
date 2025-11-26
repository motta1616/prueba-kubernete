package com.example.prueba_kubernetes.model;

import lombok.Data;

@Data
public class Producto {
    private int id;
    private String producto;
    private double precio;
}
