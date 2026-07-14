package com.xxxx.ddd.application.service.event.impl;

import org.springframework.stereotype.Service;

import com.xxxx.ddd.application.service.event.EventAppService;
import com.xxxx.domain.service.HiDomainService;

import jakarta.annotation.Resource;

@Service
public class EventAppServiceImpl implements EventAppService {

    // Call Domain Service
    @Resource
    private HiDomainService hiDomainService;

    @Override
    public String sayHi(String who) {
        return hiDomainService.sayHi(who);
    }

}
