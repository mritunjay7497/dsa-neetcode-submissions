class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // int resArrLen = nums.length-k+1;
        List<Integer> resArr = new ArrayList<>();

        // bruteforce
        // for(int i=0; i<nums.length-k+1; i++){
        //     int max = nums[i];
        //     for(int j=i; j<i+k; j++){
        //         max = Math.max(max,nums[j]);
        //         resArr[i] = max;
        //     }
        // }

        // optimal
        Deque<Integer> dq = new ArrayDeque<>();
        int rptr = 0;

        /*
        * Logic for deque
        * from the end, we will push the current element index in the deque.
        * if already stored index has element lower than that at current idx, we will remove the previously stored idx.
        * if next idx element is lower than that at current idx, we will still store that idx, bcoz it might be
        * greatest in next window (when lptr and rptr is moved by 1 unit each)
        * when rptr - lptr + 1 == k,we will pop the element from the begining of deque.
        * This will give us the maximum element idx as we are storing idx in monotonically decresing order(monotonic stack)
        */
        
        while(rptr < nums.length){
            int lptr = rptr-k+1;

            while(!dq.isEmpty() && dq.peekFirst() < lptr){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[rptr]){
                dq.removeLast();
            }

            dq.addLast(rptr);

            if(rptr >= k-1){
                resArr.add(nums[dq.peekFirst()]);
            }
            rptr++;
        }

        return resArr.stream().mapToInt(Integer::intValue).toArray();
    }
}
