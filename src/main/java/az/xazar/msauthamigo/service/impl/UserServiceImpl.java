package az.xazar.msauthamigo.service.impl;

import az.xazar.msauthamigo.client.PermissionClientRest;
import az.xazar.msauthamigo.client.UserClientRest;
import az.xazar.msauthamigo.client.model.permission.PermissionDto;
import az.xazar.msauthamigo.client.model.user.UserDto;
import az.xazar.msauthamigo.domain.User;
import az.xazar.msauthamigo.mapper.UserMapper;
import az.xazar.msauthamigo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserClientRest userClient;
    private final PermissionClientRest permissionClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);

        checkUser(username, user);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName().name()));
        });
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        UserDto userDto = userClient.getByUsername(username);
        List<PermissionDto> roleList = permissionClient.getRoleListByUserId(userDto.getId());
        log.info("roleList: {},", roleList);
        return UserMapper.toAuthUser(userDto, roleList);
    }

    private void checkUser(String username, User user) {
        if (user == null) {
            log.info("User not found in the DB");
            throw new UsernameNotFoundException("User not found in the DB");
        } else {
            log.info("User found in the DB: {}", username);
        }
    }
}
