package com.ipartek.fromacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.PerroDAOSqlite;
import com.ipartek.formacion.pojo.Perro;

/**
 * @WebServlet("/perroController") es la URL donde escucha este controlador
 */
@WebServlet(name = "PerroController", urlPatterns = { "/perroController" })

public class PerrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PerrosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Perro> lista = new ArrayList<Perro>();
		// conseguir perros llamdo al modelo

		try {
			PerroDAOSqlite dao = PerroDAOSqlite.getInstance();

			// conseguir datos llamado al modelo ( bbdd )
			lista = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();

		}

		// Los DATOS (atributos) a enviar a la vista para pintarlos
		// request.setAttribute( String, Objeto);
		// String podeis poner el nombre que querais, pero eso mismo nombre lo usaremos
		// en la JSP para acceder al Objeto
		// Objeto, podeis enviar lo que querais: String, boolean, Perro,
		// ArrayList<Perro>,....
		request.setAttribute("perros", lista);
		request.setAttribute("mensaje", "Recuperados " + lista.size() + " perros");

		// Comando para ir a la VISTA, hacemos un "forwad" y escribimos el nombre de la
		// JSP "perros.jsp"
		request.getRequestDispatcher("perros.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensaje = "";
		// recibir los datos del formulario en input del atributo name
		String parametroNombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");
		String peso = request.getParameter("peso");
		boolean vacunado = request.getParameter("vacunado") != null ? true : false;
		String historia = request.getParameter("historia");

		Perro p = new Perro();
		p.setNombre(parametroNombre);
		p.setRaza(raza);
		p.setPeso(Float.parseFloat(peso));
		p.setVacunado(vacunado);
		p.setHistoria(historia);

		try {
			PerroDAOSqlite dao = PerroDAOSqlite.getInstance();
			dao.crear(p);
			mensaje = "el perro se ha creado con exito";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mensaje", "Lo sentimos pero " + p.getNombre() + " de perro ya existe");

		}

		// enviarlos a la JSP
		request.setAttribute("perro", p);
		request.setAttribute("mensaje", mensaje);
// ir ala JSP
		request.getRequestDispatcher("perro.jsp").forward(request, response);

	}

}
