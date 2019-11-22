/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

import java.util.Collections;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class sortAllRows {
    
    public void sortAllRowsBy(DefaultTableModel model, int colIndex, boolean ascending) {
    Vector data = model.getDataVector();
    Collections.sort(data, new ColumnSorter(colIndex, ascending));
    model.fireTableStructureChanged();
    }
    
}
