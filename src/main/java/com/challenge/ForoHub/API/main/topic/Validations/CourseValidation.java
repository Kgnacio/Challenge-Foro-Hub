package Forohub.API.main.topic.validations;

import Forohub.API.main.course.CourseRepository;
import Forohub.API.main.topic.Dtos.DtoRegisterTopic;
import Forohub.API.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseValidation implements TopicValidator{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void validate(DtoRegisterTopic dtoRegisterTopic) {
        if (courseRepository.findById(dtoRegisterTopic.idCourse()).isEmpty()) {
            throw new IntegrityValidation("No se encontro el perfil");
        }
    }
}