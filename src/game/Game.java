/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static javax.swing.JOptionPane.showMessageDialog;
//import com.croftsoft.core.CroftSoftConstants;
@SuppressWarnings("serial")
public class Game extends JPanel {
        Graphics graph;
        boolean FirstTime=true;
        int Target_X=0;
        int Target_Y=0;
        int Step = 32;
        static int CellWidth=32;
        static int CellHeight=32;
        static int Width=20;   
        static int Height=20; 
        int StartingPointX=0;
        int StartingPointY=0;
        int Height_Pixels=Height*CellHeight;
        int Width_Pixels=Width*CellWidth;
        String[] FieldDesign = new String[20];
        char[][] Field = new char[20][20]; 
        
        Tank tank0 = new Tank(this,0);
        Tank tank1 = new Tank(this,1);
        Tank tank2 = new Tank(this,2);
        
        
        
	public Game() {
            addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {				
                    tank0.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {			
                    tank0.keyPressed(e);
            }
            });
            setFocusable(true);
	}
	
	

	@Override
	public void paint(Graphics g) {
                
            super.paint(g);
            graph=g;            
            DrawField(0);        
            tank0.paint((Graphics2D)g);
              
	}
        //private void DrawField(Graphics g,int Level){
        private void DrawField(int Level){
            int X_Axis;
            int Y_Axis;
            Graphics2D g2d = (Graphics2D) graph;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            //if (FirstTime){
                //ShowLevel(0);
                FirstTime=false;
            //}
            for (int i=0;i<=Width;i++){
                X_Axis=i*CellWidth;                    
                graph.drawLine(StartingPointX+X_Axis,StartingPointY,StartingPointX+X_Axis,StartingPointY+Height_Pixels);
            }
            for (int j=0;j<=Height;j++){
                Y_Axis=j*CellHeight;
                graph.drawLine(StartingPointX,StartingPointY+Y_Axis,StartingPointX+Width_Pixels,StartingPointY+Y_Axis);
            }
            
            
            
            
            
            tank0.paint(g2d);
        }
	public static void main(String[] args) throws InterruptedException {
                int Height_Pixels=Height*CellHeight;
                int Width_Pixels=Width*CellWidth;
                int X_Margin=100;
                int Y_Margin=200;
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
                Button a=new Button("HI");
		frame.add(game);
                
		frame.setSize(Width_Pixels+X_Margin,Height_Pixels+Y_Margin);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
                DrawField(0);                                 
                
		while (true) {			
			game.repaint();
			Thread.sleep(10);
		}
	}
        private void DefineLevel(int Level){
		switch(Level){
		case 0:
			FieldDesign[0] ="____________________";
			FieldDesign[1] ="____________________";
			FieldDesign[2] ="____***********_____";
			FieldDesign[3] ="____________________";
			FieldDesign[4] ="____________________";
			FieldDesign[5] ="____________________";
			FieldDesign[6] ="____*********_______";
			FieldDesign[7] ="____________*_______";
			FieldDesign[8] ="____________*_______";
			FieldDesign[9] ="_________T__*_______";
			FieldDesign[10]="____________*_______";
			FieldDesign[11]="______*******_______";
			FieldDesign[12]="____________________";
			FieldDesign[13]="___________b________";
			FieldDesign[14]="____________________";
			FieldDesign[15]="____________________";
			FieldDesign[16]="____________________";
			FieldDesign[17]="___0________________";
			FieldDesign[18]="____________________";
			FieldDesign[19]="_________1_____2____";
		break;
		case 1:
			FieldDesign[0] ="____________________";
			FieldDesign[1] ="_**_______b_________";
			FieldDesign[2] ="____*_______________";
			FieldDesign[3] ="____*___********____";
			FieldDesign[4] ="____*_______________";
			FieldDesign[5] ="____________________";
			FieldDesign[6] ="__*******____*____b_";
			FieldDesign[7] ="T_____________*______";
			FieldDesign[8] ="_____________*______";
			FieldDesign[9] ="____b_______________";
			FieldDesign[10]="_______________****_";
			FieldDesign[11]="_______*****_____*__";
			FieldDesign[12]="_________________*__";
			FieldDesign[13]="___*________________";
			FieldDesign[14]="___*________________";
			FieldDesign[15]="___*__________*_____";
			FieldDesign[16]="___*__________*_____";
			FieldDesign[17]="____________________";
			FieldDesign[18]="_**____**____**_____";
			FieldDesign[19]="_*0____*1____*2_____";
		break;
		case 2:
			FieldDesign[0] ="_________T__________";
			FieldDesign[1] ="__***_________****__";
			FieldDesign[2] ="____________________";
			FieldDesign[3] ="___****__****_______";
			FieldDesign[4] ="____________________";
			FieldDesign[5] ="___________*****____";
			FieldDesign[6] ="____________________";
			FieldDesign[7] ="______******___**___";
			FieldDesign[8] ="__***_______________";
			FieldDesign[9] ="____________________";
			FieldDesign[10]="____________________";
			FieldDesign[11]="_______*******___***";
			FieldDesign[12]="____________________";
			FieldDesign[13]="__***_______________";
			FieldDesign[14]="_____________***____";
			FieldDesign[15]="______*_____________";
			FieldDesign[16]="_____*******________";
			FieldDesign[17]="**__________________";
			FieldDesign[18]="____________________";
			FieldDesign[19]="_____*_0______*_____";
		break;
		}
	}
        public void ShowLevel(int Level){		
		DefineLevel(Level);	
		CreateGameField();
		DrawGameField();
                
                tank0.setTankAngle(180);                               
                tank0.setTank_X_Loc(8);
                tank0.setTank_Y_Loc(19);
                
                tank1.setTankAngle(0);
                tank1.setTank_X_Loc(1);
                tank1.setTank_Y_Loc(1);
                
                tank2.setTankAngle(270);
                tank2.setTank_Y_Loc(17);
                
                
                tank2.setTank_X_Loc(17);
	}
        private void CreateGameField(){
            char Char=' ';
		for (int j=0;j<Height;j++){
			for (int i=0;i<Width;i++){
                            Char=FieldDesign[j].charAt(i);
                            Field[i][j]=Char;
			}			
		}		
	}
        
        private void ShowPhoto(String PhotoName,int Tank_X_Loc,int Tank_Y_Loc){      
            Image image;
            int x=Tank_X_Loc*Step;
            int y=Tank_Y_Loc*Step;
            try{    
                File image2 = new File(PhotoName);
                image = ImageIO.read(image2);
                graph.drawImage(image, x, y, Step, Step, this);
            }
            catch (IOException e){
                e.printStackTrace();
            }        
        }

        private void DrawGameField(){
            
            
            String ImageName="";
            String Path="C:/Ideation Max/Java Robotics/";
            for (int i=0;i<Height;i++){			
                for (int j=0;j<Width;j++){	
                    switch(Field[i][j]){
                        case 'T':
                                Target_X=i;
                                Target_Y=j;
                                ImageName=Path+"Images/Castle.png";
                                ShowPhoto(ImageName,i,j);
                        break;
                        case '*':
                                ImageName=Path+"Images/wall.png";
                                ShowPhoto(ImageName,i,j);
                        break;
                        case '_':
                                ImageName=Path+"Images/Blank.png";
                                ShowPhoto(ImageName,i,j);
                        break;
                        case 'b':
                                ImageName=Path+"Images/Bomb.png";
                                ShowPhoto(ImageName,i,j);
                        break;
/*                        
                        case '0':
                                tank0.setTankAngle(90);                               
                                tank0.setTank_X_Loc(i);
                                tank0.setTank_Y_Loc(j);
                                
                        break;
                        
                        case '1':
                                Tank_X_Loc[1]=i;
                                Tank_Y_Loc[1]=j;
                                Tank_Angle[1]=Math.floor((Math.random() * 4) )* 90;
                                ShowTank(1);
                        break;
                        case '2':
                                Tank_X_Loc[2]=i;
                                Tank_Y_Loc[2]=j;
                                Tank_Angle[2]=Math.floor((Math.random() * 4) )* 90;
                                ShowTank(2);
                        break;
*/        
                    }
                }			
            }
            
	}
}