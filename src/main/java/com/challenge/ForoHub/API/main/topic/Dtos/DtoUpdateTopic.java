package Forohub.API.main.topic.Dtos;

import jakarta.validation.constraints.NotNull;

public record DtoUpdateTopic(
        @NotNull
        Long id,
        String title,
        String message,
        Boolean status
) {
}