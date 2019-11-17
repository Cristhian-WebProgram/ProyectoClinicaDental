package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.entity.Boleta;

public interface IBoletaService {

	public Boleta insertar(Boleta Boleta);
	public void eliminar(int idBoleta);
	List<Boleta> listar();
	
	public Boleta buscarPorId(int idBoleta);
	Optional<Boleta> fetchByVoucherIdWithPatientWhithVoucherDetailWithMedicine(int id) throws Exception;
	
	
	
}
