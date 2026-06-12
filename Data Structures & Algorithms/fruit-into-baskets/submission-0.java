class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> fc = new HashMap<>();
        int maxLength = 0;
        int lptr=0;
        int rptr=0;

        // Find max-length sub-array with at-most 2 types of fruits

        // Optimal
        while(rptr<fruits.length){
            if(fc.get(fruits[rptr]) != null){
                fc.put(fruits[rptr],fc.get(fruits[rptr]) + 1);
            }else{
                fc.put(fruits[rptr],1);
            }
        

            if(fc.size() <=2){
                maxLength = Math.max(maxLength, rptr-lptr+1);
            }else{
                int currentLeftFruitCount = fc.get(fruits[lptr]);
                if(currentLeftFruitCount==1){
                    fc.remove(fruits[lptr]);
                }else{
                    fc.put(fruits[lptr], currentLeftFruitCount - 1);
                }
                lptr++;
            }
            rptr++;
        }

        // bruteforce
        // for(int i=0;i<fruits.length; i++){
        //     Set<Integer> basket = new HashSet<>();
        //     for(int j=i; j<fruits.length; j++){
        //         basket.add(fruits[j]);
        //         if(basket.size()<=2){
        //             maxLength = Math.max(maxLength, j-i+1);
        //         }else{
        //             break;
        //         }
        //     }
        // }

        return maxLength;
    }
}