import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zyx
 */
public class SecurityCodeBuilder {
    public static void main(String[] args) {
        BufferedImage bufferedImage = new BufferedImage(80, 40, BufferedImage.TYPE_INT_RGB);
        try {
            FileOutputStream file = new FileOutputStream("img.jpg");
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.red);
            graphics.fillRect(0, 0, 80,40);
            graphics.setFont(new Font("微软雅黑", Font.BOLD, 20));
            graphics.setColor(Color.BLACK);
            graphics.drawString("1234", 15, 30);
            ImageIO.write(bufferedImage, "jpg", file);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
