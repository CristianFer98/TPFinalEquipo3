package ar.edu.unlam.tallerweb1.controladores;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.ParseException;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.DatosAgendaMesMedico;
import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.modelo.Dias;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioSesionMedico;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.assertj.core.api.Assertions.assertThat;

public class ControladorMedicoTest {

	private ModelAndView mav = new ModelAndView();
	private ServicioSesionMedico servicioUsuario;
	private ControladorMedico controladorMedico;

	Especialidad especialidad1 = new Especialidad();
	Especialidad especialidad2 = new Especialidad();

	@Before
	public void testQueSeHaceDespuesDeCadaTest() {

		servicioUsuario = mock(ServicioSesionMedico.class);
		controladorMedico = new ControladorMedico(servicioUsuario);

	}

//_______________________________________________________________________________________________//

	@Test
	public void testQueMeMuestraElFormularioDeEdicionDePerfilMedico() {
		
		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);
		when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(1);
		
		
		ArrayList<Especialidad> especializaciones = new ArrayList<Especialidad>();
		especialidad1.setIdEspecialidad(1);
		especialidad1.setEspecialidad("Cardiologo");
		especialidad2.setIdEspecialidad(2);
		especialidad2.setEspecialidad("Pediatra");

		especializaciones.add(especialidad1);
		especializaciones.add(especialidad2);

		when(servicioUsuario.obtenerListaDeEspecializaciones()).thenReturn(especializaciones);

		mav = controladorMedico.formularioEdicionPerfil(mockedRequest);

		assertThat(mav.getViewName()).isEqualTo("editarPerfilMedico");
		assertThat(mav.getModel().get("lista")).isEqualTo(especializaciones);
	}

//________________________________________________________________________________________________//

@Test
public void testQueMeCargaDatosDeUnMedico() throws IOException {
	// creo los datos
	DatosDeActualizacionPerfilMedico datosActualizacion = new DatosDeActualizacionPerfilMedico();
	datosActualizacion.setEspecialidad(1);
	datosActualizacion.setId(1);
	datosActualizacion.setPaginaPersonal("Cristian.com");
	datosActualizacion.setTelefono("1134778956");

	Integer id = 1;
	Boolean cargaExitosa = true;

	HttpSession http = mock(HttpSession.class);
	HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
	when(mockedRequest.getSession()).thenReturn(http);
	when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(id);
	
	when(servicioUsuario.cargarDatos(datosActualizacion, id)).thenReturn(cargaExitosa);

	mav = controladorMedico.CargarDatosMedico(datosActualizacion, mockedRequest);

	assertThat(mav.getViewName()).isEqualTo("paginaPrincipalMedicos");
}

	@Test
	public void testQueNoMeCargaDatosDeUnMedico() throws IOException {
		// creo los datos
		DatosDeActualizacionPerfilMedico datosActualizacion = new DatosDeActualizacionPerfilMedico();
		datosActualizacion.setEspecialidad(1);
		datosActualizacion.setId(1);
		datosActualizacion.setPaginaPersonal("Cristian.com");
		datosActualizacion.setTelefono("1134778956");

		Integer id = 1;
		Boolean cargaExitosa = false;

		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);
		when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(id);
		when(servicioUsuario.cargarDatos(datosActualizacion, id)).thenReturn(cargaExitosa);

		mav = controladorMedico.CargarDatosMedico(datosActualizacion, mockedRequest);

		assertThat(mav.getViewName()).isEqualTo("editarPerfilMedico");
		assertThat(mav.getModel().get("mensaje")).isEqualTo("hubo un error");
	}

//_________________________________________________________________________________________________________//



//__________________________________________________________________________________________________________//

	@Test
	public void testQueMePermitamostrarFormularioAgendaMedica() {
		
		
		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);
		when(mockedRequest.getSession()).thenReturn(http);
		when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(1);

		Dias dia1 = new Dias();
		Dias dia2 = new Dias();
		Dias dia3 = new Dias();
		Dias dia4 = new Dias();
		Dias dia5 = new Dias();
		Dias dia6 = new Dias();
		Dias dia7 = new Dias();

		dia1.setDias("Lunes");
		dia2.setDias("Martes");
		dia3.setDias("Miercoles");
		dia4.setDias("Jueves");
		dia5.setDias("Viernes");
		dia6.setDias("Sabado");
		dia7.setDias("Domingo");
		ArrayList<Dias> dias = new ArrayList<Dias>();

		dias.add(dia1);
		dias.add(dia2);
		dias.add(dia3);
		dias.add(dia4);
		dias.add(dia5);
		dias.add(dia6);
		dias.add(dia7);

		when(servicioUsuario.obtenerDiasDeLaSemana()).thenReturn(dias);
		mav = controladorMedico.mostrarFormularioAgendaMedica(mockedRequest);

		assertThat(mav.getViewName()).isEqualTo("formularioCargaAgenda");
		assertThat(mav.getModel().get("lista")).isEqualTo(dias);
	}
	
//___________________________________________________________________________________________________________//
	
	@Test
	public void testQueMePermitaCargarLaAgendaDeUnMedico() throws ParseException, java.text.ParseException {
		DatosAgendaMesMedico datos = new DatosAgendaMesMedico();
		
		datos.setHorarioComienzoJornada("08:00");
		datos.setHorarioFinJornada("16:00");
		datos.setDuracionTurno("00:30");

		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);
		when(mockedRequest.getSession()).thenReturn(http);
		when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(1);
		
		
		mav = controladorMedico.cargarAgendaMedico(datos, mockedRequest);
		
		assertThat (mav.getViewName()).isEqualTo("exito");
	}
	
	

}
