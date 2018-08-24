package controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
public class CodeController {
    private static Logger logger = (Logger) LoggerFactory.getLogger(CodeController.class);

    @RequestMapping(value = "/code", method = RequestMethod.GET)
    public void codePage(ModelMap map)
            throws MaliformedURLExpeption, Exception {
    }


}