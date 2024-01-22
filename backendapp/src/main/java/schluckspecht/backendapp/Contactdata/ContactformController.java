package schluckspecht.backendapp.Contactdata;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//URL for localhost: http://localhost:8080/Contactforms
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ContactformController {

    private final ContactRepo repository;

    ContactformController(ContactRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/Contactforms")
    List<Contactform> all() {
        return repository.findAll();
    }

    @GetMapping("/Contactforms/{id}")
    Contactform one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow();
    }

    @PostMapping("/create_newContactform")
    Contactform newContactform(@RequestBody Contactform newContactform) {
        return repository.save(newContactform);
    }

    @PutMapping("/replace_Contactform/{id}")
    Contactform replaceContactform(@RequestBody Contactform newContactform, @PathVariable Long id) {

        return repository.findById(id)
                .map(Contactform -> {
                    Contactform.setEmail(newContactform.getEmail());
                    Contactform.setImagePath(newContactform.getImagePath());
                    Contactform.setName(newContactform.getName());
                    Contactform.setPhonenumber(newContactform.getPhonenumber());
                    Contactform.setPosition(newContactform.getPosition());
                    return repository.save(Contactform);
                })
                .orElseGet(() -> {
                    newContactform.setId(id);
                    return repository.save(newContactform);
                });
    }

    @DeleteMapping("/delete_Contactform/{id}")
    void deleteContactform(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
