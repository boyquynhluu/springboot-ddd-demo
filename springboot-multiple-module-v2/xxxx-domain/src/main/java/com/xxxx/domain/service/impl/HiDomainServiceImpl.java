package com.xxxx.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxxx.domain.repository.HiDomainRepository;
import com.xxxx.domain.service.HiDomainService;

@Service
public class HiDomainServiceImpl implements HiDomainService {

    @Autowired
    private HiDomainRepository hiDomainRepository;

    @Override
    public String sayHi(String who) {

        return hiDomainRepository.sayHi(who);
    }

}
