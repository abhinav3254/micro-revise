package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.dao.QuizDao;
import com.feign.QuizInterface;
import com.pojo.QuestionWrapper;
import com.pojo.Quiz;
import com.pojo.Response;


@Service
public class QuizService {
	
	@Autowired
	private QuizDao quizDao;
	
	@Autowired
	private QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		try {
			
			List<Integer> questionsId = quizInterface.generateQuestionsForQuiz(category, numQ).getBody();
			
			Quiz quiz = new Quiz();
			quiz.setTitle(title);
			quiz.setQuestions(questionsId);
			
			quizDao.save(quiz);
			return new ResponseEntity<String>("created",HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	public List<QuestionWrapper> getQuizQuestion(Integer id) {
		
		
		Quiz quizFromDatabase = quizDao.findById(id).get();
		List<Integer> questions = quizFromDatabase.getQuestions();
		List<QuestionWrapper> list = quizInterface.getQuestionsFromId(questions).getBody();
		
		return list;
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responseList) {
		
		Integer ans = quizInterface.getScore(responseList).getBody();
		
		return new ResponseEntity<Integer>(ans,HttpStatus.OK);
	}

}
