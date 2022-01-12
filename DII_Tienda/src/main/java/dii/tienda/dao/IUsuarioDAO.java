package dii.tienda.dao;

import java.util.ArrayList;

import dii.tienda.model.Usuario;

public interface IUsuarioDAO {

	public ArrayList<Usuario> getListaUsuarios();
	
	public ArrayList<Usuario> grabarUsuario(Usuario usuario);
}
