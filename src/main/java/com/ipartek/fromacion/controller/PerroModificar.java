package com.ipartek.fromacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.PerroDAOSqlite;
import com.ipartek.formacion.pojo.Perro;

/**
 * Servlet implementation class PerroModificar
 */
@WebServlet(name = "PerroModificar", urlPatterns = { "/perro-modificar" })
public class PerroModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PerroModificar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroId = request.getParameter("id");
		PerroDAOSqlite dao = PerroDAOSqlite.getInstance();
		int id = Integer.parseInt(parametroId);

		// conseguir datos llamado al modelo ( bbdd )
		Perro perro = new Perro();
		perro = dao.recuperar(id);

		request.setAttribute("perro", perro);

		request.getRequestDispatcher("modificarPerro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PerroDAOSqlite dao = PerroDAOSqlite.getInstance();
		String mensaje = "";
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");
		float peso = Float.parseFloat(request.getParameter("peso"));
		boolean vacunado = (request.getParameter("vacunado") == null) ? false : true;
		String historia = request.getParameter("historia");

		Perro p = new Perro();
		p.setId(id);
		p.setNombre(nombre);
		p.setRaza(raza);
		p.setPeso(peso);
		p.setVacunado(vacunado);
		p.setHistoria(historia);
		try {
			dao.modificar(p);
			mensaje = "Perro Modificado con exito";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// enviarlos a la JSP
		request.setAttribute("perro", p);
		request.setAttribute("mensaje", mensaje);
		// ir a la JSP
		request.getRequestDispatcher("modificarPerro.jsp").forward(request, response);

	}

}
