package UIWindows;

/**
 *
 * @author andre
 */
public class EventHandler extends javax.swing.JFrame {
    
    
    public EventHandler(){
        TermsOfConditions carRentalUI = new TermsOfConditions();
        carRentalUI.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        EventHandler EV = new EventHandler();
    }
    
}
