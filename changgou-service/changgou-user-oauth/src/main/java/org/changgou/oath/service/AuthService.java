package org.changgou.oath.service;


import org.changgou.oath.util.AuthToken;

public interface AuthService {

    AuthToken login(String username, String password, String clientId, String clientSecret);
}
