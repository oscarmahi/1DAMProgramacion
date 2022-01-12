package dii.tienda.inicio;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dii.tienda.model.LineaCarrito;
import dii.tienda.model.Producto;
import dii.tienda.model.Usuario;
import dii.tienda.service.ProductoService;

/**
 * Servlet implementation class TiendaController
 */
@WebServlet("")
public class TiendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String usuarioSesion="";
	ArrayList<LineaCarrito> lineaCarrito;
	String mensajeDoGet=null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TiendaController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Producto> listaProducto = new ArrayList<>();

		listaProducto = new ProductoService().llenarListaProductos();

		request.setAttribute("mensaje", mensajeDoGet);
		request.getSession().setAttribute("usuarioSesion", usuarioSesion);
		request.setAttribute("listaProducto", listaProducto);
		request.getRequestDispatcher("./jsp/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tipoOperacion = request.getParameter("operacion");
		String mensaje = "";
		String user, pass, pass2;

		//----------------------------------------------------------------------------------------listo los productos de la cesta
		if (tipoOperacion.equals("listar")) {

			ArrayList<String> listaNumeros = new ArrayList<>();

			String aux = "";
			int i = 0;
			aux = i + "";
			while (request.getParameter(aux) != null) {
				listaNumeros.add(request.getParameter(aux));
				i++;
				aux = i + "";
			}

			ArrayList<Producto> listaProducto = new ArrayList<>();
			listaProducto = new ProductoService().llenarListaProductos();

			new ProductoService();
			lineaCarrito = ProductoService.CompletaCesta(listaProducto, listaNumeros);
			//lineaCarrito = new ProductoService().CompletaCesta(listaProducto, listaNumeros);
			
			request.getSession().setAttribute("usuarioSesion", usuarioSesion);
			request.getSession().setAttribute("listaCarrito", lineaCarrito);
			request.getRequestDispatcher("./jsp/cesta.jsp").forward(request, response);
			//----------------------------------------------------------------------------------------llamo a la vista de login
		}else if (tipoOperacion.equals("login")) {
			request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
			//-----------------------------------------------------------------------------------------boton consulta del login
		}else if (tipoOperacion.equals("consultaLogin")) {
			// recupero los datos que me vienen del servlet
			user = request.getParameter("user");
			pass = request.getParameter("pass");
			Usuario usuario = new Usuario(user, pass);
			boolean existe = new ProductoService().verificarUsuario(usuario);
			
			if (existe) {
				mensaje = "Usuario Logado";
				usuarioSesion = user;
				
				request.getSession().setAttribute("usuarioSesion", usuarioSesion);
				
				if (lineaCarrito == null) {
					mensajeDoGet=null;
					doGet(request, response);
				}else {
					request.getSession().setAttribute("listaCarrito", lineaCarrito);
					request.getRequestDispatcher("./jsp/cesta.jsp").forward(request, response);
				}
			}else {
				mensaje = "Usuario NO Logado";
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
			}
		//------------------------------------------------------------------------------------------------Grabar un nuevo usuario
		}else if (tipoOperacion.equals("grabarLogin")) {
			
			// recupero los datos que me vienen del servlet
			user = request.getParameter("user");
			pass = request.getParameter("pass");
			pass2 = request.getParameter("pass2");
			Usuario usuario = new Usuario(user, pass);
			
			if (!user.equals("") && !pass.equals("") && !pass2.equals("") && pass2.equals(pass)) {
				//ArrayList<Usuario> listaUsuarios = new ProductoService().grabarUsuario(usuario);
				ArrayList<Usuario> listaUsuarios = new ProductoService().grabarUsuario(usuario);
				mensaje = "Usuario grabado";
			}else {
				mensaje = "Faltan datos para hacer la grabacion, o datos incorrectos";
			}
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
			//-------------------------------------------------------------------------------------------grabar la cesta
		}else if (tipoOperacion.equals("cesta")) {
			if (usuarioSesion.length()!=0) {
				mensajeDoGet="Cesta Grabada por el Usuario";
				doGet(request, response);
			}else {
				mensaje = "Usuario NO Logado";
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
			}
		}
	}

}
