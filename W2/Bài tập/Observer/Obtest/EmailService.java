import java.io.EOFException;

public class EmailService implements Observer{
    @Override 
    public void update (){
        try {
            System.out.println("Email sent");
            throw new EOFException("Error");
        } catch (EOFException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
