package pe.edu.upc.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.repository.IEspecialistaDAO;
import pe.edu.upc.spring.entity.Especialista;

import pe.edu.upc.spring.service.IEspecialistaService;



@Service
public class EspecialistaServiceImpl implements IEspecialistaService {

	@Autowired
	private IEspecialistaDAO hEspecialista;
	
	@Override
	@Transactional
	public boolean insertar(Especialista Especialista) {
	
		Especialista objEspecialista = hEspecialista.save(Especialista);
		if (objEspecialista == null) {
			return false;
		}
		else {return true;}
	}

	@Override
	@Transactional
	public boolean modificar(Especialista Especialista) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			hEspecialista.save(Especialista);
			flag=true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idEspecialista) {
		// TODO Auto-generated method stub
		hEspecialista.delete(idEspecialista);
	}

	@Override
	@Transactional(readOnly=true)
	public Especialista listarId(int idEspecialista) {
		// TODO Auto-generated method stub
		return hEspecialista.findOne(idEspecialista);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Especialista> listar() {
		// TODO Auto-generated method stub
		return hEspecialista.findAll();
	}

	@Override
	public List<Especialista> findByEspecialista(String nombreEspecialista) {
		return hEspecialista.findByEspecialista(nombreEspecialista);
	}
	
	
	
}
