package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import controllers.AlumnoController;
import controllers.AuthController;
import controllers.DocenteController;
import controllers.HomeController;

public class AlumnoView {
	private DefaultTableModel modelo;
	private JTable tablaDocentes;
	
	public void alumno() {
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Alumnos"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true);  
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#F4F6F7"));
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600);
		
		
		JLabel lblNewLabel = new JLabel("Alumnos");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.BOLD, 24));
		lblNewLabel.setBounds(100, 60, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.LEFT);
		panel.add(lblNewLabel);
		
		
        
        String[] columnas = {"ID", "Nombre", "Turno", "Grupo"};

 
        Object[][] datos = {
        	    {"1", "Carlos Pérez", "Vespertino", "A"},
        	    {"2", "María García", "Matutino", "B"},
        	    {"3", "Luis Martínez", "Vespertino", "C"},
        	    {"4", "Ana López", "Matutino", "A"},
        	    {"5", "Pedro Sánchez", "Vespertino", "B"},
        	    {"6", "Jorge Ramírez", "Matutino", "C"},
        	    {"7", "Sofía Torres", "Vespertino", "A"},
        	    {"8", "Miguel Díaz", "Matutino", "B"},
        	    {"9", "Valeria Mendoza", "Vespertino", "C"},
        	    {"10", "Ricardo Herrera", "Matutino", "A"},
        	    {"11", "Fernanda Ríos", "Vespertino", "B"},
        	    {"12", "Andrés Cruz", "Matutino", "C"},
        	    {"13", "Daniela Flores", "Vespertino", "A"},
        	    {"14", "Emilio Ortega", "Matutino", "B"},
        	    {"15", "Natalia Silva", "Vespertino", "C"},
        	    {"16", "Iván Morales", "Matutino", "A"},
        	    {"17", "Laura Navarro", "Vespertino", "B"},
        	    {"18", "Óscar Castro", "Matutino", "C"},
        	    {"19", "Camila Vega", "Vespertino", "A"},
        	    {"20", "Diego Pineda", "Matutino", "B"},
        	    {"21", "Julia Estrada", "Vespertino", "C"},
        	    {"22", "Héctor Salinas", "Matutino", "A"},
        	    {"23", "Paola Aguirre", "Vespertino", "B"},
        	    {"24", "Manuel Castañeda", "Matutino", "C"},
        	    {"25", "Andrea Robles", "Vespertino", "A"}

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
		
        //boton de crear 
        JLabel lblCrear = new JLabel("Nuevo alumno");
        lblCrear.setBounds(210, 460, 140, 20);
        lblCrear.setForeground(Color.DARK_GRAY);
        lblCrear.setVisible(false); 
        panel.add(lblCrear);
        
        JButton btnCrear = new JButton();
        btnCrear.setBounds(200, 420, 100, 40);
        btnCrear.setFocusPainted(false);
        btnCrear.setBackground(Color.decode("#28a745")); 

        btnCrear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	lblCrear.setVisible(true);
                panel.repaint(); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	lblCrear.setVisible(false);
            }

		});
        
        
        ImageIcon iconoCrear = new ImageIcon(getClass().getResource("/files/agregar.png"));
        Image imagenCrear = iconoCrear.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(imagenCrear);
        btnCrear.setIcon(icon);
        
        btnCrear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.dispose();
				AlumnoController ac = new AlumnoController();
				ac.CrearAlumno();
			}
		});
        
        panel.add(btnCrear);
        
        //boton de editar
        JLabel lbleditar = new JLabel("Editar alumno");
        lbleditar.setBounds(330, 460, 140, 20);
        lbleditar.setForeground(Color.DARK_GRAY);
        lbleditar.setVisible(false); 
        panel.add(lbleditar);
        
        JButton btnEditar = new JButton();
        btnEditar.setBounds(320, 420, 100, 40);
        btnEditar.setFocusPainted(false);
        btnEditar.setBackground(Color.decode("#007bff")); 

        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	lbleditar.setVisible(true);
                panel.repaint(); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	lbleditar.setVisible(false);
            }

		});
        
        
        ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/files/editar.png"));
        Image imagenEditar = iconoEditar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(imagenEditar);
        btnEditar.setIcon(icon2);
        
        btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.dispose();
				AlumnoController ac = new AlumnoController();
				ac.EditarAlumno();
				
			}
		});
        panel.add(btnEditar);

        
        //boton de consultar
        JLabel lblConsultar = new JLabel("Consultar");
        lblConsultar.setBounds(463, 460, 140, 20);
        lblConsultar.setForeground(Color.DARK_GRAY);
        lblConsultar.setVisible(false); 
        panel.add(lblConsultar);
        
        JButton btnConsultar = new JButton();
        btnConsultar.setBounds(440, 420, 100, 40);
        btnConsultar.setFocusPainted(false);
        btnConsultar.setBackground(Color.decode("#A7C7E7")); 

        btnConsultar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	lblConsultar.setVisible(true);
                panel.repaint(); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	lblConsultar.setVisible(false);
            }

		});
        

        
        ImageIcon iconoConsultar = new ImageIcon(getClass().getResource("/files/busqueda.png"));
        Image imagenConsulta = iconoConsultar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon icon3 = new ImageIcon(imagenConsulta);
        btnConsultar.setIcon(icon3);
        
        btnConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.dispose();
				AlumnoController ac = new AlumnoController();
				ac.ConsultarAlumno();
			}
		});
        panel.add(btnConsultar);
        
        
        //boton de eliminar 
        JLabel lblEliminar = new JLabel("Eliminar");
        lblEliminar.setBounds(590, 460, 140, 20);
        lblEliminar.setForeground(Color.DARK_GRAY);
        lblEliminar.setVisible(false); 
        panel.add(lblEliminar);
        
        JButton btnEliminar = new JButton();
        btnEliminar.setBounds(560, 420, 100, 40);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBackground(Color.RED); 

        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	lblEliminar.setVisible(true);
                panel.repaint(); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	lblEliminar.setVisible(false);
            }

		});
        

        ImageIcon iconoDocente = new ImageIcon(getClass().getResource("/files/borrar.png"));
        Image imagenEscalada2 = iconoDocente.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado2 = new ImageIcon(imagenEscalada2);
        btnEliminar.setIcon(iconoEscalado2);

        
        
        btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		        int selectedRow = tablaDocentes.getSelectedRow(); 

		        if (selectedRow != -1) { 

		            int confirmResult = JOptionPane.showConfirmDialog(
		                ventana,
		                "¿Estás seguro de que quieres eliminar a este alumno?","Confirmar Eliminación",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

		            if (confirmResult == JOptionPane.YES_OPTION) {
		               
		                JOptionPane.showMessageDialog(ventana, "Alumno eliminado con éxito.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(ventana, "Por favor, selecciona un alumno  para eliminar.", "Error al eliminar", JOptionPane.WARNING_MESSAGE);
		        }
			}
		});
        panel.add(btnEliminar);
		
		
        //boton para regresar
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
            	HomeController hc = new HomeController();
            	hc.home();
			}
		});
		
		panel.add(btnRegresar);
		
		
		//boton para el logout
		JButton btnCerarSesion = new JButton();
		btnCerarSesion.setBounds(850, 20, 50, 50);
		ImageIcon iconoCerrarSesion = new ImageIcon(getClass().getResource("/files/logout.png"));
		Image imagenEscalada3 = iconoCerrarSesion.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnCerarSesion.setIcon(new ImageIcon(imagenEscalada3));

		btnCerarSesion.setBorderPainted(false);
		btnCerarSesion.setContentAreaFilled(false);
		btnCerarSesion.setFocusPainted(false);

		btnCerarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cerrar sesión?","Confirmar cierre de sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
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
	
	
	public void CrearAlumno(){
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Crear"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true);  
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#F4F6F7"));
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600);
		
		JLabel lblNewLabel = new JLabel("Dar de alta alumno");
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


        JLabel lblGrado = new JLabel("Turno:");
        lblGrado.setBounds(250, 290, 150, 25);
        panel.add(lblGrado);

        JTextField txtGrado = new JTextField();
        txtGrado.setBounds(410, 290, 250, 25);
        panel.add(txtGrado);


        JLabel lblMateria = new JLabel("Grupo:");
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
		           
		            JOptionPane.showMessageDialog(null, "Alumno guardado con éxito.");
		            ventana.dispose();
					AlumnoController ac = new AlumnoController();
					ac.alumno();
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
				AlumnoController ac = new AlumnoController();
				ac.alumno();
			}
		});
		
		panel.add(btnRegresar);
	    
		ventana.add(panel);
		ventana.repaint();
		ventana.revalidate();
	}
	
	public void EditarAlumno(){
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Editar"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true);  
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#F4F6F7"));
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600);
		
		JLabel lblNewLabel = new JLabel("Editar alumno");
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


        JLabel lblGrado = new JLabel("Turno:");
        lblGrado.setBounds(250, 290, 150, 25);
        panel.add(lblGrado);

        JTextField txtGrado = new JTextField("Matutino");
        txtGrado.setBounds(410, 290, 250, 25);
        panel.add(txtGrado);
        
        
        JLabel lblMateria = new JLabel("Grupo:");
        lblMateria.setBounds(250, 330, 150, 25);
        panel.add(lblMateria);
        
        JTextField txtMateria = new JTextField("A");
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
					AlumnoController ac = new AlumnoController();
					ac.alumno();
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
				AlumnoController ac = new AlumnoController();
				ac.alumno();
			}
		});
		
		panel.add(btnRegresar);
	    
		ventana.add(panel);
		ventana.repaint();
		ventana.revalidate();
	}
	
	public void ConsultarAlumno(){
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Informacion"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true);  
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#F4F6F7"));
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600);
		
		JLabel lblNewLabel = new JLabel("Información del alumno");
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


        JLabel lblGrado = new JLabel("Turno:");
        lblGrado.setBounds(x, 290, 150, 25);
        panel.add(lblGrado);

        JTextField txtGrado = new JTextField("Matutino");
        txtGrado.setBounds(x2, 290, 250, 25);
        txtGrado.setEditable(false);
        panel.add(txtGrado);
        
        JLabel lblGrupo = new JLabel("Grupo:");
        lblGrupo.setBounds(x, 330, 150, 25);
        panel.add(lblGrupo);
        
        JTextField txtMateria = new JTextField("A");
        txtMateria.setBounds(x2, 330, 250, 25);
        txtMateria.setEditable(false);
        panel.add(txtMateria);
        
        
        JLabel lblDescargar = new JLabel("Descargar información");
        lblDescargar.setBounds(675, 465, 140, 20);
        lblDescargar.setForeground(Color.DARK_GRAY);
        lblDescargar.setVisible(false); 
        panel.add(lblDescargar);
        
        JButton btnDescargar = new JButton();
        btnDescargar.setBounds(680, 420, 120, 40);
        btnDescargar.setFocusPainted(false);
        btnDescargar.setBackground(Color.decode("#007bff")); 

        btnDescargar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblDescargar.setVisible(true);
                panel.repaint(); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblDescargar.setVisible(false);
            }

		});
        
       
        ImageIcon iconoDescargar = new ImageIcon(getClass().getResource("/files/descarga.png"));
        Image imgEscalada = iconoDescargar.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        btnDescargar.setIcon(new ImageIcon(imgEscalada));
        btnDescargar.setIconTextGap(10);

        btnDescargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ventana, "Información descargada exitosamente.", "Descarga", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panel.add(btnDescargar);
        
        //imagen que simula al alumno
        ImageIcon imagenMaestro = new ImageIcon(getClass().getResource("/files/alumnoImagen.png"));
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
				AlumnoController ac = new AlumnoController();
				ac.alumno();
			}
		});
		
		panel.add(btnRegresar);
        
		ventana.add(panel);
		ventana.repaint();
		ventana.revalidate();
	}
	
	
}
