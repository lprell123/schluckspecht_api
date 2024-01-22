package schluckspecht.backendapp.Feedpostdata;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//URL for localhost: http://localhost:8080/Feedposts
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FeedpostController {
    private final FeedpostRepo repository;

    public FeedpostController(FeedpostRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/Feedposts")
    List<Feedpost> all() {
        return repository.findAll();
    }

    @GetMapping("/Feedposts/{id}")
    Feedpost one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    @PostMapping("/create_newFeedpost")
    public ResponseEntity<String> createNewFeedpost(@RequestBody Feedpost newFeedpost) {

        // Process and save the new feedpost to the database
        Feedpost savedFeedpost = repository.save(newFeedpost);

        return ResponseEntity.ok("Feedpost created successfully. ID: " + savedFeedpost.getId());
    }

    @PutMapping("/replace_Feedpost/{id}/{adminkey}")
    Feedpost replaceFeedpost(@RequestBody Feedpost newFeedpost, @PathVariable Long id) {
        return repository.findById(id)
                .map(feedpost -> {
                    feedpost.setTitle(newFeedpost.getTitle());
                    feedpost.setContent(newFeedpost.getContent());
                    feedpost.setDate(newFeedpost.getDate());
                    feedpost.setImagePath(newFeedpost.getImagePath());
                    return repository.save(feedpost);
                })
                .orElseGet(() -> {
                    newFeedpost.setId(id);
                    return repository.save(newFeedpost);
                });
    }

    @DeleteMapping("/delete_Feedpost/{id}")
    void deleteFeedpost(@PathVariable Long id) {
        repository.deleteById(id);
    }
}