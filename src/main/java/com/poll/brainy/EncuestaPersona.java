package com.poll.brainy;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="ENCUESTA_PERSONA")
@IdClass(value = EncuestaPersona.class)
public class EncuestaPersona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ENCUESTA")
	private Integer idEncuesta;
	
	@Id
	@Column(name="ID_PERSONA")
	private Integer idPersona;

	public Integer getIdEncuesta() {
		return idEncuesta;
	}

	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEncuesta == null) ? 0 : idEncuesta.hashCode());
		result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
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
		EncuestaPersona other = (EncuestaPersona) obj;
		if (idEncuesta == null) {
			if (other.idEncuesta != null)
				return false;
		} else if (!idEncuesta.equals(other.idEncuesta))
			return false;
		if (idPersona == null) {
			if (other.idPersona != null)
				return false;
		} else if (!idPersona.equals(other.idPersona))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EncuestaPersona [idEncuesta=" + idEncuesta + ", idPersona=" + idPersona + "]";
	}
	
	
}
