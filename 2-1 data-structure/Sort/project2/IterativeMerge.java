package project2;

public class IterativeMerge {
	
    private static void merge(Comparable[] in, Comparable[] out, int low, int mid, int high) 
    {
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) out[k] = in[j++];
            else if (j > high) out[k] = in[i++];
            else if (isLess(in[j], in[i])) out[k] = in[j++];
            else out[k] = in[i++];
        }
    }

    public static void sort(Comparable[] a)
    {
        Comparable[] src = a, dst = new Comparable[a.length], tmp;
        int N = a.length;
        for(int n = 1; n<N;n*=2){
            for(int i = 0;i<N;i+=2*n)
                merge(src,dst,i,i+n-1,Math.min(i+2*n-1,N-1));
            tmp = src;
            src = dst;
            dst = tmp;
        }
        if(src!=a)System.arraycopy(src,0,a,0,N);
        assert isSorted(a);
    }
    
    private static boolean isSorted(Comparable[] a)
    {
        for(int i=1;i<a.length;i++)
            if(isLess(a[i],a[i-1])) return false;
        return true;
    }
    
    private static boolean isLess(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }
}