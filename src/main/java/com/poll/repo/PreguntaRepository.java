package com.poll.repo;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.poll.brainy.Pregunta;

public interface PreguntaRepository extends PagingAndSortingRepository<Pregunta, Integer> {
	

    @Query("FROM Pregunta where idPregunta = (select max(idPregunta) from Pregunta) ")
    Iterable<Pregunta> findLastId();
    
    

}
