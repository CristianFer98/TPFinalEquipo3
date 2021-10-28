package ar.edu.unlam.tallerweb1.servicios;


import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import ar.edu.unlam.tallerweb1.modelo.DatosAgendaMesMedico;
import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSesionMedico;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Time;
import java.util.ArrayList;

public class ServicioSesionMedicoTest {

	private RepositorioSesionMedico repositorio; // el servicio que va a ser un MOCK
	private ServicioSesionMedicoImpl servicio; // el registro que me va hacer los metodos

	@Before
	public void testQueSeHaceDespuesDeCadaTest() {// este before se hace despues de cada test

		repositorio = mock(RepositorioSesionMedico.class); // me crea un mokito que es un objeto para separar y probar
		servicio = new ServicioSesionMedicoImpl(repositorio);
		// individualmente las capas

	}

	@Test
	public void testQueMePermiteCargarDatosAUnMedico() {

		DatosDeActualizacionPerfilMedico datosActualizacion = new DatosDeActualizacionPerfilMedico();
		datosActualizacion.setEspecialidad(1);
		datosActualizacion.setFoto("FOTO.PNG");
		datosActualizacion.setId(1);
		datosActualizacion.setPaginaPersonal("Cristian.com");
		datosActualizacion.setTelefono("1134778956");

		when(repositorio.cargarDatos(datosActualizacion, datosActualizacion.getId())).thenReturn(new Usuario());
		Boolean cargaExitosa = servicio.cargarDatos(datosActualizacion, datosActualizacion.getId());

		assertThat(cargaExitosa).isTrue();

	}

//_________________________________________________________________________________________________________//	

	@Test
	public void testQueNoMePermiteCargarDatosAUnMedico() {

		DatosDeActualizacionPerfilMedico datosActualizacion = new DatosDeActualizacionPerfilMedico();
		datosActualizacion.setEspecialidad(1);
		datosActualizacion.setFoto("FOTO.PNG");
		datosActualizacion.setId(1);
		datosActualizacion.setPaginaPersonal("Cristian.com");
		datosActualizacion.setTelefono("1134778956");

		when(repositorio.cargarDatos(datosActualizacion, datosActualizacion.getId())).thenReturn(null);
		Boolean cargaExitosa = servicio.cargarDatos(datosActualizacion, datosActualizacion.getId());

		assertThat(cargaExitosa).isFalse();

	}

//_________________________________________________________________________________________________________//

	@Test
	public void testQueMePermitaObtenerLaInformacionDeUnUsuarioPorId() {
		Integer id = 1;
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1);

		when(repositorio.obtenerUsuarioPorId(id)).thenReturn(usuario);
		Usuario usuarioObtenido = servicio.obtenerInformacion(id);

		assertThat(usuarioObtenido).isEqualTo(usuario);
	}

//_________________________________________________________________________________________________________//

	@Test
	public void testQueMeNoPermitaObtenerLaInformacionDeUnUsuarioPorId() {
		Integer id = 1;
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1);

		when(repositorio.obtenerUsuarioPorId(id)).thenReturn(null);
		Usuario usuarioObtenido = servicio.obtenerInformacion(id);

		assertThat(usuarioObtenido).isNotEqualTo(usuario);
		
	}

	
//______________________TEST DE LOS TESTS ___________________________________________________________________//
	
	
	@SuppressWarnings({ "deprecation" })
	@Test
	public void testQueMePermiteGenerarAgendaParaUnMedico() {

		Time horarioComienzoJornada = mock(Time.class);
		Time horarioFinJornada = mock(Time.class);
		
		DatosAgendaMesMedico datos = mock (DatosAgendaMesMedico.class);
		ArrayList <Integer> diasDeLaSemana = new ArrayList<Integer>();
		datos.setDiasDeLaSemanaElegidos(diasDeLaSemana);
		diasDeLaSemana.add(1);
		
		when(datos.getDiasDeLaSemanaElegidos()).thenReturn(diasDeLaSemana);
		
		
		when(horarioComienzoJornada.getHours()).thenReturn(16);
		when(horarioComienzoJornada.getMinutes()).thenReturn(00);

		when(horarioFinJornada.getHours()).thenReturn(8);
		when(horarioFinJornada.getMinutes()).thenReturn(0);
		
		Integer id = 1;
		
		ArrayList <TurnoMedico> turnos = new ArrayList <TurnoMedico>();
		when(repositorio.cargarAgenda(turnos, id)).thenReturn(true);
		Boolean querecibioo = servicio.cargarAgenda(datos, id, horarioComienzoJornada, horarioFinJornada);
		
		assertThat(querecibioo).isTrue();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		DatosAgendaMesMedico datos = new DatosAgendaMesMedico();
//		Usuario usuario = mock(Usuario.class);
//		usuario.setIdUsuario(1);
//		usuario.setEmail("Cris@gmail.com");
//		
//		ArrayList <Integer> diasDeLaSemanaElegidos = new ArrayList <Integer>();
//		diasDeLaSemanaElegidos.add(2);
//		diasDeLaSemanaElegidos.add(4);
//		datos.setDiasDeLaSemanaElegidos(diasDeLaSemanaElegidos);
//		ArrayList <TurnoMedico> nuevosTurnos = new ArrayList <TurnoMedico>();
//		
//
//		Time horarioComienzoJornada = new Time(8,00,00);
//		Time horarioFinJornada = new Time(16,00,00);
//		
//	LocalDateTime tiempoActual = LocalDateTime.now();
//		
//		@SuppressWarnings("deprecation")
//		LocalDateTime inicioDeActividadMensual = LocalDateTime.of(tiempoActual.getYear(), tiempoActual.getMonth(),
//				tiempoActual.getDayOfMonth(), horarioComienzoJornada.getHours() -3, horarioComienzoJornada.getMinutes()) ;
//
//		@SuppressWarnings("deprecation")
//		LocalDateTime finDeActividadMensual = LocalDateTime.of(tiempoActual.getYear(), tiempoActual.getMonth().plus(1),
//				tiempoActual.getDayOfMonth(), horarioFinJornada.getHours() -3 , horarioFinJornada.getHours());
//
//	
//		
//		Integer idMedico = 1;
//
//		when(repositorio.cargarAgenda(nuevosTurnos, usuario.getIdUsuario())).thenReturn(true);
//		when(repositorio.obtenerUsuarioPorId(1)).thenReturn(usuario);
//
//		when(servicio.recorrerFechas(inicioDeActividadMensual, finDeActividadMensual, datos.getDiasDeLaSemanaElegidos())).thenReturn(new ArrayList <TurnoMedico>());
//
//		
//		Boolean cargo = servicio.cargarAgenda(datos, idMedico, horarioComienzoJornada, horarioFinJornada);
//		
//		assertThat(cargo).isTrue();
	}
	
}
