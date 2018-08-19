package Array;

public class Candy_135 {

    public static int candy(int[] ratings) {
        // to though the entire list twice
        int[] result = new int[ratings.length];

        // head to tail
        for(int i=0; i<ratings.length; i++){
            if(!satisfy(i, result, ratings)){
                // increment result[i] by 1
                if(i == 0)
                    result[i]++;
                else
                    result[i] = result[i-1] + 1;
            }
        }

        // tail to head
        for(int i=ratings.length - 1; i>=0; i--){
            if(!satisfy(i, result, ratings)){
                // increment result[i] by 1
                if(i == ratings.length - 1)
                    result[i]++;
                else
                    result[i] = result[i+1] + 1;
            }
        }

        int allCount = 0;
        for(int r : result)
            allCount += r;

        return allCount;
    }

    // return true if result[index] is good, otherwise, return false;
    public static boolean satisfy(int index, int[] result, int[] ratings){
        //          0, 1, 2, 3 #
        // ratings  1, 0, 2, 3
        // result
        int left_rating    = (index == 0) ? ratings[0] : ratings[index-1];
        int current_rating = ratings[index];
        int right_rating   = (index == ratings.length - 1) ? ratings[ratings.length - 1] : ratings[index + 1];

        int left_result    = (index == 0) ? result[0] : result[index-1];
        int current_result = result[index];
        int right_result   = (index == result.length - 1) ? result[result.length - 1] : result[index + 1];

        if(index == 0){
            if (current_rating > right_rating && current_result <= right_result){
                return false;
            }
        }else if(index == result.length - 1){
            if (left_rating < current_rating && left_result >= current_result){
                return false;
            }
        }else{
            if(left_rating < current_rating && left_result >= current_result){
                return false;
            }else if(current_rating > right_rating && current_result <= right_result){
                return false;
            }else{
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,3,4,5,2}));
    }
}
