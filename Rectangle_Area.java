class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int lx,ly,rx,ry,intersectionArea,area1,area2;
        lx = Math.max(A,E);
        ly = Math.max(B,F);
        rx = Math.min(C,G);
        ry = Math.min(D,H);
        area1 = (C-A)*(D-B);
        area2 = (G-E)*(H-F);
        if(lx>=rx || ly>=ry)
        {
            return area1+area2;
        }
        intersectionArea = (rx-lx) * (ry-ly);
        return area1+area2-intersectionArea;
    }
}
