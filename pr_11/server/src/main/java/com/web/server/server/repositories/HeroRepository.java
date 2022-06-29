package com.web.server.server.repositories;

import org.springframework.data.repository.CrudRepository;

import com.web.server.server.model.HeroModel;

public interface HeroRepository extends CrudRepository<HeroModel, Long>{
  
}
