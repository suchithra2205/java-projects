package projecttutorial;
import java.util.Random;
import java.util.Scanner;
class tictoc{
	static char [][] board;
	public tictoc() 
	{
		board=new char[3][3];
		initboard();
	}
	void initboard()
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j] = ' ';
			
			}
		}
			
	}
	 static void displayboard()
	{
		System.out.println("------------");
		for(int i=0;i<board.length;i++)
		{
			System.out.print('|');
			for(int j=0;j<board[i].length;j++)
			
			{
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			
			System.out.println("------------");
		}
	}
	static void insert(int row ,int col,char mark)
	{
		if(row>=0&& row<=2 && col>=0&& col<=2)
		{
		board[row][col]=mark;
	}
		else
		{
			System.out.println("not valid index");
		}
}
	static boolean checkcolwin()
	{
		for(int j=0;j<board.length;j++)
		{
			if( board[0][j]!=' '&& board[0][j]==board[1][j]&&board[1][j]==board[2][j])
			{
				return true;
			}
	
		}
		return false;
	}
	 static boolean checkrowwin()
	{
		for(int i=0;i<board.length;i++)
		{
			if( board[i][0]!=' '&&board[i][0]==board[i][1]&&board[i][1]==board[i][2])
			{
				return true;
			}
	
		}
		return false;
		
	}
	 static boolean checkdiagonalwin()
	{
		if( board[0][0]!=' '&&board[0][0]==board[1][1]&& board[1][1]==board[2][2]|| 
				board[0][2]!=' '&&board[0][2]==board[1][1]&& board[1][1]==board[2][0])
		{
			return true;
		}
		return false;
	}
	static boolean checkdraw() {
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				if(board[i][j]==' ')
				{
					return false;
				}
			
			}
		}return true;
	}
	   
}
abstract class player{
	String name;
	char mark;
	 abstract void makemove();
	 boolean isvalid(int row,int col)
		{
			if(row>=0&&row<=2 &&col>=0 &&col<=2)
			{
				if(tictoc.board[row][col]==' ')
				{
					return true;
					
				}
			}
			return false;
		}
}
class humanplayer extends player{
	
	humanplayer(String name,char mark)
	{
	this.name=name;
	this.mark=mark;
	}
	void makemove()
	{
	Scanner sc=new Scanner(System.in);
	int row;
	int col ;
	do {
	System.out.println("enter row and column");
	row=sc.nextInt();
	col=sc.nextInt();
	}while(!isvalid(row,col));
	
	tictoc.insert(row,col,mark);
	}
	
	
		
	}
class AIplayer extends player{
	
	AIplayer(String name,char mark)
	{
	this.name=name;
	this.mark=mark;
	}
	void makemove()
	{
		Scanner sc=new Scanner(System.in);
		int row;
		int col;
	do {	
	Random r=new Random();
     row=r.nextInt(3);
	 col =r.nextInt(3);
	}while(!isvalid(row,col));
	
	tictoc.insert(row,col,mark);
	}
	
	
	}

class tictoctoegame {
	
    
    
	public static void main(String[] args) {
		new tictoc();
	  humanplayer  p1=new humanplayer("bob",'X');
	   AIplayer p2=new  AIplayer("AIs",'O');
	   player cp;
	   cp=p1;
	   while(true) {
	   System.out.println(cp.name+"turn");
	   cp.makemove();
	   tictoc.displayboard();
	   if(tictoc.checkcolwin()||tictoc.checkrowwin()||tictoc.checkdiagonalwin())
	   {
		   System.out.println(cp.name+"won");
		   break;
	   }
	   else  if(tictoc.checkdraw())
	   {
		   System.out.println("it's a draw");
		   break;
	   }
	   else
	   {
		   if(cp==p1)
		   {
			   cp=p2;
		   }
		   else {
			   cp=p1;
		   }
		
	   }
	   
	

	}

}}
