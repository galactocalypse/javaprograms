import java.io.*;
    class Selection{
        DataInputStream conin=new DataInputStream(System.in);
        int array[],i,j,ctr,temp;
        Selection(){
            i=j=ctr=temp=0;
        }
        void getLength(){
            System.out.println("\t\t Selection Sort");
            System.out.print("Enter array length : ");
            try{
                array=new int[Integer.parseInt(conin.readLine())];
            }
            catch(IOException e){}
        }
        void acceptArray(){
            for(i=0;i<array.length;i++){
                System.out.print("Enter array["+i+"] : ");
                try{
                    array[i]=Integer.parseInt(conin.readLine());
                }
                catch(IOException e){}
            }
        }
        void findPrime(){
            for(i=0;i<array.length;i++){
                ctr=0;
                for(j=1;j<array[i];j++){
                    if((array[i]%j)==0){ctr++;}
                }
            
            if(ctr==1){System.out.println(array[i]+"\t\t PRIME");}
            if(ctr>1){System.out.println(array[i]+"\t\t -");}
        }
    }
    void sortArray(){
        for(i=0;i<(array.length-1);i++){
            for(j=i;j<array.length-1;j++){
                if(array[i]>array[i+1]){
                temp=array[i];
                array[i]=array[i+1];
                array[i+1]=temp;
            }
        }
        }
    }
    void displayArray(){
        for(i=0;i<array.length;i++){
            System.out.print(array[i]+" , ");
        }
    }
    public static void main(String args[]){
        Selection s=new Selection();
        s.getLength();
        s.acceptArray();
        s.findPrime();
        System.out.println("Array before sorting :");
        s.displayArray();
        System.out.println("Array after sorting :");
        s.sortArray();
        s.displayArray();
           }

}