/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author hmaghaw
 */


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import java.io.IOException;
import static javax.swing.JOptionPane.showMessageDialog;

public class Tank {
	static int Width=20;   
        static int Height=20;
	

        int Step = 32;
	private Game game;
        private Image image;
        int Tank_Angle=90;
        int Tank_Y_Loc=0;
	int Tank_X_Loc=0;
        int CurrentTank=0;
        static String[] TankColor={"Red","Green","Blue"};
        
	//public Tank(Game game,int TankId) {
	//	this.game= game;
        //        CurrentTank=TankId;
	//}
        public Tank(Game game,int TankId) {
		this.game= game;
                CurrentTank=TankId;
	}
        //public void SetCurrentTank(int TankId){
        //    CurrentTank=TankId;
        //}
        public void setTankAngle(int Angle){
            this.Tank_Angle=Angle;
        }
        public void setTank_Y_Loc(int Value){
            this.Tank_Y_Loc=Value;
        }
        public void setTank_X_Loc(int Value){
            this.Tank_X_Loc=Value;
        }
        public void keyReleased(KeyEvent e) {

	}
        private void Move(){
		int New_X;
		int New_Y;
		String Field="_";
                //showMessageDialog(null, "Tank_Y_Loc !"+Tank_Y_Loc);
		switch(Tank_Angle){
                    case 0:
                        if (Tank_Y_Loc>0){
                            New_Y=Tank_Y_Loc-1;
                            New_X=Tank_X_Loc;

                            switch (Field){
                            case "*":
                            break;
                            case "_":					
                                    Tank_Y_Loc=New_Y;
                            break;
                            case "b":

                            break;
                            }
                        }
                    break;
                    case 90:
                        if (Tank_X_Loc<Width-1){
                            New_Y=Tank_Y_Loc;
                            New_X=Tank_X_Loc+1;					
                            if (Field=="_"){
                                    Tank_X_Loc=New_X;
                            }
                        }
                    break;
                    case 180:
                        if (Tank_Y_Loc<Height-1){
                            New_Y=Tank_Y_Loc+1;
                            New_X=Tank_X_Loc;					

                            if (Field=="_"){
                                    Tank_Y_Loc=New_Y;
                            }
                        }
                    break;
                    case 270:
                        if (Tank_X_Loc>0){
                            New_Y=Tank_Y_Loc;
                            New_X=Tank_X_Loc-1;

                            if (Field=="_"){
                                    Tank_X_Loc=Tank_X_Loc-1;
                            }
                        }
                    break;
		}
	}
	public void keyPressed(KeyEvent e) {
            
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    Tank_Angle=Tank_Angle-90;
                    if (Tank_Angle==-90){
                            Tank_Angle=270;
                    }
                    //showMessageDialog(null, "Tank_Angle !"+Tank_Angle);
                    break;
                 case KeyEvent.VK_RIGHT:
                    Tank_Angle=Tank_Angle+90;
                    if (Tank_Angle==360){
                            Tank_Angle=0;
                    }
                    //showMessageDialog(null, "Tank_Angle !"+Tank_Angle);
                    break;  
                 case KeyEvent.VK_UP:
                        int k = 2;
      int g = "GVU".hashCode() % 3000;
      int f = "QVV".hashCode() % 3000;
      for (int s = 0; s <= f; s++)
         k = (k ^ s) % g;
      //showMessageDialog(null, "k :"+k);
                        Move();
                    break; 
            }
            
	}
        
        private String GetTankShape(int TankId){
		String PhotoName="";
		switch(Tank_Angle){
			case 0:
				PhotoName="Tank-Up.png";
			break;
			case 90:
				PhotoName="Tank-Right.png";
			break;
			case 180:
				PhotoName="Tank-Down.png";
			break;
			case 270:
				PhotoName="Tank-Left.png";
			break;
		}
		return "C:/Ideation Max/Java Robotics/Images/"+TankColor[TankId]+"/"+PhotoName;
	}
	
	public void paint(Graphics2D g) {
	    String PhotoName=GetTankShape(CurrentTank);
            //showMessageDialog(null, "GetTankShape :"+CurrentTank);
            int x=Tank_X_Loc*Step;
            int y=Tank_Y_Loc*Step;
            try{    
                File image2 = new File(PhotoName);
                image = ImageIO.read(image2);
                g.drawImage(image, x, y, Step, Step, game);
            }
            catch (IOException e){
                e.printStackTrace();
            }
            
        }
	
}