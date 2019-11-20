package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.entity.ProgramacionMensual;

@Repository
public interface IProgramacionMensualDAO extends JpaRepository<ProgramacionMensual,Integer>{
	
	
	@Query("from ProgramacionMensual p where p.idProgramacionMensual like %:idProgramacionMensual% ")
	public List<ProgramacionMensual> findByProgramacionMensual(int idProgramacionMensual);

}
