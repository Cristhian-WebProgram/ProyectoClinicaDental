package pe.edu.upc.spring.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.entity.Consultorio;

import pe.edu.upc.spring.repository.IConsultorioDAO;
import pe.edu.upc.spring.service.IConsultorioService;

@Service
public class ConsultorioServiceImpl implements IConsultorioService {

	@Autowired
	private IConsultorioDAO hConsultorio;
	
	@Override
	@Transactional
	public boolean insertar(Consultorio Consultorio) {
	
		Consultorio objConsultorio = hConsultorio.save(Consultorio);
		if (objConsultorio == null) {
			return false;
		}
		else {return true;}
	}

	@Override
	@Transactional
	public boolean modificar(Consultorio Consultorio) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			hConsultorio.save(Consultorio);
			flag=true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idConsultorio) {
		// TODO Auto-generated method stub
		hConsultorio.delete(idConsultorio);
	}

	@Override
	@Transactional(readOnly=true)
	public Consultorio listarId(int idConsultorio) {
		// TODO Auto-generated method stub
		return hConsultorio.findOne(idConsultorio);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Consultorio> listar() {
		// TODO Auto-generated method stub
		return hConsultorio.findAll();
	}

	@Override
	public Consultorio buscarId(int idConsultorio) {
		return hConsultorio.findOne(idConsultorio);
	}
	
}
