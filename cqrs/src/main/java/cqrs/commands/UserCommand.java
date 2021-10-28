package cqrs.commands;

import domain.models.Address;
import domain.models.Contact;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public class UserCommand {

    @Getter
    @Setter
    public static class CreateUserCommand {
        private String userId;
        private String firstName;
        private String lastName;
    }

    @Getter
    @Setter
    public static class UpdateUserCommand {
        private String userId;
        private Set<Address> addresses;
        private Set<Contact> contacts;
    }
}
