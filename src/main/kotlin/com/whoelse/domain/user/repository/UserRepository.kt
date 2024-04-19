package com.whoelse.domain.user.repository

import com.whoelse.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String>