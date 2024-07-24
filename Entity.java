import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Entity {
    public int worldX,worldY;
    public int speed;

    public BufferedImage StdDown, StdUp, StdLeft, StdRight, WalkDown_1, WalkDown_2, WalkUp_1, WalkUp_2, WalkLeft_1, WalkLeft_2, WalkRight_1, WalkRight_2;
    public String direction;
    public boolean moving;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea;
    public boolean collisionOn = false;
}
