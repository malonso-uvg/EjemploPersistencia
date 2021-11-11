/**
 * 
 */
package com.example.ui;

import java.util.Scanner;

import com.example.controller.UsuarioAdministracion;
import com.example.dal.IDBConnector;
import com.example.dal.MySQLConnector;
import com.example.model.Usuario;

/**
 * @author MAAG
 *
 */
public class EjemploUsuarios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		Usuario nuevo = new Usuario();
		
		System.out.println("Ingrese nombre del usuario");
		nuevo.setNombre(in.nextLine());
		System.out.println("Ingrese apellido del usuario");
		nuevo.setApellido(in.nextLine());
		System.out.println("Ingrese descripcion del usuario");
		nuevo.setDescripcion(in.nextLine());
		
		try {
			IDBConnector miBaseDatos = new MySQLConnector("www.telesoftmedia.com:3306/uvg_test", "uvg_user", "DelValle2021%");
			UsuarioAdministracion admin = new UsuarioAdministracion(miBaseDatos);
			
			if (admin.crearUsuario(nuevo)) {
				System.out.println("Dato guardado exitosamente");
			}else {
				System.out.println("Dato no guardado");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
