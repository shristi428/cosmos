
public class Knight_tour {
	static int N=8;
	
	static boolean isSafe(int x,int y, int sol[][]) 
	{
		return(x>=0&&x<N&&y>=0&&y<N&&sol[x][y]==-1);
	}

	static void printSolution(int sol[][])
	{
		
		for(int x=0;x<N;x++) {
			for(int y=0;y<N;y++)
				System.out.print(sol[x][y]+" ");
			System.out.println();
		}
	}
	
	
	
	static boolean solveKT()
	{
		
		int sol[][]=new int[8][8];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				sol[i][j]=-1;
		}
		
		
		int xMove[]= {2,1,-1,-2,-2,-1,-1,2};
		int yMove[]= {1,2,2,1,-1,-2,-2,-1};
		
		
		
		sol[0][0]=0;
		
		if(!solveKTUtil(0,0,1,sol,xMove,yMove))
			return false;
		else
			printSolution(sol);
		return true;		
		}
	
	static boolean solveKTUtil(int x, int y, int movei,int[][] sol,int[] xMove,int[] yMove) {
		int k,x_next,y_next;
		
		if(movei==N*N)
			return true;
		
		for(k=0;k<8;k++) {
		  x_next=x+xMove[k];
		  y_next=y+yMove[k];
		  
		  if(isSafe(x_next,y_next,sol))
		  { sol[x_next][y_next]=movei;
		  
		  if(solveKTUtil(x_next,y_next,movei+1,sol,xMove,yMove))
			  return true;
		  else
			  sol[x_next][y_next]=-1;
		  
		}
		  }
		return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
              solveKT();
		
		
		
	}
	
	

}
