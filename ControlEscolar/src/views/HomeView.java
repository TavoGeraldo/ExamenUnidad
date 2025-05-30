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

import controllers.AlumnoController;
import controllers.AuthController;
import controllers.DocenteController;
import controllers.HomeController;
import models.AuthModel;

public class HomeView {

	public HomeView() {
	}

	public void home() {
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
		btnNewButton2.setBorderPainted(false);

		ImageIcon iconoAlumnos = new ImageIcon(getClass().getResource("/files/alumno.png"));
		Image imagenEscalada = iconoAlumnos.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		btnNewButton2.setIcon(iconoEscalado);

		btnNewButton2.setIconTextGap(10);
		btnNewButton2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton2.setHorizontalTextPosition(SwingConstants.CENTER);

		btnNewButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.dispose();
				AlumnoController ac = new AlumnoController();
				ac.alumno();
			}
		});

		panel.add(btnNewButton2);

		JButton btnNewButton3 = new JButton("Docentes");
		btnNewButton3.setBackground(Color.GRAY);
		btnNewButton3.setOpaque(true);
		btnNewButton3.setForeground(new Color(0, 0, 0));
		btnNewButton3.setBounds(505, 190, 200, 200);
		btnNewButton3.setFocusPainted(false);
		btnNewButton3.setBorderPainted(false);

		ImageIcon iconoDocente = new ImageIcon(getClass().getResource("/files/maestro.png"));
		Image imagenEscalada2 = iconoDocente.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado2 = new ImageIcon(imagenEscalada2);
		btnNewButton3.setIcon(iconoEscalado2);

		btnNewButton3.setIconTextGap(10);
		btnNewButton3.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton3.setHorizontalTextPosition(SwingConstants.CENTER);

		btnNewButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.dispose();
				DocenteController dc = new DocenteController();
				dc.docente();
			}
		});

		panel.add(btnNewButton3);

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
}
