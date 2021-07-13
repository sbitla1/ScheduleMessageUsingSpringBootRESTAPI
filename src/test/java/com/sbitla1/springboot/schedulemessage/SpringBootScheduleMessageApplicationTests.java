package com.sbitla1.springboot.schedulemessage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbitla1.springboot.schedulemessage.controller.MessageController;
import com.sbitla1.springboot.schedulemessage.model.Message;
import com.sbitla1.springboot.schedulemessage.repository.MessageRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class SpringBootScheduleMessageApplicationTests {

	private Message message;

	@MockBean
	private MessageRepository messageRepository;

}
