package dii.tienda.model;

public class Usuario {
	
	private String emailUsuario;
	private String password;
	
	public Usuario(String emailUsuario, String password) {
		this.emailUsuario = emailUsuario;
		this.password = password;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
