package pe.edu.upc.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.entity.Servicio;

@Repository
public interface IServicioDAO extends JpaRepository<Servicio,Integer>{
	
	@Query("from Servicio p where p.nombre like %:nombre% ")
	public List<Servicio> findByNameServicio(String nombre);

}
