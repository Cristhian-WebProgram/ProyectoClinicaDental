package pe.edu.upc.spring.serviceimpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import pe.edu.upc.spring.entity.Reserva;
import pe.edu.upc.spring.repository.IReservaDAO;
import pe.edu.upc.spring.service.IReservaService;

@Service
public class ReservaServiceImpl implements IReservaService{

	@Autowired
	private IReservaDAO rReserva;

	@Override
	@Transactional
	public boolean insertar(Reserva reserva) {
		Reserva objReserva = rReserva.save(reserva);
		if (objReserva == null) {
			return false;
		}
		else {return true;}
	}
	
	@Override
	@Transactional
	public boolean modificar(Reserva reserva) {
		boolean flag=false;
		try {
			rReserva.save(reserva);
			flag=true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idReserva) {
		rReserva.delete(idReserva);
	}

	@Override
	@Transactional(readOnly=true)
	public Reserva listarId(int idReserva) {
		return rReserva.findOne(idReserva);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Reserva> listar() {
	
		return rReserva.findAll();
	}
	@Override
	public Reserva buscarPorId(int idReserva) {
		return rReserva.findOne(idReserva);
	}
	
	
	
	@Override
	public List<Reserva> findByNameReserva(String nombreReserva) {
		return rReserva.findByNameReserva(nombreReserva);
	}

	
}
	