public class ArrayUtils<T> {
    // To print an array without writing the for every time
	public void stampaArrey (T[] arrey){
        for(int i = 0; i < arrey.length; ++i){
            System.out.println(arrey[i]);
        }
    }
}