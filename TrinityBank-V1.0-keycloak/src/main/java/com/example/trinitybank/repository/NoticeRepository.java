package com.example.trinitybank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.trinitybank.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

	@Query(value = "from Notice n where CURDATE() BETWEEN noticeBegDt AND noticeEndDt")
	List<Notice> findAllActiveNotices();
}
