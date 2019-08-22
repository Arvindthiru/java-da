/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate,i;
        candidate = 0;
        for(i=1;i<n;i++)
        {
            if(knows(candidate,i))
            {
                candidate = i;
            }
        }
        i=0;
        while(i<n)
        {
            if(i==candidate)
            {
                i++;
                continue;
            }
            if(knows(i,candidate) == true && knows(candidate,i) == false){
                i++;
            }
            else
            {
                candidate = -1;
                break;
            }
        }
        return candidate;
    }
}
