/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/11/2020
 * Time: 9:10 SA
 */

public interface Manager<T> {
    boolean add(T obj);
    boolean remove(T obj);
    T remove(int index);
    T edit(int index, T obj);
}
