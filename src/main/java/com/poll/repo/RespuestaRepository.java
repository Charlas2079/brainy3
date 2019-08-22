package com.poll.repo;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.poll.brainy.Respuesta;

public interface RespuestaRepository extends PagingAndSortingRepository<Respuesta, Integer> {
	
	@Query("FROM Respuesta where idTipoRespuesta = ?1 ")
    Iterable<Respuesta> findRespuestaByIdTipo(@Param("idtipo") Integer tipoRespuesta);
	
	@Query("FROM Respuesta where idTipoRespuesta = ?1 and grupo_respuesta =?2")
    Iterable<Respuesta> findRespuestaByIdTipoGrupo(@Param("idtipo") Integer tipoRespuesta, @Param("grupo") String grupoRespuesta);
	
	@Query(value="select * FROM Respuesta where grupo_respuesta = :grupo", nativeQuery = true)
    Iterable<Respuesta> findRespuestaByGrupo( @Param("grupo") String grupoRespuesta);
	

}
