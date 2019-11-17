package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.entity.ProgramacionMensual;

import pe.edu.upc.spring.repository.IProgramacionMensualDAO;
import pe.edu.upc.spring.service.IProgramacionMensualService;

@Service
public class ProgramacionMensualServiceImpl implements IProgramacionMensualService {

	@Autowired
	private IProgramacionMensualDAO cProgramacionMensual;
	
	@Override
	@Transactional
	public boolean insertar(ProgramacionMensual ProgramacionMensual) {
		ProgramacionMensual objProgramacionMensual = cProgramacionMensual.save(ProgramacionMensual);
		if (objProgramacionMensual == null) {
			return false;
		}
		else {return true;}
	}

	@Override
	@Transactional
	public boolean modificar(ProgramacionMensual ProgramacionMensual) {
		boolean flag=false;
		try {
			cProgramacionMensual.save(ProgramacionMensual);
			flag=true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idProgramacionMensual) {
		cProgramacionMensual.delete(idProgramacionMensual);
		
	}

	@Override
	@Transactional(readOnly=true)
	public ProgramacionMensual listarId(int idProgramacionMensual) {
		return cProgramacionMensual.findOne(idProgramacionMensual);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProgramacionMensual> listar() {
		return cProgramacionMensual.findAll();
	}
	
	@Override
	public List<ProgramacionMensual> findByProgramacionMensual(String nombreProgramacionMensual) {
		return cProgramacionMensual.findByNameProgramacionMensual(nombreProgramacionMensual);
	}
}
