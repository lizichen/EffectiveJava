package TreeAndGraph;

import java.util.Arrays;

public class BinaryHeap {
    private int[] heaplist;
    private int heapsize;
    private int maxOrMin = 0;

    public BinaryHeap(int size){
        heaplist = new int[size];
        heapsize = 0;
    }

    public BinaryHeap(int size, int maxOrMin){
        this(size);
        this.maxOrMin = maxOrMin; // 0 for default as MinHeap, 1 for MaxHeap
    }

    private void insert(int k){ // O(log n)
        if(this.heaplist.length - 1 == heapsize){
            doubleHeapSize();
        }
        int pos = ++heapsize;
        this.heaplist[pos] = k;
        if(maxOrMin == 0){ // Min Heap
            for(; pos > 1 && k < heaplist[pos/2] ; pos = pos/2)
                heaplist[pos] = heaplist[pos/2];
        }else if(maxOrMin == 1){ // Max Heap
            for(; pos > 1 && k > heaplist[pos/2] ; pos = pos/2)
                heaplist[pos] = heaplist[pos/2];
        }
        heaplist[pos] = k;
    }

    // Pop out the root of the binary heap
    // Put the last integer from the array to the root of the binary heap
    // Compare the new 'root' with children and place it at the right place
    private int popRoot(){ // Percolate Down O(log n)
        int root = this.heaplist[1];

        int last = this.heaplist[heapsize];
        this.heaplist[1] = last;
        this.heaplist[heapsize--] = 0;
        int pos = 1;
        if(maxOrMin == 0){
            for(; pos < heapsize && pos*2<heapsize && (last > heaplist[pos*2] || last > heaplist[pos*2+1]) ; ){
               if(heaplist[pos*2] <= heaplist[pos*2+1]){
                   heaplist[pos] = heaplist[pos*2];
                   pos = pos*2;
               }else if(last > heaplist[pos*2+1]){
                   heaplist[pos] = heaplist[pos*2+1];
                   pos = pos*2+1;
               }
            }
            heaplist[pos] = last;
        }
        else if(maxOrMin == 1){
            for(; pos < heapsize && pos*2 < heapsize && (last < heaplist[pos*2] || last < heaplist[pos*2+1]) ; ){
                if(heaplist[pos*2] >= heaplist[pos*2+1]){
                    heaplist[pos] = heaplist[pos*2];
                    pos = pos*2;
                }else if(last < heaplist[pos*2+1]){
                    heaplist[pos] = heaplist[pos*2+1];
                    pos = pos*2+1;
                }
            }
            heaplist[pos] = last;
        }
        return root;
    }

    public void doubleHeapSize(){
        int[] newArr = new int[this.heaplist.length*2];
        for(int i=0;i<=this.heapsize;i++){
            newArr[i] = this.heaplist[i];
        }
        this.heaplist = newArr;
    }

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(10, 1);
        System.out.println("Insearting...");
        int[] arr = {6,7,12,10,15,17,5,23,4,72,1,93,19,2};
        for(int i=0;i<arr.length;i++){
            heap.insert(arr[i]);
        }
        System.out.println(Arrays.toString(heap.heaplist));
        System.out.println("\nPopping out...");
        while(heap.heapsize!=0){
            System.out.println(heap.popRoot());
            System.out.println(Arrays.toString(heap.heaplist));
        }
    }
}
