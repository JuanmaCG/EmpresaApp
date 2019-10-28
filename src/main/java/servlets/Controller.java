package servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.AltaEmpleado;
import acciones.ModificarEmpleado;
import acciones.MostrarEmpleado;
import acciones.MostrarEmpleados;
import acciones.MostrarSalario;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Accion ac;
		String nomVista;
		RequestDispatcher rd;

		try {
			switch(request.getParameter("accion")) {
			case "Mostrar":
				ac = new MostrarEmpleados();
				nomVista = ac.ejecutar(getServletContext(), request, response);
				rd = request.getRequestDispatcher(nomVista);
				rd.forward(request, response);
				break;
			
			case "SalarioEspecifico":
				ac = new MostrarSalario();
				nomVista = ac.ejecutar(getServletContext(), request, response);
				rd = request.getRequestDispatcher(nomVista);
				rd.forward(request, response);
				break;
			case "DarDeAlta":
				ac = new AltaEmpleado();
				nomVista = ac.ejecutar(getServletContext(), request, response);
				rd = request.getRequestDispatcher(nomVista);
				rd.forward(request, response);
				break;
			case "ModificarEmpleado":
				ac = new MostrarEmpleado();
				nomVista = ac.ejecutar(getServletContext(), request, response);
				rd = request.getRequestDispatcher(nomVista);
				rd.forward(request, response);
				break;
			case "Modificar":
				ac = new ModificarEmpleado();
				nomVista = ac.ejecutar(getServletContext(), request, response);
				rd = request.getRequestDispatcher(nomVista);
				rd.forward(request, response);
				break;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	

}
