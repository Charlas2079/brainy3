package com.poll.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.poll.brainy.Client;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel="clients", path="clients")
public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {

}
