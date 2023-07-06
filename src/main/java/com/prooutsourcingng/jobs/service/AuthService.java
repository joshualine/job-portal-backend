package com.prooutsourcingng.jobs.service;

import com.prooutsourcingng.jobs.payload.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
