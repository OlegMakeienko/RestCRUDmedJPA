package com.makeienko.restcrudmedjpa.repository;

import com.makeienko.restcrudmedjpa.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
