package com.sena.sistema_inventario.controller; 

import java.util.List; 

import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; // <-- 1. IMPORTAR POST MAPPING
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.sistema_inventario.model.Producto; 
import com.sena.sistema_inventario.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "https://inventariojosue.netlify.app")

public class ProductoController { 

    private final ProductoService service; 

    public ProductoController(ProductoService service) { 
        this.service = service; 
    } 

    @GetMapping("/productos") 
    public List<Producto> listarProductos() { 
        return service.listarProductos(); 
    } 

    @GetMapping("/productos/{id}") 
    public Producto buscarPorId(@PathVariable Long id) { 
        return service.buscarPorId(id).orElse(null); 
    }

    @GetMapping("/productos/codigo/{codigo}")
public Producto buscarPorCodigo(@PathVariable String codigo) {
    // Asegúrate de definir buscarPorCodigo en tu ProductoService
    return service.buscarPorCodigo(codigo).orElse(null);
}

    // <-- 2. AGREGAR EL MÉTODO POST PARA CREAR PRODUCTOS
    @PostMapping("/productos")
    public Producto registrarProducto(@RequestBody Producto producto) {
        return service.guardarProducto(producto);
    }

    @DeleteMapping("/productos/{id}") 
    public void eliminarProducto(@PathVariable Long id) { 
        service.eliminarProducto(id); 
    }

    @PutMapping("/productos/{id}") 
    public Producto actualizarProducto( 
            @PathVariable Long id, 
            @RequestBody Producto producto) { 
        return service.actualizarProducto(id, producto); 
    }
}