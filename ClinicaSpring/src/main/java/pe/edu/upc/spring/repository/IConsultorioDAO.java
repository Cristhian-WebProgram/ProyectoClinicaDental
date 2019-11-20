package pe.edu.upc.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.upc.spring.entity.Consultorio;


public interface IConsultorioDAO extends JpaRepository<Consultorio,Integer>{
	
	@Query("from Consultorio p where p.idConsultorio like %:idConsultorio% ")
	public List<Consultorio> findByConsultorio (int idConsultorio);
}