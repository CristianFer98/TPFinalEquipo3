package ar.edu.unlam.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Doctor;

public class ConexBaseDeDatosTEST extends SpringTest{

	@Test
	@Transactional @Rollback
	public void testGuardarDoctor() {
		Doctor doctor= givenExisteDoctor();
		Long id= whenGuardoElDoctor(doctor);
		thenLaPuedoBuscarPorId(id); 		
	}

	private Long whenGuardoElDoctor(Doctor doctor) {
		session().save(doctor);
        return doctor.getIdDoctor();
	}

	private Doctor givenExisteDoctor() {
		Doctor doctor = new Doctor();
        doctor.setNombre("Esteban");
        return doctor;
	}

    private void thenLaPuedoBuscarPorId(Long id) {
        Doctor buscada = session().get(Doctor.class, id);
        assertThat(buscada).isNotNull();
    }
	
}
