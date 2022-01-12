package dii.tienda.service;

import java.util.ArrayList;

import dii.tienda.dao.IProductoDAO;
import dii.tienda.dao.IUsuarioDAO;
import dii.tienda.dao.ProductoDAOImplMem;
import dii.tienda.dao.UsuarioDAOImplMem;
import dii.tienda.model.LineaCarrito;
import dii.tienda.model.Producto;
import dii.tienda.model.Usuario;

public class ProductoService {

	private IProductoDAO udao = new ProductoDAOImplMem();
	private IUsuarioDAO usao = new UsuarioDAOImplMem();

	public ArrayList<Producto> llenarListaProductos() {

		ArrayList<Producto> lista = udao.getListaProducto();

		return lista;
	}

	public static ArrayList<LineaCarrito> CompletaCesta(ArrayList<Producto> listaProducto, ArrayList<String> listaNumeros) {
		ArrayList<LineaCarrito> listaCarrito = new ArrayList<>();
		int unidades=0;
		for (int i = 0; i < listaProducto.size(); i++) {
			
			if (listaNumeros.get(i).equals("")) {
				unidades=0;
			}else {
				unidades = Integer.parseInt(listaNumeros.get(i));
			}
			listaCarrito.add(new LineaCarrito(
						listaProducto.get(i).getIdProducto(), 
						listaProducto.get(i).getNombreProducto(),
						unidades,
						listaProducto.get(i).getPrecioProducto(),
						null));
			
		}
		return listaCarrito;
	}

	public boolean verificarUsuario(Usuario usuario) {
		boolean existe = false;
		int i=0;
		
		while  (i < usao.getListaUsuarios().size()) {
			if ((usao.getListaUsuarios().get(i).getEmailUsuario().equals(usuario.getEmailUsuario())) &&
			    (usao.getListaUsuarios().get(i).getPassword().equals(usuario.getPassword()))) {
				existe = true;
			}
			i++;
		}
		return existe;
	}
	
	public ArrayList<Usuario> grabarUsuario(Usuario usuario) {
		
		ArrayList<Usuario> lista = usao.grabarUsuario(usuario);
		
		return lista;
	}
	
	
}
