package com.poll.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.poll.brainy.Encuesta;

public interface EncuestaRepository extends PagingAndSortingRepository<Encuesta, Integer> {

}
