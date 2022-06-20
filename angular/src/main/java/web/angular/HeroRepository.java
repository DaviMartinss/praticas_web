package web.angular;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface HeroRepository extends CrudRepository<Hero, Integer> {

}
