package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.entity.Reserva;

@Repository
public interface IReservaDAO extends JpaRepository<Reserva,Integer>{
	
	@Query("from Reserva r where e.nombreReserva like %:nombreReserva% ")
	List<Reserva> findByNameReserva(String nombreReserva);

}
