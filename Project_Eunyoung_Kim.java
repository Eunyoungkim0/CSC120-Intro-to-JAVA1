import java.util.Scanner;

public class Project_Eunyoung_Kim
{
   public static void main(String[] args)
   {
      int gSpeed = 0,
          cSpeed = 0,
          cCore  = 0,
          resolution = 0,
          numComputer = 0;
      double multiplier = 0.0,
             performance = 0.0;
      String sResolution = "",
             gRecommend = "",
             memory = "Computer Hardware Graphics Quality Recommendation Tool";
             
      final int RESOLUTION_1280_720 = 1,
                RESOLUTION_1920_1080 = 2,
                RESOLUTION_2560_1440 = 3,
                RESOLUTION_3840_2160 = 4;
                
      final double MULTIPLIER_1280_720 = 1.0,
                   MULTIPLIER_1920_1080 = 0.75,
                   MULTIPLIER_2560_1440 = 0.55,
                   MULTIPLIER_3840_2160 = 0.35;
                   
      final int PERFORMANCE_ULTRA = 17000,
                PERFORMANCE_HIGH = 15000,
                PERFORMANCE_MEDIUM = 13000,
                PERFORMANCE_LOW = 11000;
      
      //Create a Scanner object to read input
      Scanner input = new Scanner(System.in);
      
      //Get the user's input
      System.out.print("How many computers are being processed? ");
      numComputer = input.nextInt();
      
      while (numComputer < 0) {
         System.out.println("\nThe number of computers cannot be less than 0.");
         System.out.print("How many computers are being processed? ");
         numComputer = input.nextInt();
      }
      
      System.out.println("\n" + memory);
      
      for(int i=0; i<numComputer; i++){
         System.out.print("\nPlease enter the clock speed (in Megahertz) of your graphics card: ");
         gSpeed = input.nextInt();
         System.out.print("Please enter the clock speed (in Megahertz) of your processor: ");
         cSpeed = input.nextInt();
         System.out.print("Please enter the number of cores of your processor: ");
         cCore  = input.nextInt();
         
         System.out.print("What is the resolution of your monitor?\n" +
                            "\t1.1280x720\n" +
                            "\t2.1920x1080\n" +
                            "\t3.2560x1440\n" +
                            "\t4.3840x2160\n" +
                            "Please select from the options above: ");
         resolution = input.nextInt();
         
         //Determine multiplier value by the resolution      
         if(resolution == RESOLUTION_1280_720){
            multiplier = MULTIPLIER_1280_720;
            sResolution = "1280 x 720";
         }else if(resolution == RESOLUTION_1920_1080){
            multiplier = MULTIPLIER_1920_1080;
            sResolution = "1920 x 1080";
         }else if(resolution == RESOLUTION_2560_1440){
            multiplier = MULTIPLIER_2560_1440;
            sResolution = "2560 x 1440";
         }else if(resolution == RESOLUTION_3840_2160){
            multiplier = MULTIPLIER_3840_2160;
            sResolution = "3840 x 2160";
         }else{
            multiplier = 0.0;
            sResolution = "";
         }
         
         //Calculate the performance score
         performance = ((5 * gSpeed) + (cCore * cSpeed)) * multiplier;
         
         //Determine The Recommended Graphics Quality by the performance score
         if(performance > PERFORMANCE_ULTRA){
            gRecommend = "Ultra";
         }else if(performance > PERFORMANCE_HIGH){
            gRecommend = "High";
         }else if(performance > PERFORMANCE_MEDIUM){
            gRecommend = "Medium";
         }else if(performance > PERFORMANCE_LOW){
            gRecommend = "Low";
         }else{
            gRecommend = "Unable to play";
         }
         
         System.out.println("\nGPU Clock Speed: " + gSpeed + " MHz" +
                            "\nCPU Clock Speed: " + cSpeed + " MHz" +
                            "\nNumber of cores: " + cCore +
                            "\nMonitor Resolution: " + sResolution +
                            "\nPerformance Score: " + String.format("%,.3f", performance) +
                            "\nRecommended Graphics Quality: " + gRecommend);
      }
   }
}