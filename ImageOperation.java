import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class ImageOperation {

    public static void operate(int key){

        // JFileChooser fileChooser = new JFileChooser();

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.showOpenDialog(null); // to open the dialog box in the center

        File file = fileChooser.getSelectedFile(); // the file is selceted

        // file FileInputStream
        
        try {

            FileInputStream fis = new FileInputStream(file); // given file

            int i =0;

            byte []data = new byte[fis.available()]; //created a byte array

            fis.read(data);

            for(byte b : data){
                
                System.out.println(b);

                data[i] = (byte)(b^key);

                i++;

            }

            FileOutputStream fos = new FileOutputStream(file);

            fos.write(data);

            fos.close();

            fis.close();

            JOptionPane.showMessageDialog(null, "Done ");
            
        } catch (Exception e) {
            

            e.printStackTrace(); //to show the output

        
        }
        
    }

public static void main(String[] args) {
    
    System.out.println("For testing ");

    JFrame f = new JFrame(); //created a class object of JFrame

    f.setTitle("Image Operation");

    f. setSize(400,400);

    f.setLocationRelativeTo(null);

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //So that to check it closes properly

    Font font = new Font("Roboto", Font.BOLD, 25); // setting the font

    JButton button = new JButton(); // creating a button object from button class

    button.setText("Open Image");

    button.setFont(font);

    
    
    // creating text field

    JTextField textField = new JTextField(10); // for the text field box

    textField.setFont(font);

    button.addActionListener(e->{
        // the e-> it is called lambda function to replace Anonmus class to implement functional interface
        // created this in the text field so thta we can call the text field object
                System.out.println("Testing if the button click is working");

                String text = textField.getText();
                
                int key = Integer.parseInt(text); // Taking the key or the password

                operate(key);
        
            });
    f.setLayout(new FlowLayout());

    f.add(button);

    f.add(textField);


    f.setVisible(true); //boolean check


}

}
