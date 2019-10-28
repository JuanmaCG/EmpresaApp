package bbdd;

import java.sql.SQLException;
import java.util.List;

import laboral.DatosNoCorrectosException;
import laboral.Empleado;

public class EmpleadoServicio implements DAOEmpleado{

	EmpleadoDAO dao;

	public EmpleadoServicio() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
		dao = new EmpleadoDAO();
	}

	@Override
	public void altaEmpleado(Empleado emp) throws SQLException {
		// TODO Auto-generated method stub
		dao.altaEmpleado(emp);
		
	}

	@Override
	public List<String> mostrarEmpleados() throws ClassNotFoundException, SQLException {
		return dao.mostrarEmpleados();
	}

	@Override
	public int buscarSalario(String dni) throws SQLException {
		return dao.buscarSalario(dni);
	}

	@Override
	public Empleado buscarEmpleado(String dni) throws SQLException, DatosNoCorrectosException {
		
		return dao.buscarEmpleado(dni);
	}

	@Override
	public void editarEmpleado(Empleado emp) throws SQLException {
		// TODO Auto-generated method stub
		dao.editarEmpleado(emp);
	}

	@Override
	public void calcularSueldo(Empleado emp) throws SQLException {
		// TODO Auto-generated method stub
		dao.calcularSueldo(emp);
	}
	
	
	
}
