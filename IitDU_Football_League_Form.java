import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class IitDU_Football_League_Form{
    public static void main(String[] args) {
        JFrame frame=new JFrame("IIT Football League Form");
        frame.setSize(800,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        //Name
        JLabel nameLabel=new JLabel("Name:");
        nameLabel.setBounds(30,20,120,30);
        frame.add(nameLabel);
        JTextField nameField=new JTextField();
        nameField.setBounds(150,20,400,30);
        frame.add(nameField);

        //Phone
        JLabel phoneLabel=new JLabel("Phone:");
        phoneLabel.setBounds(30,60,120,30);
        frame.add(phoneLabel);
        JTextField phoneField=new JTextField();
        phoneField.setBounds(150,60,400,30);
        frame.add(phoneField);

        //Email
        JLabel emailLabel=new JLabel("Email:");
        emailLabel.setBounds(30,100,120,30);
        frame.add(emailLabel);
        JTextField emailField=new JTextField();
        emailField.setBounds(150,100,400,30);
        frame.add(emailField);

        //Address
        JLabel addressLabel=new JLabel("Address:");
        addressLabel.setBounds(30,140,120,30);
        frame.add(addressLabel);
        JTextField addressField=new JTextField();
        addressField.setBounds(150,140,400,30);
        frame.add(addressField);

        //Gender
        JLabel genderLabel=new JLabel("Gender:");
        genderLabel.setBounds(30,180,120,30);
        frame.add(genderLabel);
        JRadioButton male=new JRadioButton("Male");
        male.setBounds(170,180,100,30);
        frame.add(male);
        JRadioButton female=new JRadioButton("Female");
        female.setBounds(320,180,110,30);
        frame.add(female);
        JRadioButton other=new JRadioButton("Other");
        other.setBounds(450,180,110,30);
        frame.add(other);
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        //Date Of Birth
        JLabel dobLabel=new JLabel("Date of Birth:");
        dobLabel.setBounds(30,220,120,30);
        frame.add(dobLabel);
        String[] days=new String[31];
        for(int i=1;i<=31;i++){
            days[i-1]=String.valueOf(i);
        }
        String[] months={"Jan","Feb","Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] years=new String[100];
        for(int i=0;i<100;i++){
            years[i]=String.valueOf(2025-i);
        }
        JComboBox<String>dayBox=new JComboBox<>(days);
        JComboBox<String> monthBox=new JComboBox<>(months);
        JComboBox<String> yearBox=new JComboBox<>(years);
        dayBox.setBounds(150,220,125,30);
        monthBox.setBounds(280,220,125,30);
        yearBox.setBounds(410,220,140,30);
        frame.add(dayBox);
        frame.add(monthBox);
        frame.add(yearBox);

        //Degree
        JLabel degreeLabel=new JLabel("Degree:");
        degreeLabel.setBounds(30,260,120,30);
        frame.add(degreeLabel);
        String[] degrees={"Select","BSSE (Bachelor of Science in Software Engineering)","MIT (Masters in Inforamtion Technology)","MSE (Masters in Software Engineering)"};
        JComboBox<String>degreeBox=new JComboBox<>(degrees);
        degreeBox.setBounds(150,260,400,30);
        frame.add(degreeBox);

        //Upload Picure
        JLabel pictureLabel=new JLabel("Upload Picture:");
        pictureLabel.setBounds(30,300,120,30);
        frame.add(pictureLabel);
        JButton uploadButton=new JButton("Choose Picture");
        uploadButton.setBounds(150,300,400,30);
        frame.add(uploadButton);
        JLabel picturePathLabel=new JLabel();
        picturePathLabel.setBounds(280,300,180,30);
        frame.add(picturePathLabel);

        final String[] selectedPicturePath = {""};
        uploadButton.addActionListener( e -> {
            JFileChooser fileChooser=new JFileChooser();
            int option=fileChooser.showOpenDialog(frame);
            if(option==JFileChooser.APPROVE_OPTION){
                File file=fileChooser.getSelectedFile();
                selectedPicturePath[0]=file.getAbsolutePath();
                picturePathLabel.setText(selectedPicturePath[0]);
            }
        });

        //Football Info
        //Preferred Position
        JLabel positionLabel=new JLabel("Preferred Position:");
        positionLabel.setBounds(30,340,120,30);
        frame.add(positionLabel);
        String[] position={"Select","GoalKeeper","Defender","Midfielder","Forward"};
        JComboBox<String>positionBox=new JComboBox<>(position);
        positionBox.setBounds(150,340,400,30);
        frame.add(positionBox);

        //Played in Inter-DepartMental Competition
        JLabel playLabel=new JLabel("Played in Inter-Departmental Competition?:");
        playLabel.setBounds(30,380,300,30);
        frame.add(playLabel);
        JRadioButton yes=new JRadioButton("Yes");
        yes.setBounds(330,380,100,30);
        frame.add(yes);
        JRadioButton no=new JRadioButton("No");
        no.setBounds(450,380,100,30);
        frame.add(no);
        ButtonGroup playGroup=new ButtonGroup();
        playGroup.add(yes);
        playGroup.add(no);


        //Experience
        JLabel experienceLabel = new JLabel("Experience:");
        experienceLabel.setBounds(30, 420, 120, 30);
        frame.add(experienceLabel);

        JTextArea experienceArea = new JTextArea(3, 20);
        JScrollPane experienceScrollPane = new JScrollPane(experienceArea);
        experienceScrollPane.setBounds(150, 420, 400, 60);
        frame.add(experienceScrollPane);

        //Submit Button
        JButton submitButton=new JButton("Submit");
        submitButton.setBounds(270,530,100,40);
        frame.add(submitButton);

        submitButton.addActionListener(e -> {
            String name=nameField.getText();
            String phone=phoneField.getText();
            String email=emailField.getText();
            String address=addressField.getText();
            String gender=male.isSelected()?"Male":(female.isSelected()?"Female":(other.isSelected()?"Other":"Not Selected"));
            String dob=dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();
            String degree=degreeBox.getSelectedItem().toString();
            String photoPath= selectedPicturePath[0].isEmpty() ? "Not uploaded" : selectedPicturePath[0];
            String preferposition=positionBox.getSelectedItem().toString();
            String played=yes.isSelected()?"Yes":no.isSelected()?"No":"Not Selected";
            String experience=experienceArea.getText();


            if(name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty()
                    || gender.equals("Not Selected") || dob.isEmpty() || degree.equals("Select")
                    || preferposition.equals("Select") || played.equals("Not Selected")
                    || photoPath.equals("Not uploaded") || experience.isEmpty()) {

                JOptionPane.showMessageDialog(frame,
                        "Please fill all the fields",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            else {
                try {
                    FileWriter writer = new FileWriter("registration_form.txt", true); // ✅ use .txt
                    writer.write("Name: " + name + "\n");
                    writer.write("Phone: " + phone + "\n");
                    writer.write("Email: " + email + "\n");
                    writer.write("Address: " + address + "\n");
                    writer.write("Date of Birth: " + dob + "\n");
                    writer.write("Degree: " + degree + "\n");
                    writer.write("Picture: " + photoPath + "\n");
                    writer.write("Prefered position: " + preferposition + "\n");
                    writer.write("Played in Inter-Departmental Competition: " + played + "\n");
                    writer.write("Experience: " + experience + "\n");

                    writer.write("--------------------------------------------------\n");
                    writer.close();

                    JOptionPane.showMessageDialog(frame,
                            "Registration info saved successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    //Clear the form
                    nameField.setText("");
                    phoneField.setText("");
                    emailField.setText("");
                    addressField.setText("");
                    genderGroup.clearSelection();
                    dayBox.setSelectedIndex(0);
                    monthBox.setSelectedIndex(0);
                    yearBox.setSelectedIndex(0);
                    degreeBox.setSelectedIndex(0);
                    picturePathLabel.setText("");
                    selectedPicturePath[0] = "";
                    positionBox.setSelectedIndex(0);
                    playGroup.clearSelection();
                    experienceArea.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Error saving registration info: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        frame.setVisible(true);
    }

}