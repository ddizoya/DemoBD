import java.sql.*;

public class BaseDatos {

	public BaseDatos() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public void iniciar() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bdchat", "root", "mysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cerrar() throws SQLException {
		con.close();
		st.close();
	}

	public void anadirAlumno() throws SQLException {

		try {
			iniciar();
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrar();
		}

		rs = st.executeQuery("select ");
	}

}
