package com.example.prueba_kubernetes.controller;


import com.example.prueba_kubernetes.model.Producto;
import com.example.prueba_kubernetes.service.ProductoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    @Value("${pod:xxx}")
    private String pod;

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/api/productos")
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @GetMapping("/api/pod")
    public String obtenerPod() {
        return "Este es el pod: " + pod;
    }
}
