import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.script.ScriptEngineManager;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    

    GUI gp;
    KeyHandler keyH;


    public final int screenX;
    public final int screenY;


    public Player(GUI gp, KeyHandler keyH)
    {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(0,0, gp.characWidth, gp.characHeight);


        setDefualtValues();
        getPlayerImage();
    }

    public void setDefualtValues()
    {
        worldX = gp.tileSize * 25;
        worldY = gp.tileSize * 25;
        speed = 4;
        direction = "down";
        moving = false;
    }


    public void getPlayerImage() 
    {
        try {

            StdDown = ImageIO.read(getClass().getResourceAsStream("/Sprites/StandingDown.png"));
            StdUp = ImageIO.read(getClass().getResourceAsStream("/Sprites/StandingUp.png"));
            StdLeft = ImageIO.read(getClass().getResourceAsStream("/Sprites/StandingLeft.png"));
            StdRight = ImageIO.read(getClass().getResourceAsStream("/Sprites/StandingRight.png"));
            WalkDown_1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/WalkDown_1.png"));
            WalkDown_2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/WalkDown_2.png"));
            WalkUp_1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/WalkUp_1.png"));
            WalkUp_2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/WalkUp_2.png")); 
            WalkLeft_1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/WalkLeft_1.png"));
            WalkLeft_2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/WalkLeft_2.png"));
            WalkRight_1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/WalkRight_1.png"));
            WalkRight_2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/WalkRight_2.png"));

        }catch(IOException e) 
        {
            e.printStackTrace();
        }
    }

    public void update()
    {
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed)
            {
                
                moving = true;
                
                if(keyH.upPressed)
                {
                    direction = "up";
                    worldY -= speed;
                }
                else if(keyH.downPressed)
                {
                    direction = "down";
                    worldY += speed;
                }
                else if(keyH.leftPressed)
                {
                    direction = "left";
                    worldX -= speed;
                }
                else if(keyH.rightPressed)
                {
                    direction = "right";
                    worldX += speed;
                }

                collisionOn = false;
                gp.cChecker.checkTile(this);

                spriteCounter++;
                if(spriteCounter > 15)
                {
                    if(spriteNum == 1)
                    {
                        spriteNum = 2;
                    }
                    else if(spriteNum ==2)
                    {
                        spriteNum = 1;
                    }
                    spriteCounter = 0;
                }

            }
        else
        {
            moving = false;
        }        
                
    }
    
    public void draw(Graphics2D g2)
    {
       BufferedImage image = null;

       if(moving)
       {
        switch(direction)
        {
            case "up":
            if(spriteNum == 1)
            {
                image = WalkUp_1;
            }
           if(spriteNum == 2)
           {
                image = WalkUp_2;
           }
            break;
        case "down":
           if(spriteNum == 1)
           {
            image = WalkDown_1;
           }
           if(spriteNum == 2)
           {
            image = WalkDown_2;
           }
            break;
        case "right":
           if(spriteNum == 1)
           {
            image = WalkRight_1;
           }
           if(spriteNum == 2)
           {
            image = WalkRight_2;
           }     
            break;
        case "left":
           if(spriteNum == 1)
           {
            image = WalkLeft_1;
           }
           if(spriteNum == 2)
           {
            image = WalkLeft_2;
           }
            break;
        }
       }
       else
       {
        switch(direction)
        {
            case "up":
                image = StdUp;
                break;
            case "down":
                image = StdDown;
                break;
            case "left":
                image = StdLeft;
                break;
            case "right":
                image = StdRight;
                break;
            
        }
       }

       g2.drawImage(image, screenX, screenY, gp.characWidth, gp.characHeight, null);
       



    }
}
