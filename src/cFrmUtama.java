import java.awt.*;
import java.awt.image.BufferedImage; //Agar bisa memakai BufferedImage line 9
import java.io.File; //Pemanggilan File line 8
import java.io.IOException; //Untuk Try Catch Exceptions
import javax.imageio.ImageIO;
import java.lang.Math; //Untuk abs line 49

import static java.lang.Math.round;

public class cFrmUtama extends javax.swing.JFrame{
    File f;
    BufferedImage Gambar;

    public void HorizontalLine(int x1, int x2, int y, int Warna){
        for(int x=x1; x<x2; x++){
            Gambar.setRGB(x, y, Warna);
        }
    }
    public void VerticalLine(int x, int y1, int y2, int Warna){
        for(int y=y1; y<y2; y++){
            Gambar.setRGB(x, y, Warna);
        }
    }
    public void Diagonal45Line(int x, int y, int length, int Warna){
        x=x; y=y;
        for(int i=1; i<length; i++){
            Gambar.setRGB(x, y, Warna);
            x++; y++;
        }
    }
    public void FilledRectangle (int x1, int x2, int y1, int y2, int Warna){
        for(int y=y1; y<y2; y++){
            for(int x=x1; x<x2; x++){
                Gambar.setRGB(x, y, Warna);
            }
        }
    }
    public void EmptyRectangle (int x1, int x2, int y1, int y2, int Warna){
        for(int x=x1; x<x2; x++){
            Gambar.setRGB(x, y1, Warna);
            Gambar.setRGB(x,y2, Warna);
        }
        for(int y=y1; y<y2; y++){
            Gambar.setRGB(x1, y, Warna);
            Gambar.setRGB(x2, y, Warna);
        }
    }
    public void CustomDiagonal(int x1, int x2, int y1, int y2, int Warna){
        int dx, dy, xLength, yLength, Count, i;
        float x, y, rx, ry;
        x = x1; y = y1; dx = x2 - x1; dy = y2 - y1; xLength = Math.abs(dx); yLength = Math.abs(dy);
        if (xLength>yLength){
            rx = 1;
            ry = Math.abs(yLength/xLength);
            Count = xLength;
        }else{
            rx = Math.abs(xLength/yLength);
            ry = 1;
            Count = yLength;
        }
        if(dx<0) rx=-rx;
        if (dy<0) ry=-ry;
        for(i = 0; i<Count; i++){
            Gambar.setRGB(round(x), round(y), Warna);
            x += rx; y += ry;
        }
    }

    public cFrmUtama(){
        int x, y, Warna=0x00FF00;

        initComponents();
        Gambar = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_RGB);
        for(int i=0; i<1920; i++){
            for(int j=0; j<1080; j++){
                Gambar.setRGB(i, j, Color.WHITE.getRGB());
            }
        }

        HorizontalLine(50, 150, 200, 0x0000ff);
        VerticalLine(50, 100, 200, 0x3a8f22);
        Diagonal45Line(50, 100, 100, 0xffdf70);
        FilledRectangle(400, 700, 400, 500, 0xad24d3);
        EmptyRectangle(100, 300, 250, 350, 0xac4cae);
        CustomDiagonal(700, 400, 200, 200, 0xdd2899);
    }
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 986, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 614, Short.MAX_VALUE)
        );

        pack();
    }

    public void paint(Graphics g){
        g.drawImage(Gambar, 0 ,30, this);
        this.setTitle("Primitive Geometry 1");
    }
}
