package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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

import controllers.HomeController;
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
        panel1.setSize(930, 600);
        panel1.setLocation(500, 0);
        panel1.setBackground(Color.decode("#f5ebe0")); 
        panel1.setLayout(null);

        JLabel etiqueta1 = new JLabel("Nombre de usuario:");
        etiqueta1.setSize(150, 30);
        etiqueta1.setLocation(320, 80);
        etiqueta1.setForeground(Color.DARK_GRAY); 
        etiqueta1.setFont(new Font("Georgia", Font.BOLD, 14));
        panel1.add(etiqueta1);
        
        JTextField usuario = new JTextField();
        usuario.setSize(270, 30);
        usuario.setLocation(320, 110);
        usuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        usuario.setBackground(Color.WHITE);
        panel1.add(usuario);

        JLabel etiqueta2 = new JLabel("Contraseña:");
        etiqueta2.setSize(150, 30);
        etiqueta2.setLocation(320, 160);
        etiqueta2.setForeground(Color.DARK_GRAY); 
        etiqueta2.setFont(new Font("Georgia", Font.BOLD, 14));
        panel1.add(etiqueta2);
        
        JPasswordField contrasena = new JPasswordField();
        contrasena.setSize(270, 30);
        contrasena.setLocation(320, 190);
        contrasena.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        contrasena.setBackground(Color.WHITE);
        panel1.add(contrasena);

        
        ImageIcon iconUsuario = new ImageIcon(getClass().getResource("/files/usuario.png"));
        Image imagenEscalada = iconUsuario.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel imagen = new JLabel(new ImageIcon(imagenEscalada));
        imagen.setBounds(270, 110, 50, 30); 
        panel1.add(imagen);
        
        

        ImageIcon iconCandado = new ImageIcon(getClass().getResource("/files/candado.png"));
        Image imagenEscalada2 = iconCandado.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel imagen2 = new JLabel(new ImageIcon(imagenEscalada2));
        imagen2.setBounds(270, 190, 50, 30); 
        panel1.add(imagen2);

        

       
        JButton boton = new JButton("Acceder");
        boton.setBounds(370, 270, 170, 50);
        boton.setFont(new Font("Arial", Font.BOLD, 18));
        boton.setBackground(Color.decode("#2ECC71")); 
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
                	
                	ventana.dispose();
                	HomeController hc = new HomeController();
                	hc.home();
                }
            }
        });
        
        panel1.add(boton);
        
        
        
        panel1.revalidate();
        panel1.repaint();
    }
}