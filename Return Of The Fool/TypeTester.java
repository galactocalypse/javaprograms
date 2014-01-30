import java.text.*;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;     

 public class TypeTester
 {
    DataInputStream inpt=new DataInputStream(System.in);
    float result,accuracy,adjustment,error=0,mistakes;
    String input="";
    String question[]=new String[10];
    int words[]=new int[10];
    int r=4,timeTaken=0;
    String h1,h2,m1,m2,s1,s2,t1,t2;
    int hour1,hour2,minute2,minute1,second1,second2;
    
    public static void main(String[] args){
        TypeTester t=new TypeTester();
        t.testTime();
    }
    
    public TypeTester(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please go throught the general instructions given below.");
        System.out.println("Type the text that is displayed immediately after being prompted to do so because the time begins right from that time.");
        System.out.println("After you finish, press the ENTER key. Keeping to the number of characters displayed in the text is very important, otherwise your input");
        System.out.println("will be considered invalid and the program will terminate. Note that errors by which the relative positioning of word lengths would be");
        System.out.println("altered would result in display of incorrect accuracy. Therefore, it is important to keep in mind the lengths and sequences of each word.");
        System.out.println("Only such errors by which the characters in a word are changed would be entertained.");
        System.out.println("The output will consist of the following : ");
        System.out.println("\t\tGross Speed : It would display your typing speed irrespective of the errors you have made ;");
        System.out.println("\t\tAccuracy    : It would display your accuracy while typing, expressed as a percentage ;");
        System.out.println("\t\tNet Speed   : It would display your net typing speed taking into considering your accuracy, too.");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        question[0]=("We take things for granted; they know that life CANNOT be taken for granted. We live on what our parents build for us; they build a future for THEMSELVES. We live the gift of privileges; they privilege the GIFT of LIFE.");  
        question[1]=("If at times you feel so depressed and inferior, it is a proof of the fact that you are a superior being, for fools and imbeciles cannot feel the way you do. So shed off all feelings of inferiority.");
        question[2]=("Success doesn't mean the absence of failures; it means the attainment of ultimate objectives. It means winning the war, not every battle.");
        question[3]=("We make a living by what we get. We make a LIFE by what we give. Give a man a fish, you feed him for a day. Teach him how to fish, you feed him for a LIFETIME.");
        question[4]=("Now is the time to open the doors of opportunity to all of God's children. Now is the time to lift our nation from the quicksands of racial injustice to the solid rock of brotherhood.");
        question[5]=("In the process of gaining our rightful place we must not be guilty of wrongful deeds. Let us not seek to satisfy our thirst for success by drinking from the cup of bitterness and hatred. ");
        question[6]=("People suffer when they do not go to God and don't look to Him for help. That's why there's so much pain and suffering in the world.");
        question[7]=("Some people come into our lives and quickly go. Some stay for a while and leave footprints on our hearts. And we are never, ever the same.");
        question[8]=("Manners are like the zero in arithmetic. In themselves they don't have much value, but when added on, they increase the value of everything.");
        question[9]=("In stead of always harping on a man's faults, tell him of his virtues. Try to pull him out of his rut of bad habits. Hold up to him his better self, his real self that can dare and do and win out.");
        
        for(int i=0;i<10;i++){
            int l=question[i].length();
            words[i]=l/5;
        }
    }
    
    public void testTime(){
        for(;;){
            r=(int)(Math.random()*100);
            if(r<4)
                break;
        }
        int flag=0;
//         for(int i=0;i<question[r].length();i++){
//             char c=question[r].charAt(i);
//             System.out.print(c);
//             if(i>120&&flag==0&&(question[r].charAt(i+1)==' ')){
//                 System.out.println();
//                 flag=1;
//             }            
//         }
        System.out.println(question[r]);
        
//         String str="Y";
//         System.out.println("\nAre you ready (Y/N)?");
//         try{
//             str=inpt.readLine();
//         }
//         catch(IOException e){}
//         if(str.equals("Y")||str.equals("y")){             
            System.out.println("\nStart typing here...NOW.....\n");
            
            Calendar calendar = new GregorianCalendar();
            SimpleDateFormat formatter1 = new SimpleDateFormat("hh:mm:ss");
            t1=formatter1.format(calendar.getTime());
            h1=""+t1.charAt(0);
            h1=h1+t1.charAt(1);
            m1=""+t1.charAt(3);
            m1=m1+t1.charAt(4);
            s1=""+t1.charAt(6);
            s1=s1+t1.charAt(7);
            int hour1=Integer.parseInt(h1);
            int minute1=Integer.parseInt(m1);
            int second1=Integer.parseInt(s1);
            
//             char inp;
//             int i=0;
//             try{
//                 inp=(char)inpt.read();
//                 i=i+1;
//                 if(i>120&&flag==0){
//                     System.out.println();
//                     flag=1;
//                 }            
//                 input=input+inp;
//             }
//             catch(IOException g){}
    try{
        input=inpt.readLine();
    }
    catch(IOException e){}
    
            Calendar calendar1 = new GregorianCalendar();
            SimpleDateFormat formatter2 = new SimpleDateFormat("hh:mm:ss");
            t2=formatter2.format(calendar1.getTime());
            h2=""+t2.charAt(0);
            h2=h2+t2.charAt(1);
            m2=""+t2.charAt(3);
            m2=m2+t2.charAt(4);
            s2=""+t2.charAt(6);
            s2=s2+t2.charAt(7);
            int hour2=Integer.parseInt(h2);
            int minute2=Integer.parseInt(m2);
            int second2=Integer.parseInt(s2);
    
            if(hour1==hour2){
                if(minute1==minute2)
                    timeTaken=second2-second1;
                else
                    if(minute2>minute1){
                        int min=(minute2-minute1)*60;
                        if(second1>second2)
                            timeTaken=min+(second1-second2);
                        else
                            if(second2>second1)
                                timeTaken=min+(second2-second1);
                            else
                                timeTaken=min;
                    }
                    else{
                        int min=(minute1-minute2)*60;
                        if(second1>second2)
                            timeTaken=min+(second1-second2);
                        else
                            if(second2>second1)
                                timeTaken=min+(second2-second1);
                            else
                                timeTaken=min;
                        }
            }
            else
                timeTaken=(hour2-hour1*3600)+((minute2-minute1)*60)+(second2-second1); 
                
            int len1=question[r].length();
            int len2=input.length();
            if(len1==len2){
                for(int i=0;i<len1;i++){
                    if(question[r].charAt(i)!=input.charAt(i))
                        error=error+1;
                }
            } 
            else{
                System.out.println("\nYou did not keep up to the character-limit. Therefore, the program terminates. Please try again.");
                System.out.println("____________________________________________________________________________________________________________");
                System.exit(0);
            }
                      
            mistakes=((error*100)/len1);
            accuracy=100-mistakes;
            result=(words[r]*60)/timeTaken;
            System.out.println(result);
            System.out.println("Gross Speed = "+result+" words per minute.");
            System.out.println("Accuracy = "+accuracy+"%");
            result=(accuracy/100)*result;
            System.out.println("Net Speed = "+result+" words per minute.");
            System.out.println("_________________________________________________________________________________________________________________");
//         }//end of if
//         else{
//             System.out.println("The program terminates.");
//             System.out.println("____________________________________________________________________________________________________");
//             System.exit(0);
//         }//end of else
    }
}


