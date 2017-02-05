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
    public ModelAndView getCarsWithBrand(@RequestParam(required = false, value = "brand") String brand,
                                         @RequestParam(required = false,
                                                       value = "page",
                                                       defaultValue = "0") Integer page,
                                         @RequestParam(required = false,
                                                       value = "perPage",
                                                       defaultValue = "20") Integer perPage)
    {

        CarQueryModel carQueryModel = new CarQueryModel().withBrand(brand).withPage(page).withPerPage(perPage);

        return getModelAndView(carQueryModel, "?brand=" + brand, "Car brand - " + brand);
    }

    @RequestMapping(method = RequestMethod.GET, params = "maker")
    public ModelAndView getCarsWithMaker(@RequestParam(required = false, value = "maker") String maker,
                                         @RequestParam(required = false,
                                                       value = "page",
                                                       defaultValue = "0") Integer page,
                                         @RequestParam(required = false,
                                                       value = "perPage",
                                                       defaultValue = "20") Integer perPage)
    {

        CarQueryModel carQueryModel = new CarQueryModel().withMaker(maker).withPage(page).withPerPage(perPage);

        return getModelAndView(carQueryModel, "?maker=" + maker, "Diecast brand - " + maker);
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
        return new ModelAndView("redirect:" + "/cars/" + carFacade.findRandomCarId());
    }

    private ModelAndView getModelAndView(CarQueryModel carQueryModel, String query, String title)
    {
        ModelAndView mv = getModelAndView("carlist");

        CarQueryResultModel queryResult = carFacade.findCars(carQueryModel);

        mv.addObject("cars", queryResult.getCars());
        mv.addObject("page", carQueryModel.getPage());
        mv.addObject("perPage", carQueryModel.getPerPage());
        mv.addObject("query", query);
        mv.addObject("title", title);
        mv.addObject("totalCount", queryResult.getTotalCount());

        return mv;
    }
}
