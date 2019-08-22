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
@Table(name="TIPO_PREGUNTA")
@SequenceGenerator(name="tipo_pregunta_id_tipo_pregunta_seq",initialValue=1, allocationSize=1)
public class TipoPregunta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_TIPO_PREGUNTA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "tipo_pregunta_id_tipo_pregunta_seq")
	private Integer idTipoPregunta;
	@Column(name="DESCRIPCION")
	private String descripcion;
	@Column(name="RESPUESTAS")
	private String respuestas;
	@Column(name="ESCALA")
	private String escala;
	@Column(name="URL")
	private String url;
	@Column(name="TIME")
	private String time;
	
	public Integer getIdTipoPregunta() {
		return idTipoPregunta;
	}
	public void setIdTipoPregunta(Integer idTipoPregunta) {
		this.idTipoPregunta = idTipoPregunta;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(String respuestas) {
		this.respuestas = respuestas;
	}
	public String getEscala() {
		return escala;
	}
	public void setEscala(String escala) {
		this.escala = escala;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((escala == null) ? 0 : escala.hashCode());
		result = prime * result + ((idTipoPregunta == null) ? 0 : idTipoPregunta.hashCode());
		result = prime * result + ((respuestas == null) ? 0 : respuestas.hashCode());
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
		TipoPregunta other = (TipoPregunta) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (escala == null) {
			if (other.escala != null)
				return false;
		} else if (!escala.equals(other.escala))
			return false;
		if (idTipoPregunta == null) {
			if (other.idTipoPregunta != null)
				return false;
		} else if (!idTipoPregunta.equals(other.idTipoPregunta))
			return false;
		if (respuestas == null) {
			if (other.respuestas != null)
				return false;
		} else if (!respuestas.equals(other.respuestas))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TipoPregunta [idTipoPregunta=" + idTipoPregunta + ", descripcion=" + descripcion + ", respuestas="
				+ respuestas + ", escala=" + escala + "]";
	}
	
	

}
