package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.personal.diecastfun.controllers.models.ValueModel;
import com.personal.diecastfun.controllers.service.VotesFacade;

@RestController
@RequestMapping(value = "/cars/{carId}/votes")
public class VotesController
{
    @Inject
    private VotesFacade votesFacade;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ValueModel increaseVote(@PathVariable String carId)
    {
        votesFacade.increaseVote(carId);

        return new ValueModel().withValue(String.valueOf(votesFacade.getVotesById(carId)));
    }

    @RequestMapping(value = "/minus", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ValueModel decreaseVote(@PathVariable String carId)
    {
        votesFacade.decreaseVote(carId);

        return new ValueModel().withValue(String.valueOf(votesFacade.getVotesById(carId)));
    }
}
