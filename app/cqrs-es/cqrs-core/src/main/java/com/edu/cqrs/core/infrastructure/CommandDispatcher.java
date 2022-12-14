package com.edu.cqrs.core.infrastructure;

import com.edu.cqrs.core.commands.BaseCommand;
import com.edu.cqrs.core.commands.CommandHandlerMethod;

public interface CommandDispatcher {

    <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handler);
    void send(BaseCommand command);
}
