package acciones;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbdd.EmpleadoServicio;
import laboral.DatosNoCorrectosException;
import laboral.Empleado;
import servlets.Accion;

public class ModificarEmpleado implements Accion{

	public ModificarEmpleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException {

		try {
			EmpleadoServicio empServicio;
			empServicio = new EmpleadoServicio();
			Empleado emp = new Empleado(request.getParameter("nombre"), request.getParameter("dni"), request.getParameter("sexo").trim().charAt(0), Integer.parseInt(request.getParameter("categoria")),Integer.parseInt(request.getParameter("anyos")));
			empServicio.editarEmpleado(emp);
			request.setAttribute("modificado", "true");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatosNoCorrectosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/empleadoModificado.jsp";
	}

}
