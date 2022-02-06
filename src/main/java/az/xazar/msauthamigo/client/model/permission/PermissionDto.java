package az.xazar.msauthamigo.client.model.permission;

import az.xazar.msauthamigo.domain.RoleTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDto {
    private Long id;
    private Long userId;
    private RoleTypeEnum role;
}
