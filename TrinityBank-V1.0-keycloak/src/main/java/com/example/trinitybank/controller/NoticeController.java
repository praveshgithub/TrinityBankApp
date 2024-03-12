package com.example.trinitybank.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trinitybank.entity.Notice;
import com.example.trinitybank.repository.NoticeRepository;

@RestController
public class NoticeController {

	@Autowired
	private NoticeRepository noticeRepository;

	@GetMapping("/notices")
	public ResponseEntity<List<Notice>> getNotice() {
		List<Notice> notices = this.noticeRepository.findAllActiveNotices();

		if (notices != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS)).body(notices);

		} else {
			return null;
		}
	}
}
