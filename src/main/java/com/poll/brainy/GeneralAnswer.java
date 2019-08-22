package com.poll.brainy;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class GeneralAnswer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer idRespuesta;
	private String respuesta;
	private String grupoRespuesta;
	

	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRespuesta == null) ? 0 : idRespuesta.hashCode());
		result = prime * result + ((respuesta == null) ? 0 : respuesta.hashCode());
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
		GeneralAnswer other = (GeneralAnswer) obj;
		if (idRespuesta == null) {
			if (other.idRespuesta != null)
				return false;
		} else if (!idRespuesta.equals(other.idRespuesta))
			return false;
		if (respuesta == null) {
			if (other.respuesta != null)
				return false;
		} else if (!respuesta.equals(other.respuesta))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Respuesta [idRespuesta=" + idRespuesta + ", respuesta=" + respuesta + "]";
	}
	public Integer getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(Integer idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	public String getGrupoRespuesta() {
		return grupoRespuesta;
	}
	public void setGrupoRespuesta(String grupoRespuesta) {
		this.grupoRespuesta = grupoRespuesta;
	}
	
		
	

	

}
