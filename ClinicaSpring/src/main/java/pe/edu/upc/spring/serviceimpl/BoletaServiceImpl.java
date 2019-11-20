package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.spring.repository.IBoletaDAO;
import pe.edu.upc.spring.entity.Boleta;
import pe.edu.upc.spring.service.IBoletaService;

@Service
public class BoletaServiceImpl implements IBoletaService {


	@Autowired
	private IBoletaDAO boletaDao;

	@Override
	public Boleta insertar(Boleta boleta) {
		return boletaDao.save(boleta);
	}

	@Override
	public void eliminar(int idBoleta) {
		boletaDao.delete(idBoleta);
	}

	@Override
	public List<Boleta> listar() {
		return boletaDao.findAll();
	}

	@Override
	public Optional<Boleta> fetchByVoucherIdWithPatientWhithVoucherDetailWithMedicine(int id) throws Exception {
		return boletaDao.fetchByVoucherIdWithPatientWhithVoucherDetailWithMedicine(id);
	}

  @Override
    public Boleta buscarPorId(int idBoleta) {
	return boletaDao.findOne(idBoleta);
}


}