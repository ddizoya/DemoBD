import java.sql.*;
import java.util.ArrayList;

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
	ArrayList lista = new ArrayList();

	private void iniciar() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bdchat", "root", "mysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void cerrar() throws SQLException {
		con.close();
		st.close();
	}

	public void anadirAlumno() throws SQLException {

		try {
			iniciar();

			String consulta = "select * from usuario order by id_usuario";

			st = con.createStatement();
			rs = st.executeQuery(consulta);
			while (rs.next()) {
				int id_usuario = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidos = rs.getString(3);
				int sala = rs.getInt(4);
				System.out.println(id_usuario + " " + nombre + " " + apellidos
						+ " " + sala);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrar();
		}

	}

}
