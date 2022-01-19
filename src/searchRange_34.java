public class searchRange_34 {
    public static void main(String[] args) {
        int[] a=new int[] {5,7,7,8,8,10};
        System.out.println(searchRange(a,8));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        if(search(nums,target)>=0){
            res[0]=left_bound(nums,target);
            res[1]=right_bound(nums,target);
            return res;
        }else{
            return new int[] {-1,-1};
        }
    }

    public static int search(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]==target){
                return mid;
            }
        }
        return -1;
    }


    public static int left_bound(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]==target){
                right=mid-1;
            }
        }

        if(left==nums.length||nums[left]!=target) return -1;
        return left;
    }

    public static int right_bound(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]==target){
                left=mid+1;
            }
        }

        if(right<0||nums[right]!=target) return -1;
        return right;
    }
}
