package com.whoelse.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/user")
@RestController
class UserController {

    @GetMapping("/health")
    fun userHealthCheck(): String {
        return "OK"
    }
}