package Forohub.API.main.topic;

import Forohub.API.main.answer.Answer;
import Forohub.API.main.course.Course;
import Forohub.API.main.profile.Profile;
import Forohub.API.main.topic.DTOS.DtoUpdateTopic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creation_date;
    private Boolean status;
    private Boolean active;

    @OneToMany(mappedBy = "topic")
    private List<Answer> answerList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor")
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course")
    private Course course;

    public void updateData(DtoUpdateTopic dtoUpdateTopic) {
        if (dtoUpdateTopic.status() != null) {
            this.status = dtoUpdateTopic.status();
        }
        if (dtoUpdateTopic.title() != null) {
            this.title = dtoUpdateTopic.title();
        }
        if (dtoUpdateTopic.message() != null) {
            this.message = dtoUpdateTopic.message();
        }
    }

    public void deactivateTopic() {
        this.active = false;
    }
}