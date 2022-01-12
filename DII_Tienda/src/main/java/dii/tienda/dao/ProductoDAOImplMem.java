package dii.tienda.dao;

import java.util.ArrayList;

import dii.tienda.model.Producto;

public class ProductoDAOImplMem implements IProductoDAO{
	
	private static ArrayList<Producto> listaProductos = new ArrayList<Producto>();

	@Override
	public ArrayList<Producto> getListaProducto() {
		
		listaProductos.clear();
		grabarListaProducto(new Producto(1, "producto1", "descripcion1", 100));
		grabarListaProducto(new Producto(2, "producto2", "descripcion2", 200));
		grabarListaProducto(new Producto(3, "producto3", "descripcion3", 300));
		grabarListaProducto(new Producto(4, "producto4", "descripcion4", 400));
		grabarListaProducto(new Producto(5, "producto5", "descripcion5", 500));
		
		return listaProductos;
	}

	@Override
	public ArrayList<Producto> grabarListaProducto(Producto producto) {
		listaProductos.add(producto);
		
		
		
		return listaProductos;
	}


}
