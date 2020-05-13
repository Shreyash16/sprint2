package com.capgemini.onlinetestmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.onlinetestmanagement.entity.Questions;

public interface Questionsdao extends JpaRepository<Questions, Integer> {

}
