package acciones;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bbdd.EmpleadoServicio;
import laboral.DatosNoCorrectosException;
import laboral.Empleado;
import servlets.Accion;

public class MostrarEmpleado implements Accion{

	public MostrarEmpleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException {
		
		try {
			EmpleadoServicio empleadoServicio;			
			empleadoServicio = new EmpleadoServicio();
			Empleado emp;
			emp = empleadoServicio.buscarEmpleado(request.getParameter("dni"));
			request.setAttribute("empleado", emp);
			
		} catch (DatosNoCorrectosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/modificaEmpleado.jsp";
		
	}
}
