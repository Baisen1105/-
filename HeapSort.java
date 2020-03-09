public class HeapSort{
    //the target[0] is unused.the starting of heapsort is target[1]
    static int[] target = {0,3,4,2,6,7,9,10,13,17,1};
    public static void main(String[] args){
        printTarget();
        heapSort();
        printTarget();
    }

    //keep the property of the max heap
    static void maxHeapify(int num,int length){
        if(2*num > length){
            return;
        }

        if(2*num == length){
            if(target[num] >= target[2*num]){
                return;
            }
            else{
                int s = target[num];
                target[num] = target[2*num];
                target[2*num] = s;
                maxHeapify(2*num,length);
            }
        }
        else{
            if(target[2*num]>target[2*num + 1] && target[2*num]>target[num]){
                int s = target[num];
                target[num] = target[2*num];
                target[2*num] = s;
                maxHeapify(2*num,length);
            }
            else if(target[2*num+1]>target[2*num] && target[2*num+1]>target[num]){
                int s = target[num];
                target[num] = target[2*num+1];
                target[2*num+1] = s;
                maxHeapify(2*num+1,length);
            }
            else{
                return;
            }
        }

    }

    static void buildMaxHeap(){
        for(int i = (target.length-1)/2;i>0;i--){
            maxHeapify(i, target.length-1);
        }
    }

    static void heapSort(){
        buildMaxHeap();
        
        int i = target.length - 1;
        while(true){
            int s = target[1];
            target[1] = target[i];
            target[i] = s;
            i--;
            if(i==1){
                break;
            }
            maxHeapify(1, i);
        }

    }

    static void printTarget(){
        for(int i : target){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}