package pl.akademiakodu.Kwejk.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.akademiakodu.Kwejk.Dao.GifDaoImpl;

@Controller
public class GifController {
   // @Autowired
    GifDaoImpl gifDao = new GifDaoImpl();


    @GetMapping("/")
    public String home( ModelMap modelMap){
        modelMap.put("gifs", gifDao.findAll());
        return "home";
    }

    @GetMapping("/favorites")
    public String favorites(ModelMap modelMap){
        modelMap.put("fav",gifDao.findFavorites());

        return "favorites";
    }

    @GetMapping("/gif/{name}")
    public String details(@PathVariable String name, ModelMap modelMap){
        modelMap.addAttribute("gif",gifDao.findOne(name));
        return "gif-details";
    }

    @GetMapping("/categories")
   public String categories(ModelMap modelMap){
           modelMap.put("categories",gifDao.findCategory());
         return "categories";
     }
}
