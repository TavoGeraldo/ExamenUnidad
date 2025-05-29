package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import models.AuthModel;

public class AuthView {

    public AuthView() {
        // Constructor
    }
    
    public void login() {
        JFrame ventana = new JFrame();
        
        ventana.setVisible(true);
        ventana.setSize(930, 600);
        ventana.setLocationRelativeTo(null); 
        ventana.setTitle("Login"); 
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        ventana.setResizable(true); 
        
        JPanel panel1 = new JPanel();
        ventana.add(panel1);

        panel1.setOpaque(true);
        panel1.setSize(500, 700);
        panel1.setLocation(500, 0);
        panel1.setBackground(Color.decode("#023e8a")); // Azul oscuro
        panel1.setLayout(null);

        // Etiquetas (Texto blanco/amarillo)
        JLabel etiqueta1 = new JLabel("Nombre de usuario:");
        etiqueta1.setSize(150, 30);
        etiqueta1.setLocation(170, 80);
        etiqueta1.setForeground(Color.WHITE); // Amarillo
        etiqueta1.setFont(new Font("Georgia", Font.BOLD, 14));
        panel1.add(etiqueta1);

        JLabel etiqueta2 = new JLabel("Contraseña:");
        etiqueta2.setSize(150, 30);
        etiqueta2.setLocation(170, 160);
        etiqueta2.setForeground(Color.WHITE); // Blanco
        etiqueta2.setFont(new Font("Georgia", Font.BOLD, 14));
        panel1.add(etiqueta2);

        JLabel etiqueta4 = new JLabel("¿Olvidó su contraseña?");
        etiqueta4.setSize(180, 30);
        etiqueta4.setLocation(290, 220);
        etiqueta4.setForeground(Color.WHITE); // Oro
        etiqueta4.setFont(new Font("Arial", Font.ITALIC, 12));
        panel1.add(etiqueta4);

        JCheckBox caja = new JCheckBox("Recordarme");
        caja.setSize(110, 30);
        caja.setLocation(170, 220);
        caja.setForeground(Color.WHITE);
        caja.setFont(new Font("Arial", Font.PLAIN, 12));
        caja.setContentAreaFilled(false);
        panel1.add(caja);

        // Campos de texto (con fondo claro)
        JPasswordField contrasena = new JPasswordField();
        contrasena.setSize(270, 30);
        contrasena.setLocation(170, 190);
        contrasena.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        contrasena.setBackground(Color.WHITE);
        panel1.add(contrasena);

        JTextField usuario = new JTextField();
        usuario.setSize(270, 30);
        usuario.setLocation(170, 110);
        usuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        usuario.setBackground(Color.WHITE);
        panel1.add(usuario);

        // Botones con colores vibrantes
        JButton boton = new JButton("Acceder");
        boton.setBounds(220, 270, 170, 50);
        boton.setFont(new Font("Arial", Font.BOLD, 18));
        boton.setBackground(new Color(40, 167, 69)); // Verde (#28a745)
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag1 = false, flag2 = false;
                
                if(usuario.getText().equals("")) {
                    usuario.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                } else {
                    usuario.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                    flag1 = true;
                }
                
                String miContra = new String(contrasena.getPassword());
                
                if(miContra.equals("")) {
                    contrasena.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                } else {
                    contrasena.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                    flag2 = true;
                }
                
                if(flag1 && flag2) {
                	
                	
                }
            }
        });
        
        panel1.add(boton);
        
        JButton irRegistro = new JButton("Ir a registro");
        irRegistro.setBounds(220, 370, 170, 50);
        irRegistro.setFont(new Font("Arial", Font.BOLD, 18));
        irRegistro.setBackground(new Color(0, 130, 155)); // Azul turquesa (#00829B)
        irRegistro.setForeground(Color.WHITE);
        irRegistro.setFocusPainted(false);
        
        irRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para ir a registro
        		
 				ventana.dispose();
 				AuthView.this.register();
            }
        });
        
        panel1.add(irRegistro);
        
        panel1.revalidate();
        panel1.repaint();
    }
    
    public void register() {
    	
        JFrame ventana = new JFrame();
        
        ventana.setVisible(true);
        ventana.setSize(930, 600);
        ventana.setLocationRelativeTo(null); 
        ventana.setTitle("Login"); 
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        ventana.setResizable(true); 
        
        JPanel panel2 = new JPanel();
        ventana.add(panel2);
    	
    	

		panel2.setBackground(Color.decode("#adb5bd"));
		panel2.setOpaque(true);
		panel2.setSize(1000, 700);
		panel2.setLocation(0, 0);
		panel2.setLayout(null);

		JLabel etiqueta1 = new JLabel("Nombre de usuario:");
		etiqueta1.setSize(150, 30);
		etiqueta1.setLocation(180, 40);
		etiqueta1.setFont(new Font("Georgia", Font.BOLD, 14));
		panel2.add(etiqueta1);

		JTextField usuario = new JTextField();
		usuario.setSize(300, 30);
		usuario.setLocation(180, 70);
		usuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		panel2.add(usuario);

		JLabel etiqueta2 = new JLabel("Descripción personal:");
		etiqueta2.setSize(170, 30);
		etiqueta2.setLocation(180, 110);
		etiqueta2.setFont(new Font("Georgia", Font.BOLD, 14));

		panel2.add(etiqueta2);

		JTextArea bioArea = new JTextArea();
		bioArea.setSize(300, 60);
		bioArea.setLocation(180, 140);
		

		panel2.add(bioArea);

		JLabel etiqueta3 = new JLabel("Preferencias");
		etiqueta3.setSize(150, 30);
		etiqueta3.setLocation(270, 210);
		etiqueta3.setFont(new Font("Georgia", Font.BOLD, 14));
		panel2.add(etiqueta3);

		JCheckBox caja1 = new JCheckBox("Dulce");
		caja1.setSize(60, 30);
		caja1.setLocation(180, 240);
		caja1.setBackground(null);
		panel2.add(caja1);

		JCheckBox caja2 = new JCheckBox("Salado");
		caja2.setSize(80, 30);
		caja2.setLocation(260, 240);
		caja2.setBackground(null);
		panel2.add(caja2);

		JCheckBox caja3 = new JCheckBox("Amargo");
		caja3.setSize(80, 30);
		caja3.setLocation(350, 240);
		caja3.setBackground(null);
		panel2.add(caja3);

		String[] col = { "Centro", "Camino Real", "Pedregal", "Diana Laura" };
		JComboBox colonias = new JComboBox(col);
		colonias.setSize(300, 30);
		colonias.setFont(new Font("Georgia", Font.PLAIN, 14));
		colonias.setLocation(180, 280);
		panel2.add(colonias);

		JLabel etiqueta4 = new JLabel("Términos");
		etiqueta4.setSize(150, 30);
		etiqueta4.setLocation(280, 320);
		etiqueta4.setFont(new Font("Georgia", Font.BOLD, 14));
		panel2.add(etiqueta4);

		JRadioButton aceptar = new JRadioButton("Acepto los términos");
		aceptar.setSize(150, 30);
		aceptar.setLocation(180, 340);
		aceptar.setBackground(null);
		panel2.add(aceptar);

		JRadioButton noAceptar = new JRadioButton("No acepto los términos");
		noAceptar.setSize(160, 30);
		noAceptar.setLocation(330, 340);
		noAceptar.setBackground(null);
		panel2.add(noAceptar);

		ButtonGroup group = new ButtonGroup();
		group.add(aceptar);
		group.add(noAceptar);

		JButton boton = new JButton("Crear");
		boton.setSize(190, 50);
		boton.setLocation(230, 380);
		boton.setFont(new Font("Arial", Font.BOLD, 18));
		boton.setBackground(Color.decode("#28a745"));
		boton.setForeground(Color.WHITE);
		
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean flag1 = false, flag2 = false;
				
				if(usuario.getText().equals("")) {
					usuario.setBorder(BorderFactory.createLineBorder(Color.RED,3));
				}else {
					usuario.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
					flag1 = true;
				}
				if(bioArea.getText().equals("")) {
					bioArea.setBorder(BorderFactory.createLineBorder(Color.RED,3));
				}else {
					bioArea.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
					flag2 = true;
				}
				
				
				
			}
		});
		
		panel2.add(boton);
		
		JButton irLogin = new JButton("Ir al login");
		irLogin.setSize(190, 50);
		irLogin.setLocation(230, 470);
		irLogin.setFont(new Font("Arial", Font.BOLD, 18));
		irLogin.setBackground(Color.decode("#00829B"));
		irLogin.setForeground(Color.WHITE);
		
		
		irLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
 				ventana.dispose();
 				AuthView.this.login();
				
			}
		});
		
		panel2.add(irLogin);
    }
}