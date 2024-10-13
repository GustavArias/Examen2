package pe.com.cibertec.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.cibertec.model.EmpleadoEntity;

@Service
public interface EmpleadoService {

	List<EmpleadoEntity>buscarTodosEmpleados();
	EmpleadoEntity buscarUsuarioPorId(Integer id);
	void crearEmpleado(EmpleadoEntity empleadoEntity);
	void actualizarEmpleado(Integer id, EmpleadoEntity empleadoEntity);
	void eliminarEmpleado(Integer id);
}
