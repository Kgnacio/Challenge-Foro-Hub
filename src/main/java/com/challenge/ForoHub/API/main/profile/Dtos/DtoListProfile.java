package Forohub.API.main.profile.Dtos;

import java.util.List;


public record DtoListProfile(
        Long id,
        String nombre,
        String email,
        List<String> topicos
){}