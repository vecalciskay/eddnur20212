package cadenas.ordenadas;

public interface ICola<T> {
	public void push(T o);
	
	public T pull();
	
	public T peek();
	
	public boolean isEmpty();
	
	public boolean isFull();
}
