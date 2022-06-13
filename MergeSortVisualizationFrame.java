package src.classSrc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MergeSortVisualizationFrame extends JFrame {
    private JMenuBar menuBar;

    private JMenu setMenu;
    private JMenu speedMenu;
    private JMenu exitMenu;

    private ButtonGroup speedGroup;

    private JRadioButtonMenuItem speedMI1;
    private JRadioButtonMenuItem speedMI2;
    private JRadioButtonMenuItem speedMI3;
    private JRadioButtonMenuItem speedMI4;
    private JRadioButtonMenuItem speedMI5;
    public int speedFlag = 1;

    private JMenuItem frontMI;
    private JMenuItem menuMI;
    private JMenuItem closeMI;

    private ImageIcon backgroundImage;
    private ImageIcon titleImage;
    private ImageIcon startImage;
    private ImageIcon pauseImage;
    private ImageIcon restartImage;

    private JButton startButton;
    private JButton pauseButton;
    private JButton restartButton;

    private JLabel backgroundLabel;
    private JLabel titleLabel;

    private JPanel backgroundPanel;
    private JPanel titlePanel;
    private MergeSortPanel animatePanel;

    public MergeSortVisualizationFrame() {

        // GUI init
        super("ALGORITHM VISUALIZATION");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // set background
        backgroundImage = new ImageIcon("src/imageSrc/Background.png");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        backgroundPanel = (JPanel) getContentPane();
        backgroundPanel.setOpaque(false);
        getLayeredPane().add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));

        // set title panel
        titlePanel = new JPanel();
        titlePanel.setBounds(50, 25, 885, 50);
        titleImage = new ImageIcon("src/imageSrc/MergeSort.png");
        titleLabel = new JLabel(titleImage);
        titleLabel.setBounds(50, 50, titlePanel.getWidth(), titlePanel.getHeight());
        titlePanel.setOpaque(false);
        titlePanel.add(titleLabel);
        getLayeredPane().add(titleLabel, Integer.MIN_VALUE + 1);

        // set function menuBar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        setMenu = new JMenu("Set");
        menuBar.add(setMenu);

        // set Button in menuBar
        startImage = new ImageIcon("src/imageSrc/Start.png");
        pauseImage = new ImageIcon("src/imageSrc/Pause.png");
        restartImage = new ImageIcon("src/imageSrc/Restart.png");

        startButton = new JButton(startImage);
        pauseButton = new JButton(pauseImage);
        restartButton = new JButton(restartImage);

        menuBar.add(startButton);
        menuBar.add(pauseButton);
        menuBar.add(restartButton);

        // set setMenu in menuBar
        speedMenu = new JMenu("Speed");
        exitMenu = new JMenu("Exit");

        setMenu.add(speedMenu);
        setMenu.addSeparator();
        setMenu.add(exitMenu);

        // set speedButton group
        speedMI1 = new JRadioButtonMenuItem("Speed1", true);
        speedMI2 = new JRadioButtonMenuItem("Speed2", false);
        speedMI3 = new JRadioButtonMenuItem("Speed3", false);
        speedMI4 = new JRadioButtonMenuItem("Speed4", false);
        speedMI5 = new JRadioButtonMenuItem("Speed5", false);

        // add speedButtonGroup together
        speedGroup = new ButtonGroup();
        speedGroup.add(speedMI1);
        speedGroup.add(speedMI2);
        speedGroup.add(speedMI3);
        speedGroup.add(speedMI4);
        speedGroup.add(speedMI5);

        // add speedButtonGroup into speedMenu
        speedMenu.add(speedMI1);
        speedMenu.add(speedMI2);
        speedMenu.add(speedMI3);
        speedMenu.add(speedMI4);
        speedMenu.add(speedMI5);

        // add MenuItem into exitMenu
        frontMI = new JMenuItem("FRONT");
        menuMI = new JMenuItem("MENU");
        closeMI = new JMenuItem("CLOSE");

        exitMenu.add(frontMI);
        exitMenu.add(menuMI);
        exitMenu.add(closeMI);

        // Run Code Action listener
        startButton.addActionListener(new RunCodeAction());
        pauseButton.addActionListener(new RunCodeAction());
        restartButton.addActionListener(new RunCodeAction());

        // Speed Action listener
        speedMI1.addActionListener(new SpeedAction());
        speedMI2.addActionListener(new SpeedAction());
        speedMI3.addActionListener(new SpeedAction());
        speedMI4.addActionListener(new SpeedAction());
        speedMI5.addActionListener(new SpeedAction());

        // Exit Action listener
        frontMI.addActionListener(new ExitAction());
        menuMI.addActionListener(new ExitAction());
        closeMI.addActionListener(new ExitAction());

        // add InsertSort Panel into this frame
        animatePanel = new MergeSortPanel();
        getContentPane().add(animatePanel);
    }

    private class RunCodeAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Object option = event.getSource();
            if (option == startButton) {
                animatePanel.timer.start();
            } else if (option == pauseButton) {
                animatePanel.timer.stop();
            } else if (option == restartButton) {
                new MergeSortVisualizationFrame();
                setVisible(false);
            }
        }
    }

    private class ExitAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Object option = event.getSource();
            if (option == frontMI) {
                new MainFrame();
                setVisible(false);
            } else if (option == menuMI) {
                new Frame1();
                setVisible(false);
            } else if (option == closeMI) {
                System.exit(0);
            }
        }
    }

    private class SpeedAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Object speed = event.getSource();
            if (speed == speedMI1) {
                speedFlag = 1;
            } else if (speed == speedMI2) {
                speedFlag = 2;
            } else if (speed == speedMI3) {
                speedFlag = 3;
            } else if (speed == speedMI4) {
                speedFlag = 4;
            } else if (speed == speedMI5) {
                speedFlag = 5;
            }
            animatePanel.timer.setDelay(1000 - 200 * (speedFlag - 1));
        }
    }
}
