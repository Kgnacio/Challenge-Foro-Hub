package Forohub.API.main.topic;

import Forohub.API.main.course.Course;
import Forohub.API.main.course.CourseRepository;
import Forohub.API.main.profile.Profile;
import Forohub.API.main.profile.ProfileRepository;
import Forohub.API.main.topic.Dtos.DtoRegisterTopic;
import Forohub.API.main.topic.Dtos.DtoTopicList;
import Forohub.API.main.topic.validations.TopicValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CreateTopicService {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    List<TopicValidator> validatorList;

    public DtoTopicList create(DtoRegisterTopic dtoRegisterTopic) {
        // validations
        validatorList.forEach(v -> v.validate(dtoRegisterTopic));
        // relations
        Profile profile = profileRepository.findById(dtoRegisterTopic.idAutor()).get();
        Course course = courseRepository.findById(dtoRegisterTopic.idCourse()).get();
        // instance of topic
        LocalDateTime creationDate = LocalDateTime.now();
        Topic topic = new Topic(null, dtoRegisterTopic.title(), dtoRegisterTopic.message(), creationDate, false, true, null, profile, course);
        topicRepository.save(topic);

        return new DtoTopicList(topic);
    }
}