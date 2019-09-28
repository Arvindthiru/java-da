import java.util.*;

class Coordinate {
  int i;
  int j;

  Coordinate(int i, int j) {
    this.i = i;
    this.j = j;
  }
}

class Main{
  public static int treasureIsland(char[][] island)
  {
    int i,j,k,m,n,levelcount,levelsize,nextlevelsize=0;
    i = 0;
    j = 0;
    m = island.length;
    n = island[0].length;
    Queue<Coordinate> bfs = new LinkedList<>();
    bfs.add(new Coordinate(i,j));
    Coordinate temp;
    levelsize = 1;
    levelcount = 0;
    while(bfs.isEmpty()==false)
    {
      for(k=0;k<levelsize;k++)
      {
        temp = bfs.poll();
        i = temp.i;
        j = temp.j;
        if(island[i][j] == 'X')
        {
          return levelcount;
        }
        island[i][j] = 'D';
        if(j+1<n && island[i][j+1]!='D')
        {
          bfs.add(new Coordinate(i,j+1));
          nextlevelsize++;

        }
        if(i+1<m && island[i+1][j]!='D')
        {
          bfs.add(new Coordinate(i+1,j));
          nextlevelsize++;
        }
        if(j-1>=0 && island[i][j-1]!='D')
        {
          bfs.add(new Coordinate(i,j-1));
          nextlevelsize++;
        }
        if(i-1>=0 && island[i-1][j]!='D')
        {
          bfs.add(new Coordinate(i-1,j));
          nextlevelsize++;
        }
      }
      levelsize = nextlevelsize;
      nextlevelsize = 0;
      levelcount++;
    }
    return -1;
  }
  public static void main(String[] args) {
    
    char[][] island = new char[][]{
        {'O', 'O', 'O', 'X'},
    };
    int result = treasureIsland(island);
    System.out.println(result);
  }
}
