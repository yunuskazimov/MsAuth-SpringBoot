package az.xazar.msauthamigo.client;

import az.xazar.msauthamigo.client.model.user.UserDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class UserClientRest {
    private final RestTemplate restTemplate;
    private final String apiUrl;

    public UserClientRest(RestTemplate restTemplate
            , @Value("${client.users.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    public UserDto getByUsername(String username) {
        String url = String.format("%s/%s", apiUrl, "u");
        GetUsernameForm form = new GetUsernameForm();
        form.setUsername(username);
        log.info("get user with rest. Path: {}", url);
        return restTemplate.postForObject(url, form, UserDto.class);
    }
}

@Data
class GetUsernameForm {
    private String username;
}