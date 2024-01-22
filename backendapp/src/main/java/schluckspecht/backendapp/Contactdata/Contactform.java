package schluckspecht.backendapp.Contactdata;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contactform {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String position;

    private String phonenumber;

    private String email;

    private String imagePath;

    protected Contactform () {}

    public Contactform (String name, String position, String phonenumber, String email, String imagePath) {
        this.name = name;
        this.position = position;
        this.phonenumber = phonenumber;
        this.email = email;
        this.imagePath = imagePath;
    }

    public Contactform (String name, String position, String email, String imagePath) {
        this.name = name;
        this.position = position;
        this.email = email; // can be email or phonenumber
        this.imagePath = imagePath;
    }

    public Contactform (String name, String position, String imagePath) {
        this.name = name;
        this.position = position;
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return String.format(
                "this Post: [id=%d, name='%s', position='%s', phonenumber='%s', email='%s', imgpath='%s']",
                id, name, position, phonenumber, email, imagePath);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
