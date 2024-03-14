import java.awt.*;
import javax.swing.*;

public class MidpointLineDrawing extends JPanel {

    private int x1, y1, x2, y2;

    // Konstruktor untuk menginisialisasi koordinat garis
    public MidpointLineDrawing(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // Override metode paintComponent untuk menggambar garis
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLine(g, x1, y1, x2, y2);
    }

    // Metode untuk menggambar garis menggunakan algoritma Midpoint
    private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1; // Menghitung perubahan x
        int dy = y2 - y1; // Menghitung perubahan y
        int d = 2 * dy - dx; // Parameter keputusan awal
        int incrE = 2 * dy; // Increment untuk bergerak E
        int incrNE = 2 * (dy - dx); // Increment untuk bergerak NE
        int x = x1; // Koordinat x awal
        int y = y1; // Koordinat y awal

        g.setColor(Color.BLACK); // Mengatur warna menjadi hitam
        g.fillRect(x, y, 1, 1); // Menggambar sebuah pixel di titik awal

        // Melakukan iterasi terhadap koordinat x
        while (x < x2) {
            if (d <= 0) { // Jika d kurang dari atau sama dengan 0, pilih E
                d += incrE;
                x++; // Bergerak ke pixel berikutnya di arah E
            } else { // Jika d lebih besar dari 0, pilih NE
                d += incrNE;
                x++; // Bergerak ke pixel berikutnya di arah NE
                y--; // Bergerak secara diagonal
            }
            g.setColor(Color.BLACK); // Mengatur warna menjadi hitam
            g.fillRect(x, y, 1, 1); // Menggambar sebuah pixel di titik saat ini
        }
    }

    // Metode utama untuk membuat JFrame dan menampilkan garis
    public static void main(String[] args) {
        int x1 = 50; // Koordinat x awal
        int y1 = 100; // Koordinat y awal
        int x2 = 250; // Koordinat x akhir
        int y2 = 50; // Koordinat y akhir

        JFrame frame = new JFrame("Midpoint Line Drawing"); // Membuat JFrame
        MidpointLineDrawing panel = new MidpointLineDrawing(x1, y1, x2, y2); // Membuat panel dengan koordinat garis
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Mengatur operasi penutupan default
        frame.add(panel); // Menambahkan panel ke dalam frame
        frame.setSize(400, 300); // Mengatur ukuran frame
        frame.setVisible(true); // Membuat frame terlihat
    }
}
