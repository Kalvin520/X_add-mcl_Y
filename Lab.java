package ch1;

import javax.swing.*;
import java.awt.*;
/**
 * @author kalvin
 */
public class LoopLab extends JPanel {
    String type;
    int n;
     public  LoopLab(){
         type = JOptionPane.showInputDialog("Do you want an addition table or multiplication table? (A or M)");
         n = Integer.parseInt(JOptionPane.showInputDialog("How big do you want the table to be?"));//要多少格
     }
    @Override
    public void paintComponent(Graphics graphics){

        int w = getWidth();
        int h = getHeight();
        int x = 0;//第一個筐x
        int y = 0;//第一個筐y
        int cellWidth = w / n;  //每格寬度
        int cellHeight = h / n; //每格高度

        //nested for loop
        //table是從1開始 int i = 1
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1 ){
                    //黃底
                    graphics.setColor(Color.yellow);
                    graphics.fillRect(x, y, cellWidth, cellHeight);
                }
                //外層黑匡
                graphics.setColor(Color.pink);
                graphics.drawRect(x, y, cellWidth, cellHeight);

                if (i == 1){
                    graphics.drawString("" + j, x + 5, y + 20 );//抓j直
                } else if (j == 1) {
                    graphics.drawString("" + i , x + 5, y + 20 );//抓i直
                }else {
                    int value;
                    if ("a".equals(type.toLowerCase())){
                        value = i + j;
                    }
                    else {
                        value = i * j;
                    }
                    graphics.drawString("" + value, x + 5, y + 20 );//設定筐內文字座標高度
                }
                x += cellWidth;
            }
            x = 0;
            y += cellHeight;
        }
    }
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize( 720,720);
        window.setContentPane(new LoopLab());
        window.setVisible(true);
    }
}
