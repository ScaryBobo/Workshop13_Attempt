package VTTP.workshop13Attempt2.Model;

import java.io.Serializable;
import java.util.Random;

public class ContactModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private int phoneNumber;
    private String id;
    
    public ContactModel(){
        this.id = generateId(8);
    }

    private synchronized String generateId(int numChars){
        Random r = new Random();
        StringBuilder strBuilder = new StringBuilder();
        while(strBuilder.length() < numChars){
            strBuilder.append(Integer.toHexString(r.nextInt()));
        }
        return strBuilder.toString().substring(0, numChars);
    }
    
    public ContactModel(String name, String email, int phoneNumber){
        this.email = email;
        this.name = name;
        this.id = generateId(8);
        this.phoneNumber = phoneNumber; 
    }
    
    public ContactModel(String name, String email, int phoneNumber, String id) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer string) {
        this.phoneNumber = string;
    }

    public String getId() {
        return id;
    }

    public void setId(String contactId) {
        this.id = contactId;
    }

    

}
