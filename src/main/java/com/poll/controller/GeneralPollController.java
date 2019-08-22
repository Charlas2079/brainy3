package com.poll.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.poll.brainy.GeneralAnswer;
import com.poll.brainy.GeneralPoll;
import com.poll.brainy.GeneralQuestion;
import com.poll.brainy.GeneralUser;
import com.poll.repo.GeneralAnswerRepository;
import com.poll.repo.GeneralPollRepository;
import com.poll.repo.GeneralQuestionRepository;
import com.poll.repo.GeneralUserRepository;

@RestController
public class GeneralPollController {
		
	@Autowired
    private GeneralPollRepository generalPollRepository;
	
	@Autowired
    private GeneralQuestionRepository generalQuestionRepository;
	
	@Autowired
    private GeneralAnswerRepository generalAnswerRepository;
	
	@Autowired
    private GeneralUserRepository generalUserRepository;
	
		@GetMapping("/api/generalPolls/{encuestaId}")
		  public GeneralPoll getPollById(@PathVariable (value = "encuestaId") Integer encuestaId) {
		    GeneralPoll gp = new GeneralPoll();
		    List <GeneralQuestion> gq = new ArrayList();
		    List <GeneralAnswer> ga = new ArrayList();
		    List <GeneralUser> gu = new ArrayList();
		    //GeneralPoll gpAux = new GeneralPoll();
		    gp = generalPollRepository.findPollById(encuestaId);
		    gq = generalQuestionRepository.findQuestionsById(encuestaId);
		    for (GeneralQuestion gq1:gq){
		    	ga = generalAnswerRepository.findAnswersById(encuestaId, gq1.getIdPregunta());
		    	gq1.setAnswers(ga);
		    	ga = new ArrayList();
		    }
		    gu = generalUserRepository.findUsersById(encuestaId);
		    //gp.setFecha_cierre(Date.valueOf(gpAux.getFecha_cierre().toString()));
		    //gp = repository.findPollById(id);
		    gp.setUsers(gu);
		    gp.setQuestions(gq);
		    //gp.setUsers(null);
		    return gp;
		  }
}
