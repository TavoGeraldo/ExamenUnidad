package views;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.AuthController;
import controllers.HomeController;

public class AlumnoView {
	public void alumno() {
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Alumnos"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true);  
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600);
		
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
