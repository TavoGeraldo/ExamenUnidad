package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


import models.AuthModel;

public class HomeView {

	public HomeView() {
	}

	public void home()
	{
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Home"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true);  
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600); 
		
		JLabel lblNewLabel = new JLabel("Control Escolar");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);
		
		
		JButton btnNewButton2 = new JButton("Alumnos");
		btnNewButton2.setBackground(Color.GRAY);
		btnNewButton2.setOpaque(true);
		btnNewButton2.setForeground(new Color(0, 0, 0));
		btnNewButton2.setBounds(205, 190, 200, 200);
		btnNewButton2.setFocusPainted(false);
		
		ImageIcon iconoAlumnos = new ImageIcon(getClass().getResource("/files/alumno.png"));
		Image imagenEscalada = iconoAlumnos.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada); 
		btnNewButton2.setIcon(iconoEscalado);
		
		btnNewButton2.setIconTextGap(10);
		btnNewButton2.setVerticalTextPosition(SwingConstants.BOTTOM);   
		btnNewButton2.setHorizontalTextPosition(SwingConstants.CENTER);
	
		panel.add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("Docentes");
		btnNewButton3.setBackground(Color.GRAY);
		btnNewButton3.setOpaque(true);
		btnNewButton3.setForeground(new Color(0, 0, 0));
		btnNewButton3.setBounds(505, 190, 200, 200);
		btnNewButton3.setFocusPainted(false);

		
		ImageIcon iconoDocente = new ImageIcon(getClass().getResource("/files/maestro.png"));
		Image imagenEscalada2 = iconoDocente.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado2 = new ImageIcon(imagenEscalada2); 
		btnNewButton3.setIcon(iconoEscalado2);
		
		btnNewButton3.setIconTextGap(10);
		btnNewButton3.setVerticalTextPosition(SwingConstants.BOTTOM);   
		btnNewButton3.setHorizontalTextPosition(SwingConstants.CENTER);
		
		panel.add(btnNewButton3);
		
		 
		
		ventana.add(panel);
		ventana.repaint();
		ventana.revalidate();
	}
}
