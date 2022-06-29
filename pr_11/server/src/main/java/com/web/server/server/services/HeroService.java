package com.web.server.server.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.web.server.server.model.HeroModel;
import com.web.server.server.repositories.HeroRepository;

@Service
public class HeroService {
  final HeroRepository heroRepository;

  public HeroService(HeroRepository heroRepository) {
    this.heroRepository = heroRepository;
  }
  
  public HeroModel save(HeroModel heroModel){
    return heroRepository.save(heroModel);
  }

  public List<HeroModel> listAll(){
    List<HeroModel> heros = new ArrayList<>();
    Iterable<HeroModel> result = heroRepository.findAll();
    result.forEach(heros::add);

    return heros;
  }

  public HeroModel getById(long id){
    return heroRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Hero not found"));
  }

  public HeroModel update(HeroModel newData, long id){
    HeroModel hero = heroRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Hero not found"));
    BeanUtils.copyProperties(newData, hero);
    hero.setId(id);

    return heroRepository.save(hero);
  }

  public void delete(long id){
    heroRepository.deleteById(id);
  }
}
