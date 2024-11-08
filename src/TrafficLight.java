import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLight extends JFrame {
    private TrafficLightColor currentColor;
    private final JPanel lightPanel;

    public TrafficLight() {
        setTitle("Traffic Light");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        lightPanel = new JPanel();
        lightPanel.setBackground(Color.BLACK);
        add(lightPanel, BorderLayout.CENTER);

        currentColor = TrafficLightColor.RED;

        Timer timer = new Timer(2500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (currentColor) {
                    case RED:
                        currentColor = TrafficLightColor.YELLOW;
                        break;
                    case YELLOW:
                        currentColor = TrafficLightColor.GREEN;
                        break;
                    case GREEN:
                        currentColor = TrafficLightColor.RED;
                        break;
                }
                updateLight();
            }
        });
        timer.start();

        updateLight();
    }

    private void updateLight() {
        lightPanel.removeAll();
        switch (currentColor) {
            case RED:
                lightPanel.add(createLight(Color.RED));
                break;
            case YELLOW:
                lightPanel.add(createLight(Color.YELLOW));
                break;
            case GREEN:
                lightPanel.add(createLight(Color.GREEN));
                break;
        }
        lightPanel.revalidate();
        lightPanel.repaint();
        System.out.println(currentColor.getAction());
    }

    private Component createLight(Color color) {
        JPanel light = new JPanel();
        light.setBackground(color);
        light.setPreferredSize(new Dimension(200, 200));
        return light;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrafficLight trafficLight = new TrafficLight();
            trafficLight.setVisible(true);
        });
    }
}
