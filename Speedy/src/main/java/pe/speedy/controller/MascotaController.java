package pe.speedy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.speedy.model.Mascota;
import pe.speedy.service.MascotaService;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

	
	@Autowired
	private MascotaService servicio;
	
	@RequestMapping("/listarTodo")
	public String listarMascota(Model model) {
		List<Mascota> listaMascota = servicio.buscarTodo();
		
		model.addAttribute("listaMascotas", listaMascota);
		return "listaMascota";
	}
	
	@RequestMapping("/nuevo")
	public String nuevaMascota(Model model) {
		Mascota mascota  = new Mascota();
		model.addAttribute("", mascota);
		return "registrarMascota";
		
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearMascota(@ModelAttribute("mascota") Mascota mascota) {
		    servicio.crear(mascota);
		    return "redirect:/mascota/listarTodo";
	
	}
	
	@RequestMapping(value = "/actualizar/{idMascota}")
	public ModelAndView editarMascota(@PathVariable(name="idMascota") int idMascota) {
		
		ModelAndView mav = new ModelAndView("editarMascota");
		Mascota mascota = servicio.buscarPorID(idMascota);
		mav.addObject("mascota", mascota );
		return mav;
		
	}
	
	@RequestMapping(value = "/eliminar/{idMascota}")
	public String eliminarCategoria(@PathVariable(name="idMascota") int idMascota) {
		servicio.borrarPorID(idMascota);
		return "redirect:/mascota/listarTodo";
		
	}
}
