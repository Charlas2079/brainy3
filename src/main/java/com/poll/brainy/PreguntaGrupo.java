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
@Table(name="PREGUNTA_GRUPO")
@SequenceGenerator(name="pregunta_criterio_grupo_id_pregunta_criterio_grupo_seq", initialValue=1, allocationSize=1)
public class PreguntaGrupo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_PREGUNTA_GRUPO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pregunta_criterio_grupo_id_pregunta_criterio_grupo_seq")
	private Integer idPreguntaGrupo;
	
	@Column(name="ID_ENCUESTA")
	private Integer idEncuesta;	
	@Column(name="ID_PREGUNTA")
	private Integer idPregunta;
	@Column(name="ID_GRUPO")
	private Integer idGrupo;
	
	public Integer getIdPreguntaGrupo() {
		return idPreguntaGrupo;
	}
	public void setIdPreguntaGrupo(Integer idPreguntaGrupo) {
		this.idPreguntaGrupo = idPreguntaGrupo;
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
	public Integer getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGrupo == null) ? 0 : idGrupo.hashCode());
		result = prime * result + ((idEncuesta == null) ? 0 : idEncuesta.hashCode());
		result = prime * result + ((idPregunta == null) ? 0 : idPregunta.hashCode());
		result = prime * result + ((idPreguntaGrupo == null) ? 0 : idPreguntaGrupo.hashCode());
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
		PreguntaGrupo other = (PreguntaGrupo) obj;
		if (idGrupo == null) {
			if (other.idGrupo != null)
				return false;
		} else if (!idGrupo.equals(other.idGrupo))
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
		if (idPreguntaGrupo == null) {
			if (other.idPreguntaGrupo != null)
				return false;
		} else if (!idPreguntaGrupo.equals(other.idPreguntaGrupo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PreguntaCriterioGrupo [idEncuesta=" + idEncuesta + ", idPreguntaGrupo="
				+ idPreguntaGrupo + ", idGrupo=" + idGrupo + "]";
	}
	
	

}
