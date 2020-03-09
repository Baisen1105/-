import java.util.ArrayList;
import java.util.List;

public class MergeSort{
    static int[] target = {3,4,2,6,7,9,10,13,17,1};
    public static void main(String[] args){
        printTarget();
        mergeSort(0, target.length-1);
        printTarget();
    }

    static void mergeSort(int low,int high){
        if(low == high){//if only one number in this round,only neet return 
            return;
        }
        else{
            //get the mid of the array
            int mid = (high+low)/2;
            //to save the result temporary
            List<Integer> list = new ArrayList<>();
            //sort each half of the array
            mergeSort(low, mid);
            mergeSort(mid+1, high);
            
            for(int i = low,j = mid+1;;){
                //compare each half then add the smaller one into the list
                if(target[i] <= target[j]){
                    list.add(target[i]);
                    i++;
                }
                else{
                    list.add(target[j]);
                    j++;
                }

                
                if(i>mid){
                    for(;j<=high;j++){
                        list.add(target[j]);
                    }
                    break;
                }
                else if(j>high){
                    for(;i<=mid;i++){
                        list.add(target[i]);
                    }
                    break;
                }
            }

            int i = low;
            for(Integer integer : list){
                target[i++] = integer;

            }
            return;

        }

    }

    static void printTarget(){
        for(int i : target){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}