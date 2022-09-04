Take 3000 sized array as k can go till 1000 so if start is 0 and end is at 1000 max we can go to 1000, and if start is 1000 and end is 0 we have to -1000
​
So 1000 index is treated as 0. Also if abs difference b/w startPos and endPos is greater than k then we w'll return 0 as there aren't enough steps.