package pl.akademiakodu.Kwejk.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akademiakodu.Kwejk.Dao.CategoryDao;
import pl.akademiakodu.Kwejk.Dao.CategoryDaoImpl;
import pl.akademiakodu.Kwejk.Dao.GifDaoImpl;
import pl.akademiakodu.Kwejk.Model.Category;
import pl.akademiakodu.Kwejk.Model.Gif;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class GifController {
    //@Autowired
    GifDaoImpl gifDao = new GifDaoImpl();
    CategoryDao categoryDao = new CategoryDaoImpl();


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
        modelMap.put("categories", categoryDao.findAll());
        return "categories";
    }

    @GetMapping("/category/{id}")
    public String category(@PathVariable Long id, ModelMap modelMap){
       Category c = categoryDao.findFavorite(id);
       List<Gif> gifs = gifDao.findAll().stream().filter((g)->g.getCategory().equals(c.getName())).collect(Collectors.toList());
       //System.out.println(gifs);
       modelMap.addAttribute("category", c);
       modelMap.addAttribute("gifs", gifs);
       return "category";
    }

    @GetMapping("/search")
    public String search(@RequestParam String q, ModelMap modelMap){
       //System.out.println(gifDao.findOne(q));
       if(q.equals(GifDaoImpl.name1) || q.equals(GifDaoImpl.name2) || q.equals(GifDaoImpl.name3) || q.equals(GifDaoImpl.name4) || q.equals(GifDaoImpl.name5) || q.equals(GifDaoImpl.name6)) {
           modelMap.addAttribute("gif", gifDao.findOne(q));
           return "gif-details";
       } else if(q.equals(CategoryDaoImpl.name1) || q.equals(CategoryDaoImpl.name2) || q.equals(CategoryDaoImpl.name3)){
           Category c = categoryDao.findOne(q);
           List<Gif> gifs = gifDao.findAll().stream().filter((g)->g.getCategory().equals(c.getName())).collect(Collectors.toList());
           //System.out.println(gifs);
           modelMap.addAttribute("category", c);
           modelMap.addAttribute("gifs", gifs);
           return "category";
       }

       return "home";
    }
}
