package VTTP.workshop13Attempt2.Utility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.springframework.ui.Model;

import VTTP.workshop13Attempt2.Workshop13Attempt2Application;
import VTTP.workshop13Attempt2.Model.ContactModel;

public class ContactUtil {
    private Logger logger = Logger.getLogger(ContactUtil.class.getName());
    public void saveContact(ContactModel contact, Model model){
        String dataFileName = contact.getId();
        PrintWriter printWriter = null;
        FileWriter fileWriter = null;

        //PrinterWriter saves data into the file
        //FileWriter saves the file

        try {
            fileWriter 
            = new FileWriter(Workshop13Attempt2Application.dataDIR + "/" + 
                            dataFileName, Charset.forName("UTF-8"));
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(contact.getName());
            printWriter.println(contact.getEmail());
            printWriter.println(contact.getPhoneNumber()); 

        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }finally{
            if(printWriter != null)
                printWriter.close();
            try {
                if(fileWriter != null)
                    fileWriter.close();
            }catch(IOException e){
                logger.log(Level.WARNING, e.getMessage());
            }   
        }        
    }

    public void getContactById(Model model, String contactId){
        ContactModel cResp = new ContactModel();
        try {
            Path filePath = new java.io.File(Workshop13Attempt2Application.dataDIR + "/" + contactId).toPath();
            Charset charset = Charset.forName("UTF-8");
            List<String> lines = Files.readAllLines(filePath, charset);
            cResp.setName(lines.get(0));
            cResp.setEmail(lines.get(1));
            cResp.setPhoneNumber(Integer.parseInt(lines.get(2)));
            cResp.setId(contactId);
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        model.addAttribute("contact", cResp);
        
    }
}
