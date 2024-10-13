package todocode.com.producto.micro.servicies;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todocode.com.producto.micro.dto.DTONombreProducto;
import todocode.com.producto.micro.model.ProductoMicro;
import todocode.com.producto.micro.repository.IProductoMicroserviciosRepository;

@Service
public class ProductoServicioMicroServicios implements IProductoMicroservicios{
	
	@Autowired
	private IProductoMicroserviciosRepository prodRepoMicro;

	@Override
	public void saveProductoMicroservicios(ProductoMicro ProdMicro) {

		prodRepoMicro.save(ProdMicro);		
		
	}

	@Override
	public List<ProductoMicro> listProductoMicroservicios() {

		List<ProductoMicro>getPersonas=prodRepoMicro.findAll();
		
		return getPersonas;
	}

	@Override
	public ProductoMicro findProductoMicroservicios(Long id_producto_buscar) {
		
		ProductoMicro prod=prodRepoMicro.findById(id_producto_buscar).orElse(null);
		
		return prod;
		
	}

	@Override
	public void editProductoMicroservicios(Long id_buscar, ProductoMicro prodMicroEditar) {
		
		ProductoMicro prod=this.findProductoMicroservicios(id_buscar);
		
		prod.setNombre_producto(prodMicroEditar.getNombre_producto());
		prod.setMarca_producto(prodMicroEditar.getMarca_producto());
		prod.setPrecio(prodMicroEditar.getPrecio());
		
		this.saveProductoMicroservicios(prod);		
		
	}

	@Override
	public void deleteProductoMicroservicios(Long id_producto_eliminar) {
		
		prodRepoMicro.deleteById(id_producto_eliminar);
		
	}
	
	
	//enviar el código del producto con el nombre del producto

	@Override	
	public List<DTONombreProducto> getNameProduct() {
		// TODO Auto-generated method stub
		
		List<ProductoMicro>todoProductos=this.listProductoMicroservicios();
		List<DTONombreProducto>CodigoNombreProducto=new ArrayList<DTONombreProducto>();
		
		
		for(int i=0;i<todoProductos.size();i++) {
			
			DTONombreProducto elProducto=new DTONombreProducto();
						
			elProducto.setCodigo_producto(todoProductos.get(i).getId_producto());
			elProducto.setNombre_producto(todoProductos.get(i).getNombre_producto());
			
			CodigoNombreProducto.add(elProducto);		
			
			
		}
		
		
		
		return CodigoNombreProducto;	
		

	}
	
	
//enviar productos de solo un carrito carrito
	@Override
	public List<DTONombreProducto> getNombreProducto(List<Long> codigos_productos) {
		// TODO Auto-generated method stub
		
		List<DTONombreProducto> nombresProductos=new ArrayList<DTONombreProducto>();
		
		for(int i=0;i<codigos_productos.size();i++) {		
			
			DTONombreProducto elProductoConNombre=new DTONombreProducto();			
			ProductoMicro elProductos=this.findProductoMicroservicios(codigos_productos.get(i));
			elProductoConNombre.setCodigo_producto(elProductos.getId_producto());
			elProductoConNombre.setNombre_producto(elProductos.getNombre_producto());
			nombresProductos.add(elProductoConNombre);
			
		}
		
		return nombresProductos;
		
		
	}

}
