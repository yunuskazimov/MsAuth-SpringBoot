package az.xazar.msauthamigo.client.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private boolean isDeleted;
    private String username;
    private String password;
    private String email;
}
