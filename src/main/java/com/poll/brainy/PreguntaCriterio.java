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
@Table(name="PREGUNTA_CRITERIO")
@SequenceGenerator(name="pregunta_criterio_id_pregunta_criterio_seq", initialValue=1, allocationSize=1)
public class PreguntaCriterio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_PREGUNTA_CRITERIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pregunta_criterio_id_pregunta_criterio_seq")
	private Integer idPreguntaCriterio;
	
	@Column(name="ID_ENCUESTA")
	private Integer idEncuesta;
	
	@Column(name="ID_PREGUNTA")
	private Integer idPregunta;
	
	@Column(name="ID_CRITERIO")
	private Integer idCriterio;
	
	@Column(name="PESO")
	private Integer peso;
	
	@Column(name="PESO_ENCUESTA")
	private Integer pesoEncuesta;

	

	public Integer getIdPreguntaCriterio() {
		return idPreguntaCriterio;
	}

	public void setIdPreguntaCriterio(Integer idPreguntaCriterio) {
		this.idPreguntaCriterio = idPreguntaCriterio;
	}

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

	public Integer getIdCriterio() {
		return idCriterio;
	}

	public void setIdCriterio(Integer idCriterio) {
		this.idCriterio = idCriterio;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getPesoEncuesta() {
		return pesoEncuesta;
	}

	public void setPesoEncuesta(Integer pesoEncuesta) {
		this.pesoEncuesta = pesoEncuesta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCriterio == null) ? 0 : idCriterio.hashCode());
		result = prime * result + ((idEncuesta == null) ? 0 : idEncuesta.hashCode());
		result = prime * result + ((idPregunta == null) ? 0 : idPregunta.hashCode());
		result = prime * result + ((idPreguntaCriterio == null) ? 0 : idPreguntaCriterio.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((pesoEncuesta == null) ? 0 : pesoEncuesta.hashCode());
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
		PreguntaCriterio other = (PreguntaCriterio) obj;
		if (idCriterio == null) {
			if (other.idCriterio != null)
				return false;
		} else if (!idCriterio.equals(other.idCriterio))
			return false;
		if (idEncuesta == null) {
			if (other.idEncuesta!= null)
				return false;
		} else if (!idEncuesta.equals(other.idEncuesta))
			return false;
		if (idPregunta == null) {
			if (other.idPregunta!= null)
				return false;
		} else if (!idPregunta.equals(other.idPregunta))
			return false;
		if (idPreguntaCriterio == null) {
			if (other.idPreguntaCriterio != null)
				return false;
		} else if (!idPreguntaCriterio.equals(other.idPreguntaCriterio))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (pesoEncuesta == null) {
			if (other.pesoEncuesta != null)
				return false;
		} else if (!pesoEncuesta.equals(other.pesoEncuesta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PreguntaCriterio [idPreguntaCriterio=" + idPreguntaCriterio + ", idEncuesta=" + idEncuesta
				+ ", idCriterio=" + idCriterio + ", peso=" + peso + ", pesoEncuesta=" + pesoEncuesta + "]";
	}

	
}
