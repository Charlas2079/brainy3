package com.poll.brainy;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GrupoRespuesta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String grupoRespuesta;

	public String getGrupoRespuesta() {
		return grupoRespuesta;
	}

	public void setGrupoRespuesta(String grupoRespuesta) {
		this.grupoRespuesta = grupoRespuesta;
	}
	

}
