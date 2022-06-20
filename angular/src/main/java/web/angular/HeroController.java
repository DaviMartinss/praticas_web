package web.angular;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HeroController {
	
	@Autowired
	HeroService heroService;

	@GetMapping("/api/hero")
	public List<Hero> getTurmaList() {
		return heroService.getHeroList();
	}
	
	
	
	
	

}