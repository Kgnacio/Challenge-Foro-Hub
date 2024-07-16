package Forohub.API.main.topic.validations;

import Forohub.API.main.topic.Dtos.DtoRegisterTopic;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class TitleValidation implements TopicValidator{

    public void validate(DtoRegisterTopic dtoRegisterTopic) {
        if (dtoRegisterTopic.title().length() < 4) {
            throw new ValidationException("El titulo es muy corto");
        }
    }
}