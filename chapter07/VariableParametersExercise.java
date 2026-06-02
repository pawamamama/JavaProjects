public class VariableParametersExercise {
    public static void main(String[] args) {
   			HspMethod hsp = new HspMethod();
			String result = hsp.showScore("王微信", 102.11, 110, 150.111, 167.9);
			System.out.println(result);	
		}

}
class HspMethod  {
	 public String showScore(String name,double... nums) {
	 		double totalScore = 0;
	 		for (int i = 0;i < nums.length ;i++ ) {
	 			totalScore += nums[i];
	 		}
	 		return name + nums.length + "门成绩总分为 = " +totalScore;
	 }
}