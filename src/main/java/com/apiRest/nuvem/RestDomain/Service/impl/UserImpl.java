package com.apiRest.nuvem.RestDomain.Service.impl;

import com.apiRest.nuvem.RestDomain.Controller.GlobalHadle.ExistingUser;
import com.apiRest.nuvem.RestDomain.Model.User;
import com.apiRest.nuvem.RestDomain.Repository.UserRepository;
import com.apiRest.nuvem.RestDomain.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class UserImpl implements UserService {

    private final UserRepository repository;

    public UserImpl(UserRepository repository){
       this.repository =  repository;
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) throws ExistingUser {
        if(userToCreate.getId() != null && repository.existsById(userToCreate.getId())){
            throw new ExistingUser("This user ID already exist" );
        }
        return repository.save(userToCreate);
    }
}
