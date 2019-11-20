package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.entity.Promocion;

@Repository
public interface IPromocionDAO extends JpaRepository<Promocion,Integer>{
	
	@Query("from Promocion p where p.idPromocion like %:idPromocion% ")
	public List<Promocion> findByPromocion(int idPromocion);

}
