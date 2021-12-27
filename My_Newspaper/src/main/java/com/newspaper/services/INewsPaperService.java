package com.newspaper.services;

import java.util.Set;

import com.newspaper.model.NewsPaper;

public interface INewsPaperService {
	
	/**
	 * This method is used to create newspaper
	 * @param newsPaper
	 * @return newspaper
	 */
	public NewsPaper createNewspaper(NewsPaper newsPaper);

	/**
	 * This method is used to get newspaper by newspaperid
	 * @param newsPaperid
	 * @return newspaper
	 */
	public NewsPaper getNewspaper(Long newsPaperid);

	/**
	 * This method is used to get newspaper by vendorid
	 * @param userId
	 * @return set of newspaper
	 */
	public Set<NewsPaper> getNewspaperByUserId(long userId);

	 /**
	  * This method is used to get all newspaper
	 * @param user_id
	 * @return set of newspaper
	 */
	public Set<NewsPaper> getAllNewsPaper(long user_id);

	/**
	 * This method is used to update newspaper by newspaperid
	 * @param newsPaper
	 * @return newspaper
	 */
	public NewsPaper updateNewspaper(NewsPaper newsPaper);

	
	
	//delete 
	NewsPaper deleteNewspaper(long newsPaperId) throws Exception;

	public void deleteNewspaperFk(Long paper_id);


	

}