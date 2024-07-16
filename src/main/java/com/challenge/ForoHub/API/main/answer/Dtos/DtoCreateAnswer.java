package Forohub.API.main.answer.Dtos;

import jakarta.validation.constraints.NotNull;

public record DtoCreateAnswer(
        @NotNull
        String message,
        @NotNull
        Long idAutor,
        @NotNull
        Long idTopic
) {}