package Forohub.API.main.topic.validations;
import Forohub.API.main.topic.Dtos.DtoRegisterTopic;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class MessageLengthValidation implements TopicValidator {

    public void validate(DtoRegisterTopic dtoRegisterTopic) {
        if (dtoRegisterTopic.message().length() < 10) {
            throw new ValidationException("El mensaje es muy corto");
        }
        if (dtoRegisterTopic.message().length() > 99) {
            throw new ValidationException("El mensaje es muylargo");
        }
    }
}