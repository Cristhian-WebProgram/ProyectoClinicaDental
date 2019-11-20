package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.entity.Promocion;

import pe.edu.upc.spring.repository.IPromocionDAO;
import pe.edu.upc.spring.service.IPromocionService;

@Service
public class PromocionServiceImpl implements IPromocionService {

	@Autowired
	private IPromocionDAO cPromocion;
	
	@Override
	@Transactional
	public boolean insertar(Promocion Promocion) {
		Promocion objPromocion = cPromocion.save(Promocion);
		if (objPromocion == null) {
			return false;
		}
		else {return true;}
	}

	@Override
	@Transactional
	public boolean modificar(Promocion Promocion) {
		boolean flag=false;
		try {
			cPromocion.save(Promocion);
			flag=true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idPromocion) {
		cPromocion.delete(idPromocion);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Promocion listarId(int idPromocion) {
		return cPromocion.findOne(idPromocion);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Promocion> listar() {
		return cPromocion.findAll();
	}
	
	@Override
	public Promocion buscarId(int idPromocion) {
		return cPromocion.findOne(idPromocion);
	}
	

}