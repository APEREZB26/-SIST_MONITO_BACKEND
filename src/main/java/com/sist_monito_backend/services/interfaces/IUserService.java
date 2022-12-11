package com.sist_monito_backend.services.interfaces;

import com.sist_monito_backend.entities.User;

import java.util.Optional;

public interface IUserService {
   Optional<User> findByEmail(String email);
}
