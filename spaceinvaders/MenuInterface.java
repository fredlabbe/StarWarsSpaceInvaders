package spaceinvaders;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cstuser
 */
public class MenuInterface {
    private static FXMLMenuDocumentController controller; 
    
        
    public static void registerController1(FXMLMenuDocumentController ctrl1)
    {
        controller = ctrl1;
    }
} 
