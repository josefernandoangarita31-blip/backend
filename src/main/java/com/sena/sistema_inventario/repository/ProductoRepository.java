package com.sena.sistema_inventario.repository; 
import com.sena.sistema_inventario.model.Producto; 
import org.springframework.data.jpa.repository.JpaRepository; 
import java.util.Optional;
public interface ProductoRepository extends JpaRepository<Producto, Long> { 
    // AGREGAR ESTA LÍNEA:
    Optional<Producto> findByCodigo(String codigo);
}

