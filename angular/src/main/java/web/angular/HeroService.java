package web.angular;

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
	
	public Iterable<Hero> getHeroList() {
		return heroRepository.findAll();
	}
	
	public Hero getHero(@PathVariable int id) {
		return heroRepository.findById(id).get();
	}
	
	public void addHero(@RequestBody Hero hero) {

		heroRepository.save(hero);
	}
	
	public Boolean updateHero(@PathVariable int id, @RequestBody Hero hero) {

		Hero heroGET = getHero(id);

		heroGET.setNome(hero.getNome());
		
		heroRepository.save(heroGET);
		
		return true;
	}
	
	public Boolean deleteHero(@PathVariable int id) {

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
