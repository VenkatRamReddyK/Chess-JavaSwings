import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame implements ActionListener{

public boolean set=true,WHITE_WIN=false,BLACK_WIN=false;//0->false  for white 1-> true for blacks
int counter;
String coin_name;
private int cast=0,i,j,row=0,col=0,rs,cs,flag,rd,cd,rss,css,rdd,cdd,rsh,csh,rsk,csk,rc,cc;
int p;
public Color my_Color,opp_Color,opp_Color_Pressed,my_Color_Pressed;

private static final int WINDOW_WIDTH=1024;
private static final int WINDOW_HEIGHT=786;

private static final GridLayout LAYOUT_STYLE=new GridLayout(8,8,2,2); 

public Label myLabel=new Label("C H E S S");
public JButton button[][]=new JButton[8][8];
public JButton prev_Pressed=new JButton(" ");
public JButton null_Button=new JButton(" ");
public JButton output_Button=new JButton(" ");
ImageIcon tempIcon,output1,iCherry,iRook_b,iKnight_b,iBishop_b,iQueen_b,iKing_b,iPawn_b,iRook_w,iKnight_w,iBishop_w,iQueen_w,iKing_w,iPawn_w;

	public Game(){												
	
	super("------~~~~~~~~~~~~~~~~~~~~CHESS~~~~~~~~~~~~~~~~~~~~------");
	coin_name=new String("");
	
		//counter=10;											
		//myColor.setColor();
	 tempIcon	=new ImageIcon("");
	 iCherry=new ImageIcon("COINS/cherry.jpg");
	 output1=new ImageIcon("COINS/extras/output.jpg");
		
	 iRook_b=new ImageIcon("COINS/Blacks/b_rook.jpg");//8
	 iKnight_b=new ImageIcon("COINS/Blacks/b_knight.jpg");//7
	 iBishop_b=new ImageIcon("COINS/Blacks/b_bishop.jpg");//6
	 iQueen_b=new ImageIcon("COINS/Blacks/b_queen.jpg");
	 iKing_b=new ImageIcon("COINS/Blacks/b_king.jpg");
	 iPawn_b=new ImageIcon("COINS/Blacks/b_pawn.jpg");//10

	
	 iRook_w=new ImageIcon("COINS/Whites/w_rook.jpg");//8
	 iKnight_w=new ImageIcon("COINS/Whites/w_knight.jpg");//7
	 iBishop_w=new ImageIcon("COINS/Whites/w_bishop.jpg");//6
	 iQueen_w=new ImageIcon("COINS/Whites/w_queen.jpg");
	 iKing_w=new ImageIcon("COINS/Whites/w_king.jpg");
	 iPawn_w=new ImageIcon("COINS/Whites/w_pawn.jpg");//10


	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(LAYOUT_STYLE);

	output_Button.setIcon(output1);
	
	setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
	setBounds(200,35,WINDOW_WIDTH,WINDOW_HEIGHT);
	myLabel.setBackground(Color.BLUE);
	myLabel.setForeground(Color.BLACK);
	myLabel.setBounds(0,0,WINDOW_WIDTH,100);
	
	//	window.add(myLabel);
	  for(i=0;i<8;i++)	  {
		for(j=0;j<8;j++)		{
			button[i][j]=new JButton("");
			button[i][j].setBounds(3000,200,150,300);
			button[i][j].setText(" ");
		add(button[i][j]);
		}
	  }

	for(i=1;i<2;i++)	  {
		for(j=0;j<8;j++)		{
			button[i][j].setIcon(iPawn_b);
			button[i][j].setText("B_PWN");
		}
	  }
	 for(i=6;i<7;i++)	  {
		for(j=0;j<8;j++)		{
			button[i][j].setIcon(iPawn_w);	
			button[i][j].setText("W_PWN");
			
		}
	  }
	for (i=0;i<8;i++){
		for(j=0;j<8;j++){
			if((i+j)%2==0)
						button[i][j].setBackground(Color.WHITE);
			else
						button[i][j].setBackground(Color.BLACK);
				
		}
	}
	  	
	  	
button[7][0].setIcon(iRook_w);	button[7][0].setText("W_ROK");
button[7][7].setIcon(iRook_w);	button[7][7].setText("W_ROK");
button[7][1].setIcon(iKnight_w);button[7][1].setText("W_KNT");
button[7][6].setIcon(iKnight_w);button[7][6].setText("W_KNT");
button[7][2].setIcon(iBishop_w);button[7][2].setText("W_BSP");
button[7][5].setIcon(iBishop_w);button[7][5].setText("W_BSP");
button[7][3].setIcon(iQueen_w); button[7][3].setText("W_QEN");
button[7][4].setIcon(iKing_w);  button[7][4].setText("W_KNG"); 


button[0][0].setIcon(iRook_b);	button[0][0].setText("B_ROK");
button[0][7].setIcon(iRook_b);  button[0][7].setText("B_ROK");
button[0][1].setIcon(iKnight_b);button[0][1].setText("B_KNT");
button[0][6].setIcon(iKnight_b);button[0][6].setText("B_KNT");
button[0][2].setIcon(iBishop_b);button[0][2].setText("B_BSP");
button[0][5].setIcon(iBishop_b);button[0][5].setText("B_BSP");
button[0][3].setIcon(iQueen_b); button[0][3].setText("B_QEN");
button[0][4].setIcon(iKing_b);  button[0][4].setText("B_KNG"); 

/*		 for(i=0;i<8;i++)  {
		for(j=0;j<8;j++)		{
			button[i][j].setToolTipText(" ");
		}
	  }
*/
	  for(i=0;i<8;i++)	  	  {
		for(j=0;j<8;j++)		{
			button[i][j].addActionListener(this);
		}
	  }

	
	setIconImage(Toolkit.getDefaultToolkit().getImage("cherry.jpg"));
	
		setVisible(true);
	}
	
	public void set_It(){
		set=true;
	}	

	public void unset_It(){
		set=false;
	}

	public void set_Source(ActionEvent E){
		
	Object source=E.getSource();
	for(i=0;i<8;i++){
		for(j=0;j<8;j++){
			if(source.equals(button[i][j])){
				row=i;col=j;
			}
		}
	}
	}

    public Color color_Of(int row_,int col_,int ch){
	
		String temp_name=button[row_][col_].getText();

	char first_Character=temp_name.charAt(0);
	if(first_Character=='B'){
		my_Color=Color.BLACK;
		opp_Color=Color.WHITE;
	
	}
	else if(first_Character=='W'){
		my_Color=Color.WHITE;
		opp_Color=Color.BLACK;
	}
	else{
			my_Color=Color.RED;
			opp_Color=Color.BLUE;
	}
//	button[row_][col_].setFocusable(true);

//	button[row_][col_].setBackground(my_Color);
	
	if (ch==1)
		return my_Color;
	else 
		return opp_Color;
			
}

	public void actionPerformed(ActionEvent E){
	
		
		set_Source(E);//sets row,col to the sourced button
		 my_Color_Pressed=color_Of(row,col,1);
		opp_Color_Pressed=color_Of(row,col,2);

	if(set){
		display_Move_B(E); 
	}
	else
		display_Move_W(E);	
}

	public void display_Move_W(ActionEvent E){

if(button[row][col].getBackground().equals(Color.PINK)){//killing
  	//	prev_Pressed.setIcon(button[rd][cd].getIcon());	prev_Pressed.setText(button[rd][cd].getText());
		button[row][col].setIcon(button[rs][cs].getIcon());		button[row][col].setText(button[rs][cs].getText());
		button[rs][cs].setIcon(null_Button.getIcon());			button[rs][cs].setText(null_Button.getText());
    	refresh_Move(); 
    		set_It();
    			is_check(E);	button[row][col].setToolTipText(" - click me - ");
}
else if(button[row][col].getBackground().equals(Color.GREEN)){
                                                          
	if(cast==3){
		button[row][col].setIcon(button[row][col+2].getIcon());		button[row][col].setText(button[row][col+2].getText());
		button[row][col+1].setIcon(button[row][col-2].getIcon());	button[row][col+1].setText(button[row][col-2].getText());
		button[row][col-2].setIcon(button[row][col-1].getIcon());	button[row][col-2].setText(button[row][col-1].getText());
		button[row][col+2].setIcon(button[row][col-1].getIcon());	button[row][col+2].setText(button[row][col-1].getText());
			button[row][col].setToolTipText(" - click me - ");
	}
  else if(cast==4){
		button[row][col].setIcon(button[row][col-2].getIcon());  button[row][col].setText(button[row][col-2].getText());//castle kng pos
		button[row][col-2].setIcon(button[row][col-1].getIcon());button[row][col-2].setText(button[row][col-1].getText());//refresh king
		button[row][col-1].setIcon(button[row][col+1].getIcon());button[row][col-1].setText(button[row][col+1].getText());//castle rook
		button[row][col+1].setIcon(button[row][col-2].getIcon());button[row][col+1].setText(button[row][col-2].getText());//refresh rook pos
			button[row][col].setToolTipText(" - click me - ");
	}	
		refresh_Move(); 
    		set_It();	
}
else 
		display_Move(E);
			
		
	
}

	public void display_Move_B(ActionEvent E){


if(button[row][col].getBackground().equals(Color.PINK)){//killing
  	//	prev_Pressed.setIcon(button[rd][cd].getIcon());	prev_Pressed.setText(button[rd][cd].getText());
		button[row][col].setIcon(button[rs][cs].getIcon());		button[row][col].setText(button[rs][cs].getText());
		button[rs][cs].setIcon(null_Button.getIcon());			button[rs][cs].setText(null_Button.getText());
    	refresh_Move(); 
    		unset_It();		is_check(E);
    			button[row][col].setToolTipText(" - click me - ");
}
else if(button[row][col].getBackground().equals(Color.GREEN)){

	if(cast==1){
		button[row][col].setIcon(button[row][col+2].getIcon());		button[row][col].setText(button[row][col+2].getText());
		button[row][col+1].setIcon(button[row][col-2].getIcon());	button[row][col+1].setText(button[row][col-2].getText());
		button[row][col-2].setIcon(button[row][col-1].getIcon());	button[row][col-2].setText(button[row][col-1].getText());
		button[row][col+2].setIcon(button[row][col-1].getIcon());	button[row][col+2].setText(button[row][col-1].getText());
			button[row][col].setToolTipText(" - click me - ");
	}
 else if(cast==2){
		button[row][col].setIcon(button[row][col-2].getIcon());  button[row][col].setText(button[row][col-2].getText());//castle kng pos
		button[row][col-2].setIcon(button[row][col-1].getIcon());button[row][col-2].setText(button[row][col-1].getText());//refresh king
		button[row][col-1].setIcon(button[row][col+1].getIcon());button[row][col-1].setText(button[row][col+1].getText());//castle rook
		button[row][col+1].setIcon(button[row][col-2].getIcon());button[row][col+1].setText(button[row][col-2].getText());//refresh rook pos
			button[row][col].setToolTipText(" - click me - ");
	}	
		refresh_Move(); 
    		unset_It();	
}
else 
		display_Move(E);		
		
			


	}
	
	public void display_Move(ActionEvent E){
	
									
	String name=E.getActionCommand();
	
	if((name.equals("B_ROK") && !set) || (name.equals("W_ROK") && set))	{
	  	refresh_Move(); 	counter=0;	display_Destiny_Rook();coin_name="ROOK";
	}
	else if((name.equals("B_KNT") && !set) || (name.equals("W_KNT")&& set))	{
	  	refresh_Move();	counter=0; 	display_Destiny_Knight();coin_name="KNIGHT";
	}
	else if((name.equals("B_BSP") && !set) || (name.equals("W_BSP") && set))	{
	  	refresh_Move(); 	counter=0;	display_Destiny_Bishop();coin_name="BISHOP";
	}
	else if((name.equals("B_KNG") && !set) || (name.equals("W_KNG") && set))	{
	  	refresh_Move(); 	counter=0;	display_Destiny_King();	coin_name="KING";
	}
	else if((name.equals("B_QEN") && !set) || (name.equals("W_QEN") && set))	{
	  	refresh_Move(); 	counter=0;	display_Destiny_Queen();coin_name="QUEEN";
	}
	else if((name.equals("B_PWN") && !set) || (name.equals("W_PWN") && set))	{
	  	refresh_Move(); 	counter=0;	display_Destiny_Pawn();coin_name="PAWN";
		}					
	else if(name.equals(" ")){//check here for background 
		display_Destiny();
			is_check(E);
	}
	else{	 	refresh_Move();
		if(set)
			JOptionPane.showMessageDialog(this,"--	ITS A WHITES TURN TO MOVE A COIN --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	
	  	else
		     	JOptionPane.showMessageDialog(this,"--	ITS A BLACKS TURN TO MOVE A COIN --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	
				setVisible(true);counter=10;
     }
   if(counter==0){
	 			JOptionPane.showMessageDialog(this,"-- THIS    " + coin_name + "   ---- "+"\n"+" DOESN'T HAVE ANY POSSIBLE DESTINATIONS ---- "+"\n" + "TO PROCEED A MOVE-- "," ----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
  	 			setVisible(true);
 		}

}

	public void display_Destiny_Pawn(){
 	
 	rs=row;cs=col;
  if(my_Color_Pressed==Color.BLACK )   {
  	
  	     if(color_Of(rs+1,cs,1).equals(Color.RED) && rs<7) //empty location 
 		  {	
 		  		button[rs+1][cs].setToolTipText(" - click me - ");
 		  	 button[rs+1][cs].setBackground(Color.YELLOW);counter++;}
 		  	 	
  		  if(rs==1 && color_Of(rs+1,cs,1).equals(Color.RED) && color_Of(rs+2,cs,1).equals(Color.RED))// EMPTY LOCATION 
		  {   	button[rs+2][cs].setToolTipText(" - click me - ");
		   button[rs+2][cs].setBackground(Color.YELLOW); counter++;}

   	  	  if(rs<7 && cs<7 && color_Of(rs+1,cs+1,2).equals(my_Color_Pressed) )//killing purpose ------- Color
   	  	  {		button[rs+1][cs+1].setToolTipText(" - click me - ");
   	  	  	 button[rs+1][cs+1].setBackground(Color.PINK); counter++;}	
  		  if(rs<7 && cs>0 && color_Of(rs+1,cs-1,2).equals(my_Color_Pressed) ) // killing purpose
  		  {	button[rs+1][cs-1].setToolTipText(" - click me - ");
  		  	 button[rs+1][cs-1].setBackground(Color.PINK);counter++;}
	 
   }
   
   else if(my_Color_Pressed==Color.WHITE)   {
  
 	 	  if(rs>0 && color_Of(rs-1,cs,1).equals(Color.RED))//empty location
 		  {	
 		  		button[rs-1][cs].setToolTipText(" - click me - ");
   	  	  		  	  button[rs-1][cs].setBackground(Color.YELLOW);counter++;}
				 
  		  if(rs==6 && color_Of(rs-1,cs,1).equals(Color.RED) && color_Of(rs-2,cs,1).equals(Color.RED))//empty location
  		  {	
  		  		button[rs-2][cs].setToolTipText(" - click me - ");
   	  	 	  button[rs-2][cs].setBackground(Color.YELLOW);counter++;}
 
  	
  		  if(rs>0 && cs<7 && color_Of(rs-1,cs+1,2).equals(my_Color_Pressed) )//kill move
  		  {  
  		  		button[rs-1][cs+1].setToolTipText(" - click me - ");
   	  	   	  button[rs-1][cs+1].setBackground(Color.PINK);counter++;}

  		  if(rs>0 && cs>0 && color_Of(rs-1,cs-1,2).equals(my_Color_Pressed) )//kill move
  		  {	 	button[rs-1][cs-1].setToolTipText(" - click me - ");
  		    button[rs-1][cs-1].setBackground(Color.PINK);counter++;}
 			     
  }




}//certified

	public void display_Destiny_Rook(){
  flag=1;	rs=row;cs=col;
  for(p=1;p<8;p++)
  {	  	  
		if(cs+p<8 && flag==1 && color_Of(rs,cs+p,2).equals(my_Color_Pressed))
		{	button[rs][cs+p].setBackground(Color.PINK);flag=0;counter++;
				button[rs][cs+p].setToolTipText(" - click me - ");
		}
		else if(cs+p<8 && flag==1 && color_Of(rs,cs+p,1).equals(Color.RED))
		{button[rs][cs+p].setBackground(Color.YELLOW);counter++;
			button[rs][cs+p].setToolTipText(" - click me - ");}
	    else 		break;
  }

    flag=1;
  for(p=1;p<8;p++)
  {	  
		if(cs-p>=0 && flag==1 && color_Of(rs,cs-p,2).equals(my_Color_Pressed))
		{	button[rs][cs-p].setToolTipText(" - click me - ");
			button[rs][cs-p].setBackground(Color.PINK);flag=0;counter++;}
		else if(cs-p>=0 && flag==1 && color_Of(rs,cs-p,1).equals(Color.RED))
		{button[rs][cs-p].setBackground(Color.YELLOW);counter++;
			button[rs][cs-p].setToolTipText(" - click me - ");
		}
	   else	  break;
  }
    flag=1;
  for(p=1;p<8;p++)
  {	  
	  
		if(rs-p>=0 && flag==1  && color_Of(rs-p,cs,2).equals(my_Color_Pressed))
		{	button[rs-p][cs].setToolTipText(" - click me - ");
			button[rs-p][cs].setBackground(Color.PINK);flag=0;counter++;}
		else if(rs-p>=0 && flag==1  && color_Of(rs-p,cs,1).equals(Color.RED))
		{	button[rs-p][cs].setBackground(Color.YELLOW);counter++;
			button[rs-p][cs].setToolTipText(" - click me - ");
		}
	   else	  break;
  }
  flag=1;
  for(p=1;p<8;p++)
  {	  
		if(rs+p<8 && flag==1 && color_Of(rs+p,cs,2).equals(my_Color_Pressed))
		{
		button[rs+p][cs].setToolTipText(" - click me - ");
		button[rs+p][cs].setBackground(Color.PINK);flag=0;counter++;}
		else if(rs+p<8 && flag==1 && color_Of(rs+p,cs,1).equals(Color.RED))
		{
		button[rs+p][cs].setToolTipText(" - click me - ");
		button[rs+p][cs].setBackground(Color.YELLOW);counter++;}
	    else  break;
  }	
	}//certified

	public void	display_Destiny_Knight(){
			rs=row;cs=col;
if(rs<6 && cs<7){
	if(color_Of(rs+2,cs+1,1).equals(Color.RED))
	{	
		button[rs+2][cs+1].setToolTipText(" - click me - ");
		button[rs+2][cs+1].setBackground(Color.YELLOW);  counter++; }
	else if(color_Of(rs+2,cs+1,2).equals(my_Color_Pressed))
	{	button[rs+2][cs+1].setToolTipText(" - click me - ");
	button[rs+2][cs+1].setBackground(Color.PINK);  counter++; }
}
		
if(rs<6 && cs>=1){
	if(color_Of(rs+2,cs-1,1).equals(Color.RED))
	{button[rs+2][cs-1].setToolTipText(" - click me - ");
		  button[rs+2][cs-1].setBackground(Color.YELLOW);    counter++;}
	else if(color_Of(rs+2,cs-1,2).equals(my_Color_Pressed))
	{
		button[rs+2][cs-1].setToolTipText(" - click me - ");
		 button[rs+2][cs-1].setBackground(Color.PINK);  counter++;  }
}

if(rs<7 && cs<6){
	 if(color_Of(rs+1,cs+2,1).equals(Color.RED))
	 {  button[rs+1][cs+2].setToolTipText(" - click me - ");
	 	 button[rs+1][cs+2].setBackground(Color.YELLOW); counter++;  }
	 else if(color_Of(rs+1,cs+2,2).equals(my_Color_Pressed))
	 {   button[rs+1][cs+2].setToolTipText(" - click me - ");
	 	 button[rs+1][cs+2].setBackground(Color.PINK);  counter++; }
}

if(rs<7 && cs>1){
	if(color_Of(rs+1,cs-2,1).equals(Color.RED))
	{	  button[rs+1][cs-2].setToolTipText(" - click me - ");
		 button[rs+1][cs-2].setBackground(Color.YELLOW); counter++; 
		} 
 	else if(color_Of(rs+1,cs-2,2).equals(my_Color_Pressed ))
 	{	  button[rs+1][cs-2].setToolTipText(" - click me - ");
 			 button[rs+1][cs-2].setBackground(Color.PINK); counter++;  }
}
	 	 	
if(rs>=1 && cs>=2){
	if(color_Of(rs-1,cs-2,1).equals(Color.RED))
	{   button[rs-1][cs-2].setBackground(Color.YELLOW);  counter++;
	button[rs-1][cs-2].setToolTipText(" - click me - ");
	}
 else if(color_Of(rs-1,cs-2,2).equals(my_Color_Pressed ))
 {  button[rs-1][cs-2].setBackground(Color.PINK);  counter++;
 	  button[rs-1][cs-2].setToolTipText(" - click me - ");}
}
	    	
if(rs>=1 && cs<6){
	if(color_Of(rs-1,cs+2,1).equals(Color.RED))
	{	button[rs-1][cs+2].setBackground(Color.YELLOW);  counter++;
	button[rs-1][cs+2].setToolTipText(" - click me - "); }
	else if(color_Of(rs-1,cs+2,2).equals(my_Color_Pressed ))
	{	button[rs-1][cs+2].setBackground(Color.PINK);  counter++; 
		button[rs-1][cs+2].setToolTipText(" - click me - "); }
}
				
if(rs>=2 && cs>=1){
	if(color_Of(rs-2,cs-1,1).equals(Color.RED))
	{	   button[rs-2][cs-1].setBackground(Color.YELLOW); counter++;
	button[rs-2][cs-1].setToolTipText(" - click me - "); 
	}
	else if(color_Of(rs-2,cs-1,2).equals(my_Color_Pressed ))
	{button[rs-2][cs-1].setToolTipText(" - click me - "); 
				button[rs-2][cs-1].setBackground(Color.PINK); counter++;}
}		
if(rs>=2 && cs<7){
	if(color_Of(rs-2,cs+1,1).equals(Color.RED))
	{   button[rs-2][cs+1].setBackground(Color.YELLOW);  counter++; 
		button[rs-2][cs+1].setToolTipText(" - click me - "); 
		}
	 else if(color_Of(rs-2,cs+1,2).equals(my_Color_Pressed ))
	 { button[rs-2][cs+1].setToolTipText(" - click me - "); 
	 	button[rs-2][cs+1].setBackground(Color.PINK);  counter++; }
}	   	
}//certified

	public void display_Destiny_Bishop(){
  flag=1;	rs=row;cs=col;
  for(p=1;p<8;p++)
  {	  	  
		if(rs+p<8 && cs+p<8 && flag==1 && color_Of(rs+p,cs+p,2).equals(my_Color_Pressed))
		{button[rs+p][cs+p].setToolTipText(" - click me - "); 
				button[rs+p][cs+p].setBackground(Color.PINK);flag=0; counter++;}
		else if(rs+p<8 && cs+p<8 && flag==1 && color_Of(rs+p,cs+p,1).equals(Color.RED))
		{button[rs+p][cs+p].setToolTipText(" - click me - ");
			button[rs+p][cs+p].setBackground(Color.YELLOW); counter++;}
	    else 		break;
  }

    flag=1;
  for(p=1;p<8;p++)
  {	  
		if(rs-p>=0 && cs-p>=0 && flag==1 && color_Of(rs-p,cs-p,2).equals(my_Color_Pressed))
		{
			button[rs-p][cs-p].setToolTipText(" - click me - ");
			button[rs-p][cs-p].setBackground(Color.PINK);flag=0; counter++;}
		else if(rs-p>=0 && cs-p>=0 && flag==1 && color_Of(rs-p,cs-p,1).equals(Color.RED))
		{button[rs-p][cs-p].setToolTipText(" - click me - ");
		 button[rs-p][cs-p].setBackground(Color.YELLOW); counter++;}
	   else	  break;
  }
    flag=1;
  for(p=1;p<8;p++)
  {	  
	  
		if(rs-p>=0 && cs+p<8 && flag==1  && color_Of(rs-p,cs+p,2).equals(my_Color_Pressed))
		{
				button[rs-p][cs+p].setToolTipText(" - click me - ");
				button[rs-p][cs+p].setBackground(Color.PINK);flag=0; counter++;}
		else if(rs-p>=0 && cs+p<8 && flag==1  && color_Of(rs-p,cs+p,1).equals(Color.RED))
		{
			button[rs-p][cs+p].setToolTipText(" - click me - ");
			button[rs-p][cs+p].setBackground(Color.YELLOW); counter++;}
	   else	  break;
  }
  flag=1;
  for(p=1;p<8;p++)
  {	  
		if(rs+p<8 && cs-p>=0 && flag==1 && color_Of(rs+p,cs-p,2).equals(my_Color_Pressed))
		{
			button[rs+p][cs-p].setToolTipText(" - click me - ");
			button[rs+p][cs-p].setBackground(Color.PINK);flag=0; counter++;}
		else if(rs+p<8 && cs-p>=0 && flag==1 && color_Of(rs+p,cs-p,1).equals(Color.RED))
		{
		button[rs+p][cs-p].setToolTipText(" - click me - ");
		button[rs+p][cs-p].setBackground(Color.YELLOW); counter++;}
	    else  break;
  }	
	}//certified

	public void display_Destiny_Queen(){
	display_Destiny_Bishop();
	display_Destiny_Rook();
	}//certified

	public void display_Destiny_King(){
		rs=row;cs=col;
 
  castling_Move();//sets cast if there is a chance of castling 
  
   	
   if(rs>0 && cs>0 ){
	   	if(color_Of(rs-1,cs-1,1).equals(Color.RED))
	   	{		button[rs-1][cs-1].setToolTipText(" - click me - ");
   	  	 
	   		 button[rs-1][cs-1].setBackground(Color.YELLOW);counter++;}
 	   else if(color_Of(rs-1,cs-1,2).equals(my_Color_Pressed))
 	   {	button[rs-1][cs-1].setToolTipText(" - click me - ");
 	   	button[rs-1][cs-1].setBackground(Color.PINK);counter++;}
  	   
   }
 if(rs>0){
    	if(color_Of(rs-1,cs,1).equals(Color.RED))
    	{	button[rs-1][cs].setToolTipText(" - click me - ");
    		button[rs-1][cs].setBackground(Color.YELLOW);counter++;}
		else  if(color_Of(rs-1,cs,2).equals(my_Color_Pressed))
		{	button[rs-1][cs].setToolTipText(" - click me - ");
				button[rs-1][cs].setBackground(Color.PINK);counter++;}
		
   }
   
if(rs>0 && cs<7){
 		if(color_Of(rs-1,cs+1,1).equals(Color.RED))
 		{	button[rs-1][cs+1].setToolTipText(" - click me - ");
 			button[rs-1][cs+1].setBackground(Color.YELLOW);counter++;}
	 	else if( color_Of(rs-1,cs+1,2).equals(my_Color_Pressed))
	 	{	button[rs-1][cs+1].setToolTipText(" - click me - ");
	 		button[rs-1][cs+1].setBackground(Color.PINK);counter++;}
		
  }
 
if(cs<7){
 	if(color_Of(rs,cs+1,1).equals(Color.RED)) 	
 	{	button[rs][cs+1].setToolTipText(" - click me - ");
 		button[rs][cs+1].setBackground(Color.YELLOW);counter++;}
    else if(color_Of(rs,cs+1,2).equals(my_Color_Pressed))
    {	button[rs][cs+1].setToolTipText(" - click me - ");
    	button[rs][cs+1].setBackground(Color.PINK);counter++;}
 
 }
 
if(rs<7 && cs<7){
 	if(color_Of(rs+1,cs+1,1).equals(Color.RED))
 	{	button[rs+1][cs+1].setToolTipText(" - click me - ");
 		button[rs+1][cs+1].setBackground(Color.YELLOW);counter++;}
    else if(color_Of(rs+1,cs+1,2).equals(my_Color_Pressed))
    {	button[rs+1][cs+1].setToolTipText(" - click me - ");
    	button[rs+1][cs+1].setBackground(Color.PINK);counter++;}
 }

if(rs<7){
 	if(color_Of(rs+1,cs,1).equals(Color.RED))
 	{	button[rs+1][cs].setToolTipText(" - click me - ");
 			button[rs+1][cs].setBackground(Color.YELLOW);counter++;}
 else if(color_Of(rs+1,cs,2).equals(my_Color_Pressed))
 {
 	button[rs+1][cs].setToolTipText(" - click me - ");
  	button[rs+1][cs].setBackground(Color.PINK);counter++;}
 
 }
if(rs<7 && cs>0){
  	if(color_Of(rs+1,cs-1,1).equals(Color.RED))
  	{
  			button[rs+1][cs-1].setToolTipText(" - click me - ");
  			button[rs+1][cs-1].setBackground(Color.YELLOW);counter++;}
	else if(color_Of(rs+1,cs-1,2).equals(my_Color_Pressed))
	{	button[rs+1][cs-1].setToolTipText(" - click me - ");

	button[rs+1][cs-1].setBackground(Color.PINK);counter++;}
   
 }
if(cs>0){
 	if(color_Of(rs,cs-1,1).equals(Color.RED))
 	{		button[rs][cs-1].setToolTipText(" - click me - ");
			button[rs][cs-1].setBackground(Color.YELLOW);counter++;}
 	else if(color_Of(rs,cs-1,2).equals(my_Color_Pressed))
 	{	button[rs][cs-1].setToolTipText(" - click me - ");
		button[rs][cs-1].setBackground(Color.PINK);counter++;}

 	}
 }//certified	

	public void refresh_Move(){

	for (int ii=0;ii<8;ii++){
		for(int jj=0;jj<8;jj++){
			if((ii+jj)%2==0)
						button[ii][jj].setBackground(Color.WHITE);
			else
						button[ii][jj].setBackground(Color.BLACK);
				
		}
	}
	
		is_Game_Over();

	if(!WHITE_WIN)
	{
		JOptionPane.showMessageDialog(this,"---  BLACKS WON THE GAME","----	MSG	  ---",JOptionPane.INFORMATION_MESSAGE);
	setVisible(false);
	
	}
	if(!BLACK_WIN){
				JOptionPane.showMessageDialog(this,"--- WHITES WON THE GAME","----	MSG	  ---",JOptionPane.INFORMATION_MESSAGE);
	setVisible(false);
	}

}//certified

	public void display_Destiny(){
		rd=row;cd=col;	
		//validity_Move();
		start_Move();
		refresh_Move();
  }  

    public void start_Move(){

   if(button[rd][cd].getBackground().equals(Color.YELLOW)){//move
  	//	prev_Pressed.setIcon(button[rd][cd].getIcon());	prev_Pressed.setText(button[rd][cd].getText());
		button[rd][cd].setIcon(button[rs][cs].getIcon());		button[rd][cd].setText(button[rs][cs].getText());
		button[rs][cs].setIcon(null_Button.getIcon());			button[rs][cs].setText(null_Button.getText());
		
	
		if(set)	
				unset_It();
		else
				set_It();
		
   
   }
   else if(button[rd][cd].getBackground().equals(Color.WHITE) || button[rd][cd].getBackground().equals(Color.BLACK)){//invalid move
    	refresh_Move();
     JOptionPane.showMessageDialog(this,"--	BE INTELLIGENT TO CLICK A COIN "+"\n"+"TO PROCEED A MOVE --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);counter=10;
   }
   
   	
  // else	break;
 
  
  }

  	public void castling_Move(){			 //---------------	castling
  	
  
if(cs-4>=0){

 if(button[rs][cs].getText().equals("B_KNG") && button[rs][cs-4].getText().equals("B_ROK") ) {
 	
    if(button[rs][cs-1].getText().equals(" ") && button[rs][cs-2].getText().equals(" ") && button[rs][cs-3].getText().equals(" "))   {
    	
       cast=3;	 button[rs][cs-2].setBackground(Color.GREEN);counter++;
    
   }
 }
}	
if(cs+3<=7){
  
 if(button[rs][cs].getText().equals("B_KNG") && button[rs][cs+3].getText().equals("B_ROK") ) {
 	
    if(button[rs][cs+1].getText().equals(" ") && button[rs][cs+2].getText().equals(" ")){
    
       cast=4;  button[rs][cs+2].setBackground(Color.GREEN);counter++;
  
   }
 }  
 	
}
if(cs-4>=0){

 if(button[rs][cs].getText().equals("W_KNG") && button[rs][cs-4].getText().equals("W_ROK") ) {
 	
    if(button[rs][cs-1].getText().equals(" ") && button[rs][cs-2].getText().equals(" ") && button[rs][cs-3].getText().equals(" "))   {
    	
       cast=1;	 button[rs][cs-2].setBackground(Color.GREEN);counter++;
    
   }
 }
}	
if(cs+3<=7){
  
 if(button[rs][cs].getText().equals("W_KNG") && button[rs][cs+3].getText().equals("W_ROK") ) {
 	
    if(button[rs][cs+1].getText().equals(" ") && button[rs][cs+2].getText().equals(" ")){
    
       cast=2;  button[rs][cs+2].setBackground(Color.GREEN);counter++;
  
   }
 }  
 	
}
  	}//certified
  	
  	public void is_Game_Over(){
  	
  	
  	for(i=0;i<8;i++){
  	  		for(j=0;j<8;j++){
  	  		
  	  			if(button[i][j].getText().equals("W_KNG"))
  	  			{	WHITE_WIN=true;i=8;j=8;
  	  			}
  	  			else	WHITE_WIN=false;
  	  			
  	  		}
  	}			
  	  		
  	for(i=0;i<8;i++){
  	  		for(j=0;j<8;j++){
  	  		
  	  			if(button[i][j].getText().equals("B_KNG"))
  	  			{	BLACK_WIN=true;i=8;j=8;
  	  			}
  	  			else	BLACK_WIN=false;
 	  			
  	  		}
  	}			
  	  	  	

  }

	public void is_check(ActionEvent ae){
	//	String text=ae.getActionCommand();
		if(set){//blacks move
		for(i=0;i<8;i++){
			for(j=0;j<8;j++){
				if(button[i][j].getText().equals("W_KNG")){
					row=i;col=j;
				//		button[row][col].setBackground(Color.red);
					
					i=8;
					j=8;//breaking out of loop
				}
			}
		}
			
		}
		else{//whites move
			for(i=0;i<8;i++){
				for(j=0;j<8;j++){
					if(button[i][j].getText().equals("B_KNG")){
						row=i;col=j;
					//	button[row][col].setBackground(Color.red);
							
						i=8;
						j=8;//breaking out of loop
					}
				 }
		    }
			
			
		}
threat_From_Opp_Camp();	
	}
		
	boolean is_threat(int rp,int cp,String str){
		
		if(set){//blacks move
				if((button[rp][cp].getText().compareTo("B_"+str))==0 )
					return true;
		}
		else{//
				if((button[rp][cp].getText().compareTo("W_"+str))==0)
					return true;
		}
					return false;
					
	
	}
	
	public void threat_From_Opp_Camp(){
		rs=row;cs=col;
		
		threat_King("KNG");
		threat_Queen("QEN");
    	threat_Rook("ROK");
    	threat_Bishop("BSP");
		threat_Knight("KNT");
		threat_Pawn("PWN");	
}

	public void threat_Queen(String name){

	threat_Bishop(name);
	threat_Rook(name);
}

	public void threat_Rook(String name){
		
  flag=1;
  int p=0;
  for(p=1;p<8;p++)
  {	  	  
		if( cs+p<8 && flag==1) {
		
			if(is_threat(rs,cs+p,name))
	    	{
	    		button[rs][cs+p].setBackground(Color.RED);flag=0;	button[rs][cs].setBackground(Color.BLUE);
		    	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
				setVisible(true);p=8;
		    }
		    else if((color_Of(row,col,1)==color_Of(rs,cs+p,1)) || (color_Of(row,col,1)==color_Of(rs,cs+p,2))){
		    	flag=0;p=8;
		    }
	  }
  }

    flag=1;	
  for(p=1;p<8;p++)
  {	  

		if(cs-p>=0 && flag==1) {
		
			if(is_threat(rs,cs-p,name))
	    	{
	    		button[rs][cs-p].setBackground(Color.RED);flag=0;	button[rs][cs].setBackground(Color.BLUE);
		    	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
				setVisible(true);	p=8;
		    }
		    else if((color_Of(row,col,1)==color_Of(rs,cs-p,1)) || (color_Of(row,col,1)==color_Of(rs,cs-p,2)) ){
		    	flag=0;p=8;
		    }
	  }
	
	
	
  }
    flag=1;
  for(p=1;p<8;p++)
  {	  
	  	if(rs-p>=0 && flag==1) {
		
			if(is_threat(rs-p,cs,name))
	    	{
	    		button[rs-p][cs].setBackground(Color.RED);flag=0;	button[rs][cs].setBackground(Color.BLUE);
		    	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
				setVisible(true);	p=8;
		    }
		    else if((color_Of(row,col,1)==color_Of(rs-p,cs,1)) || (color_Of(row,col,1)==color_Of(rs-p,cs,2)) ){
		    	flag=0;p=8;
		    }
	  }
	
  }
  flag=1;
  for(p=1;p<8;p++)
  {	  
		if(rs+p<8 && flag==1) {
		
			if(is_threat(rs+p,cs,name))
	    	{
	    		button[rs+p][cs].setBackground(Color.RED);flag=0;	button[rs][cs].setBackground(Color.BLUE);
		    	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
				setVisible(true);	p=8;
		    }
		    else if((color_Of(row,col,1)==color_Of(rs+p,cs,1)) || (color_Of(row,col,1)==color_Of(rs+p,cs,2)) ){
		    	flag=0;p=8;
		    }
	  }
	
		
		
  }	
  	
}
	
	public void threat_Bishop(String name){

  flag=1;

  for(p=1;p<8;p++)
  {	  	  
		if(rs+p<8 && cs+p<8 && flag==1) {
		
			if(is_threat(rs+p,cs+p,name))
	    	{
	    		button[rs+p][cs+p].setBackground(Color.RED);flag=0;	button[rs][cs].setBackground(Color.BLUE);
		    	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
				setVisible(true);p=8;
		    }
		    else if((color_Of(row,col,1)==color_Of(rs+p,cs+p,1)) || (color_Of(row,col,1)==color_Of(rs+p,cs+p,2))){
		    	flag=0;p=8;
		    }
	  }
  }

    flag=1;
  for(p=1;p<8;p++)
  {	  

		if(rs-p>=0 && cs-p>=0 && flag==1) {
		
			if(is_threat(rs-p,cs-p,name))
	    	{
	    		button[rs-p][cs-p].setBackground(Color.RED);flag=0;	button[rs][cs].setBackground(Color.BLUE);
		    	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
				setVisible(true);	p=8;
		    }
		    else if((color_Of(row,col,1)==color_Of(rs-p,cs-p,1)) || (color_Of(row,col,1)==color_Of(rs-p,cs-p,2))){
		    	flag=0;p=8;
		    }
	  }
	
	
	
  }
    flag=1;
  for(p=1;p<8;p++)
  {	  
	  	if(rs-p>=0 && cs+p<8 && flag==1) {
		
			if(is_threat(rs-p,cs+p,name))
	    	{
	    		button[rs-p][cs+p].setBackground(Color.RED);flag=0;	button[rs][cs].setBackground(Color.BLUE);
		    	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
				setVisible(true);	p=8;
		    }
		    else if((color_Of(row,col,1)==color_Of(rs-p,cs+p,1)) || (color_Of(row,col,1)==color_Of(rs-p,cs+p,2))){
		    	flag=0;p=8;
		    }
	  }
	
  }
  flag=1;
  for(p=1;p<8;p++)
  {	  
		if(rs+p<8 && cs-p>=0 && flag==1) {
		
			if(is_threat(rs+p,cs-p,name))
	    	{
	    		button[rs+p][cs-p].setBackground(Color.RED);flag=0;	button[rs][cs].setBackground(Color.BLUE);
		    	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
				setVisible(true);	p=8;
		    }
		    else if((color_Of(row,col,1)==color_Of(rs+p,cs-p,1)) || (color_Of(row,col,1)==color_Of(rs+p,cs-p,2)) ){
		    	flag=0;p=8;
		    }
	  }
	
		
		
  }	
	
}

	public void threat_Knight(String name){
	
if(rs<6 && cs<7){
if(is_threat(rs+2,cs+1,name))
	{ 
	button[rs+2][cs+1].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);
	}
}
		
if(rs<6 && cs>=1){
	if(is_threat(rs+2,cs-1,name))
	{ 
	button[rs+2][cs-1].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);
	}
}

if(rs<7 && cs<6){
	if(is_threat(rs+1,cs+2,name))
	{ 
	button[rs+1][cs+2].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);
	}
}

if(rs<7 && cs>1){
	if(is_threat(rs+1,cs-2,name))
	{ 
	button[rs+1][cs-2].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);
	}
}
	 	 	
if(rs>=1 && cs>=2){
	if(is_threat(rs-1,cs-2,name))
	{ 
	button[rs-1][cs-2].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);
	}
}
	    	
if(rs>=1 && cs<6){
	if(is_threat(rs-1,cs+2,name))
	{ 
	button[rs-1][cs+2].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);
	}
}
				
