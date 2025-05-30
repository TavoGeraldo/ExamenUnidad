package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controllers.AuthController;
import controllers.DocenteController;
import controllers.HomeController;

public class DocenteView {
	
	private DefaultTableModel modelo;
	private JTable tablaDocentes;

	
	public void docente() {
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Docentes"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true);  
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#fefae0"));
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600);
		
		JLabel lblNewLabel = new JLabel("Docentes");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);
		
		
        
        String[] columnas = {"ID", "Nombre", "Materia", "Correo"};

 
        Object[][] datos = {
            {"1", "Carlos Pérez", "Matemáticas", "cperez@escuela.edu"},
            {"2", "Laura Gómez", "Física", "lgomez@escuela.edu"},
            {"3", "José Martínez", "Química", "jmartinez@escuela.edu"}
        };


        modelo = new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        tablaDocentes = new JTable(modelo);
        
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tablaDocentes.getColumnCount(); i++) {
            tablaDocentes.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        
        tablaDocentes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tablaDocentes.setRowHeight(25);
        
        JTableHeader header = tablaDocentes.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 16));
        header.setBackground(Color.DARK_GRAY);
        header.setForeground(Color.WHITE);
        

        tablaDocentes.setIntercellSpacing(new Dimension(0, 0));
        tablaDocentes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(tablaDocentes);
        scrollPane.setBounds(100, 100, 700, 300); 

        panel.add(scrollPane, BorderLayout.CENTER);
        
        JButton btnCrear = new JButton("Crear");
        btnCrear.setBounds(200, 420, 100, 40);
        btnCrear.setFocusPainted(false);
        
        btnCrear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.dispose();
				DocenteController dc = new DocenteController();
				dc.CrearDocente();
			}
		});
        
        panel.add(btnCrear);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(320, 420, 100, 40);
        btnEditar.setFocusPainted(false);
        btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.dispose();
				DocenteController dc = new DocenteController();
				dc.EditarDocente();
				
			}
		});
        panel.add(btnEditar);

        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(440, 420, 100, 40);
        btnConsultar.setFocusPainted(false);
        btnConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.dispose();
				DocenteController dc = new DocenteController();
				dc.ConsultarDocente();
			}
		});
        panel.add(btnConsultar);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(560, 420, 100, 40);
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		        int selectedRow = tablaDocentes.getSelectedRow(); 

		        if (selectedRow != -1) { 

		            int confirmResult = JOptionPane.showConfirmDialog(
		                ventana,
		                "¿Estás seguro de que quieres eliminar a este docente?","Confirmar Eliminación",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

		            if (confirmResult == JOptionPane.YES_OPTION) {
		               
		                JOptionPane.showMessageDialog(ventana, "Docente eliminado con éxito.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(ventana, "Por favor, selecciona un docente para eliminar.", "Error al eliminar", JOptionPane.WARNING_MESSAGE);
		        }
			}
		});
        panel.add(btnEliminar);

		
		
		JButton btnRegresar = new JButton();
		btnRegresar.setBounds(20, 20, 50, 50);
		ImageIcon iconoRegresar = new ImageIcon(getClass().getResource("/files/regresar.png"));
		Image imagenEscalada3 = iconoRegresar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnRegresar.setIcon(new ImageIcon(imagenEscalada3));

		btnRegresar.setBorderPainted(false);
		btnRegresar.setContentAreaFilled(false);
		btnRegresar.setFocusPainted(false);
		
		btnRegresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.dispose();
            	HomeController hc = new HomeController();
            	hc.home();
			}
		});
		
		panel.add(btnRegresar);
		
		JButton btnCerarSesion = new JButton();
		btnCerarSesion.setBounds(850, 20, 50, 50);
		ImageIcon iconoCerrarSesion = new ImageIcon(getClass().getResource("/files/logout.png"));
		Image imagenEscalada = iconoCerrarSesion.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnCerarSesion.setIcon(new ImageIcon(imagenEscalada));

		btnCerarSesion.setBorderPainted(false);
		btnCerarSesion.setContentAreaFilled(false);
		btnCerarSesion.setFocusPainted(false);

		btnCerarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cerrar sesión?","Cerrar sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (opcion == JOptionPane.YES_OPTION) {
		            ventana.dispose();
		    		AuthController app = new AuthController(); 
		     		app.login();
		        }
			}
		});

		panel.add(btnCerarSesion);
		
		
		ventana.add(panel);
		ventana.repaint();
		ventana.revalidate();
	}
	
	public void CrearDocente(){
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Crear"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true);  
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#fefae0"));
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600);
		
		JLabel lblNewLabel = new JLabel("Crear Docente");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(250, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.LEFT);
		panel.add(lblNewLabel);

        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setBounds(250, 90, 150, 25);
        panel.add(lblNombres);

        JTextField txtNombres = new JTextField();
        txtNombres.setBounds(410, 90, 250, 25);
        panel.add(txtNombres);


        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(250, 130, 150, 25);
        panel.add(lblApellidos);

        JTextField txtApellidos = new JTextField();
        txtApellidos.setBounds(410, 130, 250, 25);
        panel.add(txtApellidos);


        JLabel lblFecha = new JLabel("Fecha de nacimiento (dd/mm/aaaa):");
        lblFecha.setBounds(250, 170, 250, 25);
        panel.add(lblFecha);

        JTextField txtFecha = new JTextField();
        txtFecha.setBounds(500, 170, 160, 25);
        panel.add(txtFecha);


        JLabel lblCorreo = new JLabel("Correo electrónico:");
        lblCorreo.setBounds(250, 210, 150, 25);
        panel.add(lblCorreo);

        JTextField txtCorreo = new JTextField();
        txtCorreo.setBounds(410, 210, 250, 25);
        panel.add(txtCorreo);


        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(250, 250, 150, 25);
        panel.add(lblTelefono);

        JTextField txtTelefono = new JTextField();
        txtTelefono.setBounds(410, 250, 250, 25);
        panel.add(txtTelefono);


        JLabel lblGrado = new JLabel("Grado de estudios:");
        lblGrado.setBounds(250, 290, 150, 25);
        panel.add(lblGrado);

        JTextField txtGrado = new JTextField();
        txtGrado.setBounds(410, 290, 250, 25);
        panel.add(txtGrado);


        JLabel lblMateria = new JLabel("Materia a impartir:");
        lblMateria.setBounds(250, 330, 150, 25);
        panel.add(lblMateria);
        
        JTextField txtMateria = new JTextField();
        txtMateria.setBounds(410, 330, 250, 25);
        panel.add(txtMateria);
        
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(390, 390, 150, 35);
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		        boolean flag = true;


		        if (txtNombres.getText().equals("")) {
		            txtNombres.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            flag = false;
		        } else {
		            txtNombres.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		        }


		        if (txtApellidos.getText().equals("")) {
		            txtApellidos.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            flag = false;
		        } else {
		            txtApellidos.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		        }


		        if (txtFecha.getText().equals("")) {
		            txtFecha.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            flag = false;
		        } else {
		            txtFecha.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		        }

		 
		        if (txtCorreo.getText().equals("")) {
		            txtCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            flag = false;
		        } else {
		            txtCorreo.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		        }

		     
		        String telefono = txtTelefono.getText();
		        if (telefono.equals("")) {
		            txtTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            flag = false;
		        } else {
		            boolean soloNumeros = true;
		            for (int i = 0; i < telefono.length(); i++) {
		                if (!Character.isDigit(telefono.charAt(i))) {
		                    soloNumeros = false;
		                    break;
		                }
		            }
		            if (soloNumeros == false) {
		                txtTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		                JOptionPane.showMessageDialog(null, "El teléfono debe contener solo números.", "Error", JOptionPane.ERROR_MESSAGE);
		                flag = false;
		            } else {
		                txtTelefono.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		            }
		        }


		        if (txtGrado.getText().equals("")) {
		            txtGrado.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            flag = false;
		        } else {
		            txtGrado.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		        }
		        
		        if (txtMateria.getText().equals("")) {
		        	txtMateria.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            flag = false;
		        } else {
		        	txtMateria.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		        }

		        if (flag == true) {
		           
		            JOptionPane.showMessageDialog(null, "Docente guardado con éxito.");
		            ventana.dispose();
	            	DocenteController dc = new DocenteController();
	            	dc.docente();
		        } 
			}
		});
        panel.add(btnGuardar);
		
		
		JButton btnRegresar = new JButton();
		btnRegresar.setBounds(20, 20, 50, 50);
		ImageIcon iconoRegresar = new ImageIcon(getClass().getResource("/files/regresar.png"));
		Image imagenEscalada = iconoRegresar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnRegresar.setIcon(new ImageIcon(imagenEscalada));

		btnRegresar.setBorderPainted(false);
		btnRegresar.setContentAreaFilled(false);
		btnRegresar.setFocusPainted(false);
		
		btnRegresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.dispose();
            	DocenteController dc = new DocenteController();
            	dc.docente();
			}
		});
		
		panel.add(btnRegresar);
	    
		ventana.add(panel);
		ventana.repaint();
		ventana.revalidate();
	}
	
	public void EditarDocente(){
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Editar"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true);  
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#fefae0"));
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600);
		
		JLabel lblNewLabel = new JLabel("Editar Docente");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(250, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.LEFT);
		panel.add(lblNewLabel);

        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setBounds(250, 90, 150, 25);
        panel.add(lblNombres);

        JTextField txtNombres = new JTextField("Carlos");
        txtNombres.setBounds(410, 90, 250, 25);
        panel.add(txtNombres);


        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(250, 130, 150, 25);
        panel.add(lblApellidos);

        JTextField txtApellidos = new JTextField("Pérez Gómez");
        txtApellidos.setBounds(410, 130, 250, 25);
        panel.add(txtApellidos);


        JLabel lblFecha = new JLabel("Fecha de nacimiento (dd/mm/aaaa):");
        lblFecha.setBounds(250, 170, 250, 25);
        panel.add(lblFecha);

        JTextField txtFecha = new JTextField("15/04/1980");
        txtFecha.setBounds(500, 170, 160, 25);
        panel.add(txtFecha);
        

        JLabel lblCorreo = new JLabel("Correo electrónico:");
        lblCorreo.setBounds(250, 210, 150, 25);
        panel.add(lblCorreo);

        JTextField txtCorreo = new JTextField("carlos.perez@escuela.edu");
        txtCorreo.setBounds(410, 210, 250, 25);
        panel.add(txtCorreo);


        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(250, 250, 150, 25);
        panel.add(lblTelefono);

        JTextField txtTelefono = new JTextField("6123456789");
        txtTelefono.setBounds(410, 250, 250, 25);
        panel.add(txtTelefono);


        JLabel lblGrado = new JLabel("Grado de estudios:");
        lblGrado.setBounds(250, 290, 150, 25);
        panel.add(lblGrado);

        JTextField txtGrado = new JTextField("Maestría en Física");
        txtGrado.setBounds(410, 290, 250, 25);
        panel.add(txtGrado);
        
        
        JLabel lblMateria = new JLabel("Materia a impartir:");
        lblMateria.setBounds(250, 330, 150, 25);
        panel.add(lblMateria);
        
        JTextField txtMateria = new JTextField("Matemáticas");
        txtMateria.setBounds(410, 330, 250, 25);
        panel.add(txtMateria);
        
        
        JButton btnGuardar = new JButton("Confirmar cambios");
        btnGuardar.setBounds(390, 390, 150, 35);
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		        boolean flag = true;


		        if (txtNombres.getText().equals("")) {
		            txtNombres.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            flag = false;
		        } else {
		            txtNombres.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		        }


		        if (txtApellidos.getText().equals("")) {
		            txtApellidos.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            flag = false;
		        } else {
		            txtApellidos.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		        }


		        if (txtFecha.getText().equals("")) {
		            txtFecha.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            flag = false;
		        } else {
		            txtFecha.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		        }

		 
		        if (txtCorreo.getText().equals("")) {
		            txtCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            flag = false;
		        } else {
		            txtCorreo.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		        }

		     
		        String telefono = txtTelefono.getText();
		        if (telefono.equals("")) {
		            txtTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            flag = false;
		        } else {
		            boolean soloNumeros = true;
		            for (int i = 0; i < telefono.length(); i++) {
		                if (!Character.isDigit(telefono.charAt(i))) {
		                    soloNumeros = false;
		                    break;
		                }
		            }
		            if (soloNumeros == false) {
		                txtTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		                JOptionPane.showMessageDialog(null, "El teléfono debe contener solo números.", "Error", JOptionPane.ERROR_MESSAGE);
		                flag = false;
		            } else {
		                txtTelefono.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		            }
		        }


		        if (txtGrado.getText().equals("")) {
		            txtGrado.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            flag = false;
		        } else {
		            txtGrado.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		        }
		        
		        if (txtMateria.getText().equals("")) {
		        	txtMateria.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		            flag = false;
		        } else {
		        	txtMateria.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		        }

		        if (flag == true) {
		           
		            JOptionPane.showMessageDialog(null, "Se guardaron los cambios con éxito.");
		            ventana.dispose();
	            	DocenteController dc = new DocenteController();
	            	dc.docente();
		        } 
			}
		});
        panel.add(btnGuardar);
		
		
		JButton btnRegresar = new JButton();
		btnRegresar.setBounds(20, 20, 50, 50);
		ImageIcon iconoRegresar = new ImageIcon(getClass().getResource("/files/regresar.png"));
		Image imagenEscalada = iconoRegresar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnRegresar.setIcon(new ImageIcon(imagenEscalada));

		btnRegresar.setBorderPainted(false);
		btnRegresar.setContentAreaFilled(false);
		btnRegresar.setFocusPainted(false);
		
		btnRegresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.dispose();
            	DocenteController dc = new DocenteController();
            	dc.docente();
			}
		});
		
		panel.add(btnRegresar);
	    
		ventana.add(panel);
		ventana.repaint();
		ventana.revalidate();
	}
	
	public void ConsultarDocente(){
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Informacion"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true);  
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#fefae0"));
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600);
		
		JLabel lblNewLabel = new JLabel("Información del docente");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(190, 35, 290, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.LEFT);
		panel.add(lblNewLabel);
		
		int x = 190;
		int x2 = 350;
        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setBounds(x, 90, 150, 25);
        panel.add(lblNombres);

        JTextField txtNombres = new JTextField("Carlos");
        txtNombres.setBounds(x2, 90, 250, 25);
        txtNombres.setEditable(false);
        panel.add(txtNombres);


        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(x, 130, 150, 25);
        panel.add(lblApellidos);

        JTextField txtApellidos = new JTextField("Pérez Gómez");
        txtApellidos.setBounds(x2, 130, 250, 25);
        txtApellidos.setEditable(false);
        panel.add(txtApellidos);


        JLabel lblFecha = new JLabel("Fecha de nacimiento (dd/mm/aaaa):");
        lblFecha.setBounds(x, 170, 250, 25);
        panel.add(lblFecha);

        JTextField txtFecha = new JTextField("15/04/1980");
        txtFecha.setBounds(440, 170, 160, 25);
        txtFecha.setEditable(false);
        panel.add(txtFecha);


        JLabel lblCorreo = new JLabel("Correo electrónico:");
        lblCorreo.setBounds(x, 210, 150, 25);
        panel.add(lblCorreo);

        JTextField txtCorreo = new JTextField("carlos.perez@escuela.edu");
        txtCorreo.setBounds(x2, 210, 250, 25);
        txtCorreo.setEditable(false);
        panel.add(txtCorreo);


        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(x, 250, 150, 25);
        panel.add(lblTelefono);

        JTextField txtTelefono = new JTextField("6123456789");
        txtTelefono.setBounds(x2, 250, 250, 25);
        txtTelefono.setEditable(false);
        panel.add(txtTelefono);


        JLabel lblGrado = new JLabel("Grado de estudios:");
        lblGrado.setBounds(x, 290, 150, 25);
        panel.add(lblGrado);

        JTextField txtGrado = new JTextField("Maestría en Física");
        txtGrado.setBounds(x2, 290, 250, 25);
        txtGrado.setEditable(false);
        panel.add(txtGrado);
        
        JLabel lblMateria = new JLabel("Materia a impartir:");
        lblMateria.setBounds(x, 330, 150, 25);
        panel.add(lblMateria);
        
        JTextField txtMateria = new JTextField("Matemáticas");
        txtMateria.setBounds(x2, 330, 250, 25);
        txtMateria.setEditable(false);
        panel.add(txtMateria);
        
        ImageIcon imagenMaestro = new ImageIcon(getClass().getResource("/files/maestroImagen.png"));
        Image imagenEscalada2 = imagenMaestro.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        JLabel imagen2 = new JLabel(new ImageIcon(imagenEscalada2));
        imagen2.setBounds(680, 90, 160, 160); 
        imagen2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        panel.add(imagen2);
       
       
		JButton btnRegresar = new JButton();
		btnRegresar.setBounds(20, 20, 50, 50);
		ImageIcon iconoRegresar = new ImageIcon(getClass().getResource("/files/regresar.png"));
		Image imagenEscalada = iconoRegresar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnRegresar.setIcon(new ImageIcon(imagenEscalada));

		btnRegresar.setBorderPainted(false);
		btnRegresar.setContentAreaFilled(false);
		btnRegresar.setFocusPainted(false);
		
		btnRegresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.dispose();
            	DocenteController dc = new DocenteController();
            	dc.docente();
			}
		});
		
		panel.add(btnRegresar);
        
		ventana.add(panel);
		ventana.repaint();
		ventana.revalidate();
	}
	
	
	
}
