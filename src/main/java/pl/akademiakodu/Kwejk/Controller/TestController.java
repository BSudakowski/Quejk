package pl.akademiakodu.Kwejk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akademiakodu.Kwejk.Dao.GifDao;

@Controller
public class TestController {

@Autowired
    GifDao dao;
   @GetMapping ("/")
    public String Home(ModelMap modelMap){
       modelMap.put("gifs", dao.getGifs());
        return "home";
    }
}
