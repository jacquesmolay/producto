package todocode.com.producto.micro.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todocode.com.producto.micro.dto.DTONombreProducto;
import todocode.com.producto.micro.model.ProductoMicro;
import todocode.com.producto.micro.servicies.ProductoServicioMicroServicios;

@RestController
@RequestMapping("/producto_micro")
public class ProductoMicroservicosController {
	
	@Autowired
	private ProductoServicioMicroServicios proServ;

	@Value("${server.port}")
	private int serverPort;

	
	
	@GetMapping("/listar_producto_micro")
	public List<ProductoMicro>showProductoMicro(){

		System.out.println("el puerto es  "+serverPort);
		return proServ.listProductoMicroservicios();		
		
	}
	
	
	@GetMapping("/encontrar_producto_micro/{id_producto_buscar}")
	public ProductoMicro showProductoMicro(@PathVariable Long id_producto_buscar) {
		
		return proServ.findProductoMicroservicios(id_producto_buscar);		
		
	}
	
	@PostMapping("/crear_producto_micro")
	public String saveProductoMicro(@RequestBody ProductoMicro prod) {
		
		proServ.saveProductoMicroservicios(prod);
		
		return "Producto grabado correctamente";
		
	}
	
	@PutMapping("/update_producto_micro/{id_producto_buscar_editar}")
	public String editProductoMicro(@PathVariable Long id_producto_buscar_editar, @RequestBody ProductoMicro prodEditar ) {
		
		proServ.editProductoMicroservicios(id_producto_buscar_editar, prodEditar);
		
		return "Producto Modificado";
		
	}
	
	@DeleteMapping("/eliminar_producto_micro/{id_producto_buscar_eliminar}")
	public String deleteProductoMicro(@PathVariable Long id_producto_buscar_eliminar) {
		
		proServ.deleteProductoMicroservicios(id_producto_buscar_eliminar);
		
		return "Producto Eliminado";
	}
	
	//retornona todos los productos en DTONombreProducto
	
	@GetMapping("/microservicio_encontrar_producto")
	public List<DTONombreProducto> getProductosInfo(){
		
		return proServ.getNameProduct();
		
	}
	
	
	//retorna solo unos productos
	
	@GetMapping("/find_producto/{productos_id}")
	public List<DTONombreProducto> getInfoProducto(@PathVariable("productos_id") List<Long> productos_id ){
		
	
		return proServ.getNombreProducto(productos_id);
		
	}
	
	

}
