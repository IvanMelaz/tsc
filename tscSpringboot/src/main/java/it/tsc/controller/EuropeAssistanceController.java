package it.tsc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EuropeAssistanceController extends BaseController {
  private static final Logger logger = LoggerFactory.getLogger(EuropeAssistanceController.class);

  @RequestMapping(value = { "/europeAssistance" }, method = RequestMethod.GET)
  public ModelAndView welcomePage() {
    ModelAndView model = new ModelAndView();
    model.setViewName("europeAssistance");
    return model;
  }

}
