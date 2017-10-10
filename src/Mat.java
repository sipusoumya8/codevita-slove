import java.util.*;
public class Mat {
static int n;
static int matrix[][];
static int lstmatrix[][];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=Integer.parseInt(sc.nextLine());
		matrix=new int[n][n];
		lstmatrix=new int[n][n];
		String in=sc.nextLine();
		char arr1[]=in.toCharArray();
		String arr2[]=new String [n];
		boolean b=true;
		if(arr1[0]=='{'&& arr1[arr1.length-1]=='}'){
			StringBuffer insb=new StringBuffer(in);
			in=insb.substring(1,arr1.length-1);
			String splitcoma[]=in.split(",");
			if(splitcoma.length==n){
				for(int i=0;i<splitcoma.length;i++){
					arr2=splitcoma[i].split("#");
					if(arr2.length==n){
						for(int j=0;j<arr2.length;j++){
							matrix[i][j]=Integer.parseInt(arr2[j]);
						}
					}
					else b=false;
				}
				if(b){
					///////////////////////////////////////////////////////////
					for(int i=0;i<n;i++){
						for(int j=0;j<n;j++){
							int lst=findleast(matrix,i,j);
							lstmatrix[i][j]=lst;
						}
					}
					/////////////////////////////////////////////////////////
					int h=lstmatrix[0][0];
					for (int row = 1; row < n; row++){ //find highest value
					      for (int col = 1; col < n; col++){
					        if (lstmatrix[row][col] > h){
					         h = lstmatrix[row][col]; 
					        }
					      }
					}
					      System.out.print("{");
					      String sk="";
					for(int i=0;i<n;i++){
						for(int j=0;j<n;j++){
							if(lstmatrix[i][j]==h){
								sk=sk+(i+1)+"#"+(j+1)+',';
							}
						}
					}
					
					StringBuffer inslb=new StringBuffer(sk);
					sk=inslb.substring(0,sk.length()-1);
					System.out.print(sk+"}");
				
			}
			
			}}
	}
	
	public static int findleast(int[][] m,int i,int j) {
		int temp=matrix[i][j];
                for (int i1 = Math.max(0, i -1); i1 < Math.min(n, i + 2); i1++) {
                    for (int j1 = Math.max(0, j -1); j1 < Math.min(n, j + 2); j1++) {
                        if (i1 != i || j1 != j)
                        {	
                        	if(temp>m[i1][j1]){
                        		temp=m[i1][j1];
                        	}
                        }
                    }
                }
                return temp;
	}

}
