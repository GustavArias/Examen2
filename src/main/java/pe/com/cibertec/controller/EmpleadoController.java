package pe.com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pe.com.cibertec.model.AreaEntity;
import pe.com.cibertec.model.EmpleadoEntity;
import pe.com.cibertec.service.AreaService;
import pe.com.cibertec.service.EmpleadoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller

public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private AreaService areaService;
	
	
	@GetMapping("/listar_empleado")
	public String listarEmpleado(Model model) {
		List<EmpleadoEntity>listaEmpleado = empleadoService.buscarTodosEmpleados();
		model.addAttribute("lst_empleado",listaEmpleado);
		
		return "listar_empleado";
	}
	
	@GetMapping("/detalle_empleado/{id}")
	public String verDetalle(Model model, @PathVariable("id")Integer id) {
		EmpleadoEntity empleadoEncontrado = empleadoService.buscarUsuarioPorId(id);
		model.addAttribute("user",empleadoEncontrado);
		
		return "detalle_empleado";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmpleado(@PathVariable("id")Integer id) {
		empleadoService.eliminarEmpleado(id);
		
		return "redirect:/listar_empleado";
	}
	
	@GetMapping("/registrar_usuario")
	public String mostrarRegistrarEmpleado(Model model) {
		List<AreaEntity>listaArea = areaService.listarArea();
		model.addAttribute("area",listaArea);
		model.addAttribute("user", new EmpleadoEntity());
		
		return "registrar_empleado";
	}
	
	@PostMapping("/registrar_empleado")
	public String registrarEmpleado(@ModelAttribute("empleado")EmpleadoEntity emple,Model model) {
		empleadoService.crearEmpleado(emple);
		
		
		return "redirect:/listar_empleado";
	}
	
	@GetMapping("/editar_empleado/{id}")
	public String mostrarEditarUsuario(@PathVariable("id")Integer id, Model model) {
		EmpleadoEntity empleadoEncontrado = empleadoService.buscarUsuarioPorId(id);
		model.addAttribute("user",empleadoEncontrado);
		return "editar_empleado";
	}
	
	@PostMapping("/editar_empleado/{id}")
	public String editarEmpleado(@PathVariable("id")Integer id, @ModelAttribute("user") EmpleadoEntity user, Model model) {
		
		empleadoService.actualizarEmpleado(id, user);
		
		return "redirect:/listar_empleado";
	}
	
}
