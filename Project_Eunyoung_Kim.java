import java.util.Scanner;

public class Project_Eunyoung_Kim
{
   public static void main(String[] args)
   {
      int gSpeed = 0;
      int cSpeed = 0;
      int cCore  = 0;
      int resolution = 0;
      double multiplier = 0.0;
      double performance = 0.0;
      String gRecommend = "";
      
      //Create a Scanner object to read input
      Scanner input = new Scanner(System.in);
      
      //Get the user's input
      System.out.println("Enter the clock speed (in Megahertz) of their graphics card (GPU)");
      gSpeed = input.nextInt();
      System.out.println("Enter the clock speed (in Megahertz) of their processor (CPU)");
      cSpeed = input.nextInt();
      System.out.println("Enter the number of cores that their processor (CPU) has");
      cCore  = input.nextInt();
      
      System.out.println("Select the resolution of your monitor\n" +
                         "1. 1280 x 720\n" +
                         "2. 1920 x 1080\n" +
                         "3. 2560 x 1440\n" +
                         "4. 3840 x 2160\n");
      resolution = input.nextInt();
      
      //Determine multiplier value by the resolution
      switch(resolution)
      {
         case 1:
            multiplier = 1.0;
            break;
         case 2:
            multiplier = 0.75;
            break;
         case 3:
            multiplier = 0.55;
            break;
         case 4:
            multiplier = 0.35;
            break;
         default:
            multiplier = 0.0;
      }
      
      performance = ((5 * gSpeed) + (cCore * cSpeed)) * multiplier;
      
      if(performance > 17000){
         gRecommend = "Ultra";
      }else if(performance > 15000){
         gRecommend = "High";
      }else if(performance > 13000){
         gRecommend = "Medium";
      }else if(performance > 11000){
         gRecommend = "Low";
      }else{
         gRecommend = "Unable to play";
      }
   }
}