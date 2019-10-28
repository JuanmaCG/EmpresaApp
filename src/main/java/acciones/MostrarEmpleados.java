package acciones;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbdd.EmpleadoServicio;
import servlets.Accion;

public class MostrarEmpleados implements Accion{

	public MostrarEmpleados() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		EmpleadoServicio empleadoServicio = new EmpleadoServicio();
		String vista = "/empleados.jsp";
		List<String> listaEmpleados = empleadoServicio.mostrarEmpleados();
		request.setAttribute("empleados", listaEmpleados);
		return vista;
	}}
