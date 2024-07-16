package Forohub.API.main.topic.Dtos;

import jakarta.validation.constraints.NotNull;

public record DtoRegisterTopic(
        @NotNull
       String title,
       @NotNull
       String message,
       @NotNull
       Long idAutor,
       @NotNull
       Long idCourse
) { }