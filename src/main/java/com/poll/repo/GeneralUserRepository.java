package com.poll.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.poll.brainy.GeneralUser;

public interface GeneralUserRepository extends PagingAndSortingRepository<GeneralUser, Integer> {
	@Query(value="select persona.email " + 
			"from persona inner join encuesta_persona on encuesta_persona.id_persona = persona.id_persona " + 
			"where encuesta_persona.id_encuesta = :id", nativeQuery = true)
    public List<GeneralUser> findUsersById( @Param("id") Integer idEncuesta);
}
