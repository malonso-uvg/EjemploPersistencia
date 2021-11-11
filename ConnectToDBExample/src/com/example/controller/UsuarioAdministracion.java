/**
 * 
 */
package com.example.controller;

import com.example.dal.IDBConnector;
import com.example.model.Usuario;
import com.mysql.jdbc.ResultSet;

/**
 * @author MAAG
 *
 */
public class UsuarioAdministracion {

	private IDBConnector baseDeDatos;
	public UsuarioAdministracion(IDBConnector conexion) {
		baseDeDatos = conexion;
	}
	
	public boolean crearUsuario(Usuario nuevoUsuario) throws Exception{
		String query = "INSERT INTO usuario values(null, '" + nuevoUsuario.getNombre() + "','" + nuevoUsuario.getApellido() + "','" + nuevoUsuario.getDescripcion() + "')";
		return baseDeDatos.saveData(query);
	}
	
	public Usuario obtenerUsuario(int id) throws Exception{
		Usuario miUsuario = new Usuario();
		ResultSet rs = (ResultSet) baseDeDatos.getData("select usuario_id, nombre, apellido, description from usuario");
		while (rs.next()) {
			miUsuario.setId(rs.getInt(1));
			miUsuario.setNombre(rs.getString(2));
			miUsuario.setApellido(rs.getString(3));
			miUsuario.setDescripcion(rs.getString(4));
		}
		return miUsuario;
	}
}
