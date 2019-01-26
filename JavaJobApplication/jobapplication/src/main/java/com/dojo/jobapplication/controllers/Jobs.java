package com.dojo.jobapplication.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dojo.jobapplication.models.Job;
import com.dojo.jobapplication.models.User;
import com.dojo.jobapplication.services.JobService;
import com.dojo.jobapplication.services.UserService;

@Controller
public class Jobs {

	private final JobService jobService;
	private final UserService userService;
	
	public Jobs(JobService jobService, UserService userService) {
		this.jobService = jobService;
		this.userService = userService;
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		
		List<Job> jobs = jobService.findAllJobs();
		model.addAttribute("jobs", jobs);
		
		User user=userService.findById((Long) session.getAttribute("id"));
		System.out.println("Displaying user: " + user.getFirstName());
		
		return "dashboard";
	}
	
	@GetMapping("/createJob")
	public String newJob(HttpSession session, Model model) {
		
		System.out.println("User: " + userService.findById((Long) session.getAttribute("id")));
		model.addAttribute("this_user", userService.findById((Long) session.getAttribute("id")));
		model.addAttribute("job", new Job());
		
		return "new_job";
	}
	
}
