import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class W06_Grader
{

    public W06_Grader()
    {
    }

    public static int testBasicObject()
    {
        try
        {
            int points = 35;
            int deduction = points / 7;
            BufferedImage block = ImageIO.read(new File("Block.gif"));
            BufferedImage bricks = ImageIO.read(new File("Bricks.gif"));
            BufferedImage logo = ImageIO.read(new File("Logo.gif"));
            BufferedImage pipe = ImageIO.read(new File("Pipe.gif"));
            System.out.println("Testing BasicObject methods");
            int rand1 = (int)(Math.random() * 300D);
            int rand2 = (int)(Math.random() * 300D);
            BasicObject b1 = new BasicObject(rand1, rand2, false);
            BasicObject b2 = new BasicObject(rand1 / 2, rand2 / 2, true);
            if(b1.getX() != rand1 || b2.getX() != rand1 / 2)
            {
                System.out.println("Error with your 3 argument BasicObject constructor.  The x is not working correctly.  This could also be caused by your getX method");
                points -= deduction;
            } else
            if(b1.getY() != rand2 || b2.getY() != rand2 / 2)
            {
                System.out.println("Error with your 3 argument BasicObject constructor.  The y is not working correctly.  This could also be caused by your getY method");
                points -= deduction;
            } else
            if(b1.getSolidState() || !b2.getSolidState())
            {
                System.out.println("Error with your 3 argument BasicObject constructor.  The solid state is not working correctly.  This could also be caused by your getSolidState method");
                points -= deduction;
            }
            b1 = new BasicObject(rand1, rand2, false, block);
            b2 = new BasicObject(rand1 / 2, rand2 / 2, true, bricks);
            if(b1.getX() != rand1 || b2.getX() != rand1 / 2)
            {
                System.out.println("Error with your 4 argument BasicObject constructor.  The x is not working correctly.  This could also be caused by your getX method");
                points -= deduction;
            } else
            if(b1.getY() != rand2 || b2.getY() != rand2 / 2)
            {
                System.out.println("Error with your 4 argument BasicObject constructor.  The y is not working correctly.  This could also be caused by your getY method");
                points -= deduction;
            } else
            if(b1.getSolidState() || !b2.getSolidState())
            {
                System.out.println("Error with your 4 argument BasicObject constructor.  The solid state is not working correctly.  This could also be caused by your getSolidState method");
                points -= deduction;
            } else
            if(b1.getCurrentImage() != block || b2.getCurrentImage() != bricks)
            {
                System.out.println("Error with your 4 argument BasicObject constructor.  The current image is not working correctly.  This could also be caused by your getCurrentImage method");
                points -= deduction;
            }
            rand1 = (int)(Math.random() * 300D);
            rand2 = (int)(Math.random() * 300D);
            b1.setX(rand1);
            b2.setX(rand2);
            if(b1.getX() != rand1 || b2.getX() != rand2)
            {
                System.out.println("Error with your setX method.  This could also be caused by your getX method");
                points -= deduction;
            }
            rand1 = (int)(Math.random() * 300D);
            rand2 = (int)(Math.random() * 300D);
            b1.setY(rand1);
            b2.setY(rand2);
            if(b1.getY() != rand1 || b2.getY() != rand2)
            {
                System.out.println("Error with your setY method.  This could also be caused by your getY method");
                points -= deduction;
            }
            b1.setSolidState(true);
            b2.setSolidState(false);
            if(!b1.getSolidState() || b2.getSolidState())
            {
                System.out.println("Error with your setSolidState method. This could also be caused by your getSolidState method");
                points -= deduction;
            }
            rand1 = (int)(Math.random() * 300D);
            rand2 = (int)(Math.random() * 300D);
            b1.moveTo(rand1, rand2);
            b2.moveTo(rand2, rand1);
            if(b1.getX() != rand1 || b2.getX() != rand2)
            {
                System.out.println("Error with your moveTo method.  The x variable is not set correctly.  This could also be caused by your getX method");
                points -= deduction;
            } else
            if(b1.getY() != rand2 || b2.getY() != rand1)
            {
                System.out.println("Error with your moveTo method.  The y variable is not set correctly.  This could also be caused by your getX method");
                points -= deduction;
            }
            b1.setCurrentImage(logo);
            b2.setCurrentImage(pipe);
            if(b1.getCurrentImage() != logo || b2.getCurrentImage() != pipe)
            {
                System.out.println("Error with your setCurrentImage method.  This could also be caused by your getCurrentImage method");
                points -= deduction;
            }
            new CreatePicture(0);
            return points;
        }
        catch(IOException e)
        {
            System.out.println("Unfortunately there was an error thrown.  Probably the images are not loading.  Unable to grade your file");
            e.printStackTrace();
            return 0;
        }
    }

    public static int testAnimatedObject()
    {
        try
        {
            int points = 45;
            int deduction = points / 7;
            System.out.println("Testing AnimatedObject methods");
            BufferedImage bowser[] = {
                ImageIO.read(new File("Bowser1.gif")), ImageIO.read(new File("Bowser2.gif")), ImageIO.read(new File("Bowser3.gif"))
            };
            BufferedImage mario[] = {
                ImageIO.read(new File("Mario1.gif")), ImageIO.read(new File("Mario2.gif")), ImageIO.read(new File("Mario3.gif"))
            };
            int rand1 = (int)(Math.random() * 300D);
            int rand2 = (int)(Math.random() * 300D);
            AnimatedObject b1 = new AnimatedObject(rand1, rand2, false);
            AnimatedObject b2 = new AnimatedObject(rand1 / 2, rand2 / 2, true);
            if(b1.getX() != rand1 || b2.getX() != rand1 / 2)
            {
                System.out.println("Error with your 3 argument AnimatedObject constructor.  The x is not working correctly.  This could also be caused by your getX method");
                points -= deduction;
            } else
            if(b1.getY() != rand2 || b2.getY() != rand2 / 2)
            {
                System.out.println("Error with your 3 argument AnimatedObject constructor.  The y is not working correctly.  This could also be caused by your getY method");
                points -= deduction;
            } else
            if(b1.getSolidState() || !b2.getSolidState())
            {
                System.out.println("Error with your 3 argument AnimatedObject constructor.  The solid state is not working correctly.  This could also be caused by your getSolidState method");
                points -= deduction;
            }
            b1 = new AnimatedObject(rand1, rand2, false, bowser);
            b2 = new AnimatedObject(rand1 / 2, rand2 / 2, true, mario);
            if(b1.getX() != rand1 || b2.getX() != rand1 / 2)
            {
                System.out.println("Error with your 4 argument AnimatedObject constructor.  The x is not working correctly.  This could also be caused by your getX method");
                points -= deduction;
            } else
            if(b1.getY() != rand2 || b2.getY() != rand2 / 2)
            {
                System.out.println("Error with your 4 argument AnimatedObject constructor.  The y is not working correctly.  This could also be caused by your getY method");
                points -= deduction;
            } else
            if(b1.getSolidState() || !b2.getSolidState())
            {
                System.out.println("Error with your 4 argument AnimatedObject constructor.  The solid state is not working correctly.  This could also be caused by your getSolidState method");
                points -= deduction;
            } else
            if(b1.getCurrentImage() != bowser[0] || b2.getCurrentImage() != mario[0])
            {
                System.out.println("Error with your 4 argument AnimatedObject constructor.  The current image is not working correctly.  This could also be caused by your getCurrentImage method");
                points -= deduction;
            }
            rand1 = (int)(Math.random() * 300D);
            rand2 = (int)(Math.random() * 300D);
            b1.setX(rand1);
            b2.setX(rand2);
            if(b1.getX() != rand1 || b2.getX() != rand2)
            {
                System.out.println("Error with your setX method.  This could also be caused by your getX method");
                points -= deduction;
            }
            rand1 = (int)(Math.random() * 300D);
            rand2 = (int)(Math.random() * 300D);
            b1.setY(rand1);
            b2.setY(rand2);
            if(b1.getY() != rand1 || b2.getY() != rand2)
            {
                System.out.println("Error with your setY method.  This could also be caused by your getY method");
                points -= deduction;
            }
            b1.setSolidState(true);
            b2.setSolidState(false);
            if(!b1.getSolidState() || b2.getSolidState())
            {
                System.out.println("Error with your setSolidState method. This could also be caused by your getSolidState method");
                points -= deduction;
            }
            rand1 = (int)(Math.random() * 300D);
            rand2 = (int)(Math.random() * 300D);
            b1.moveTo(rand1, rand2);
            b2.moveTo(rand2, rand1);
            if(b1.getX() != rand1 || b2.getX() != rand2)
            {
                System.out.println("Error with your moveTo method.  The x variable is not set correctly.  This could also be caused by your getX method");
                points -= deduction;
            } else
            if(b1.getY() != rand2 || b2.getY() != rand1)
            {
                System.out.println("Error with your moveTo method.  The y variable is not set correctly.  This could also be caused by your getX method");
                points -= deduction;
            }
            b1.setCurrentImage(bowser[1]);
            b2.setCurrentImage(mario[mario.length - 1]);
            if(b1.getCurrentImage() != bowser[1] || b2.getCurrentImage() != mario[mario.length - 1])
            {
                System.out.println("Error with your setCurrentImage method.  This could also be caused by your getCurrentImage method");
                points -= deduction;
            }
            new CreatePicture(1);
            return points;
        }
        catch(IOException e)
        {
            System.out.println("Unfortunately there was an error thrown.  Probably the images are not loading.  Unable to grade your file");
            e.printStackTrace();
            return 0;
        }
    }
}
