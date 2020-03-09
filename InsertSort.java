public class InsertSort{
    static int[] target = {3,6,2,7,8,1,12,5,10,13,7};

    public static void main(String[] args){
        printTarget();
        sort();
        printTarget();
    }

    static void sort(){
        for(int i = 1;i<target.length;i++){
            for(int j = target.length -1;j>=i;j--){
                if(target[j]<target[j-1]){
                    change(j-1, j);
                }
                else{
                    continue;
                }
            }
        }
    }

    static void change(int i,int j){
        int s = target[i];
        target[i] = target[j];
        target[j] = s;
    }

    static void printTarget(){
        for(int i : target){
            System.out.print(i+" ");
        }
        System.out.println();
    }

} 