package Forohub.API.main.answer.validations;

import Forohub.API.main.answer.DTOS.DtoCreateAnswer;
import Forohub.API.mainn.topic.TopicRepository;
import Forohub.API.main.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicValidation implements AnswerValidation{

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(DtoCreateAnswer dtoCreateAnswer) {
        if (topicRepository.findById(dtoCreateAnswer.idTopic()).isEmpty()) {
            throw new IntegrityValidation("No fue encontrado un topico con este id");
        }
    }
}