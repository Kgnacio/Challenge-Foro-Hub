package Forohub.API.main.profile.Dtos;

import jakarta.validation.constraints.NotNull;

public record DtoUpdateProfile(
        @NotNull
        Long id,
        String name,
        String email
) { }