package InterviewQuiz;

public class RecursivePermutation {

    private int[] buffer;

    public RecursivePermutation(int n){
        this.buffer = new int[n];
    }

    public void setBuffer(int[] arr){
        for(int i=0;i<buffer.length;i++){
            buffer[i] = arr[i];
        }
    }

    private void permall(int height) {
        if(height==1){
            this.printBuffer();
        }
        else {
            for(int i=0; i<height;i++){
                swap(this.buffer, i, height);
                permall(height-1);
                swap(this.buffer, i, height);
            }
        }
    }

    private static void swap(int[] buffer, int i, int height){
        int tmp = buffer[i];
        buffer[i] = buffer[height-1];
        buffer[height-1] = tmp;
    }

    private void printBuffer(){
        for(int i=0;i<buffer.length;i++){
            System.out.print(buffer[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] integerArr = {1,2,3,4};
        int height = integerArr.length;
        RecursivePermutation recursivePermutation = new RecursivePermutation(height);
        recursivePermutation.setBuffer(integerArr);
        recursivePermutation.permall(height);
    }
}
