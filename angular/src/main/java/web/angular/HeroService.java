package web.angular;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class HeroService {
	
	@Autowired
	HeroRepository heroRepository;
	
	@GetMapping("/api/hero")
	public List<Hero> getHeroList() {
		return (List<Hero>) heroRepository.findAll();
	}
	
	@GetMapping("/api/hero/{id}")
	public Hero getHero(@PathVariable int id) {
		return heroRepository.findById(id).get();
	}
	
	@PostMapping("/api/hero")
	public void addHero(@RequestBody Hero hero) {

		heroRepository.save(hero);
	}
	
	@PutMapping("/api/hero/{id}")
	public Boolean updateTurma(@PathVariable int id, @RequestBody Hero hero) {

		Hero heroGET = getHero(id);

		heroGET.setNome(hero.getNome());
		
		heroRepository.save(heroGET);
		
		return true;
	}
	
	@DeleteMapping("/api/turma/{id}")
	public Boolean deleteTurma(@PathVariable int id) {

		Hero hero = getHero(id);

		if(hero != null) {
			heroRepository.deleteById(id);
			return true;

		}else {
			System.out.println("Turma não existe");
			return false;
		}

	}
	

}
