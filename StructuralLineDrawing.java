import java.awt.*;
import javax.swing.*;

public class StructuralLineDrawing extends JPanel {

    private int x0, y0, x1, y1;

    // Konstruktor untuk menginisialisasi titik awal dan akhir garis
    public StructuralLineDrawing(int x0, int y0, int x1, int y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    // Metode untuk menggambar komponen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLine(g, x0, y0, x1, y1);
    }

    // Metode untuk menggambar garis menggunakan algoritma struktural
    private void drawLine(Graphics g, int x0, int y0, int x1, int y1) {
        // Hitung perubahan horizontal dan vertikal
        int dx = x1 - x0;
        int dy = y1 - y0;

        // Tentukan arah langkah
        int stepX = (dx > 0) ? 1 : -1;
        int stepY = (dy > 0) ? 1 : -1;

        // Hitung panjang garis dalam langkah-langkah
        int dxAbs = Math.abs(dx);
        int dyAbs = Math.abs(dy);
        int steps = Math.max(dxAbs, dyAbs);

        // Gambar garis pixel per pixel
        for (int i = 0; i < steps; i++) {
            // Gambar satu piksel hitam pada koordinat (x0, y0)
            g.setColor(Color.BLACK);
            g.fillRect(x0, y0, 1, 1);

            // Update posisi (x0, y0) ke piksel berikutnya
            x0 += stepX;
            y0 += stepY;
        }
    }

    // Metode utama untuk menjalankan aplikasi
    public static void main(String[] args) {
        // Tentukan koordinat titik awal dan titik akhir garis
        int x0 = 50; // Koordinat x titik awal garis
        int y0 = 50; // Koordinat y titik awal garis
        int x1 = 150; // Koordinat x titik akhir garis
        int y1 = 70; // Koordinat y titik akhir garis

        // Buat frame
        JFrame frame = new JFrame("Structural Line Drawing");
        // Buat panel untuk menggambar garis
        StructuralLineDrawing panel = new StructuralLineDrawing(x0, y0, x1, y1);
        // Atur operasi penutupan default untuk frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Tambahkan panel ke dalam frame
        frame.add(panel);
        // Atur ukuran frame
        frame.setSize(200, 120);
        // Tampilkan frame
        frame.setVisible(true);
    }
}
