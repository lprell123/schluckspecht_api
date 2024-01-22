package schluckspecht.backendapp.Feedpostdata;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedpostRepo extends CrudRepository<Feedpost, Long> {

    List<Feedpost> findAll();

    List<Feedpost> findByDate(String date);

    Feedpost findById(long id);
}