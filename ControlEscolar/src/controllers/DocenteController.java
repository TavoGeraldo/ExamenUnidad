package controllers;


import views.DocenteView;

public class DocenteController {
	
	private DocenteView vista;

	public DocenteController() {
		
		vista = new DocenteView();
	}
	
	public void docente()
	{
		vista.docente();
	}
	public void CrearDocente()
	{
		vista.CrearDocente();
	}
	public void EditarDocente()
	{
		vista.EditarDocente();
	}
	
	public void ConsultarDocente()
	{
		vista.ConsultarDocente();
	}
}
