class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies,1);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int index = 0;
        for(int rating:ratings){
            minHeap.offer(new int[]{rating,index});
            index++;
        }
        while(!minHeap.isEmpty()){
            int[] current = minHeap.poll();
            int rating = current[0];
            int i = current[1];
            int required_candies=  1;
            if(i>0 && ratings[i]>ratings[i-1]){required_candies = Math.max(required_candies,candies[i-1]+1);}
            if((i+1)<n && ratings[i]>ratings[i+1]){required_candies = Math.max(required_candies,candies[i+1]+1);}
            candies[i] = required_candies;
        }
        int sum = 0;
        for(int candy:candies){
            sum+=candy;
        }
        return sum;
    }
}