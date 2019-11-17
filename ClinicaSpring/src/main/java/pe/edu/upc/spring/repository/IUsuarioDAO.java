package pe.edu.upc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.entity.Usuario;


@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {

	@Query("from Usuario r where e.nameUsuario like %:nameUsuario% ")
	public Usuario findByUsername(String username);

}
