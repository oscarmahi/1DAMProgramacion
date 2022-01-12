package dii.tienda.model;

public class LineaCarrito {
	
	private int idProducto;
	private String nombreProducto;
	private int unidades;
	private float precio;
	private String usuario;

	public LineaCarrito(int idProducto, String nombreProducto, int unidades, float precio, String usuario) {
		
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.unidades = unidades;
		this.precio = precio;
		this.usuario = usuario;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
}
