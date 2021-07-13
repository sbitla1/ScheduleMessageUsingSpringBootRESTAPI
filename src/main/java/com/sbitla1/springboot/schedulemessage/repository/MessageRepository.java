package com.sbitla1.springboot.schedulemessage.repository;

import com.sbitla1.springboot.schedulemessage.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.List;

@EnableJpaRepositories
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllMessageByDeliveryDate(Date deliveryDate);
}
