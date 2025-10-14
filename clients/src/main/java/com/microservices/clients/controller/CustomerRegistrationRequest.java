package com.microservices.clients.controller;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {

}
