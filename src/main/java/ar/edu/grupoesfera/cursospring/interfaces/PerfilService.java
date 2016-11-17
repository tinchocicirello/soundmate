package ar.edu.grupoesfera.cursospring.interfaces;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface PerfilService {
	public Usuario buscarPerfilUsuario (String nombreUsuario);
	public Banda buscarPerfilBanda (String nombreBanda);
}