package com.sbitla1.springboot.schedulemessage.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "message")
	private String message;

	@Column(name = "delivery_Date")
	private LocalDateTime deliveryDate;

	public Message() {

	}

	public Message(String message, LocalDateTime deliveryDate) {
		this.message = message;
		this.deliveryDate = deliveryDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", message=" + message + ", deliveryDate=" + deliveryDate + "]";
	}

}
