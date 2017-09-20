/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caesarciphermessage;

/**
 *
 * @author travis
 */
public class CaesarCipherMessage {

    private String originalMessage;
    private String cleanMessage;
    private String cipher;
    private int shift;
    
    public CaesarCipherMessage(String originalMessage, int shift) {
        this.originalMessage = originalMessage;
        this.shift = shift;
    }
    
    private void cleanseMessage() {
        cleanMessage = new String();    
        for (int i = 0; i < originalMessage.length(); i++) {
            if (Character.isAlphabetic(originalMessage.charAt(i)))
                cleanMessage += Character.toUpperCase(originalMessage.charAt(i));
        }
    }
    
    private char shiftChar(char c) {
        int numValue = (int)c - 65;
        return (char)(((numValue+shift)%26)+65);
    }
    
    public void generateCipher() {
        cleanseMessage();
        
        cipher = new String();
        for (int i = 0; i < cleanMessage.length(); i++)
            cipher += shiftChar(cleanMessage.charAt(i));
        
        System.out.println(cipher);
    }
            
    public static void main(String[] args) {
        CaesarCipherMessage testCipher = new CaesarCipherMessage("Test Message!", 2);
    }
    
}
