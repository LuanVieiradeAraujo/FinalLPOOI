/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class InputVerifiers {
    private boolean inputError = false;
    
        public String HasInput(JTextField textField) {
            if(isNullOrEmpty(textField.getText())){
                textField.setText("Digite um valor");
                inputError = true;
                return "error";
            }
            else{
                return textField.getText();
            }
        };
        
        public static boolean isNullOrEmpty(String str) {
            if(str != null && !str.isEmpty())
                return false;
            return true;
        }
        
        public boolean hasInputErrors(){
            return this.inputError;
        }
        
        public void setInputErrors(Boolean val){
            this.inputError = val;
        }
}
