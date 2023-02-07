class FindMinimumLength {
    public static int minSubArrayLen(int goal, int[] nums) {
        int minimumLength = nums.length + 1;
        int i = 0, j = 0;
        int curSum = 0, curLength = 0;
        
        while(i < nums.length) {
        	
        	while(curSum < goal && i < nums.length) {	//expand window until curSum >= goal, bounds check
        		curSum += nums[i];
        		i++;
        		curLength++;
        	}
        	
        	while(curSum >= goal && j <= i) {			//diminish window from left side while curSum is still >= goal
            	minimumLength = (curLength < minimumLength)? curLength: minimumLength;
        		curSum -= nums[j];
        		j++;
        		curLength--;
        	}
        	
        	
        }
        
        if(minimumLength == nums.length + 1)	//not enough elements in array to reach goal
        	return 0;
        return minimumLength;
    }
    
    public static void main(String[] args) {
    	int[] array1 =   {10,2,3,11};
    	System.out.println(minSubArrayLen(11, array1)); 
    	int[] array2 =   {5, 6, 8, 2};
    	System.out.println(minSubArrayLen(7, array2));
    }
}
