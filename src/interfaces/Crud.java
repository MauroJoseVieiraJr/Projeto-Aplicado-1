package interfaces;

import java.util.List;

public interface Crud<T> {
	public void Create(T t) throws Exception;
	public List<T> Read();
	public void Update(T t) throws Exception;
	public void Delete(T t) throws Exception;
}
