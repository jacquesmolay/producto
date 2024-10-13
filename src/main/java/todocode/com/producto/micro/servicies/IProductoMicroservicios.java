package todocode.com.producto.micro.servicies;

import java.util.List;
import java.util.Map;

import todocode.com.producto.micro.dto.DTONombreProducto;
import todocode.com.producto.micro.model.ProductoMicro;

public interface IProductoMicroservicios {
	
	public void saveProductoMicroservicios(ProductoMicro ProdMicro);
	
	public List<ProductoMicro> listProductoMicroservicios();
	
	public ProductoMicro findProductoMicroservicios(Long id_producto_buscar);
	
	public void editProductoMicroservicios(Long id_buscar, ProductoMicro prodMicroEditar);
	
	public void deleteProductoMicroservicios(Long id_producto_eliminar);	
	
	//obtener nombr4e de porductos para enviar a carrito
	public List<DTONombreProducto> getNameProduct();
	
	//obtenet productos de un solo crrito
	public List<DTONombreProducto> getNombreProducto(List<Long> codigos_productos);

}
