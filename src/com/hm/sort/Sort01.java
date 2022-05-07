/**
* <p>Title: Sort01.java</p>  
* <p>Description: </p>   
* @author hanmeng
* @date 2020-11-18  
* @version 1.0 
*/  
package src.com.hm.sort;

/**
 * @author hm
 * 用于求解 Kth Element 问题，也就是第 K 个元素的问题。
 * http://002ii.cn/8W7bEK
 *https://blog.csdn.net/lw_power/article/details/80889022?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522160568483619195264715939%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=160568483619195264715939&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v28-8-80889022.first_rank_ecpm_v3_pc_rank_v2&utm_term=%E6%8E%92%E5%BA%8F%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E7%94%A8%E4%BA%8E%E6%B1%82%E8%A7%A3Kth+Element%E9%97%AE%E9%A2%98&spm=1018.2118.3001.4449
 */
public class Sort01 {
	
	public static void main(String[] args) {
		Sort01 s = new Sort01();
		int[]nums = {3,2,1,5,6,4};
		int i = 2;
		System.out.println(s.findKthLargest(nums, i));
	}
	public int findKthLargest(int[] nums, int k) {
		//第k大得元素的下标是nums.length-k
	    k = nums.length - k;
	    int l = 0, h = nums.length - 1;
	    while (l < h) {
	        int j = partition(nums, l, h);
	        if (j == k) {
	            break;
	        } else if (j < k) {
	            l = j + 1;
	        } else {
	            h = j - 1;
	        }
	    }
	    return nums[k];
	}

	/**
	 * 注意：partition 这个函数返回的是整个数组的第 k 个最小元素（从 0 开始计算）。
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	private int partition(int[] a, int left, int right) {
//	    int i = l, j = h + 1;
//	    while (true) {
//	        while (a[++i] < a[l] && i < h) ;
//	        while (a[--j] > a[l] && j > l) ;
//	        if (i >= j) {
//	            break;
//	        }
//	        swap(a, i, j);
//	    }
//	    swap(a, l, j);
//	    return j;
		
		 int pivot = a[left];
	        int j  = left;
	        for (int i = j + 1; i <= right; i++) {
	            if (a[i] < pivot) {
	                j++;
	                swap(a, j, i);
	            }
	        }
	        swap(a, left, j);
	        return j;
	}

	private void swap(int[] a, int i, int j) {
	    int t = a[i];
	    a[i] = a[j];
	    a[j] = t;
	}
}
