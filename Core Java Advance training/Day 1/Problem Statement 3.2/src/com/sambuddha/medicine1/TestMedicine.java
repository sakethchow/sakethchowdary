package com.sambuddha.medicine1;
import java.util.Scanner;
import com.sambuddha.medicine.MedicineInfo;
import com.sambuddha.medicine.Ointment;
import com.sambuddha.medicine.Syrup;
import com.sambuddha.medicine.Tablet;
public class TestMedicine 
{
	public static void main(String[] args)
	{
       MedicineInfo[] medicines = new MedicineInfo[10];

       Scanner scannerObj = new Scanner (System.in);

       int count = 0;
       int len = medicines.length;

       while (true)
       {
         if (count == len)
          break;

           System.out.print("Enter 1,2 or 3: ");

            int choice = scannerObj.nextInt();
             switch(choice) 
             {
               case 1: medicines[count] =  new Tablet ();
                 break;

                case 2: medicines[count] = new Syrup();
                   break;

                  case 3: medicines[count] =  new Ointment();
                    break;

                   default:System.out.println("wrong Choice !!");
                     continue;
               }
                  count+=1;
       }     
       
       System.out.println(" see your Medicine behaviour below");

    		   for (MedicineInfo medicine:medicines)
    		   {
    			   medicine.displayLabel();
    		   }
    		   scannerObj.close();
	}
}