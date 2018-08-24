package controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class MediaController {
    private static Logger logger = (Logger) LoggerFactory.getLogger(MediaController.class);
    @Autowired
    private ServeltContext serveltContext;
    private Object staticFileDirDir;

    @RequestMapping(value = "/media")
    public String media (ModelMap map){
        String contextPath=serveltContext.getContextPatch();
        String staticDir="/static/img/public";
        String staticPatch=serveltContext.getContextPatch();
        List<String >images=new ArrayList<>();
        File staticFileDir=new File(staticPatch);
        if(staticFileDir.list() !=null&&staticFileDir.list().length>0){
            for (String file: staticFileDir.list()) {

                if (file.matches("[a-zA-Z0-9._-]+\\.(jpg|png|gif|svg)$")) {
                    images.add(contextPath + staticDir + file);
                }
            }
            }
            map.addAttribute("images", images);
            return "media";
    }

}
