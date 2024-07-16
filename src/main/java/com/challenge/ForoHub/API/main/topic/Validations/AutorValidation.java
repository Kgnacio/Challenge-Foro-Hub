package Forohub.API.main.topic.validations;

import Forohub.API.main.profile.ProfileRepository;
import Forohub.API.main.topic.Dtos.DtoRegisterTopic;
import Forohub.API.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutorValidation implements TopicValidator{
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void validate(DtoRegisterTopic dtoRegisterTopic) {
        if (profileRepository.findById(dtoRegisterTopic.idAutor()).isEmpty()) {
            throw new IntegrityValidation("No se encontro el perfil");
        }
    }
}