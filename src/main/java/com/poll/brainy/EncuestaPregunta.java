package com.poll.brainy;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="ENCUESTA_PREGUNTA")
@IdClass(value = EncuestaPregunta.class)
public class EncuestaPregunta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ENCUESTA")
	private Integer idEncuesta;
	
	@Id
	@Column(name="ID_PREGUNTA")
	private Integer idPregunta;

	public Integer getIdEncuesta() {
		return idEncuesta;
	}

	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
	}

	public Integer getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Integer idPregunta) {
		this.idPregunta = idPregunta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEncuesta == null) ? 0 : idEncuesta.hashCode());
		result = prime * result + ((idPregunta == null) ? 0 : idPregunta.hashCode());
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
		EncuestaPregunta other = (EncuestaPregunta) obj;
		if (idEncuesta == null) {
			if (other.idEncuesta != null)
				return false;
		} else if (!idEncuesta.equals(other.idEncuesta))
			return false;
		if (idPregunta == null) {
			if (other.idPregunta != null)
				return false;
		} else if (!idPregunta.equals(other.idPregunta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EncuestaPregunta [idEncuesta=" + idEncuesta + ", idPregunta=" + idPregunta + "]";
	}
	
	
}
