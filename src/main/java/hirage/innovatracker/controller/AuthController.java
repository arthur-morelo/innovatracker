package hirage.innovatracker.controller;


import hirage.innovatracker.dto.LoginRequestDTO;
import hirage.innovatracker.dto.LoginResponseDTO;
import hirage.innovatracker.dto.PessoaResumoDTO;
import hirage.innovatracker.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;


    /** Autentica a pessoa e devolve o token JWT. Rota pública. */
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }


    /** Devolve os dados da pessoa autenticada. Requer header Authorization: Bearer {token}. */
    @GetMapping("/me")
    public ResponseEntity<PessoaResumoDTO> me(Authentication authentication) {
        return ResponseEntity.ok(authService.buscarPorEmail(authentication.getName()));
    }
}
