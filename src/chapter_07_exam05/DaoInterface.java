package chapter_07_exam05;

import java.util.ArrayList;

public interface DaoInterface<T> {
	
	public boolean insertItem(T item);
	
	public boolean deleteItem(T item);
	
	public ArrayList<T> listItem();
	
	public boolean updateItem(T item);
	
	public T searchItem(T item);
	
}
