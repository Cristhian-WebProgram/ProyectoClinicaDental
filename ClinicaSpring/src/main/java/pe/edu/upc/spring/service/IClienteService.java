package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.entity.Cliente;



public interface IClienteService {

	public boolean insertar(Cliente cliente);
	public boolean actualizar(Cliente cliente);
	public void eliminar(int DNI);
	public List<Cliente> listar();
	public Cliente listarId(int DNI);
	public List<Cliente> findByNameCliente(String nombreCliente);

}
