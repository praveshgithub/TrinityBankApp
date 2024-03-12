package com.example.trinitybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trinitybank.entity.Contact;

public interface ContactRespository extends JpaRepository<Contact, String>{

}
