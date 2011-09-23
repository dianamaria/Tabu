/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabu.models;

/**
 *
 * @author krzychu
 */
public interface Editor<T> {
    public T newItem();
    public void edit(T item);
    public boolean sureDelete(T item);
}
