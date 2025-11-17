package com.ecommerce.carritocompras.repositorio;

import com.ecommerce.carritocompras.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    
    @Query("SELECT p FROM Producto p WHERE p.activo = true ORDER BY p.id ASC")
    List<Producto> findAllActivos();
    
    List<Producto> findByNombreContainingAndActivo(String nombre, Boolean activo);
}
