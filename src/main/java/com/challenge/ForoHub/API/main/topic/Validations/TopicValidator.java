package Forohub.API.main.topic.validations;

import Forohub.API.main.topic.Dtos.DtoRegisterTopic;

public interface TopicValidator {
    void validate(DtoRegisterTopic dtoRegisterTopic);
}