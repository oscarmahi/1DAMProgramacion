package dii.tienda.dao;

import java.util.ArrayList;

import dii.tienda.model.Usuario;

public class UsuarioDAOImplMem implements IUsuarioDAO{
	
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

	@Override
	public ArrayList<Usuario> getListaUsuarios() {
		
		return listaUsuarios;
	}

	@Override
	public ArrayList<Usuario> grabarUsuario(Usuario usuario) {
		
		listaUsuarios.add(usuario);
		
		
		return listaUsuarios;
	}

	
	
	
}
