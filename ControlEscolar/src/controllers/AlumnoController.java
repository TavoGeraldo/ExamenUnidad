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
	public void CrearAlumno()
	{
		vista.CrearAlumno();
	}
	public void EditarAlumno()
	{
		vista.EditarAlumno();
	}
	public void ConsultarAlumno()
	{
		vista.ConsultarAlumno();
	}
}
