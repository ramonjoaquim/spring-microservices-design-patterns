package cqrs.aggregates;

import cqrs.commands.UserCommand;
import domain.models.User;
import cqrs.repository.UserWriteRepository;

public class UserAggregate {
    private UserWriteRepository writeRepository;

    public UserAggregate(UserWriteRepository repository) {
        this.writeRepository = repository;
    }

    public User handleCreateUserCommand(UserCommand.CreateUserCommand command) {
        User user = new User(command.getUserId(), command.getFirstName(), command.getLastName());
        writeRepository.addUser(user.getId(), user);
        return user;
    }

    public User handleUpdateUserCommand(UserCommand.UpdateUserCommand command) {
        User user = writeRepository.getUser(command.getUserId());
        user.setAddresses(command.getAddresses());
        user.setContacts(command.getContacts());
        writeRepository.addUser(user.getId(), user);
        return user;
    }
}
