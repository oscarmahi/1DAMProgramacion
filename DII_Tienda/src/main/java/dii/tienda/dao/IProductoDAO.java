package dii.tienda.dao;

import java.util.ArrayList;

import dii.tienda.model.Producto;

public interface IProductoDAO {

	public ArrayList<Producto> getListaProducto();
	
	public ArrayList<Producto> grabarListaProducto(Producto producto);
	
}
