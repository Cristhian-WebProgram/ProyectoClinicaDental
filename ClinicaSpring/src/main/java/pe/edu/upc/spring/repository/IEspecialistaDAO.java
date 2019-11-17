package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.entity.Especialista;

@Repository
public interface IEspecialistaDAO extends JpaRepository<Especialista,Integer>{
	
	@Query("from Especialista p where p.nombreEspecialista like %:nombreEspecialista% ")
	List<Especialista>findByNameEspecialista (@Param("nombreEspecialista")String nombreEspecialista);

}
