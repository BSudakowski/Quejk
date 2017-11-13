package pl.akademiakodu.Kwejk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akademiakodu.Kwejk.Dao.GifDao;
import pl.akademiakodu.Kwejk.Model.Gif;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    GifDao dao;

   @GetMapping ("/")
    public String Home(ModelMap modelMap){
       modelMap.put("gifs", dao.getGifs());
        return "home";
    }

    @GetMapping("/favorites")
    public String favorites(ModelMap modelMap){
        List<Gif> favoriteGifs = new ArrayList<>();
        for(int i = 0; i < dao.getGifs().size(); i++){
            if(dao.getGifs().get(i).isFavorite()){
                favoriteGifs.add(dao.getGifs().get(i));
            }
        }
        modelMap.addAttribute("favoriteGifs", favoriteGifs);
        return "favorites";
    }

    @GetMapping("/details")
    public String gifDetails(ModelMap modelMap, @RequestParam String id){
        modelMap.put("gifDetail", dao.getGifs().get(Integer.parseInt(id)));
        return "gif-details";
    }
}
