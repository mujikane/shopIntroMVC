package com.centro.modelo;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/*
 * Bean Cliente
 */
public class Cliente {
	
	//Atributos
	private String nombreUsu, nombre, apellidos, dni, email,  pass, direccion;
	private int telefono;
	
	public Cliente(){
		this.nombreUsu = null;
		this.nombre = null;
		this.apellidos = null;
		this.dni = null;
		this.email = null;
		this.pass = null;
		this.direccion = null;
		this.telefono = 0;
	}
	
	public Cliente (String nombreUsu, String password){
		this.nombreUsu = nombreUsu;
		this.pass = password;
	}
	//Getters y setters
	public String getNombreUsu() {
		return nombreUsu;
	}

	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass){
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Metodo que encripta el password
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String encriptarPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		sha.update(password.getBytes("utf-8"));
		byte[] digest = sha.digest();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<digest.length;i++){
		    sb.append(String.format("%02x", digest[i]));
		}
		return sb.toString();
	}

}



