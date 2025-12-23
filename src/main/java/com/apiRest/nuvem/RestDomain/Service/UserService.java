package com.apiRest.nuvem.RestDomain.Service;

import com.apiRest.nuvem.RestDomain.Model.User;

public interface UserService {


    User findById(Long id);
    User create(User userToCreate);



}
