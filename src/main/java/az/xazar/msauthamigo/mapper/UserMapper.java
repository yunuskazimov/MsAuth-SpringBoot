package az.xazar.msauthamigo.mapper;

import az.xazar.msauthamigo.client.model.permission.PermissionDto;
import az.xazar.msauthamigo.client.model.user.UserDto;
import az.xazar.msauthamigo.domain.Role;
import az.xazar.msauthamigo.domain.RoleTypeEnum;
import az.xazar.msauthamigo.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserMapper {
    public static User toAuthUser(UserDto userDto, List<PermissionDto> permissionDtoList) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setId(userDto.getId());
        Collection<Role> roles = new ArrayList<>();
        permissionDtoList.forEach(permissionDto -> {
            Role role = new Role();
            role.setName(RoleTypeEnum.valueOf(permissionDto.getRole().toString()));
            roles.add(role);
        });
        user.setRoles(roles);
        user.setPassword(userDto.getPassword());

        return user;
    }
}
