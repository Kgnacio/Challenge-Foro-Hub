package Forohub.API.main.answer.validations;

import Forohub.API.main.answer.DTOS.DtoCreateAnswer;

public interface AnswerValidation {
    void validate(DtoCreateAnswer dtoCreateAnswer);
}