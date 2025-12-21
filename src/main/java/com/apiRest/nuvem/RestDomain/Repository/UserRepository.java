package com.apiRest.nuvem.RestDomain.Repository;

import com.apiRest.nuvem.RestDomain.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}


