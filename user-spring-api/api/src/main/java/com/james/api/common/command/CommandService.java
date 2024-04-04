package com.james.api.common.command;

import com.james.api.common.component.MessengerVo;

public interface CommandService<T> {
    MessengerVo save (T t);
    String insertMany();
    String delete (T t);
}
