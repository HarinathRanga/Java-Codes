import java.util.*;
class DividenConquer {
    public static void printArr(int ar[]){
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
    }
    public static void printArr(String ar[]){
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
    }
    public static void merge(int ar[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        //merge both
        while(i<=mid && j<=ei){
            if(ar[i]<ar[j]){
                temp[k++]=ar[i++];
            } else {
                temp[k++]=ar[j++];
            }
        }
        //left
        while(i<=mid){
            temp[k++]=ar[i++];
        }
        //right
        while(j<=ei){
            temp[k++]=ar[j++];
        }

        //copy temp into main array
        for(k=0,i=si;k<temp.length;k++,i++){
            ar[i]=temp[k];
        }
    }
    public static void mergeSort(int ar[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid= si + (ei-si)/2;
        mergeSort(ar,si,mid);
        mergeSort(ar,mid+1,ei);
        merge(ar,si,mid,ei);
    }

    public static void quickSort(int ar[],int si,int ei){
        if(si>=ei){
            return;
        }
        int pidx=partition(ar,si,ei);
        quickSort(ar,si,pidx-1);
        quickSort(ar,pidx+1,ei);
    }
    public static int partition(int ar[],int si,int ei){
        int pivot=ar[ei];
        int i=si-1;
        for(int j=si;j<ei;j++){
            if(ar[j]<=pivot){
                i++;
                int temp=ar[j];
                ar[j]=ar[i];
                ar[i]=temp;
            }
        }
        i++;
        ar[ei]=ar[i];
        ar[i]=pivot;
        return i;
    }

    public static int sortedRotatedSearch(int ar[],int key,int si,int ei){
        if(si>ei){
            return -1;
        }
        int mid=si+(ei-si)/2;
        if(ar[mid]==key){
            return mid;
        }
        if(ar[si]<=ar[mid]){
            if(ar[si]<=key && ar[mid]>=key){
                return sortedRotatedSearch(ar,key,si,mid-1);
            }
            else{
                return sortedRotatedSearch(ar,key,mid+1,ei);
            }
        }
        else{
            if(ar[mid]<=key && ar[ei]>=key){
                return sortedRotatedSearch(ar,key,mid+1,ei);
            } else {
                return sortedRotatedSearch(ar,key,si,mid-1);
            }
        }
    }

    public static void stringMergeSort(String ar[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        stringMergeSort(ar, si, mid);
        stringMergeSort(ar, mid+1, ei);
        stringMerge(ar,si,mid,ei);
    }
    public static void stringMerge(String ar[],int si,int mid,int ei){
        String temp[]=new String[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=ei){
            if(ar[i].compareTo(ar[j])<=0){
                temp[k++]=ar[i++];
            } else {
                temp[k++]=ar[j++];
            }
        }
        while(i<=mid){
            temp[k++]=ar[i++];
        }
        while(j<=ei){
            temp[k++]=ar[j++];
        }
        for(k=0,i=si;k<temp.length;k++,i++){
            ar[i]=temp[k];
        }
    }
    public static void main(String[] args) {
        String ar[]={"sun","earth","mars","mercury"};
        stringMergeSort(ar, 0, ar.length-1);
        printArr(ar);
    }
}