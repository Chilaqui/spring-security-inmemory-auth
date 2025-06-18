package com.security.memory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
class MemoryApplicationTests {

	@Autowired
	private MemoryApplication memoryApplication;

	@Test
	@WithMockUser(username = "admin", roles = {"ADMIN", "DEVELOPER", "USER"})
	public void testWithMockUser() {
		//Este test verifica que el contexto de Spring se carga correctamente con un usuario simulado
		//con los roles ADMIN, DEVELOPER y USER.
		//No se requiere ninguna aserción aquí, ya que el objetivo es simplemente verificar
		//que el contexto de la aplicación se carga sin errores.
		//Si el contexto no se carga correctamente, Spring lanzará una excepción y el test
		//fallará automáticamente.
		System.out.println("Context loaded with mock user: ");
	}

	@Test
	void contextLoads() {
	}

}
