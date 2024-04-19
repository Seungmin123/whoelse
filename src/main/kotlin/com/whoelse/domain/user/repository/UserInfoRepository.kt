package com.whoelse.domain.user.repository

import com.whoelse.domain.user.model.UserInfo
import org.springframework.data.jpa.repository.JpaRepository

interface UserInfoRepository: JpaRepository<UserInfo, Long>