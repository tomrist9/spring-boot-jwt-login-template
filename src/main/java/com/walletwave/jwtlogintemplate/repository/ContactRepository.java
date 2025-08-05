package com.walletwave.jwtlogintemplate.repository;

import com.walletwave.jwtlogintemplate.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {


}
