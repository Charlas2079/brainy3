package com.poll.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.poll.brainy.GrupoRespuesta;

public interface GrupoRespuestaRepository extends PagingAndSortingRepository<GrupoRespuesta, String> {

	@Query(value="select distinct grupo_respuesta FROM Respuesta", nativeQuery = true)
    Iterable<GrupoRespuesta> findAllGrupoRespuesta();
	
	@Query(value="select distinct grupo_respuesta FROM Respuesta where id_Tipo_Respuesta = ?1 ", nativeQuery = true)
    Iterable<GrupoRespuesta> findGrupoRespuestaByIdTipo(@Param("idtipo") Integer tipoRespuesta);
	
	
	@Query(value="select distinct grupo_respuesta FROM Respuesta, pregunta where id_pregunta = ?1 and id_Tipo_Respuesta = id_tipo_pregunta  ", nativeQuery = true)
    Iterable<GrupoRespuesta> findGrupoRespuestaByIdPregunta(@Param("idtipo") Integer tipoRespuesta);
	
}
