import java.io.*;
    class StringSort{
        int i,length=5;
        String array[],sorted[],unsorted[];
        DataInputStream inpt=new DataInputStream(System.in);
        void acceptArray()throws Exception{
            array=new String[length];
            for(i=0;i<length;i++){
            System.out.print("Enter element "+(i+1)+" : ");
            array[i]=inpt.readLine();
        }
    }
    void generateSorted(){
        for(i=0;i<length-1;i++){

            
            
            
            
                String temp=array[i];
                array[i]=array[i+1];
                array[i+1]=temp;
            }
        
}
    void display(){
        for(i=0;i<length;i++){
            System.out.println(array[i]);
        }
     }
     void main()throws Exception{
         StringSort s=new StringSort();
         s.acceptArray();
         System.out.println("\n Array before sorting :");
         s.display();
         s.generateSorted();
         System.out.println("\n Array after sorting :");
         s.display();
        }
    }