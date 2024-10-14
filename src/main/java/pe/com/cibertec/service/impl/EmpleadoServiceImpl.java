package pe.com.cibertec.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.model.EmpleadoEntity;
import pe.com.cibertec.repository.EmpleadoRepository;
import pe.com.cibertec.service.EmpleadoService;

@Service

public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public List<EmpleadoEntity> buscarTodosEmpleados() {
		
		return empleadoRepository.findAll();
	}

	@Override
	public void crearEmpleado(EmpleadoEntity empleadoEntity) {
		
		empleadoRepository.save(empleadoEntity);
		
	}
	
	@Override
	public EmpleadoEntity buscarUsuarioPorId(Integer id) {
		
		return empleadoRepository.findById(id).get();
	}
	
	@Override
	public void actualizarEmpleado(Integer id, EmpleadoEntity empleadoNuevo) {
		EmpleadoEntity empleadoEncontrado = buscarUsuarioPorId(id);
		if(empleadoEncontrado == null) {
			throw new RuntimeException("Empleado no encontrado");
		}
		try {
			empleadoEncontrado.setNombre(empleadoNuevo.getNombre());
			empleadoEncontrado.setApellido(empleadoNuevo.getApellido());
			empleadoRepository.save(empleadoEncontrado);
		} catch (Exception e) {
			throw new RuntimeException("Ocurrio un error al actualizar");
		}
		
	}

	@Override
	public void eliminarEmpleado(Integer id) {
		
		EmpleadoEntity empleadoEncontrado = buscarUsuarioPorId(id);
		if(empleadoEncontrado != null) {
			empleadoRepository.delete(empleadoEncontrado);
		}	
	}

}
