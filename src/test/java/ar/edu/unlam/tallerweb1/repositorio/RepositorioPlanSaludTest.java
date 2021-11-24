package ar.edu.unlam.tallerweb1.repositorio;



import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import ar.edu.unlam.tallerweb1.modelo.PlanSalud;
//import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlanSalud;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;

public class RepositorioPlanSaludTest extends SpringTest {
	


	
	@Autowired
    private RepositorioPlanSalud repositorio;
	
	@Autowired
    private RepositorioRegistroLogin repositorioLog;
	
	@Test
	public void testQueMePermiteRegistrarSubscripcion() {

//		PlanSalud plan = new PlanSalud();
//		plan.setIdPlanSalud(2);
//		
//		
//		Usuario usuario = new Usuario();
//		usuario.setIdUsuario(5);
//		usuario.setNombre("Montoto");
//		
//		repositorioLog.registrarUsuario(usuario);
//		
//		repositorio.registrarSubscripcion(plan.getIdPlanSalud(), usuario.getIdUsuario());
//		
//		Usuario usuarioDevuelto = repositorio.obtenerUsuario(usuario.getIdUsuario());
//		
//		assertThat(usuarioDevuelto.getPlan().getIdPlanSalud()).isEqualTo(1);
		
	}






}
