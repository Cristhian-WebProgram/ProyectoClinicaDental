package pe.edu.upc.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.entity.HistorialClinico;
import pe.edu.upc.spring.repository.IHistorialClinicoDAO;
import pe.edu.upc.spring.service.IHistorialClinicoService;

@Service
public class HistorialClinicoServiceImpl implements IHistorialClinicoService {

	@Autowired
	private IHistorialClinicoDAO hHistorialClinico;
	
	@Override
	@Transactional
	public boolean insertar(HistorialClinico HistorialClinico) {
	
		HistorialClinico objHistorialClinico = hHistorialClinico.save(HistorialClinico);
		if (objHistorialClinico == null) {
			return false;
		}
		else {return true;}
	}

	@Override
	@Transactional
	public boolean modificar(HistorialClinico HistorialClinico) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			hHistorialClinico.save(HistorialClinico);
			flag=true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idHistorialClinico) {
		// TODO Auto-generated method stub
		hHistorialClinico.delete(idHistorialClinico);
	}

	@Override
	@Transactional(readOnly=true)
	public HistorialClinico listarId(int idHistorialClinico) {
		// TODO Auto-generated method stub
		return hHistorialClinico.findOne(idHistorialClinico);
	}

	@Override
	@Transactional(readOnly=true)
	public List<HistorialClinico> listar() {
		// TODO Auto-generated method stub
		return hHistorialClinico.findAll();
	}
	
	@Override
	public List<HistorialClinico> findByHistorialClinico(String nombreHistorialClinico) {
		return hHistorialClinico.findByNameHistorialClinico(nombreHistorialClinico);
	}

}
