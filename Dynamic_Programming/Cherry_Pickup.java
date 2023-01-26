package Dynamic_Programming;

public class Cherry_Pickup {
    public int solve(int i,int j1,int j2, int grid[][], int n,int m){
        if(j1<0 || j1>=m || j2<0 || j2>=m || i>=n){
            return (int)(-1e8);
        }
        if(i==n-1){
            if(j1==j2){
                return grid[i][j1]; // for common
            }else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        int maxi=(int) (-1e8);
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                int value=0;
                if(j1==j2) value=grid[i][j1];
                else value=grid[i][j1]+grid[i][j2];
                value+=solve(i+1,j1+dj1,j2+dj2,grid,n,m);
                maxi=Math.max(maxi,value);
            }
        }
        return maxi;
    }

    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        return solve(0,0,m-1,grid,n,m);
    }
}
