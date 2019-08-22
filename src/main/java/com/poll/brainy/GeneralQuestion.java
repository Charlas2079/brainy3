package com.poll.brainy;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GeneralQuestion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id	
	private Integer idPregunta;
	private String descripcion;	
	private Boolean obligatoriedad;
	private String TipoPregunta;
	@OneToMany
	private List<GeneralAnswer>answers;

	
	public List<GeneralAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<GeneralAnswer> answers) {
		this.answers = answers;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
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
		GeneralQuestion other = (GeneralQuestion) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idPregunta == null) {
			if (other.idPregunta != null)
				return false;
		} else if (!idPregunta.equals(other.idPregunta))
			return false;
		
		return true;
	}

	public Integer getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Integer idPregunta) {
		this.idPregunta = idPregunta;
	}

	@Override
	public String toString() {
		return "Pregunta [idPregunta=" + idPregunta + ", descripcion=" + descripcion +  "]";
	}

	public Boolean getObligatoriedad() {
		return obligatoriedad;
	}

	public void setObligatoriedad(Boolean obligatoriedad) {
		this.obligatoriedad = obligatoriedad;
	}

	public String getTipoPregunta() {
		return TipoPregunta;
	}

	public void setTipoPregunta(String tipoPregunta) {
		TipoPregunta = tipoPregunta;
	}	
	
		
	
}
