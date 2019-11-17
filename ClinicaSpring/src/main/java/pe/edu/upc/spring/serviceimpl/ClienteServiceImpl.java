package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.entity.Cliente;
import pe.edu.upc.spring.repository.IClienteDAO;
import pe.edu.upc.spring.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDAO cCliente;
	
	@Override
	@Transactional
	public boolean insertar(Cliente cliente) {
		Cliente objCliente = cCliente.save(cliente);
		if (objCliente == null) {
			return false;
		}
		else {return true;}
	}

	@Override
	@Transactional
	public boolean actualizar(Cliente cliente) {
		boolean flag=false;
		try {
			cCliente.save(cliente);
			flag=true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idCliente) {
		cCliente.delete(idCliente);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente listarId(int idCliente) {
		return cCliente.findOne(idCliente);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cliente> listar() {
		return cCliente.findAll();
	}

	@Override
	public List<Cliente> findByCliente(String nombreCliente) {
		return cCliente.findByNameCliente(nombreCliente);
	}
	
}
