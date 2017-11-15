package pl.akademiakodu.Kwejk.Dao;

import org.springframework.stereotype.Component;
import pl.akademiakodu.Kwejk.Model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CategoryDaoImpl implements CategoryDao {


    public static final String name1 = "Android";
    public static final String name2 = "Funny";
    public static final String name3 = "Programming";

    private static List<Category> names = new ArrayList<>();

    static{
        names.add(new Category(new Long(0), "Android"));
        names.add(new Category(new Long(1), "Funny"));
        names.add(new Category(new Long(2), "Programming"));
    }


    @Override
    public List<Category> findAll() {
        return names;
    }

    @Override
    public Category findFavorite(Long index) {
        Integer i = new Integer(index.toString());
        return names.get(i);
    }

    @Override
    public Category findOne(String name) {

        return names.stream().filter((c)->c.getName().equals(name)).collect(Collectors.toList()).get(0);
    }

    @Override
    public Set<Category> findCategory() {
        return null;
    }
}
