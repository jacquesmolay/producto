package todocode.com.producto.micro.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTONombreProducto {
	
	private Long codigo_producto;
	private String nombre_producto;

}
