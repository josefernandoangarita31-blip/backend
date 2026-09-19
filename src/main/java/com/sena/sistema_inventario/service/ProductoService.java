package com.sena.sistema_inventario.service;

import org.springframework.stereotype.Service;
import com.sena.sistema_inventario.repository.ProductoRepository;
import com.sena.sistema_inventario.model.Producto; 
import java.util.List; 
import java.util.Optional;

@Service 
public class ProductoService { 

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) { 
        this.repository = repository; 
    }

    public List<Producto> listarProductos() { 
        return repository.findAll(); 
    }  

    public Producto guardarProducto(Producto producto) { 
        return repository.save(producto); 
    } 

    public Optional<Producto> buscarPorId(Long id) { 
        return repository.findById(id);
    }

    public void eliminarProducto(Long id) { 
        repository.deleteById(id); 
    }

    public Optional<Producto> buscarPorCodigo(String codigo) {
    return repository.findByCodigo(codigo);
}

    public Producto actualizarProducto(Long id, Producto productoActualizado) { 
        return repository.findById(id).map(producto -> { 
            producto.setCodigo(productoActualizado.getCodigo()); 
            producto.setNombre(productoActualizado.getNombre()); 
            producto.setCategoria(productoActualizado.getCategoria()); 
            producto.setPrecio(productoActualizado.getPrecio()); 
            producto.setCantidad(productoActualizado.getCantidad()); 
            return repository.save(producto); 
        }).orElse(null); 
    } 
}