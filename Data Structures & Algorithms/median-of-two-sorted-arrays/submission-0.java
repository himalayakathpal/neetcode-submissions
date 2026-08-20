class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m ==0) {
            return n%2 == 0 ? (double) (nums2[n/2] + nums2[(n/2) - 1] ) /2 : nums2[n/2];
        }
        if (n ==0) {
            return m%2 == 0 ? (double) (nums1[m/2] + nums1[(m/2) - 1] ) /2 : nums1[m/2];
        }

        int leftElementsCount = (m+n+1)/2;
        if (m>n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            m = nums1.length;
            n = nums2.length;
        }
        
        int start = 0;
        int end = m;
        int mid;

        while (start<=end) {
            mid = (start+end)/2;
            int otherCount = leftElementsCount - mid;
            int firstLeft = mid>0 ? nums1[mid-1]: Integer.MIN_VALUE;
            int firstRight = mid<m? nums1[mid] : Integer.MAX_VALUE;
            int secondLeft = otherCount>0? nums2[otherCount-1] : Integer.MIN_VALUE;
            int secondRight = otherCount<n? nums2[otherCount] : Integer.MAX_VALUE;

            if (firstLeft<= secondRight && secondLeft<=firstRight) {
                if ((m+n)%2==0) return (double) (Math.max(firstLeft,secondLeft) + Math.min(firstRight,secondRight))/2;
                else return Math.max(firstLeft,secondLeft);
            } else if (firstLeft>secondRight) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
}

