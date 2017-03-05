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
import com.personal.diecastfun.domain.Era;

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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCars(@RequestParam(required = false, value = "brand") String brand,
                                @RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                @RequestParam(required = false, value = "perPage", defaultValue = "20") Integer perPage)
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

    @RequestMapping(method = RequestMethod.GET, params = "category")
    public ModelAndView getCarsWithCategory(@RequestParam(required = false, value = "category") String category,
                                            @RequestParam(required = false,
                                                          value = "page",
                                                          defaultValue = "0") Integer page,
                                            @RequestParam(required = false,
                                                          value = "perPage",
                                                          defaultValue = "20") Integer perPage)
    {

        CarQueryModel carQueryModel = new CarQueryModel().withCategory(category).withPage(page).withPerPage(perPage);

        return getModelAndView(carQueryModel, "?category=" + category, "Category - " + category);
    }

    @RequestMapping(method = RequestMethod.GET, params = "era")
    public ModelAndView getCarsWithEra(@RequestParam(required = false, value = "era") String era,
                                       @RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                       @RequestParam(required = false,
                                                     value = "perPage",
                                                     defaultValue = "20") Integer perPage)
    {

        CarQueryModel carQueryModel = new CarQueryModel().withEra(Era.valueOf(era)).withPage(page).withPerPage(perPage);

        return getModelAndView(carQueryModel, "?era=" + era, "Era - " + era);
    }

    @RequestMapping(method = RequestMethod.GET, params = "customized=true")
    public ModelAndView getCustomizedCars(@RequestParam(required = false, value = "customized") boolean customized,
                                          @RequestParam(required = false,
                                                        value = "page",
                                                        defaultValue = "0") Integer page,
                                          @RequestParam(required = false,
                                                        value = "perPage",
                                                        defaultValue = "20") Integer perPage)
    {
        CarQueryModel carQueryModel = new CarQueryModel().withCustomized(customized)
                                                         .withPage(page)
                                                         .withPerPage(perPage);

        return getModelAndView(carQueryModel, "?customized=true", "Customs");
    }

    @RequestMapping(method = RequestMethod.GET, params = "restored=true")
    public ModelAndView getRestoredCars(@RequestParam(required = false, value = "restored") boolean restored,
                                        @RequestParam(required = false,
                                                      value = "page",
                                                      defaultValue = "0") Integer page,
                                        @RequestParam(required = false,
                                                      value = "perPage",
                                                      defaultValue = "20") Integer perPage)
    {
        CarQueryModel carQueryModel = new CarQueryModel().withPage(page).withPerPage(perPage).withRestored(restored);

        return getModelAndView(carQueryModel, "?restored=true", "Restorations");
    }

    @RequestMapping(value = "/{carId}", method = RequestMethod.GET)
    public ModelAndView getSpecificCar(@PathVariable String carId)
    {
        viewsFacade.addView(carId);
        ModelAndView mv = getModelAndView("cardetails");

        mv.addObject("id", carId);
        mv.addObject("car", carFacade.findCarById(carId));
        mv.addObject("votes", votesFacade.getVotesById(carId));
        mv.addObject("views", viewsFacade.getViews(carId));

        return mv;
    }

    @RequestMapping(value = "/{carId}/seealso", method = RequestMethod.GET)
    public ModelAndView getSeeAlso(@PathVariable String carId)
    {
        ModelAndView mv = new ModelAndView("seealso");

        mv.addObject("picturesUrl", configFacade.getPicturesUrl());
        mv.addObject("cars", carFacade.findSeeAlso(carId));

        return mv;
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public ModelAndView getRandomCar()
    {
        return new ModelAndView("redirect:" + "/cars/" + carFacade.findRandomCarId());
    }

    @RequestMapping(method = RequestMethod.GET, params = "q")
    public ModelAndView search(@RequestParam(required = false, value = "q") String query,
                               @RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                               @RequestParam(required = false, value = "perPage", defaultValue = "20") Integer perPage)
    {

        CarQueryModel carQueryModel = new CarQueryModel().withQuery(query).withPage(page).withPerPage(perPage);

        return getModelAndView(carQueryModel, "?q=" + query, "Search Results for '" + query + "'");
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
