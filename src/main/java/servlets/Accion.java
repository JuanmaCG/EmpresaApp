package servlets;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Accion {

	public String ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException, SQLException;
}
