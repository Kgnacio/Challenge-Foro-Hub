package Forohub.API.controller;

import Forohub.API.main.user.DTOS.DtoAunthetication;
import Forohub.API.main.user.DTOS.DtoJwtToken;
import Forohub.API.main.user.User;
import Forohub.API.infra.security.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "Autenticacion", description = "obtiene el token para el usuario")
public class AutenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid DtoAunthetication dtoAunthetication) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(dtoAunthetication.username(), dtoAunthetication.password());
        Authentication userAuth = authenticationManager.authenticate(authToken);
        String jwtToken = tokenService.generateToken((User) userAuth.getPrincipal());
        return ResponseEntity.ok(new DtoJwtToken(jwtToken));
    }

}