package Forohub.API.main.profile;

import Forohub.API.main.answer.Answer;
import Forohub.API.main.course.Course;
import Forohub.API.main.profile.DTOS.DtoUpdateProfile;
import Forohub.API.main.topic.DTOS.DtoUpdateTopic;
import Forohub.API.main.topic.Topic;
import Forohub.API.main.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "profiles")
@Entity(name = "Profile")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "profile",  cascade = CascadeType.ALL)
    private List<Topic> topicList;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Answer> answerList;

    public void updateData(DtoUpdateProfile dtoUpdateProfile) {
        if (dtoUpdateProfile.name() != null) {
            this.name = dtoUpdateProfile.name();
        }
        if (dtoUpdateProfile.email() != null) {
            this.email = dtoUpdateProfile.email();
        }
    }

    public void deactivateProfile() {
        this.active = false;
    }
}