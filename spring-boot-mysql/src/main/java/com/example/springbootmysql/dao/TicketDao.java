package com.example.springbootmysql.dao;

import com.example.springbootmysql.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TicketDao extends JpaRepository<Ticket, Integer> {

}
