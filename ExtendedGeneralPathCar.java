import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class ExtendedGeneralPathCar extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Mengatur skala agar sesuai dengan gambar
        g2d.scale(0.5, 0.5);
        
        // Gambar badan mobil
        g2d.setColor(Color.RED);
        g2d.fillRect(10, 100, 400, 100);

        // Gambar roda
        g2d.setColor(Color.BLACK);
        g2d.fillOval(50, 170, 100, 100);
        g2d.fillOval(310, 170, 100, 100);

        // Membuat jalur umum
        GeneralPath path = new GeneralPath();

        // Mulai jalur
        path.moveTo(50, 100);

        // Kurva quadratic dengan titik kontrol
        path.quadTo(150, 50, 300, 100);
        
        // Tambahkan titik kontrol untuk kurva quadratic
        g2d.setColor(Color.BLUE);
        g2d.fillRect(150, 50, 5, 5);
        g2d.drawLine(50, 100, 150, 50);
        g2d.drawLine(300, 100, 150, 50);

        // Kurva cubic dengan titik kontrol
        path.curveTo(320, 50, 350, 150, 450, 100);

        // Tambahkan titik kontrol untuk kurva cubic
        g2d.setColor(Color.GREEN);
        g2d.fillRect(320, 50, 5, 5);
        g2d.fillRect(350, 150, 5, 5);
        g2d.drawLine(300, 100, 320, 50);
        g2d.drawLine(450, 100, 350, 150);

        // Gambar jalur mobil dengan garis solid
        g2d.setColor(Color.BLACK);
        g2d.draw(path);

        // Tampilkan grafik
        g2d.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Extended General Path Car");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ExtendedGeneralPathCar());
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
