package com.ipartek.fromacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.PerroDAOSqlite;

/**
 * Servlet implementation class PerroEliminar
 */
@WebServlet("/perro-eliminar")
public class PerroEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PerroDAOSqlite dao = PerroDAOSqlite.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PerroEliminar() {
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
		try {
			int id = Integer.parseInt(parametroId);
			if (dao.eliminar(id)) {
				request.setAttribute("mensaje", "perro borrado");
			} else {
				request.setAttribute("mensaje", "el perro no se ha borrado");
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			request.setAttribute("perros", dao.listar());
			request.getRequestDispatcher("perros.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
