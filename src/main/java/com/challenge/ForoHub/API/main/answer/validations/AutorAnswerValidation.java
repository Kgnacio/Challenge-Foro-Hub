package Forohub.API.main.answer.validations;

import Forohub.API.main.answer.DTOS.DtoCreateAnswer;
import Forohub.API.main.profile.ProfileRepository;
import Forohub.API.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AutorAnswerValidation implements AnswerValidation{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void validate(DtoCreateAnswer dtoCreateAnswer) {
        if (profileRepository.findById(dtoCreateAnswer.idAutor()).isEmpty()) {
            throw new IntegrityValidation("No fue encontrado un perfil con este id");
        }
    }
}