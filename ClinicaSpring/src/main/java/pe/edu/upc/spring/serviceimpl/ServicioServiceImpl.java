package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.entity.Servicio;

import pe.edu.upc.spring.repository.IServicioDAO;
import pe.edu.upc.spring.service.IServicioService;

@Service
public class ServicioServiceImpl implements IServicioService{

	@Autowired
	private IServicioDAO rServicio;

	@Override
	@Transactional
	public boolean insertar(Servicio Servicio) {
		Servicio objServicio = rServicio.save(Servicio);
		if (objServicio == null) {
			return false;
		}
		else {return true;}
	}
	
	@Override
	@Transactional
	public boolean modificar(Servicio Servicio) {
		boolean flag=false;
		try {
			rServicio.save(Servicio);
			flag=true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idServicio) {
		rServicio.delete(idServicio);
	}

	@Override
	@Transactional(readOnly=true)
	public Servicio listarId(int idServicio) {
		return rServicio.findOne(idServicio);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Servicio> listar() {
	
		return rServicio.findAll();
	}

	@Override
	public List<Servicio> findByNameServicio(String nombreServicio) {
		return rServicio.findByNameServicio(nombreServicio);
	}
	
	
	@Override
	public Servicio buscarPorId(int idServicio) {
		return rServicio.findOne(idServicio);
	}
	
	
	
}
