package com.poll.repo;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.poll.brainy.User;


public interface PersonaRepository extends PagingAndSortingRepository<User, Integer>
 {
	 
}
