package Forohub.API.main.answer.validations;

import Forohub.API.main.answer.DTOS.DtoCreateAnswer;
import Forohub.API.main.answer.DTOS.DtoListAnswers;
import Forohub.API.main.answer.validations.AnswerValidation;
import Forohub.API.main.profile.Profile;
import Forohub.API.main.profile.ProfileRepository;
import Forohub.API.main.topic.Topic;
import Forohub.API.main.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CreateAnswerService {

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private List<AnswerValidation> answerValidationList;

    public DtoListAnswers create(DtoCreateAnswer dtoCreateAnswer) {
        // validations
        answerValidationList.forEach(v -> v.validate(dtoCreateAnswer));
        // relations
        Profile profile = profileRepository.findById(dtoCreateAnswer.idAutor()).get();
        Topic topic = topicRepository.findById(dtoCreateAnswer.idTopic()).get();
        // instance..
        LocalDateTime creationDate = LocalDateTime.now();
        Answer answer = new Answer(null, dtoCreateAnswer.message(), creationDate, false, true, profile, topic);
        answerRepository.save(answer);
        return new DtoListAnswers(answer);
    }

}