package com.newspaper.controller.impl;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newspaper.controller.INewspaperController;
import com.newspaper.model.NewsPaper;
import com.newspaper.services.INewsPaperService;

@RestController

@CrossOrigin("http://localhost:4200")

@RequestMapping(path = "/newspaper")
public class NewspaperController implements INewspaperController {

	private Logger logger = LoggerFactory.getLogger(NewspaperController.class);

	@Autowired
	private INewsPaperService newspaperService;

	@Override
	public ResponseEntity<Set<NewsPaper>> getAllNewspapers(@PathVariable("user_id") Long user_id) {

		logger.info("Inside @class :NewspaperController @Method :getAllNewspapers");
		Set<NewsPaper> listOfNewsPapers = null;
		listOfNewsPapers = this.newspaperService.getAllNewsPaper(user_id);

		return new ResponseEntity<Set<NewsPaper>>(listOfNewsPapers, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Set<NewsPaper>> getAllNewspapersByVendor(@PathVariable("vendor_id") Long vendor_id) {
		logger.info("Inside @class :NewspaperController @Method :getAllNewspapersByVendor");
		Set<NewsPaper> listOfNewsPapers = null;
		listOfNewsPapers = this.newspaperService.getNewspaperByUserId(vendor_id);
		return new ResponseEntity<Set<NewsPaper>>(listOfNewsPapers, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<NewsPaper> deleteNewspaperByNewspaperId(@PathVariable("paper_id") Long paper_id) {
		logger.info("Inside @class :NewspaperController @Method :deleteNewspaperByNewspaperId");
		NewsPaper news = null;
		if (paper_id == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		try {
			 this.newspaperService.deleteNewspaper(paper_id);

		} catch (Exception ex) {
			ex.getMessage();
			return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
		}
		return new ResponseEntity<NewsPaper>(news, HttpStatus.OK);
	}

	@PostMapping("/addNewspaperByVendorId/")
	public NewsPaper addNewspaperByVendorId(@RequestBody NewsPaper news, HttpServletRequest request) {
		try {
			logger.info("Inside @class :NewspaperController @Method :addNewspaperByVendorId");
			return this.newspaperService.createNewspaper(news);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResponseEntity<NewsPaper> updateNewspaper(@RequestBody NewsPaper newsPaper,
			@PathVariable("news_id") long news_id) {
		try {
			logger.info("Inside @class :NewspaperController @Method :updateNewspaper");
			NewsPaper news1 = newspaperService.getNewspaper(news_id);
			news1.setDescription(newsPaper.getDescription());
			news1.setLanguage(newsPaper.getLanguage());
			news1.setRate(newsPaper.getRate());
			news1.setTitle(newsPaper.getTitle());
			newspaperService.updateNewspaper(news1);
			return new ResponseEntity<NewsPaper>(news1, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public ResponseEntity<NewsPaper> getNewspaper(long news_id) {

		NewsPaper news1 = newspaperService.getNewspaper(news_id);

		return new ResponseEntity<NewsPaper>(news1, HttpStatus.OK);
	}

}
