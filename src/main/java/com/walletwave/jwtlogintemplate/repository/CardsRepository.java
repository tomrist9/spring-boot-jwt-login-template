package com.walletwave.jwtlogintemplate.repository;

import java.util.List;


import com.walletwave.jwtlogintemplate.model.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {

    List<Cards> findByCustomerId(long customerId);

}