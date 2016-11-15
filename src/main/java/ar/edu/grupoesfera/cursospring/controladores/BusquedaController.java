package ar.edu.grupoesfera.cursospring.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.BusquedaService;
import ar.edu.grupoesfera.cursospring.modelo.Busqueda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Controller
public class BusquedaController {
	
	@Inject
	public BusquedaService busquedaService;	// A�ado la interface como atributo del controlador
	
	@RequestMapping(path="/busqueda")
	public ModelAndView search(HttpServletRequest request){
		
		ModelMap search = new ModelMap();
		Busqueda busqueda = new Busqueda();
		search.addAttribute(busqueda);
		
		return new ModelAndView("busqueda", search);
		
	}
	
	@RequestMapping(path="/resultadoBusqueda", method = RequestMethod.POST)
	public ModelAndView busquedaRol(@ModelAttribute("busqueda") Busqueda busqueda){
		
		List<Usuario> listaResultados = busquedaService.buscarUsuarios(busqueda);	// Pasamos al servicio el objeto "busqueda" de tipo "Busqueda", y obtenemos una lista de Usuarios
																					// con la lista de resultados de usuarios del instrumento buscado
		
		ModelMap resultado = new ModelMap();			// Creamos un modelmap y le asignamos la lista de resultados
		resultado.addAttribute("resultados",listaResultados);
		
		return new ModelAndView("resultadoBusqueda",resultado);
	}
	
}