package com.walletwave.jwtlogintemplate.repository;

import java.util.List;

import com.walletwave.jwtlogintemplate.model.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {

    @Query("FROM Notice n WHERE CURRENT_TIMESTAMP BETWEEN n.noticBegDt AND n.noticEndDt")
    List<Notice> findAllActiveNotices();

}
