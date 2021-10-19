package cadenas.ordenadas;

public interface IPila<T> {

	public void push(T o);
	
	public T pop();
	
	public T peek();
	
	public boolean isEmpty();
	
	public boolean isFull();
}
