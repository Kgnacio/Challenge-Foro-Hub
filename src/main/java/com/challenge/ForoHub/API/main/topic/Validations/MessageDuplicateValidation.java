package Forohub.API.main.topic.validations;

import Forohub.API.main.Dtos.DtoRegisterTopic;
import Forohub.API.main.topic.Topic;
import Forohub.API.main.topic.TopicRepository;
import Forohub.API.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MessageDuplicateValidation implements TopicValidator{
    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(DtoRegisterTopic dtoRegisterTopic) {
        Optional<Topic> topic = topicRepository.findByMessage(dtoRegisterTopic.message());

        if (topic.isPresent()) {
            throw new IntegrityValidation("Ya hay un topico con este mismo mensaje");
        }
    }
}