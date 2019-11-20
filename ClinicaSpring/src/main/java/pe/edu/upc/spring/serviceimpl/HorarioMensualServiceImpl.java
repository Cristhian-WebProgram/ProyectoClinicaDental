package pe.edu.upc.spring.serviceimpl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.spring.entity.HorarioMensual;

import pe.edu.upc.spring.repository.IHorarioMensualDAO;
import pe.edu.upc.spring.service.IHorarioMensualService;

@Service
public class HorarioMensualServiceImpl implements IHorarioMensualService {

	@Autowired
	private IHorarioMensualDAO cHorarioMensual;
	
	@Override
	@Transactional
	public boolean insertar(HorarioMensual HorarioMensual) {
		HorarioMensual objHorarioMensual = cHorarioMensual.save(HorarioMensual);
		if (objHorarioMensual == null) {
			return false;
		}
		else {return true;}
	}

	@Override
	@Transactional
	public boolean modificar(HorarioMensual HorarioMensual) {
		boolean flag=false;
		try {
			cHorarioMensual.save(HorarioMensual);
			flag=true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idHorarioMensual) {
		cHorarioMensual.delete(idHorarioMensual);
		
	}

	@Override
	@Transactional(readOnly=true)
	public HorarioMensual listarId(int idHorarioMensual) {
		return cHorarioMensual.findOne(idHorarioMensual);
	}

	@Override
	@Transactional(readOnly=true)
	public List<HorarioMensual> listar() {
		return cHorarioMensual.findAll();
	}
	
	@Override
	public HorarioMensual buscarId(int idHorarioMensual) {
		return cHorarioMensual.findOne(idHorarioMensual);
	}
	
}
