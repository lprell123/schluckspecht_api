package schluckspecht.backendapp.Contactdata;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepo extends CrudRepository<Contactform, Long> {

    List<Contactform> findAll();

    Contactform findById(long id);

}
