package sorting;

/**
 * Merge
 */
public class Merge {

    public static void mergesort(int[] array){
        merge(array, new int[array.length] , 0, array.length-1);
    }

    public static void merge(int[] array, int[] temp, int left, int right){
        if(left>=right){
            return;
        }

        int mid = (left + right)/2;
        merge(array, temp, left , mid);
        merge(array, temp, mid+1, right);
        mergeHalves(array, temp, left, right);
    }

    public static void mergeHalves(int[] array, int[] temp, int left, int right){
        int leftEnd = (right+left) /2;
        int rightStart = leftEnd +1;
        int size = right - left+1;

        int startLeft = left;
        int startRight = rightStart;
        int index =  left;

        while(startLeft <= leftEnd && startRight <= right){
            if(array[startLeft]<=array[startRight]){
                temp[index] = array[startLeft];
                startLeft++;
            }else{
                temp[index] = array[startRight];
                startRight++;
            }
            index++;
        }
 
        System.arraycopy(array, startLeft, temp, index, leftEnd - startLeft +1);
        System.arraycopy(array, startRight, temp, index, right - startRight +1);
        System.arraycopy(temp, left, array, left, size);

    }


    public static void main(String[] args){

    }
}