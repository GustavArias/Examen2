package pe.com.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.model.AreaEntity;
import pe.com.cibertec.repository.AreaRepository;
import pe.com.cibertec.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaRepository areaRepository;
	
	@Override
	public List<AreaEntity> listarArea() {
		// TODO Auto-generated method stub
		return areaRepository.findAll();
	}

}
