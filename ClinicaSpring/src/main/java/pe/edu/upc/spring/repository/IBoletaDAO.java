package pe.edu.upc.spring.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.entity.Boleta;

@Repository
public interface IBoletaDAO extends JpaRepository <Boleta,Integer> {	


//@Query("select p from Boleta p join fetch p.idReserva p join fetch p.DetalleBoleta bd join fetch bd.idServicio where p.idboleta=?1")
//Optional<Boleta> fetchByVoucherIdWithPatientWhithVoucherDetailWithMedicine(int idboleta);



}