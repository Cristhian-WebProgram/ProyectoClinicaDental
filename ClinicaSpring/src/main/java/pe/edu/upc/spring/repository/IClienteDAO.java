package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.entity.Cliente;

@Repository
public interface IClienteDAO extends JpaRepository<Cliente, Integer>{
	
	@Query("from Cliente p where p.nombreCliente like %:nombreCliente% ")
	public List<Cliente> findByNameCliente(String nombreCliente);
}
