package Forohub.API.main.user.Dtos;

import jakarta.validation.constraints.NotNull;

public record DtoAunthetication(
        @NotNull
        String username,
        @NotNull
        String password
) {}