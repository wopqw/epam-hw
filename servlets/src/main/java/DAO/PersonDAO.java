package DAO;

import model.Person;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by wopqw on 23.10.16.
 */
public interface PersonDAO {

    Collection<Person> getAll();

    Collection<String> getPersonRole(Person person);

    @SuppressWarnings("unused")
    default Optional<Person> getById(long id){
        return getAll().stream()
                .filter(p -> p.getId() == id)
                .findAny();
    }

    default Optional<Person> isRegistred(String login, String hash){

        return getAll().stream()
                .filter(p -> p.getEmail().equals(login))
                .filter(p -> p.getPassword().equals(hash))
                .findAny();
    }
}
