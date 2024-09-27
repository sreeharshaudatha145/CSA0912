import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnlineLearningPlatform extends JFrame implements ActionListener {
    private JPanel currentPanel;
    private CardLayout cardLayout;

    public OnlineLearningPlatform() {
        setTitle("Online Learning Platform");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        currentPanel = new JPanel(cardLayout);

        addLoginPanel();
        add(currentPanel);

        setVisible(true);
    }

    private void addLoginPanel() {
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> {
            // Check login credentials (dummy)
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.equals("admin") && password.equals("password")) {
                showDashboardPanel();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        currentPanel.add(loginPanel, "loginPanel");
    }

    private void showDashboardPanel() {
        JPanel dashboardPanel = new JPanel(new GridLayout(3, 1));
        JButton courseManagementButton = new JButton("Course Management");
        JButton studentEnrollmentButton = new JButton("Student Enrollment");
        JButton backButton = new JButton("Tap to Back");

        courseManagementButton.addActionListener(e -> showCourseManagementPanel());
        studentEnrollmentButton.addActionListener(e -> showStudentEnrollmentPanel());
        backButton.addActionListener(e -> cardLayout.show(currentPanel, "loginPanel"));

        dashboardPanel.add(courseManagementButton);
        dashboardPanel.add(studentEnrollmentButton);
        dashboardPanel.add(backButton);

        currentPanel.add(dashboardPanel, "dashboardPanel");
        cardLayout.show(currentPanel, "dashboardPanel");
    }

    private void showCourseManagementPanel() {
        JPanel courseManagementPanel = new JPanel(new GridLayout(5, 1));
        JButton javaButton = new JButton("Java");
        JButton pythonButton = new JButton("Python");
        JButton cPlusPlusButton = new JButton("C++");
        JButton cButton = new JButton("C");
        JButton dsaButton = new JButton("DSA");
        JButton backButton = new JButton("Tap to Back");

        javaButton.addActionListener(e -> showContentDeliveryPanel("Java"));
        pythonButton.addActionListener(e -> showContentDeliveryPanel("Python"));
        cPlusPlusButton.addActionListener(e -> showContentDeliveryPanel("C++"));
        cButton.addActionListener(e -> showContentDeliveryPanel("C"));
        dsaButton.addActionListener(e -> showContentDeliveryPanel("DSA"));
        backButton.addActionListener(e -> cardLayout.show(currentPanel, "dashboardPanel"));

        courseManagementPanel.add(javaButton);
        courseManagementPanel.add(pythonButton);
        courseManagementPanel.add(cPlusPlusButton);
        courseManagementPanel.add(cButton);
        courseManagementPanel.add(dsaButton);
        courseManagementPanel.add(backButton);

        currentPanel.add(courseManagementPanel, "courseManagementPanel");
        cardLayout.show(currentPanel, "courseManagementPanel");
    }

    private void showStudentEnrollmentPanel() {
        JPanel studentEnrollmentPanel = new JPanel(new GridLayout(3, 1));
        JButton loginWithEmailButton = new JButton("Login with Email ID");
        JButton loginWithOTPButton = new JButton("Login with OTP");
        JButton backButton = new JButton("Tap to Back");

        loginWithEmailButton.addActionListener(e -> showContentDeliveryPanel("Login with Email ID"));
        loginWithOTPButton.addActionListener(e -> showContentDeliveryPanel("Login with OTP"));
        backButton.addActionListener(e -> cardLayout.show(currentPanel, "dashboardPanel"));

        studentEnrollmentPanel.add(loginWithEmailButton);
        studentEnrollmentPanel.add(loginWithOTPButton);
        studentEnrollmentPanel.add(backButton);

        currentPanel.add(studentEnrollmentPanel, "studentEnrollmentPanel");
        cardLayout.show(currentPanel, "studentEnrollmentPanel");
    }

    private void showContentDeliveryPanel(String course) {
        JPanel contentDeliveryPanel = new JPanel(new GridLayout(3, 1));
        JButton introductionButton = new JButton("Introduction");
        JButton basicsButton = new JButton("Basics");
        JButton backButton = new JButton("Tap to Back");

        introductionButton.addActionListener(e -> showQuizzesPanel("Introduction"));
        basicsButton.addActionListener(e -> showQuizzesPanel("Basics"));
        backButton.addActionListener(e -> cardLayout.show(currentPanel, "courseManagementPanel"));

        contentDeliveryPanel.add(introductionButton);
        contentDeliveryPanel.add(basicsButton);
        contentDeliveryPanel.add(backButton);

        currentPanel.add(contentDeliveryPanel, "contentDeliveryPanel");
        cardLayout.show(currentPanel, "contentDeliveryPanel");
    }

    private void showQuizzesPanel(String topic) {
        JPanel quizzesPanel = new JPanel(new GridLayout(5, 1));
        JLabel quizLabel = new JLabel("Quiz for " + topic);
        JButton quiz1Button = new JButton("Quiz 1");
        JButton quiz2Button = new JButton("Quiz 2");
        JButton backButton = new JButton("Tap to Back");

        // Action listeners for Quiz 1 and Quiz 2 buttons
        quiz1Button.addActionListener(e -> showMCQs("Quiz 1", topic));
        quiz2Button.addActionListener(e -> showMCQs("Quiz 2", topic));
        backButton.addActionListener(e -> cardLayout.show(currentPanel, "contentDeliveryPanel"));

        quizzesPanel.add(quizLabel);
        quizzesPanel.add(quiz1Button);
        quizzesPanel.add(quiz2Button);
        quizzesPanel.add(backButton);

        currentPanel.add(quizzesPanel, "quizzesPanel");
        cardLayout.show(currentPanel, "quizzesPanel");
    }

    // Method to show MCQs for a specific quiz
    private void showMCQs(String quizTitle, String topic) {
        JPanel mcqsPanel = new JPanel(new GridLayout(6, 1));
        JLabel titleLabel = new JLabel(quizTitle + " for " + topic);
        JLabel question1Label = new JLabel("1. What is a loop in programming?");

        // MCQ Options for Question 1
                // MCQ Options for Question 1
        String[] optionsQuestion1 = {
            "A way to execute code only once",
            "A block of code that is repeated a specific number of times",
            "A data structure for storing multiple values",
            "A type of conditional statement"
        };

        JComboBox<String> answer1ComboBox = new JComboBox<>(optionsQuestion1);

        JLabel question2Label = new JLabel("2. What is a string in programming?");

        // MCQ Options for Question 2
        String[] optionsQuestion2 = {
            "A data type for storing multiple numeric values",
            "A collection of characters",
            "A method for controlling program flow",
            "An algorithm for sorting arrays"
        };

        JComboBox<String> answer2ComboBox = new JComboBox<>(optionsQuestion2);

        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Tap to Back");

        // Action listener for the Submit button
        submitButton.addActionListener(e -> {
            // Get selected answers and process them
            String answer1 = (String) answer1ComboBox.getSelectedItem();
            String answer2 = (String) answer2ComboBox.getSelectedItem();
            
            // Correct answers (dummy for demonstration)
            String correctAnswer1 = "A block of code that is repeated a specific number of times";
            String correctAnswer2 = "A collection of characters";

            // Check if the selected answers are correct
            boolean isCorrect1 = answer1.equals(correctAnswer1);
            boolean isCorrect2 = answer2.equals(correctAnswer2);

            // Prepare feedback message
            StringBuilder feedback = new StringBuilder("Answers submitted:\n");
            feedback.append("1. ").append(answer1).append(" (").append(isCorrect1 ? "Correct" : "Wrong").append(")\n");
            feedback.append("2. ").append(answer2).append(" (").append(isCorrect2 ? "Correct" : "Wrong").append(")");

            JOptionPane.showMessageDialog(this, feedback.toString(), "Submission", JOptionPane.INFORMATION_MESSAGE);
        });

        backButton.addActionListener(e -> cardLayout.show(currentPanel, "quizzesPanel"));

        mcqsPanel.add(titleLabel);
        mcqsPanel.add(question1Label);
        mcqsPanel.add(answer1ComboBox);
        mcqsPanel.add(question2Label);
        mcqsPanel.add(answer2ComboBox);
        mcqsPanel.add(submitButton);
        mcqsPanel.add(backButton);

        currentPanel.add(mcqsPanel, quizTitle.toLowerCase() + "MCQPanel");
        cardLayout.show(currentPanel, quizTitle.toLowerCase() + "MCQPanel");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(OnlineLearningPlatform::new);
    }
}
