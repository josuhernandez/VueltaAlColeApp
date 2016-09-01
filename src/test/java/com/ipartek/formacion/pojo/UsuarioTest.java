package com.ipartek.formacion.pojo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UsuarioTest {

	
	
	
	@BeforeClass  /* se ejecuta antes del test*/
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before  /* se ejecuta antes de cada test*/
	public void setUp() throws Exception {
	}

	@After  /* se ejecuta despues de cada test*/
	public void tearDown() throws Exception {
	}

	@Test
	public void constructorPorDefecto() {
		Usuario u = new Usuario();
		assertEquals(-1,  u.getId());
		assertEquals("",  u.getNombre());
		assertEquals("",  u.getPassword());
		assertEquals("",  u.getEmail());
		
	}

}
