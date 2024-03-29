/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

import java.util.Comparator;
import java.util.Vector;

/**
 *
 * @author Usuario
 */

public class ColumnSorter implements Comparator {
    int colIndex;
    boolean ascending;
    ColumnSorter(int colIndex, boolean ascending) {
        this.colIndex = colIndex;
        this.ascending = ascending;
    }
    public int compare(Object a, Object b) {
        Vector v1 = (Vector)a;
        Vector v2 = (Vector)b;
        Object o1 = v1.get(colIndex);
        Object o2 = v2.get(colIndex);
        
        // Trata colunas vazias como nulas
        if (o1 instanceof String && ((String)o1).length() == 0) {
        o1 = null;
        }
        if (o2 instanceof String && ((String)o2).length() == 0) {
        o2 = null;
        }

        // Ordena os nulos no final
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return 1;
        } else if (o2 == null) {
            return -1;
        } else if (o1 instanceof Comparable) {
            if (ascending) {
                return ((Comparable)o1).compareTo(o2);
            } else {
                return ((Comparable)o2).compareTo(o1);
            }
        } else {
        if (ascending) {
            return o1.toString().compareTo(o2.toString());
        } else {
            return o2.toString().compareTo(o1.toString());
        }
        }
    }
}