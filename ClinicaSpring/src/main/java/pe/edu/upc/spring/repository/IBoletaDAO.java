package pe.edu.upc.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.entity.Boleta;

@Repository
public interface IBoletaDAO extends JpaRepository <Boleta,Integer> {

	@Query("select v from Boleta v  p join fetch v.boletaDetalle bd join fetch bd.idServicio where v.id=?1")
	Optional<Boleta> fetchByVoucherIdWithPatientWhithVoucherDetailWithMedicine(int id);	
}