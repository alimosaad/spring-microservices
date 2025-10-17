package com.microservices.clients.services;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {

}
