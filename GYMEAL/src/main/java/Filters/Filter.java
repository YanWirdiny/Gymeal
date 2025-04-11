/* Generic Filter Interface
 * PURPOSE: a simple filter that can be implemented by other specific Filter classes. The goal
 * is to implement these filters on some list, sort them based on (a) specific requirement(s),
 * and either generate a new list containing the items that passes the filter or removes the
 * items that don't pass, keeping only the ones we are looking for.
 */

package Filters;
public interface Filter <T> {

    //returns true if an item meets filter requirements, false otherwise.
    boolean apply(T item);
}
