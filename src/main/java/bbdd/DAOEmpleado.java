package bbdd;

import java.sql.SQLException;
import java.util.List;

import laboral.DatosNoCorrectosException;
import laboral.Empleado;

public interface DAOEmpleado {

	public void altaEmpleado(Empleado emp) throws SQLException;
	public List<String> mostrarEmpleados() throws ClassNotFoundException, SQLException;
	public int buscarSalario(String dni) throws SQLException;
	public Empleado buscarEmpleado(String dni) throws SQLException, DatosNoCorrectosException;
	public void editarEmpleado(Empleado emp) throws SQLException;
	public void calcularSueldo(Empleado emp) throws SQLException;
	
}
