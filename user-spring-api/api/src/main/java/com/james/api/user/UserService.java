package com.james.api.user;
import com.james.api.common.command.CommandService;
import com.james.api.common.query.QueryService;

import java.util.List;

public interface UserService extends CommandService, QueryService {
    // command
    String updatePassword(User user);
    // query
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);

}
