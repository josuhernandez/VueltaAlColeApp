package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.model.UsuarioDAOImpl;
import com.ipartek.formacion.pojo.Usuario;

public class ServiceUsuarioImplDB {

	private static ServiceUsuarioImplDB INSTANCE = null;

	private final Object daoUsuario;

	private ServiceUsuarioImplDB() {
		this.daoUsuario = UsuarioDAOImpl.getInstance();
	}

	public static ServiceUsuarioImplDB getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceUsuarioImplDB();
		}
	}

	@Override()
	public List<Usuario> search(String criterio) {
		System.out.println("Buscar planetas criterio " + criterio);
		return this.daoPlaneta.search(nombre);
	}

}
