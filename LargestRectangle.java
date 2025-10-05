import java.util.Stack;

public class LargestRectangle {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        Stack<Integer> stk = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]){
                stk.pop();
            }
            leftSmall[i] = (stk.isEmpty())? 0: stk.peek() + 1;
            stk.push(i);

            
        }
        stk.clear();
        for(int i = n-1; i >= 0; i--){
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]){
                stk.pop();
            }
            rightSmall[i] = (stk.isEmpty())? n-1: stk.peek() -1;
            stk.push(i);
        }

        for(int i = 0; i < n; i++){
            int width = (rightSmall[i] - leftSmall[i])+1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
        
    
    

    }
    public static void main(String[] args) {
        int[] heights ={2,1,5,6,2,3,1};
        System.out.println(largestRectangleArea(heights));
    }
}
