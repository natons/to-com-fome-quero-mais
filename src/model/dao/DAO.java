package model.dao;

import java.util.List;

public interface DAO<T> {
    
    public T findForObject(T object);
    
    public T findById(Integer id);
    
    public void remove(T object);
    
    public void save(T object);
    
    public List<T> getAllElements();
    
}
