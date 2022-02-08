package az.xazar.msauthamigo.controller;

import az.xazar.msauthamigo.service.TokenService;
import az.xazar.msauthamigo.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class AuthController {
    private final UserService userService;
    private final TokenService tokenService;

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("refreshToken controler started");
        tokenService.refreshToken(request, response);

    }

    @PostMapping("/token/active")
    public void activeToken(HttpServletRequest request, HttpServletResponse response) {
       tokenService.activeTokenCheck(request, response);
    }

    @Data
    static class RoleToUserForm {
        private String userName;
        private Set<String> roleName;
    }
}

