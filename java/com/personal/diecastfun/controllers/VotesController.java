package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.service.VotesFacade;

@Controller
@RequestMapping(value = "/vote")
public class VotesController {

	@Inject
	private VotesFacade votesFacade;

	@RequestMapping(value = "/add/{carId}", method = RequestMethod.POST)
	public ModelAndView increaseVote(@PathVariable String carId) {
		ModelAndView mv = new ModelAndView("carvotes");

		votesFacade.increaseVote(carId);

		mv.addObject("id", carId);
		mv.addObject("votes", votesFacade.getVotesById(carId));
		return mv;
	}

	@RequestMapping(value = "/minus/{carId}", method = RequestMethod.POST)
	public ModelAndView decreaseVote(@PathVariable String carId) {
		ModelAndView mv = new ModelAndView("carvotes");

		votesFacade.decreaseVote(carId);

		mv.addObject("id", carId);
		mv.addObject("votes", votesFacade.getVotesById(carId));
		return mv;
	}
}
