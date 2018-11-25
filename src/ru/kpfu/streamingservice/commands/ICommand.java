package ru.kpfu.streamingservice.commands;

import ru.kpfu.streamingservice.*;

public interface ICommand {
    public Object execute(String name, User u1);
}
