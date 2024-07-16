package Forohub.API.main.answer.Dtos;

import jakarta.validation.constraints.NotNull;

public record DtoUpdateAnswer(
        @NotNull
        Long id,
        String message,
        Boolean solution
) {}