package persons.models;


import javax.persistence.*;

@Entity
@Table(name = "logger", catalog = "persons")
public class Logger implements java.io.Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "eventDate")
    private String eventDate;

    @Column(name = "level")
    private String level;

    @Column(name = "logger")
    private String logger;

    @Column(name = "location")
    private String location;

    @Column(name = "message")
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Logger{" +
                "id=" + id +
                ", eventDate='" + eventDate + '\'' +
                ", level='" + level + '\'' +
                ", logger='" + logger + '\'' +
                ", location='" + location + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
