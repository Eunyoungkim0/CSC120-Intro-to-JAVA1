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
             performance = 0.0,
             highPerformance = 0.0,
             lowPerformance = 0.0;
      String sResolution = "",
             gRecommend = "";                   
      
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
      
      //Display the title
      displayTitle();
            
      for(int i=0; i<numComputer; i++){
         System.out.print("\nPlease enter the clock speed (in Megahertz) of your graphics card: ");
         gSpeed = input.nextInt();
         
         while(gSpeed < 800 || gSpeed > 2000){
            System.out.println("The clock speed of graphics card should be between 800 and 2000.");
            System.out.print("Please enter the clock speed (in Megahertz) of your graphics card: ");
            gSpeed = input.nextInt();
         }
         
         System.out.print("Please enter the clock speed (in Megahertz) of your processor: ");
         cSpeed = input.nextInt();
         
         while(cSpeed < 1000 || cSpeed > 5500){
            System.out.println("The clock speed of processor should be between 1000 and 5500.");
            System.out.print("Please enter the clock speed (in Megahertz) of your processor: ");
            cSpeed = input.nextInt();
         }
         
         System.out.print("Please enter the number of cores of your processor: ");
         cCore  = input.nextInt();
         
         while(cCore < 1 || cCore > 16){
            System.out.println("The number of cores should be between 1 and 16.");
            System.out.print("Please enter the number of cores of your processor: ");
            cCore  = input.nextInt();
         }
         
         System.out.print("What is the resolution of your monitor?\n" +
                            "\t1.1280x720\n" +
                            "\t2.1920x1080\n" +
                            "\t3.2560x1440\n" +
                            "\t4.3840x2160\n" +
                            "Please select from the options above: ");
         resolution = input.nextInt();
         
         while(resolution < 1 || resolution > 4){
            System.out.print("Invalid number! Please select from the options above: ");
            resolution = input.nextInt();
         }
         
         //Decide the resolution based on resolution
         sResolution = getResolutionString(resolution);
         //Decide the multiplier based on resolution
         multiplier = getMultiplierValue(resolution);
         //Calculate the performance score
         performance = calculatePerformanceScore(gSpeed, cSpeed, cCore, multiplier);
         
         if(i==0){
            highPerformance = performance;
            lowPerformance = performance;
         }else{
            if(performance > highPerformance){
               highPerformance = performance;
            }
            if(performance < lowPerformance){
               lowPerformance = performance;
            }
         }
         
         //Determine The Recommended Graphics Quality by the performance score
         gRecommend = getRecommendedQuality(performance);
         
         //Display the result of each computer
         displayInformation(gSpeed, cSpeed, cCore, sResolution, performance, gRecommend);
      }
      
      System.out.printf("\nThe highest performance score was: %,.3f\n", highPerformance);
      System.out.printf("The lowest performance score was: %,.3f", lowPerformance);
   }
   
   /** 
      The displayTitle method displays the title.
   */
   public static void displayTitle() {
      String memory = "Computer Hardware Graphics Quality Recommendation Tool";
      System.out.println("\n" + memory);
   }
   
   /** 
      The getResolutionString method returns the appropriate String representation of the monitor resolution.
      @param resolution The resolution of computer that user selected.
      @return sResolution The string type of resolution that will be showed.
   */
   public static String getResolutionString(int resolution) {
      String sResolution = "";
      
      final int RESOLUTION_1280_720 = 1,
                RESOLUTION_1920_1080 = 2,
                RESOLUTION_2560_1440 = 3,
                RESOLUTION_3840_2160 = 4;
   
      if(resolution == RESOLUTION_1280_720){
         sResolution = "1280 x 720";
      }else if(resolution == RESOLUTION_1920_1080){
         sResolution = "1920 x 1080";
      }else if(resolution == RESOLUTION_2560_1440){
         sResolution = "2560 x 1440";
      }else if(resolution == RESOLUTION_3840_2160){
         sResolution = "3840 x 2160";
      }else{
         sResolution = "";
      }
      
      return sResolution;
   }
   
   /** 
      The getMultiplierValue method returns the appropriate multiplier value.
      @param resolution The resolution of computer that user selected.
      @return multiplier The multiplier that will be used to calculate performance.
   */
   public static double getMultiplierValue(int resolution) {
      double multiplier = 0.0;
      
      final int RESOLUTION_1280_720 = 1,
                RESOLUTION_1920_1080 = 2,
                RESOLUTION_2560_1440 = 3,
                RESOLUTION_3840_2160 = 4;
      
      final double MULTIPLIER_1280_720 = 1.0,
                   MULTIPLIER_1920_1080 = 0.75,
                   MULTIPLIER_2560_1440 = 0.55,
                   MULTIPLIER_3840_2160 = 0.35;
                   
      if(resolution == RESOLUTION_1280_720){
         multiplier = MULTIPLIER_1280_720;
      }else if(resolution == RESOLUTION_1920_1080){
         multiplier = MULTIPLIER_1920_1080;
      }else if(resolution == RESOLUTION_2560_1440){
         multiplier = MULTIPLIER_2560_1440;
      }else if(resolution == RESOLUTION_3840_2160){
         multiplier = MULTIPLIER_3840_2160;
      }else{
         multiplier = 0.0;
      }
      
      return multiplier;
   }
   
   /** 
      The calculatePerformanceScore method calculates and returns the performance score.
      @param gSpeed The clock speed of graphics card.
      @param cSpeed The clock speed of processor.
      @param cCore The number of processor cores.
      @param multiplier The multiplier based on resolution.
      @return performance The performance that is calculated.
   */
   public static double calculatePerformanceScore(int gSpeed, int cSpeed, int cCore, double multiplier) {
      double performance = 0.0;
      
      performance = ((5 * gSpeed) + (cCore * cSpeed)) * multiplier;
      
      return performance;
   }
   
   /** 
      The getRecommendedQuality method returns the recommended graphics quality.
      @param performance The performance that was calculated.
      @return gRecommend The recommened graphics quality.
   */
   public static String getRecommendedQuality(double performance) {
   
      String gRecommend = "";
      
      final int PERFORMANCE_ULTRA = 17000,
                PERFORMANCE_HIGH = 15000,
                PERFORMANCE_MEDIUM = 13000,
                PERFORMANCE_LOW = 11000;
   
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
      
      return gRecommend;
   }
   
   /** 
      The displayInformation method prints out the information for a single computer.
      @param gSpeed The clock speed of graphics card.
      @param cSpeed The clock speed of processor.
      @param cCore The number of processor cores.
      @param sResolution The resolution of computer selected by user.
      @param performance The performance that was calculated.
      @param gRecommend The recommened graphics quality.
   */
   public static void displayInformation(int gSpeed, int cSpeed, int cCore, String sResolution, double performance, String gRecommend) {
   
      System.out.println("\nGPU Clock Speed: " + gSpeed + " MHz");
      System.out.println("CPU Clock Speed: " + cSpeed + " MHz");
      System.out.println("Number of cores: " + cCore);
      System.out.println("Monitor Resolution: " + sResolution);
      System.out.printf("Performance Score: %,.3f\n", performance);
      System.out.println("Recommended Graphics Quality: " + gRecommend);
   }
}