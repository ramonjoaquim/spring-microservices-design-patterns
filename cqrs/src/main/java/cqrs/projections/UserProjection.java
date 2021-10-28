package cqrs.projections;

import cqrs.queries.AddressByRegionQuery;
import cqrs.queries.ContactByTypeQuery;
import cqrs.repository.UserReadRepository;
import domain.models.Address;
import domain.models.Contact;
import domain.models.UserAddress;
import domain.models.UserContact;

import java.util.Set;

public class UserProjection {
    private UserReadRepository readRepository;
    public UserProjection(UserReadRepository readRepository) {
        this.readRepository = readRepository;
    }

    public Set<Contact> handle(ContactByTypeQuery query) {
        UserContact userContact = readRepository.getUserContact(query.getUserId());
        return userContact.getContactByType()
                .get(query.getContactType());
    }

    public Set<Address> handle(AddressByRegionQuery query) {
        UserAddress userAddress = readRepository.getUserAddress(query.getUserId());
        return userAddress.getAddressByRegion()
                .get(query.getState());
    }
}
