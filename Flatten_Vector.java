class Vector2D {
    int pos,index;
    int [][] v;
    public Vector2D(int[][] arr) {
        int i,j;
        pos = 0;
        index = 0;
        v = new int[arr.length][];
        for(i=0;i<arr.length;i++)
        {
            v[i] = new int[arr[i].length];
            for(j=0;j<arr[i].length;j++)
            {
                v[i][j] = arr[i][j];
            }
        }
    }
    
    public int next() {
        int result=-1;
        while(pos<v.length)
        {
            if(index<v[pos].length)
            {
                result = v[pos][index];
                index++;
                break;
            }
            else
            {
                pos++;
                index = 0;
            }
        }
        return result;
    }
    
    public boolean hasNext() {
        while(pos<v.length)
        {
            if(pos<v.length && index<v[pos].length)
            {
                return true;
            }
            else
            {
                pos++;
                index = 0;
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
