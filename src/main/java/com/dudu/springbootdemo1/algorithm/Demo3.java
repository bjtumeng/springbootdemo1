package com.dudu.springbootdemo1.algorithm;

public class Demo3 {
    public static void main(String[] args) {
        int[] array={4};
        System.out.println(GetNumberOfK(array,3));
    }
    public static int GetNumberOfK(int [] array , int k) {
        int number=0;
        if(array!=null&&array.length>0){
            int start=0;
            int end=array.length-1;
            int numberFirstk = getNumberFirstk(array, start, end, k);
            System.out.println(numberFirstk);
            int numberLastk = getNumberLastk(array, start, end, k);
            System.out.println(numberLastk);
            if (numberFirstk<numberLastk){
                number = numberLastk - numberFirstk+1;
            }
        }
        return number;
    }
    public static int getNumberFirstk(int[] array,int start,int end,int k){
        if (array.length<0||start>end){
            return -1;
        }
            int mid=(start+end)/2;
            if (k>array[mid]){
                start=mid;
//                getNumberFirstk(array,start,end,k);
            }else if(k<array[mid]){
                end=mid;
//                getNumberFirstk(array,start,end,k);
            }else if(k==array[mid]){
                if ((mid>1&&array[mid-1]!=k)||mid==0){
                    return mid;
                }else{
                    end=mid;
//                    getNumberFirstk(array,start,mid,k);
                }
            }
          return  getNumberFirstk(array,start,end,k);
    }

    public static int getNumberLastk(int[] array,int start,int end,int k){
       if (array.length<0||start>end){
            return -1;
        }
            int mid=(start+end)/2;
            if (k>array[mid]){
                start=mid;
//                getNumberFirstk(array,start,end,k);
            }else if(k<array[mid]){
                end=mid;
//                getNumberFirstk(array,start,end,k);
            }else if(k==array[mid]){
                if ((mid+1<array.length&&array[mid+1]!=k)||mid==0){
                    return mid;
                }else{
                    start=mid;
//                    getNumberFirstk(array,start,mid,k);
                }
            }
          return  getNumberLastk(array,start,end,k);
    }

}
