//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    class Pair{
    int a;
    int b;
    Pair(int a,int b){
      this.a = a;
      this.b = b;
    }
  }  
  Stack<Pair> s = new Stack<>();
  void push(int n){
    int min;
    if(s.isEmpty()){
      min = n;
    }else{
      min = Math.min(n,s.peek().b);
    }
    s.push(new Pair(n,min));
  }

  int pop(){
    if(s.isEmpty()) return -1;
    int data = s.peek().a;  
    s.pop();
    return data;
  }

  int top(){
          if(s.isEmpty()) return -1;

    return s.peek().a;
  }

  int getMin(){
          if(s.isEmpty()) return -1;

    return s.peek().b;
  }
}

