package schluckspecht.backendapp.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (authService.authenticate(username, password)) {
            // Successful login
            return ResponseEntity.ok("Login successful");
        } else {
            // Failed login
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
