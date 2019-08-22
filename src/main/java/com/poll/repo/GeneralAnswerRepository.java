package com.poll.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.poll.brainy.GeneralAnswer;

public interface GeneralAnswerRepository extends PagingAndSortingRepository<GeneralAnswer, Integer> {
	@Query(value="select pregunta_respuesta.id_respuesta, respuesta.respuesta, grupo_respuesta " + 
			"from pregunta inner join encuesta_pregunta on encuesta_pregunta.id_pregunta = pregunta.id_pregunta " + 
			"inner join pregunta_respuesta on pregunta_respuesta.id_pregunta = pregunta.id_pregunta " + 
			"inner join respuesta on respuesta.id_respuesta = pregunta_respuesta.id_respuesta " + 
			"inner join tipo_pregunta on tipo_pregunta.id_tipo_pregunta = respuesta.id_tipo_respuesta  " + 
			"where encuesta_pregunta.id_encuesta = :id and pregunta_respuesta.id_pregunta = :idPregunta ", nativeQuery = true)
    public List<GeneralAnswer> findAnswersById( @Param("id") Integer idEncuesta, @Param("idPregunta") Integer idPregunta);
}
