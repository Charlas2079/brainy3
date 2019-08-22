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
@Table(name="PREGUNTA")
@SequenceGenerator(name="pregunta_id_pregunta_seq", initialValue=1, allocationSize=1)
public class Pregunta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_PREGUNTA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "pregunta_id_pregunta_seq")	
	private Integer idPregunta;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="OBLIGATORIEDAD")
	private Boolean obligatoriedad;
	
	@Column(name="ID_TIPO_PREGUNTA")
	private Integer idTipoPregunta;

	@Column(name="VALOR")
	private Integer valor;


	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getObligatoriedad() {
		return obligatoriedad;
	}

	public void setObligatoriedad(Boolean obligatoriedad) {
		this.obligatoriedad = obligatoriedad;
	}

	public Integer getIdTipoPregunta() {
		return idTipoPregunta;
	}

	public void setIdTipoPregunta(Integer idTipoPregunta) {
		this.idTipoPregunta = idTipoPregunta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idPregunta == null) ? 0 : idPregunta.hashCode());
		result = prime * result + ((idTipoPregunta == null) ? 0 : idTipoPregunta.hashCode());
		result = prime * result + ((obligatoriedad == null) ? 0 : obligatoriedad.hashCode());
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
		Pregunta other = (Pregunta) obj;
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
		if (idTipoPregunta == null) {
			if (other.idTipoPregunta != null)
				return false;
		} else if (!idTipoPregunta.equals(other.idTipoPregunta))
			return false;
		if (obligatoriedad == null) {
			if (other.obligatoriedad != null)
				return false;
		} else if (!obligatoriedad.equals(other.obligatoriedad))
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
		return "Pregunta [idPregunta=" + idPregunta + ", descripcion=" + descripcion + ", obligatoriedad="
				+ obligatoriedad + ", idTipoPregunta=" + idTipoPregunta + "]";
	}	
	
		
	
}
