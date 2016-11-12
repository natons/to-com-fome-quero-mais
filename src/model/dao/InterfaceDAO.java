package model.dao;

public interface InterfaceDAO<T> {
    
    public T findForObject(T object);
    
    public T findById(Integer id);
    
    public void remove(T object);
    
    public void save(T object);
    
}
