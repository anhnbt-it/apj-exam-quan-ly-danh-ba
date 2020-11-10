/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/11/2020
 * Time: 9:10 SA
 */

public interface Manager<T> {
    void add(T obj);
    boolean remove(T obj);
    boolean remove(int index);
    boolean edit(int index, T obj);
}
