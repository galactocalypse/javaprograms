
//Project Program for Hospital Database Queue array.


// define maximum number of patients in a queue
//#define MAXPATIENTS 100

// define structure for patient data
import java.io.*;
public class patient
{
   public String FirstName = new String(new char[50]);
   public String LastName = new String(new char[50]);
   public String ID = new String(new char[20]);
}


// define class for queue

public class queue
{

   // declare member functions for queue
   
   public queue ()
   {
	  // constructor
	  NumberOfPatients = 0;
   }
   public final int AddPatientAtEnd (patient p)
   {
	  // adds a normal patient to the end of the queue.
	  // returns 1 if successful, 0 if queue is full.
	 if (NumberOfPatients >= DefineConstants.MAXPATIENTS)
	  {
		 // queue is full
		 return 0;
	  }
		 // put in new patient
		 else
		 List[NumberOfPatients] = p;
		 NumberOfPatients++;
		 return 1;
   }
   public final int AddPatientAtBeginning (patient p)
   {
	  // adds a critically ill patient to the beginning of the queue.
	  // returns 1 if successful, 0 if queue is full.
	  int i;
	  if (NumberOfPatients >= DefineConstants.MAXPATIENTS)
	  {
		 // queue is full
		 return 0;
	  }
   
	  // move all patients one position back in queue
	  for (i = NumberOfPatients-1; i >= 0; i--)
	  {
		 List[i+1] = List[i];
	  }
	  // put in new patient
	  List[0] = p;
	  NumberOfPatients++;
	  return 1;
   }
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//   patient GetNextPatient ();
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//   int RemoveDeadPatient (patient p);
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//   void OutputList ();
   public String DepartmentName = new String(new char[50]);
   private int NumberOfPatients;
   private patient[] List = new patient[DefineConstants.MAXPATIENTS];
}

