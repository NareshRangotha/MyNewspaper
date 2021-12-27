package com.newspaper.dao;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.newspaper.model.NewsPaper;


public interface INewspaperDao extends JpaRepository<NewsPaper, Long> {
	@Query(value = "SELECT * FROM news_paper where vendor=:userId", nativeQuery = true)
	public Set<NewsPaper> getNewsPaperByUserId(@Param("userId") long userId);

	
	@Query(value=("select * from news_paper where newspaperid not in (select news_paper_newspaperid from subscription where user_id=:user_id)" ),nativeQuery=true)
	public Set<NewsPaper> getAllNewsPaperNotSubscribe(@Param("user_id") long user_id);

	@Modifying
	@Transactional
	@Query(value=("delete from user_news_paper where newspaper_newspaperid =:paper_id"),nativeQuery=true)
	public void deleteByNewsFk(@Param("paper_id") Long paper_id);
	
	

	@Query(value=("SELECT distinct * FROM  news_paper" ),nativeQuery=true)
	public Set<?> getAllNewsPaperNotSubscribe();

	
}
