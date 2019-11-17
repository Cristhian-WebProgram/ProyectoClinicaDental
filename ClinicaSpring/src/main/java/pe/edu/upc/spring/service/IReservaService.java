package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.entity.Reserva;

public interface IReservaService {

public boolean insertar(Reserva Reserva);
	
	public boolean modificar(Reserva Reserva);
	
	public void eliminar(int idReserva);
	
	
	public Reserva listarId(int idReserva);
	
	public Reserva buscarPorId(int idReserva);
	
	public List<Reserva> listar();
	
	List<Reserva> findByReserva(String nombreReserva);
	
}