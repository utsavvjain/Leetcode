**Intiution is to apply sliding window hee, we just find out how many good elements we have from distinct sorted nums then subtract it from orignal size of nums.
Here we'll treat everything to which r represents as first element of window and we move l ahead means l will be ahead of j we check all the elements that statisfy nums[i]-nums[r]<=n-1, we''ll only run till <= beacuse if difff is greater than n-1 we won't satisfying the condition now the elements n-(window size) needs to be replaced with distinct value less than or equal to n-1**