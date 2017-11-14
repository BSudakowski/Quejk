package pl.akademiakodu.Kwejk.Dao;

import pl.akademiakodu.Kwejk.Model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryDaoImpl implements CategoryDao {

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
    public Category findFavorite(int index) {
        return names.get(index);
    }

    @Override
    public Category findOne(String name) {
        return null;
    }

    @Override
    public Set<Category> findCategory() {
        return null;
    }
}
