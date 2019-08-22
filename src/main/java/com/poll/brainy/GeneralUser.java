package com.poll.brainy;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class GeneralUser implements Serializable {

	@Id
	//private String idPersona;
	//private String nombre;
	private String email;
	

	private static final long serialVersionUID = -5290198995172316155L;
	
	

	/*public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "User [email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeneralUser other = (GeneralUser) obj;
		/*if (idPersona == null) {
			if (other.idPersona != null)
				return false;
		} else if (!idPersona.equals(other.idPersona))
			return false;*/
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	
}
