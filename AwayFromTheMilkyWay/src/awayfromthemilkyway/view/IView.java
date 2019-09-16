/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.view;
//prova
/**
 *
 * @author giorg
 */
public interface IView {
    //Methods in order to change different game screens
    public void openMenuWindow();
    public void openGameWindow();
    public void openInstructionsWindow();
    public void openOptionsWindow();
    public void showInformationDialog(String message, String title);
    public boolean showConfirmationDialog(String message,String title, String firstOption, String secondOption);
    public void showErrorDialog(String message);
    
    
    //Methods in order to move things in the screen
    public void updateSpaceshipPositionX(double translation);
    public void updateSpaceshipPositionY(double translation);
    public void updateSpaceshipCenter(double xCenter,double yCenter);
    public double getSpaceshippositionX();
    public double getSpaceshippositionY();
    
}