package schluckspecht.backendapp.Timelinedata;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Timelinepost {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int dayofevent;

    private int monthofevent;

    private int yearofevent;

    private String country;

    private String eventname;

    private String placement;

    private String title;

    private String tags;

    private String content;

    private String imagePath;

    protected Timelinepost () {}

    public Timelinepost (int dayofevent, int monthofevent, int yearofevent, String country, String eventname, String placement,
                         String title, String tags, String content, String imagePath) {
        this.dayofevent = dayofevent;
        this.monthofevent = monthofevent;
        this.yearofevent = yearofevent;
        this.country = country;
        this.eventname = eventname;
        this.placement = placement;
        this.title = title;
        this.tags = tags;
        this.content = content;
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return String.format(
                "this Post: [id=%d, day='%s', month='%s', year='%s', country='%s', eventname='%s', placement='%s', title='%s', tags='%s', content='%s', imgpath='%s']",
                id, dayofevent, monthofevent, yearofevent, country, eventname, placement, title, tags, content, imagePath);
    }

    public int getDayofevent() {
        return dayofevent;
    }

    public void setDayofevent(int day) {
        this.dayofevent = day;
    }

    public int getMonthofevent() {
        return monthofevent;
    }

    public void setMonthofevent(int month) {
        this.monthofevent = month;
    }

    public void setYearofevent(int year) {
        this.yearofevent = year;
    }

    public int getYearofevent() {
        return yearofevent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
