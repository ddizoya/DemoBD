import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Excel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private int id, sala;
	private String nombre, apellidos;
	private JTable table_1;
	private String[] columnas = { "ID", "Nombre", "Apellidos", "Sala" };
	private String[][] data = new String[1][4];
	private BaseDatos bd = new BaseDatos();
	private DefaultTableModel tb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Excel frame = new Excel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Excel() throws SQLException {
		
		setSize(new Dimension(644, 396));
		getContentPane().setSize(new Dimension(600, 500));
		getContentPane().setPreferredSize(new Dimension(600, 500));
		getContentPane().setMinimumSize(new Dimension(600, 500));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 634, 244);
		getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 603, 123);
		panel.add(scrollPane_1);

		table_1 = new JTable();
		tb = new DefaultTableModel(null,columnas);
		table_1.setModel(tb);
		scrollPane_1.setViewportView(table_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(121, 182, 409, 26);
		panel.add(textPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(314, 243, 320, 115);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setFocusable(false);
		scrollPane.setViewportBorder(null);
		scrollPane.setBorder(null);
		scrollPane.setBounds(0, 11, 310, 43);
		panel_1.add(scrollPane);
		String[] columnas = { "ID", "Nombre", "Apellidos", "Sala" };
		String[][] data = new String[1][4];
		table = new JTable(data, columnas);
		table.setFocusTraversalKeysEnabled(false);
		table.setFocusable(false);
		scrollPane.setViewportView(table);
		btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(111, 82, 89, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TableModel tb = table.getModel();
				for (int i = 0; i < 4; i++) {
					if (i == 0)
						id = Integer.parseInt(data[0][i]);
					if (i == 1)
						nombre = "'" + data[0][i] + "'";
					if (i == 2)
						apellidos = "'" + data[0][i] + "'";
					if (i == 3)
						sala = Integer.parseInt(data[0][i]);
				}
				
				String consulta = "Insert into usuario values(" + id + ","
						+ nombre + "," + apellidos + "," + sala + ")";
				textPane.setText(consulta);
				try {
					bd.registrarUsuario(consulta);
					bd.verUsuarios(tb);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

	}
}
