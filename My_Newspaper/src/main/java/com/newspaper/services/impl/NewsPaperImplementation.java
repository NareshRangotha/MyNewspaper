package com.newspaper.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newspaper.dao.INewspaperDao;
import com.newspaper.model.NewsPaper;
import com.newspaper.services.INewsPaperService;

@Service
public class NewsPaperImplementation implements INewsPaperService {

	@Autowired
	private INewspaperDao newsPaperRepository;

	@Override
	public NewsPaper createNewspaper(NewsPaper newsPaper) {

		return this.newsPaperRepository.save(newsPaper);
	}

	@Override
	public NewsPaper getNewspaper(Long newsPaperid) {

		return this.newsPaperRepository.findById(newsPaperid).get();
	}

	@Override
	public NewsPaper updateNewspaper(NewsPaper newsPaper) {

		return this.newsPaperRepository.save(newsPaper);
	}

	@Override
	public NewsPaper deleteNewspaper(long newsPaperId) throws Exception {

		NewsPaper deletedNews = null;
		try {
			deletedNews = newsPaperRepository.findById(newsPaperId).orElse(null);
			if (deletedNews == null) {
				throw new Exception("News not available");
			} else {
				newsPaperRepository.deleteById(newsPaperId);
			}
		} catch (Exception ex) {
			throw ex;
		}
		return deletedNews;
	}

	@Override
	public Set<NewsPaper> getAllNewsPaper(long user_id) {

		return this.newsPaperRepository.getAllNewsPaperNotSubscribe(user_id);
	}

	@Override
	public Set<NewsPaper> getNewspaperByUserId(long userId) {

		return newsPaperRepository.getNewsPaperByUserId(userId);
	}

	@Override
	public void deleteNewspaperFk(Long paper_id) {
		newsPaperRepository.deleteByNewsFk(paper_id);

	}

}