if(rs>=2 && cs>=1){
	if(is_threat(rs-2,cs-1,name))
	{ 
	button[rs-2][cs-1].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);
	}
}		
if(rs>=2 && cs<7){
	if(is_threat(rs-2,cs+1,name))
	{ 
	button[rs-2][cs+1].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);
	}
}	   	
	
}

	public void threat_Pawn(String name){
		if(rs+1<8 && !set ){
			if(cs+1<8 && is_threat(rs+1,cs+1,name))
	    	{
	    		button[rs+1][cs+1].setBackground(Color.RED);
	    		button[rs][cs].setBackground(Color.BLUE);
		    	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
				setVisible(true);
		    } 
			if(cs-1>=0 && is_threat(rs+1,cs-1,name))
	    	{
	    		button[rs+1][cs-1].setBackground(Color.RED);
	    		button[rs][cs].setBackground(Color.BLUE);
		    	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
				setVisible(true);
		    }		   
	  } 		    
	 else if(rs-1>=0 && set){
	 		if(cs-1>=0 && is_threat(rs-1,cs-1,name))
	    	{
	    		button[rs-1][cs-1].setBackground(Color.RED);
	    		button[rs][cs].setBackground(Color.BLUE);
		    	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
				setVisible(true);
		    }		
			if(cs+1<8 && is_threat(rs-1,cs+1,name))
	    	{
	    		button[rs-1][cs+1].setBackground(Color.RED);
	    		button[rs][cs].setBackground(Color.BLUE);
		    	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
				setVisible(true);
		    }
	 }
}
	public void threat_King(String name){
if(rs>0 && cs>0 ){
	   if(is_threat(rs-1,cs-1,name))
 	   {
 	button[rs-1][cs-1].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);
	}
}
if(rs>0){
       if(is_threat(rs-1,cs,name))
		{
				button[rs-1][cs].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);
		}
}
if(rs>0 && cs<7){
 		if(is_threat(rs-1,cs+1,name))
	 	{
	 	button[rs-1][cs+1].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);
		}
} 
if(cs<7){
     if(is_threat(rs,cs+1,name))
    {
    		button[rs][cs+1].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);
    	}
} 
if(rs<7 && cs<7){
 	if(is_threat(rs+1,cs+1,name))
    {
    button[rs+1][cs+1].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);	
	}
}
if(rs<7){
 if(is_threat(rs+1,cs,name))
 {
 	button[rs+1][cs].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);
 }
 
}
if(rs<7 && cs>0){
    if(is_threat(rs+1,cs-1,name))
	{
		button[rs+1][cs-1].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);
	}
   
 }
if(cs>0){
 	if(is_threat(rs,cs-1,name))
 	{
 	button[rs][cs-1].setBackground(Color.RED);
	button[rs][cs].setBackground(Color.BLUE);
	JOptionPane.showMessageDialog(this,"--	CHECK --","----	WARNING MESSAGE	  ---",JOptionPane.WARNING_MESSAGE);
	setVisible(true);	
 	}

 }
 
}

	public static void main(String args[]){

	Game CHESS=new Game();

	}

}
