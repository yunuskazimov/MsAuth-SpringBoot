package az.xazar.msauthamigo.client;

import az.xazar.msauthamigo.client.model.permission.PermissionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class PermissionClientRest {
    private final RestTemplate restTemplate;
    private final String apiUrl;

    public PermissionClientRest(RestTemplate restTemplate
            , @Value("${client.permission.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    public List<PermissionDto> getRoleListByUserId(Long userId) {
        String url = String.format("%s/%s/%d", apiUrl, "uid", userId);
        log.info("get role by user id:{}, Path: {}", userId, url);
        PermissionDto[] list = restTemplate.getForObject(url, PermissionDto[].class);
        assert list != null;
        return Arrays.stream(list).collect(Collectors.toList());
    }

}


