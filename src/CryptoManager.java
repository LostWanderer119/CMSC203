/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {
        int x = 0, temp;
        String encoded = "", keyString = "";
       plainText = plainText.replaceAll(" ", "");
        while (keyString.length() != plainText.length()) { //sets the key to be the same length as the plainText
        	keyString += key.charAt(x);
        	
        	if (x == key.length() - 1) //when the the index reaches the end rest it to 0
        		x = 0;
        	else
        		x++;
        }
        for (int i = 0; i < plainText.length(); i++) {
        	temp = ((plainText.charAt(i) + keyString.charAt(i)) % 26); //temp holds the new char value
        	temp += 'A'; //to upper case
        	encoded  += (char)temp; //converts to char and concatenates the return String
        }
    	return encoded;
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
    	 int x = 0, temp;
         String decoded = "", keyString = "";
         while (keyString.length() != encryptedText.length()) { //sets the key to be the same length as the plainText
         	keyString += key.charAt(x);
         	
         	if (x == key.length() - 1) //when the the index reaches the end rest it to 0
         		x = 0;
         	else
         		x++;
         }
         for (int i = 0; i < encryptedText.length(); i++) {
         	temp = ((encryptedText.charAt(i) - keyString.charAt(i) + 26) % 26); //temp holds the new char value
         	temp += 'A'; //to upper case
         	decoded  += (char)temp; //converts to char and concatenates the return String
         }
     	return decoded;
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    public static String playfairEncryption(String plainText, String key) {
        //create 2d array of chars 8*8
        char[][] grid = new char[8][8];
        String temp = "", encoded = "";
        int index = 0, x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        boolean found;
        
        //Generate key without duplicates
        for (int i = 0; i < key.length(); i++) {
            found = false;
            for (int f = 0; f < i; f++) {
                if (key.charAt(f) == key.charAt(i)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                temp += key.charAt(i);
            }
        } 
        
        //Add remaining characters from alphabet
        for (int i = 0; i < ALPHABET64.length(); i++) {
            found = false;
            for (int j = 0; j < temp.length(); j++) {
                if(temp.charAt(j) == ALPHABET64.charAt(i)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                temp += ALPHABET64.charAt(i);
            }
        }
        
        //Build the grid
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                grid[row][col] = temp.charAt(index++);
            }
        }

        plainText = plainText.replaceAll(" ", "").toUpperCase();
        
        //Handle odd length by adding 'Z'
        if (plainText.length() % 2 != 0) {
            plainText += 'Z';
        }
        
        //Process pairs
        for (int j = 0; j < plainText.length(); j += 2) {
            char a = plainText.charAt(j);
            char b = plainText.charAt(j + 1);
            
            //Handle repeated chars with 'X'
            if (a == b) {
                b = 'X';
                j--; //index handling
                if (j + 2 >= plainText.length()) {
                    plainText += 'Z';
                }
            }

            //Find positions in grid
            x1 = y1 = x2 = y2 = -1;
            for (int R = 0; R < 8; R++) {
                for (int C = 0; C < 8; C++) {
                    if (grid[R][C] == a) {
                        x1 = C;
                        y1 = R;
                    }
                    if (grid[R][C] == b) {
                        x2 = C;
                        y2 = R;
                    }
                }
            }
            
            //Encrypt based on positions
            if (y1 == y2) { //Same row
                encoded += grid[y1][(x1 + 1) % 8];
                encoded += grid[y2][(x2 + 1) % 8];
            } else if (x1 == x2) { //Same col
                encoded += grid[(y1 + 1) % 8][x1];
                encoded += grid[(y2 + 1) % 8][x2];
            } else { //Rectangle rule
                encoded += grid[y1][x2];
                encoded += grid[y2][x1];
            }
        }
        return encoded;
    }

    //Vigenere Decryption
    public static String playfairDecryption(String encryptedText, String key) {
        //create 2d array of chars 8*8
        char[][] grid = new char[8][8];
        String temp = "", decoded = "";
        int index = 0, x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        boolean found;
        
        //Generate key without duplicates (same as encryption)
        for (int i = 0; i < key.length(); i++) {
            found = false;
            for (int f = 0; f < i; f++) {
                if (key.charAt(f) == key.charAt(i)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                temp += key.charAt(i);
            }
        } 
        
        //Add remaining characters from alphabet
        for (int i = 0; i < ALPHABET64.length(); i++) {
            found = false;
            for (int j = 0; j < temp.length(); j++) {
                if(temp.charAt(j) == ALPHABET64.charAt(i)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                temp += ALPHABET64.charAt(i);
            }
        }
        
        //Build the grid (same as encryption)
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                grid[row][col] = temp.charAt(index++);
            }
        }

        encryptedText = encryptedText.replaceAll(" ", "").toUpperCase();
        
        //Pairing for decryption
        for (int j = 0; j < encryptedText.length(); j += 2) {
            char a = encryptedText.charAt(j);
            char b = encryptedText.charAt(j + 1);

            //Find positions in grid
            x1 = y1 = x2 = y2 = -1;
            for (int R = 0; R < 8; R++) {
                for (int C = 0; C < 8; C++) {
                    if (grid[R][C] == a) {
                        x1 = C;
                        y1 = R;
                    }
                    if (grid[R][C] == b) {
                        x2 = C;
                        y2 = R;
                    }
                }
            }
            
            //Decryption based on positions (reverse of encryption)
            if (y1 == y2) { // Same row
                decoded += grid[y1][(x1 - 1 + 8) % 8];
                decoded += grid[y2][(x2 - 1 + 8) % 8];
            } else if (x1 == x2) { // Same column
                decoded += grid[(y1 - 1 + 8) % 8][x1];
                decoded += grid[(y2 - 1 + 8) % 8][x2];
            } else { // Rectangle rule (same as encryption)
                decoded += grid[y1][x2];
                decoded += grid[y2][x1];
            }
        }
        
        //Remove padding and handle 'X' insertions
        String cleaned = "";
        for (int i = 0; i < decoded.length(); i++) {
            char current = decoded.charAt(i);
            
            //Skip 'X' that was inserted between duplicate letters
            if (i > 0 && i < decoded.length() - 1 && decoded.charAt(i) == 'X' && 
                decoded.charAt(i - 1) == decoded.charAt(i + 1)) {
                continue;
            }
            //Remove trailing 'Z' padding
            if (i == decoded.length() - 1 && current == 'Z') {
                continue;
            }
            cleaned += current;
        }
        
        return cleaned;
    }

    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
    public static String caesarEncryption(String plainText, int key) {
       	String encoded = "";
    	int temp;
    	
    	for (int index = 0; index < plainText.length(); index++) {
    		temp = ALPHABET64.indexOf(plainText.charAt(index)); //gets the index of each char in the plainText from ALPHABET64
    		encoded += ALPHABET64.charAt(temp + key); //concatenating the char in ALPHABET64 with its index shifted by the key
    	}
    	
    	return encoded;
    }

    // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
    	String decoded = "";
    	int temp;
    	
    	for (int index = 0; index < encryptedText.length(); index++) {
    		temp = ALPHABET64.indexOf(encryptedText.charAt(index)); //gets the index of each char in the encryptedText from ALPHABET64
    		decoded += ALPHABET64.charAt(temp - key); //concatenating the char in ALPHABET64 with its index shifted by the key
    	}
    	
    	return decoded;
    }    

}