final class DefineConstants
{
	public static final int MAXPATIENTS = 100;

private patient InputPatient()
{
   // this function asks user for patient data.
   patient p = new patient();
   System.out.print(" Please enter data for new patient First name: ");
   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
   p.FirstName = in.readLine();
   System.out.print(" Last name: ");
   p.LastName = in.readLine();
   System.out.print(" Social security number: ");
   p.ID = in.readLine();
   // check if data valid
   if (p.FirstName[0]==0 || p.LastName[0]==0 || p.ID[0]==0)
	{
			  // rejected
			  p.ID = "";
			  System.out.print(" Error: Data not valid. Operation cancelled.");
			  //getch();
	}
   return p;
}


private void OutputPatient(RefObject<patient> p)
{
   // this function outputs patient data to the screen
  if (p.argvalue == null || p.argvalue.ID[0]==0)
	{
			  System.out.print(" No patient");
			  return;
	}
   else
   {
   System.out.print(" Patient data:");
   }
   System.out.print(" First name: ");
   System.out.print(p.argvalue.FirstName);
   System.out.print(" Last name: ");
   System.out.print(p.argvalue.LastName);
   System.out.print(" Social security number: ");
   System.out.print(p.argvalue.ID);
}


private int ReadNumber()
{
   // this function reads an integer number from the keyboard.
   // it is used because input with cin >> doesn't work properly!
   String buffer = new String(new char[20]);
   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
   buffer = in.readLine();
   return Integer.parseInt(buffer);
}

public final class RefObject<T>
{
	public T argvalue;
	public RefObject(T refarg)
	{
		argvalue = refarg;
	}
}

public class queue
{
	public patient GetNextPatient()
	{
	   // gets the patient that is first in the queue.
	   // returns patient with no ID if queue is empty
	
	   int i;
	   patient p = new patient();
	   if (NumberOfPatients == 0)
	   {
	   // queue is empty
	   p.ID = "";
	   return p;
	   }
	   // get first patient
	   p = List[0];
	   // move all remaining patients one position forward in queue
	   NumberOfPatients--;
	   for (i = 0; i<NumberOfPatients; i++)
	   {
		  List[i] = List[i+1];
	   }
	   // return patient
	   return p;
	}
	public int RemoveDeadPatient(RefObject<patient> p)
	{
	   // removes a patient from queue.
	   // returns 1 if successful, 0 if patient not found
	   int i;
	   int j;
	   int found = 0;
	   // search for patient
	   for (i = 0; i<NumberOfPatients; i++)
		{
				  if (stricmp(List[i].ID, p.argvalue.ID) == 0)
			{
			 // patient found in queue
			 p.argvalue = List[i];
			 found = 1;
			 // move all following patients one position forward in queue
			 NumberOfPatients--;
				 for (j = i; j<NumberOfPatients; j++)
					{
							List[j] = List[j+1];
					}
			}
		}
	   return found;
	}
	public void OutputList()
	{
	   // lists entire queue on screen
	   int i;
	   if (NumberOfPatients == 0)
		{
				  System.out.print(" Queue is empty");
		}
	   else
		{
	
			for (i = 0; i<NumberOfPatients; i++)
			{
				System.out.print(" +  ");
				System.out.print(List[i].FirstName);
				 System.out.print(" ");
				 System.out.print(List[i].LastName);
				 System.out.print(" ");
				 System.out.print(List[i].ID);
			}
		}
	}
}
private void DepartmentMenu(RefObject<queue> q)
{
   // this function defines the user interface with menu for one
//department int choice = 0,success;
patient p = new patient();
   while (choice != 6)
	{
			 // clear screen
			 clrscr();
			 // print menu
			 System.out.print(" Welcome to department: ");
			 System.out.print(q.argvalue.DepartmentName);
			 System.out.print(" Please enter your choice:");
			 System.out.print(" 1:  Add normal patient");
			 System.out.print(" 2:  Add critically ill patient");
			 System.out.print(" 3:  Take out patient for operation");
			 System.out.print(" 4:  Remove dead patient from queue");
			 System.out.print(" 5:  List queue");
			 System.out.print(" 6:  Change department or exit ");
			 // get user choice
			 choice = ReadNumber();
			  // do indicated action
		  switch (choice)
	  {
			  case 1: // Add normal patient
		 p = InputPatient();
		 if (p.ID[0])
		   {
				success = q.argvalue.AddPatientAtEnd(p);
				clrscr();
				  if (success)
				{
					   System.out.print(" Patient added: ");

				}
			else
		   {
				   // error
				   System.out.print(" Error: The queue is full. Cannot add patient:");
		   }
				OutputPatient(p);
				System.out.print(" Press any key");
				getch();
	  }
	 break;

	  case 2: // Add critically ill patient
	 p = InputPatient();
	 if (p.ID[0])
		 {
			success = q.argvalue.AddPatientAtBeginning(p);
			clrscr();
			  if (success)
			{
					 System.out.print(" Patient added: ");
				 }
		   else
				 {
					 // error
					 System.out.print(" Error: The queue is full. Cannot add patient:");
			}

			  OutputPatient(p);
				  System.out.print(" Press any key");
				  getch();
		 }
	 break;

	  case 3: // Take out patient for operation
	 p = q.argvalue.GetNextPatient();
	 clrscr();
	 if (p.ID[0])
		{
		   System.out.print(" Patient to operate: ");
		   OutputPatient(p);
		}
	 else
		{
		   System.out.print(" There is no patient to operate.");
		}
		   System.out.print(" Press any key");
		   getch();
		   break;
case 4: // Remove dead patient from queue
	 p = InputPatient();
	 if (p.ID[0])
	   {
			success = q.RemoveDeadPatient(p);
			clrscr();
			  if (success)
			  {
				   System.out.print(" Patient removed: ");
			  }
			  else
			  {
				   // error
				   System.out.print(" Error: Cannot find patient: ");
			  }
		   OutputPatient(p);
			System.out.print(" Press any key");
			getch();
	   }
	 break;

	  case 5: // List queue
	 clrscr();
	 q.OutputList();
	 System.out.print(" Press any key");
	 getch();
	 break;

	 }
	  }
}
//----------------------------------------------------------------------------------------
//	Copyright © 2006 - 2009 Tangible Software Solutions Inc.
//	This class can be used by anyone provided that the copyright notice remains intact.
//
//	This class is used to simulate the ability to pass arguments by reference in Java.
//----------------------------------------------------------------------------------------
//public final class RefObject<T>
//{
//	public T argvalue;
//	public RefObject(T refarg)
//	{
//		argvalue = refarg;
//	}
//}
// main function defining queues and main menu
private static void Main()
{
   int i;
   int MenuChoice = 0;
   // define three queues
   queue[] departments = new queue[3];
   // set department names
   departments[0].DepartmentName = "Heart clinic";
   departments[1].DepartmentName = "Lung clinic";
   departments[2].DepartmentName = "Plastic surgery";

   while (MenuChoice != 4)
	{
			 // clear screen
			 clrscr();
			 // print menu
			 System.out.print(" Welcome to Software City Hospital");
			 System.out.print(" Please enter your choice: ");
		  for (i = 0; i < 3; i++)
		{
			// write menu item for department i
			System.out.print(" +  ");
			System.out.print((i+1));
			System.out.print(":  ");
			System.out.print(departments[i].DepartmentName);
		}
			System.out.print(" 4:  Exit ");
			// get user choice
			MenuChoice = ReadNumber();
			// is it a department name?
			  if (MenuChoice >= 1 && MenuChoice <= 3)
			{
			 // call submenu for department
			 // (using pointer arithmetics here:)
			 DepartmentMenu (departments + (MenuChoice-1));
			}
	}
}
}