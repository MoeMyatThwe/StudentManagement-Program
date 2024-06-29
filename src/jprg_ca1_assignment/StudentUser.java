
package jprg_ca1_assignment;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class StudentUser {
    
    public static void main(String [] args)throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File("programIntro.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip program_intro = AudioSystem.getClip();
        program_intro.open(audioStream);
        program_intro.loop(Clip.LOOP_CONTINUOUSLY);
        
        String strUserIdentity = "";
        Integer userIdentity = -1;
        
        String strUserOption = "";
        Integer userOption = 0;
        boolean quit = false;
        
        
        
        while(!quit){
            program_intro.start();
            strUserIdentity = StudentManagement.viewGetUserIdentity();
            
            if(strUserIdentity == null){
                int option = JOptionPane.showConfirmDialog(null, "Do you want to cancel the operation?", "Cancel Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    quit = true; // Exit the program
                    continue;
                } else {
                    continue; // Return to main menu
                }
            }
            
            if (StudentManagement.controllerValidateInputIsEmpty(strUserIdentity)){
                StudentManagement.viewDisplayUserInputErrorIsEmpty();
                continue;
            }
       
            
            userIdentity = StudentManagement.controllerValidateInputIsInteger(strUserIdentity);
            if(userIdentity == null){
                StudentManagement.viewDisplayUserInputErrorNotInteger();
                continue;
            }
            
            if(!StudentManagement.controllerValidateInputInRange(userIdentity)){
                StudentManagement.viewDisplayUserInputErrorNotInRange();
                continue;
            }
                     
            
            if(userIdentity.equals(1)){
                StudentManagement.handleAdminActions(program_intro);
                
            }
            
            if(userIdentity.equals(2)){
                StudentManagement.handleStudentActions(program_intro);
            }
            
            quit = true;
        }
        
    }
        
}
