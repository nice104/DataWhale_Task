package Datawhale.Q0226;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;                             //简化，如果>0则说明该三数之和不可能为0
            if (i > 0 && nums[i] == nums[i - 1]) continue;      //去重
            int target = 0 - nums[i];
            int l = i + 1, r = len - 1;                         //此处必须对i后面的数字进行筛选，不能重复
            while (l < r) {

                List<Integer> list = new ArrayList();
                if (nums[l] + nums[r] == target) {
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while (r > l && nums[l + 1] == nums[l]) l++;          //这个地方改成l-1只会出现一个结果了
                    while (r > l && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] > target) r--;
                else l++;
            }
        }
        return res;
    }
}