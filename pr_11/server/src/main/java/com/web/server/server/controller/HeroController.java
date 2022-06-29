package com.web.server.server.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.server.server.model.HeroModel;
import com.web.server.server.model.StringResponse;
import com.web.server.server.services.HeroService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/hero")
public class HeroController {
  
  final HeroService heroService;

  public HeroController(HeroService heroService) {
    this.heroService = heroService;
  }

  @GetMapping
  public ResponseEntity<List<HeroModel>> getAllHeros(){
    List<HeroModel> heroes = heroService.listAll();

    return ResponseEntity.ok(heroes);
  }

  @GetMapping("/{id}")
  public ResponseEntity<HeroModel> getHeroById(@PathVariable(value = "id") long id){
    HeroModel hero = heroService.getById(id);
    
    return ResponseEntity.ok(hero);
  }

  @PostMapping
  public ResponseEntity<HeroModel> postHero(@RequestBody HeroModel hero){
    HeroModel result = heroService.save(hero);

    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }

  @PutMapping("/{id}")
  public ResponseEntity<HeroModel> updateHero(@PathVariable(value = "id") long id, @RequestBody HeroModel hero){
    HeroModel result = heroService.update(hero, id);

    return ResponseEntity.ok(result);
  }
  
  @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> deleteHero(@PathVariable(value = "id") long id){
    heroService.delete(id);
    
    return ResponseEntity.ok(new StringResponse("Successfully deleted"));
  }
}
