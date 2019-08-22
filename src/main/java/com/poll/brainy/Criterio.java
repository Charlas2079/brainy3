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
@Table(name="CRITERIO")
@SequenceGenerator(name="criterio_id_criterio_seq", initialValue=1, allocationSize=1)
public class Criterio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="criterio_id_criterio_seq" )
	@Column(name="ID_CRITERIO")
	private Integer idCriterio;
	
	@Column(name="DESCRIPCION")
	private String nombreCriterio;
	
	public Integer getIdCriterio() {
		return idCriterio;
	}	
	public String getNombreCriterio() {
		return nombreCriterio;
	}
	public void setNombreCriterio(String nombreCriterio) {
		this.nombreCriterio = nombreCriterio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCriterio == null) ? 0 : idCriterio.hashCode());
		result = prime * result + ((nombreCriterio == null) ? 0 : nombreCriterio.hashCode());
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
		Criterio other = (Criterio) obj;
		if (idCriterio == null) {
			if (other.idCriterio != null)
				return false;
		} else if (!idCriterio.equals(other.idCriterio))
			return false;
		if (nombreCriterio == null) {
			if (other.nombreCriterio != null)
				return false;
		} else if (!nombreCriterio.equals(other.nombreCriterio))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Criterion [idCriterio=" + idCriterio + ", nombreCriterio=" + nombreCriterio + "]";
	}
	

}
