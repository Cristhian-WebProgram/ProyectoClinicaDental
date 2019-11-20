package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.entity.HorarioMensual;

@Repository
public interface IHorarioMensualDAO extends JpaRepository<HorarioMensual,Integer>{
	
	@Query("from HorarioMensual p where p.idHorarioMensual like %:idHorarioMensual% ")
	public List<HorarioMensual> findByHorarioMensual(int idHorarioMensual);

}
