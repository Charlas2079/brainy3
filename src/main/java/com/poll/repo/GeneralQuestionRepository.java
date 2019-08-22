package com.poll.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


import com.poll.brainy.GeneralQuestion;

public interface GeneralQuestionRepository extends PagingAndSortingRepository<GeneralQuestion, Integer> {
	@Query(value="select encuesta_pregunta.id_pregunta, pregunta.descripcion, obligatoriedad, tipo_pregunta.descripcion as tipo_pregunta " + 
			"from pregunta inner join encuesta_pregunta on encuesta_pregunta.id_pregunta = pregunta.id_pregunta " + 
			"inner join tipo_pregunta on tipo_pregunta.id_tipo_pregunta = pregunta.id_tipo_pregunta " + 
			"where encuesta_pregunta.id_encuesta = :id", nativeQuery = true)
    public List<GeneralQuestion> findQuestionsById( @Param("id") Integer idEncuesta);
}
