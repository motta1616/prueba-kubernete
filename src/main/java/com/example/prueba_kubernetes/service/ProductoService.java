package com.example.prueba_kubernetes.service;

import com.example.prueba_kubernetes.model.Producto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class ProductoService {
    public List<Producto> obtenerProductos() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream productList = getClass().getResourceAsStream("/productos.json");
            return mapper.readValue(productList, new TypeReference<List<Producto>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error leyendo productos.json", e);
        }
    }
}