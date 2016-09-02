package com.ipartek.formacion.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl {

	private static UsuarioDAOImpl INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conexion;

	private UsuarioDAOImpl() {
		db = DataBaseConnectionImpl.getInstance();
	}

	public static UsuarioDAOImpl getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAOImpl();
		}
	}

	@Override
	public List<Planeta> getAll() {
		List<Planeta> planetas = null;
		final String sql = "{call getAllPlanetas()}";
		try {
			this.conexion = db.getConexion();
			Planeta p = null;
			final CallableStatement cSmt = this.conexion.prepareCall(sql);
			final ResultSet rs = cSmt.executeQuery();
			planetas = new ArrayList<Planeta>();
			while (rs.next()) {
				p = new Planeta();
				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setImagen(rs.getString("imagen"));
				// add en lista
				planetas.add(p);
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return planetas;
	}

	@Override
	public Planeta getById(long id) {
		Planeta p = null;
		CallableStatement cst = null;
		final String sql = "{call buscarPlaneta(?)}";
		try {
			this.conexion = db.getConexion();
			cst = this.conexion.prepareCall(sql);
			cst.setLong(1, id);
			final ResultSet rs = cst.executeQuery();
			while (rs.next()) {
				p = new Planeta();
				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setImagen(rs.getString("imagen"));
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				cst.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
			db.desconectar();
		}
		return p;
	}

	@Override
	public boolean update(Planeta pojo) {
		boolean resul = false;
		final String sql = "{call updatePlaneta(?,?,?)}";
		CallableStatement cst = null;
		try {
			this.conexion = db.getConexion();
			cst = this.conexion.prepareCall(sql);
			// parametros entrada
			cst.setString(1, pojo.getNombre());
			cst.setString(2, pojo.getImagen());
			cst.setLong(3, pojo.getId());

			// ejecutar
			if (cst.executeUpdate() == 1) {
				resul = true;
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cst.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
			db.desconectar();
		}
		return resul;
	}

	@Override
	public List<Planeta> search(String criterio) {
		final ArrayList<Planeta> listaResul = new ArrayList<Planeta>();
		Planeta p = null;
		try {
			this.conexion = db.getConexion();
			final CallableStatement cst = this.conexion.prepareCall("{call buscarPlanetas(?)}");
			cst.setString(1, criterio);

			final ResultSet rs = cst.executeQuery();

			while (rs.next()) {
				p = new Planeta();
				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setImagen(rs.getString("imagen"));
				listaResul.add(p);
			}

		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return listaResul;
	}

}
