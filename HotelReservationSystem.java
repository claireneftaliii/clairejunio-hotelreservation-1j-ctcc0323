import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelReservationSystem {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hotel Reservation Form");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        JLabel imageLabel = new JLabel(new ImageIcon("hotel_image.png")); 
        leftPanel.add(imageLabel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(new Color(0x2C3E50));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel reservationLabel = new JLabel("Reservation Information");
        reservationLabel.setForeground(Color.WHITE);
        reservationLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rightPanel.add(reservationLabel);
        
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JComboBox<String> roomTypeComboBox = new JComboBox<>(new String[]{"Master Suite - PHP 5000", "Deluxe Room - PHP 3000", "Standard Room - PHP 1500"});
        rightPanel.add(createFormRow("Room type:", roomTypeComboBox));
        
        JTextField checkInDateField = new JTextField(10);
        rightPanel.add(createFormRow("Check-in date:", checkInDateField));
        
        JTextField checkInTimeField = new JTextField(10);
        rightPanel.add(createFormRow("Check-in time:", checkInTimeField));
        
        JTextField checkOutDateField = new JTextField(10);
        rightPanel.add(createFormRow("Check-out date:", checkOutDateField));
        
        JTextField numberOfGuestsField = new JTextField(10);
        rightPanel.add(createFormRow("Number of guests:", numberOfGuestsField));
        
        JLabel personalLabel = new JLabel("Personal Information");
        personalLabel.setForeground(Color.WHITE);
        personalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rightPanel.add(personalLabel);
        
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JTextField firstNameField = new JTextField(10);
        rightPanel.add(createFormRow("First name:", firstNameField));
        
        JTextField lastNameField = new JTextField(10);
        rightPanel.add(createFormRow("Last name:", lastNameField));
        
        JTextField emailField = new JTextField(10);
        rightPanel.add(createFormRow("Email:", emailField));
        
        JButton requestButton = new JButton("Request Booking");
        requestButton.setBackground(new Color(0xF39C12));
        requestButton.setForeground(Color.WHITE);
        requestButton.setFocusPainted(false);
        rightPanel.add(requestButton);

        requestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomType = (String) roomTypeComboBox.getSelectedItem();
                String checkInDate = checkInDateField.getText();
                String checkInTime = checkInTimeField.getText();
                String checkOutDate = checkOutDateField.getText();
                String numberOfGuests = numberOfGuestsField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();

                String bookingDetails = "Booking Requested:\n" +
                        "Room Type: " + roomType + "\n" +
                        "Check-in Date: " + checkInDate + "\n" +
                        "Check-in Time: " + checkInTime + "\n" +
                        "Check-out Date: " + checkOutDate + "\n" +
                        "Number of Guests: " + numberOfGuests + "\n" +
                        "First Name: " + firstName + "\n" +
                        "Last Name: " + lastName + "\n" +
                        "Email: " + email;

                JOptionPane.showMessageDialog(frame, bookingDetails, "Booking Details", JOptionPane.INFORMATION_MESSAGE);

                JOptionPane.showMessageDialog(frame, "Thank you for your reservation request!", "Reservation Confirmation", JOptionPane.PLAIN_MESSAGE);
            }
        });

        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static JPanel createFormRow(String labelText, JComponent inputComponent) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(0x2C3E50));
        
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.WHITE);
        label.setPreferredSize(new Dimension(120, 20));
        
        panel.add(label);
        panel.add(inputComponent);
        
        return panel;
    }
}
