package schluckspecht.backendapp.Feedpostdata;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Feedpost {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;

    private String date;

    private String imagePath;

    private String imageSource;

    private String contentSource;

    private String AdminImage;

    private String Adminname;

    protected Feedpost() {}

    public Feedpost(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Feedpost(String title, String content, String date, String imagePath) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return String.format(
                "this Post: [id=%d, firstName='%s', lastName='%s', date='%s', imgpath='%s']",
                id, title, content, date, imagePath);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String id) {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String id) {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String id) {
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String id) {
    }
}