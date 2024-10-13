package todocode.com.producto.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todocode.com.producto.micro.model.ProductoMicro;

@Repository
public interface IProductoMicroserviciosRepository extends JpaRepository<ProductoMicro, Long> {

}
