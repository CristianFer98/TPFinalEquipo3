package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.text.ParseException;
import java.time.LocalDateTime;

import javax.annotation.meta.When;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuario;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSesionMedico;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioLogueado;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ServicioUsuarioLogueadoTest {
	private RepositorioUsuarioLogueado repositorio; // el servicio que va a ser un MOCK
	private ServicioUsuarioLogueado servicio; // el registro que me va hacer los metodos
	

	@Before
	public void testQueSeHaceDespuesDeCadaTest() {// este before se hace despues de cada test

		repositorio = mock(RepositorioUsuarioLogueado.class); // me crea un mokito que es un objeto para separar y probar
		servicio = new ServicioUsuarioLogueadoImpl(repositorio);// individualmente las capas
	}

	@Test
	public void queMeDevuelvaElTurnoQueEspero() {
		
		TurnoMedico turno1 = new TurnoMedico();
		TurnoMedico turno2 = new TurnoMedico();
		
		when(repositorio.obtenerTurno(1)).thenReturn(turno1);
		when(repositorio.obtenerTurno(2)).thenReturn(turno2);
		

		assertThat(servicio.getTurnoByID(2).getId()).isEqualTo(turno2.getId());
	}
	
	@Test
	public void regitrarTurnoMedico() {		
		TurnoMedico turno1 = new TurnoMedico();
		Usuario usuario = mock(Usuario.class);
					
		when(repositorio.obtenerTurno(1)).thenReturn(turno1);
		when(repositorio.obtenerUsuario(1)).thenReturn(usuario);
		when(usuario.getDescuentoPorPlanMedico()).thenReturn(10.0); //me da o no igual que entre a ese condicional If 
																	//ya que lo unico que quiero demostrar es que funciona la reserva 
																									
		servicio.reservarTurno(turno1.getId(), usuario.getIdUsuario());
		
		assertThat(servicio.getTurnoByID(turno1.getId())).isEqualTo(turno1.getId());		
	}
	
//	@Test
//	public void setPagadoUnTurno() {
//		TurnoMedico turno1 = new TurnoMedico();
//		turno1.setPagado(false);
//		
//		Usuario usuario = new Usuario();
//				
//		servicio.setPagadoTurno(turno1, true);	
//		
//		assertThat(servicio.getTurnoByID(turno1.getId()).getPagado()).isEqualTo(true);
//	}
	


}
