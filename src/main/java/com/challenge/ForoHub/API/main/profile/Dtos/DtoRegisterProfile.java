package Forohub.API.main.profile.Dtos;

import jakarta.validation.constraints.NotNull;

public record DtoRegisterProfile(
        @NotNull
        String name,
        @NotNull
        String email
) {
}