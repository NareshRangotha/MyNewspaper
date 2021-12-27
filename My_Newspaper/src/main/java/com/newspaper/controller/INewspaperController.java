package com.newspaper.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.newspaper.model.NewsPaper;

public interface INewspaperController {

	/**
	 * This method is used to get all newspapers
	 * @return list of newspapers
	 */
	@GetMapping("/getAllNewspapers/{user_id}")
	public ResponseEntity<Set<NewsPaper>> getAllNewspapers(@PathVariable("user_id") Long user_id);

	/**
	 * This method is used to get newspapers by vendor
	 * @param vendor_id
	 * @return list of newspapers
	 */
	@GetMapping("/getAllNewspapersByVendor/{vendor_id}")
	public ResponseEntity<Set<NewsPaper>> getAllNewspapersByVendor(@PathVariable("vendor_id") Long vendor_id);

	/**
	 * This method is used to delete newspaper by newspaper
	 * @param paper_id
	 * @return string
	 */
	@DeleteMapping("/deleteNewspaperByNewspaperId/{paper_id}")
	public ResponseEntity<?> deleteNewspaperByNewspaperId(@PathVariable("paper_id") Long paper_id);

	/**
	 * This method is used to add newspaper by vendor
	 * @param newspaper
	 * @return newspaper
	 */
	@PostMapping("/addNewspaperByVendorId")
	public NewsPaper addNewspaperByVendorId(@RequestBody NewsPaper news, HttpServletRequest request);

	/**
	 * This method is used to update newspaper by newspaper 
	 * @param newspaper
	 * @return newspaper
	 */
	@PutMapping("/updateNewspaper/{news_id}")
	public ResponseEntity<NewsPaper> updateNewspaper(@RequestBody NewsPaper newspaper, @PathVariable("news_id") long news_id);


	/**
	 * This method is used to get newspaper by newspaperId
	 * @param news_id
	 * @return newspaper
	 */
	@GetMapping("/getNewspaper/{news_id}")
	public ResponseEntity<NewsPaper> getNewspaper(@PathVariable("news_id") long news_id);
	
	

}
