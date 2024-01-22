package schluckspecht.backendapp.Timelinedata;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimelineRepo extends CrudRepository<Timelinepost, Long> {

    List<Timelinepost> findAll();

    Timelinepost findById(long id);

}
