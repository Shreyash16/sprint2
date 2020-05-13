package com.capgemini.onlinetestmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinetestmanagement.entity.Questions;
import com.capgemini.onlinetestmanagement.exception.QuestionsException;
import com.capgemini.onlinetestmanagement.service.QuestionsService;

@RestController
public class Questionscontroller {

	@Autowired
	QuestionsService questionsservice;

	@CrossOrigin
	@GetMapping("/viewallquestions")
	public ResponseEntity<List<Questions>> getQuestionslist() {
		List<Questions> questionsList = questionsservice.retrieve();
		return new ResponseEntity<List<Questions>>(questionsList, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/addquestions")
	public ResponseEntity<String> addQuestions(@Valid @RequestBody Questions questions, BindingResult bindingResult)
			throws QuestionsException {
		String err = "";
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new QuestionsException(err);
		}
		try {
			questionsservice.addquestions(questions);
			return new ResponseEntity<String>("Questions added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new QuestionsException("Id already exists");
		}
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/deletequestions/{id}")
	public ResponseEntity<String> deleteQuestions(@Valid @RequestParam int questionsId)
			throws QuestionsException {
		try {
			questionsservice.deleteQuestions(questionsId);
			return new ResponseEntity<String>("Questions deleted successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new QuestionsException("Questions Id not exists");
		}
	}
	
	@CrossOrigin
	@PutMapping("/editquestions/{id}")
	public ResponseEntity <String>editquestions(@Valid @RequestBody Questions questions,@RequestParam Integer questionsId,BindingResult br ) throws QuestionsException
	{
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new QuestionsException(err);
		}
		try {
			questionsservice.editquestions(questions,questionsId);
			return new ResponseEntity<String>("Questions updated successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new QuestionsException("Questions already exists");
		}
	}
		
	

}