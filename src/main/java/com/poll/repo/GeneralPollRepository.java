package com.poll.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.poll.brainy.GeneralPoll;

public interface GeneralPollRepository extends PagingAndSortingRepository<GeneralPoll, Integer> {
	
	
	@Query(value="select id_encuesta,id_cliente,fecha_encuesta,fecha_cierre,nombre_encuesta FROM encuesta where id_encuesta = :id", nativeQuery = true)
    GeneralPoll findPollById( @Param("id") Integer idEncuesta);

}
