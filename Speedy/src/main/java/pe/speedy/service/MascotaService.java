package pe.speedy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.speedy.model.Mascota;
import pe.speedy.repository.MascotaRepository;

@Service
@Transactional
public class MascotaService {

	@Autowired
	private MascotaRepository repositorio;
	
	public List<Mascota> buscarTodo() {
		return (List<Mascota>) repositorio.findAll();
	}

	public Mascota crear(Mascota mascota) {
		return repositorio.save(mascota);
	}
	
	public Mascota actualizar(Mascota mascotaActualizar) {

		Mascota mascotaActual = repositorio.findById(mascotaActualizar.getIdMascota()).get();

		mascotaActual.setIdMascota(mascotaActualizar.getIdMascota());
		mascotaActual.setNombreMascota(mascotaActualizar.getNombreMascota());
		mascotaActual.setEdad(mascotaActualizar.getEdad());


		Mascota mascotaActualizado = repositorio.save(mascotaActual);

		return mascotaActualizado;

	}
	
	public Mascota buscarPorID(Integer idMascota) {
		return repositorio.findById(idMascota).get();

	}

	public void borrarPorID(Integer idMascota) {
		repositorio.deleteById(idMascota);
	}
}
