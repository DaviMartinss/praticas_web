package web.angular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HeroController {
	
	@Autowired
	HeroService heroService;

	@GetMapping("/api/hero")
	public Iterable<Hero> getHeroList() {
		return heroService.getHeroList();
	}
	
	@GetMapping("/api/hero/{id}")
	public Hero getHero(@PathVariable int id) {
		return heroService.getHero(id);
	}
	
	@PostMapping("/api/hero")
	public void addHero(@RequestBody Hero hero) {

		heroService.addHero(hero);
	}
	
	@PutMapping("/api/hero/{id}")
	public Boolean updateHero(@PathVariable int id, @RequestBody Hero hero) {

		heroService.updateHero(id, hero);
		
		return true;
	}
	
	@DeleteMapping("/api/turma/{id}")
	public Boolean deleteHero(@PathVariable int id) {

		Hero hero = getHero(id);

		if(hero != null) {
			heroService.deleteHero(id);
			return true;

		}else {
			System.out.println("Turma não existe");
			return false;
		}

	}
	
	
	
	
	

}