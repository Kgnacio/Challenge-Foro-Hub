package Forohub.API.main.topic.validations;

import Forohub.API.main.topic.Dtos.DtoRegisterTopic;
import Forohub.API.main.topic.Topic;
import Forohub.API.main.topic.TopicRepository;
import Forohub.API.main.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TitleDuplicateValidation implements TopicValidator{
    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(DtoRegisterTopic dtoRegisterTopic) {
        Optional<Topic> topic = topicRepository.findByTitle(dtoRegisterTopic.title());

        if (topic.isPresent()) {
            throw new IntegrityValidation("Ya existe un topico asi");
        }
    }
}