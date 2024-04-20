package SouthDragon.SpringBootJpaAdvancedMapping.entity;

import jakarta.persistence.*;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

    // annotate the class as an entity and map to db table

    // define the fields

    // annotate the fields with db column names

    // create constructors

    // generate getter/setter methods

    // generate toString() method
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String YoutubeChannel;

    @Column(name = "hobby")
    private String hobby;

    public InstructorDetail(){

    }

    public InstructorDetail( String youtubeChannel, String hobby) {

        YoutubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public String getYoutubeChannel() {
        return YoutubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        YoutubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", YoutubeChannel='" + YoutubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}