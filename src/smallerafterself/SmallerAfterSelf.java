package smallerafterself;
//https://leetcode.com/problems/count-of-smaller-numbers-after-self/

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    int leftSize;
    int duplicates;
    int smallerCount;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int x) {
        val = x;
        duplicates = 1;
    }
    
    public void insert(TreeNode node) {
        if (node.val == val) {
        	duplicates++;
        	node.smallerCount += leftSize;
        }
        else if (node.val < val) {
            leftSize++;
            if (left == null)
                left = node;
            else
                left.insert(node);
        } else if (node.val > val) {
            node.smallerCount += (leftSize + duplicates);
            if (right == null)
                right = node;
            else
                right.insert(node);
        }
    }
}

public class SmallerAfterSelf {
    
	public static List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
    	if (nums.length > 0) {
            TreeNode root = new TreeNode(nums[nums.length-1]);
            list.add(0);
            if (nums.length >= 2) {
                for (int i = nums.length-2; i >= 0; i--) {
                    TreeNode node = new TreeNode(nums[i]);
                    root.insert(node);
                    list.add(0, node.smallerCount);
                }            	
            }
    	}
        return list;    		
    }
	
	//For testcases
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSmaller(new int[]{5,2,6,1}));
		System.out.println(countSmaller(new int[]{}));
		System.out.println(countSmaller(new int[]{2}));
		System.out.println(countSmaller(new int[]{3,1}));
		int[] arr = new int[] {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
		System.out.println(countSmaller(arr));
	}

}
