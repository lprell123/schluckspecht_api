package schluckspecht.backendapp.Login;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Value("${spring.security.user.name}")
    private String appUsername;

    @Value("${spring.security.user.password}")
    private String appPassword;

    public boolean authenticate(String username, String password) {
        return username.equals(appUsername) && password.equals(appPassword);
    }
}

