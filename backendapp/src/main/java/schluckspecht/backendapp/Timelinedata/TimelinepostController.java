package schluckspecht.backendapp.Timelinedata;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//URL for localhost: http://localhost:8080/Timelineposts/create_newTimelinepost
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TimelinepostController {

    private final TimelineRepo repository;

    TimelinepostController(TimelineRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/Timelineposts")
    List<Timelinepost> all() {
        return repository.findAll();
    }

    @GetMapping("/Timelineposts/{id}")
    Timelinepost one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow();
    }

    @PostMapping("/create_newTimelinepost")
    Timelinepost newTimelinepost(@RequestBody Timelinepost newTimelinepost) {
        return repository.save(newTimelinepost);
    }

    @PutMapping("/replace_Timelinepost/{id}")
    Timelinepost replaceTimelinepost(@RequestBody Timelinepost newTimelinepost, @PathVariable Long id) {

        return repository.findById(id)
                .map(Timelinepost -> {
                    Timelinepost.setTitle(newTimelinepost.getTitle());
                    Timelinepost.setContent(newTimelinepost.getContent());
                    Timelinepost.setCountry(newTimelinepost.getCountry());
                    Timelinepost.setImagePath(newTimelinepost.getImagePath());
                    Timelinepost.setDayofevent(newTimelinepost.getDayofevent());
                    Timelinepost.setEventname(newTimelinepost.getEventname());
                    Timelinepost.setCountry(newTimelinepost.getCountry());
                    Timelinepost.setMonthofevent(newTimelinepost.getMonthofevent());
                    Timelinepost.setPlacement(newTimelinepost.getPlacement());
                    Timelinepost.setYearofevent(newTimelinepost.getYearofevent());
                    Timelinepost.setTags(newTimelinepost.getTags());
                    return repository.save(Timelinepost);
                })
                .orElseGet(() -> {
                    newTimelinepost.setId(id);
                    return repository.save(newTimelinepost);
                });
    }

    @DeleteMapping("/delete_Timelinepost/{id}")
    void deleteTimelinepost(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
