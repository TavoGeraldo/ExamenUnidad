package controllers;

import views.AlumnoView;


public class AlumnoController {
	
	private AlumnoView vista;

	public AlumnoController() {
		
		vista = new AlumnoView();
	}
	
	public void alumno()
	{
		vista.alumno();
	}
}
