package com.xxxx.ddd.infrastructure.persistence.repository;

import org.springframework.stereotype.Service;

import com.xxxx.domain.repository.HiDomainRepository;

@Service
public class HiInfrasRepositoryImpl implements HiDomainRepository {

    @Override
    public String sayHi(String who) {

        return "Hi Infrastructure " + who;
    }

}
