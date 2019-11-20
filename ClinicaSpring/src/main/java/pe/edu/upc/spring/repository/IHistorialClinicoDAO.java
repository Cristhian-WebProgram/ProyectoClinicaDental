package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.entity.HistorialClinico;

@Repository
public interface IHistorialClinicoDAO extends JpaRepository<HistorialClinico,Integer>{
	
	@Query("from HistorialClinico p where p.idHistorialClinico like %:idHistorialClinico% ")
	public List<HistorialClinico> findByHistorialClinico(int idHistorialClinico);

}
