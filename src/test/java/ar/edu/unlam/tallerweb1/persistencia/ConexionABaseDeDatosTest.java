package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.xdevapi.SessionFactory;

public class ConexionABaseDeDatosTest extends SpringTest {

	@Test
	@Transactional
	@Rollback
	public void testQueMeCompruebaConexionABD() {
		
        assertThat(session().isConnected()).isTrue();//conexion de base de datos exitosa
	}

}
