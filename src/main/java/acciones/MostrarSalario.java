package acciones;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbdd.EmpleadoServicio;
import servlets.Accion;

public class MostrarSalario implements Accion{

	
	public MostrarSalario() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException {
		EmpleadoServicio empleadoServicio = new EmpleadoServicio();
		String vista = "/salario_empleado.jsp";
		int salario = empleadoServicio.buscarSalario(request.getParameter("dni_salario"));
		request.setAttribute("salario", salario);
		request.setAttribute("dni", request.getParameter("dni_salario"));
		return vista;
	}

}
