package com.james.api.user.service;
import com.james.api.common.component.Messenger;
import com.james.api.common.service.CommandService;
import com.james.api.common.service.QueryService;
import com.james.api.user.model.User;
import com.james.api.user.model.UserDto;

import java.util.List;
import java.util.Optional;
public interface UserService extends CommandService<UserDto>, QueryService<UserDto> {
    // command
    Messenger modify(UserDto user);
    // query
    Messenger login(UserDto param);
    Optional<User> findUsersByName(String name);
    List<UserDto> findUsersByJob(String job);

    default User dtoToEntity(UserDto dto){
        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .name(dto.getName())
                .phone(dto.getPhone())
                .job(dto.getJob())
                .build();
    }

    default UserDto entityToDto(User ent) {
        return UserDto.builder()
                .username(ent.getUsername())
                .password(ent.getPassword())
                .name(ent.getName())
                .phone(ent.getPhone())
                .job(ent.getJob())
                .build();
    }


}


