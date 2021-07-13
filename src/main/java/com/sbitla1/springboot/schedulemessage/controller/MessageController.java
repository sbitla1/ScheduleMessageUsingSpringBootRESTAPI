package com.sbitla1.springboot.schedulemessage.controller;

import com.sbitla1.springboot.schedulemessage.exceptionHandler.GlobalExceptionHandler;
import com.sbitla1.springboot.schedulemessage.exceptionHandler.ResourceNotFoundException;
import com.sbitla1.springboot.schedulemessage.model.Message;
import com.sbitla1.springboot.schedulemessage.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	MessageRepository messageRepository;

	@GetMapping("/messages")
	public ResponseEntity<List<Message>> getAllMessages(@RequestParam(required = false) String message) throws GlobalExceptionHandler {
		try {
			List<Message> messages = new ArrayList<Message>();

			if (message == null){
				messageRepository.findAll().forEach(messages::add);
			}
			if (messages.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(messages, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/messages/{id}")
	public ResponseEntity<Message> getMessageById(@PathVariable("id") long id) {
		Optional<Message> messageData = messageRepository.findById(id);

		if (messageData.isPresent()) {
			return new ResponseEntity<>(messageData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/messages")
	public ResponseEntity<Message> scheduleMessage(@RequestBody Message message) {
		try {
			Message _message = messageRepository
					.save(new Message(message.getMessage(), message.getDeliveryDate()));
			return new ResponseEntity<>(_message, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/messages/{id}")
	public ResponseEntity<Message> updateMessage(@PathVariable("id") long id, @RequestBody Message message) {
		Optional<Message> tutorialData = messageRepository.findById(id);

		if (tutorialData.isPresent()) {
			Message _message = tutorialData.get();
			_message.setMessage(message.getMessage());
			_message.setDeliveryDate(message.getDeliveryDate());
			return new ResponseEntity<>(messageRepository.save(_message), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@DeleteMapping("/messages/{id}")
	public ResponseEntity<HttpStatus> deleteMessage(@PathVariable("id") long id) {
		try {
			messageRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/messages")
	public ResponseEntity<HttpStatus> deleteAllMessage() {
		try {
			messageRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/messages/deliveryDate")
	public ResponseEntity<List<Message>> findMessagesByDeliveryDate()
		{
		try {
			LocalDateTime myObj = LocalDateTime.now();
			List<Message> result = messageRepository.findAllMessageByDeliveryDate(
					new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(myObj)));

			if (result.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
