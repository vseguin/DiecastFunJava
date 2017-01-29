package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.models.CarQueryModel;
import com.personal.diecastfun.controllers.models.CarQueryResultModel;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.controllers.service.ViewsFacade;
import com.personal.diecastfun.controllers.service.VotesFacade;

@Controller
@RequestMapping(value = "/cars")
public class CarsController extends BasicController
{

    @Inject
    private CarFacade carFacade;
    @Inject
    private ViewsFacade viewsFacade;
    @Inject
    private VotesFacade votesFacade;

    @RequestMapping(method = RequestMethod.GET, params = "brand")
    public ModelAndView getCars(@RequestParam(required = false, value = "brand") String brand,
                                @RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                @RequestParam(required = false, value = "perPage", defaultValue = "20") Integer perPage)
    {

        ModelAndView mv = getModelAndView("carlist");

        CarQueryResultModel queryResult = carFacade.findCars(new CarQueryModel().withBrand(brand)
                                                                                .withPage(page)
                                                                                .withPerPage(perPage));

        mv.addObject("cars", queryResult.getCars());
        mv.addObject("page", page);
        mv.addObject("perPage", perPage);
        mv.addObject("query", "?brand=" + brand);
        mv.addObject("title", "Car brand - " + brand);
        mv.addObject("totalCount", queryResult.getTotalCount());

        return mv;
    }

    @RequestMapping(value = "/{carId}", method = RequestMethod.GET)
    public ModelAndView getSpecificCar(@PathVariable String carId)
    {
        viewsFacade.addView(carId);
        ModelAndView mv = getModelAndView("cardetails");

        mv.addObject("id", carId);
        mv.addObject("car", carFacade.findCarById(carId));
        mv.addObject("seealso", carFacade.findSeeAlso(carId));
        mv.addObject("votes", votesFacade.getVotesById(carId));
        mv.addObject("views", viewsFacade.getViews(carId));

        return mv;
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public ModelAndView getRandomCar()
    {
        return getSpecificCar(carFacade.findRandomCarId());
    }
}
