package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import laboral.DatosNoCorrectosException;
import laboral.Empleado;
import laboral.Nomina;

public class EmpleadoDAO implements DAOEmpleado{

	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public EmpleadoDAO() throws ClassNotFoundException, SQLException {
		super();
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Nominas?useSSL=false", "root", "root");
	
	}

	@Override
	public void altaEmpleado(Empleado emp) throws SQLException {
		stmt = con.createStatement();
		String query = "Insert into Empleados values ('" + emp.nombre + "','" + emp.dni + "','" + emp.sexo + "'," + emp.getCategoria() + "," + emp.anyos + ")";
		stmt.executeUpdate(query);
		String salario = "Insert into nominas values ('" + emp.dni + "'," + Nomina.sueldo(emp) + ")";
		stmt.executeUpdate(salario);
		
	}

	@Override
	public List<String> mostrarEmpleados() throws ClassNotFoundException, SQLException {
		stmt = con.createStatement();

		List<String> empleados = new ArrayList<String>();

		rs = stmt.executeQuery("select * from Empleados");

		while (rs.next()) {
			char sexo = rs.getString(3).charAt(0);
			String empleado = rs.getString(1) + "," + rs.getString(2) + "," + sexo + "," + rs.getInt(4) + ","
					+ rs.getInt(5);
			empleados.add(empleado);
		}

		return empleados;
	}

	@Override
	public int buscarSalario(String dni) throws SQLException {
		int salario = 0;
		String query = "select sueldo from nominas where dni = ?";
		PreparedStatement ps = this.con.prepareStatement(query);
		ps.setString(1, dni);
		rs = ps.executeQuery();
		while (rs.next()) {
			salario = rs.getInt("sueldo");
		}

		return salario;
	}

	@Override
	public Empleado buscarEmpleado(String dni) throws SQLException, DatosNoCorrectosException {
		Empleado empleado = null;
		String query = "select * from Empleados where dni like ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, dni);
		rs = ps.executeQuery();

		
		while(rs.next()) {
			empleado = new Empleado(rs.getString("nombre"), 
					rs.getString("dni"), 
					rs.getString("sexo").charAt(0),
					rs.getInt("categoria"),
					rs.getInt("anyos"));
		}
		
		return empleado;
	}

	@Override
	public void editarEmpleado(Empleado emp) throws SQLException {
		String query = "update Empleados set nombre = ?, sexo = ?, categoria = ?, anyos = ? where dni = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, emp.nombre);
		ps.setString(2, Character.toString(emp.sexo));
		ps.setInt(3, emp.getCategoria());
		ps.setInt(4, emp.anyos);
		ps.setString(5, emp.dni);

		ps.executeUpdate();
		calcularSueldo(emp);
		
	}

	@Override
	public void calcularSueldo(Empleado emp) throws SQLException {
		String query = "update nominas set sueldo = "+Nomina.sueldo(emp)+" where dni = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, emp.dni);
		ps.executeUpdate();
		
	}
	
	
}
