public class ReduceTheCode {
	//Each method must perform the same action as it currently does as seen by an outside class
	//You are free to change the way in which it does it the work
	//You can delete these comments and the extra blank lines
	private int foo;
	private int bar;
	private int [][] tao;
	public ReduceTheCode(){
		foo = 5;
		bar = foo * 5;
		tao = new int[foo][];
		for (int i = 0; i < foo; i++){
			tao[i] = new int[bar];
			for (int j = 0; j < bar; j++){
				tao[i][j] = foo+bar;
			}
		}
	}
	public int getFoo(){
		tao = new int[foo][];
		for (int i = 0; i < foo; i++){
			tao[i] = new int[bar];
			for (int j = 0; j < bar; j++){
				tao[i][j] = foo+bar;
			}
		}
		return foo;
	}
	public void setVariables(int a){
		foo = a;
		bar = foo * 5;
		tao = new int[foo][];
		for (int i = 0; i < foo; i++){
			tao[i] = new int[bar];
			for (int j = 0; j < bar; j++){
				tao[i][j] = foo+bar;
			}
		}
	}
	public static int a(int i){
		if(i >= 0 && i <= 20){
			return 12 + i;
		}
		else{
			return -1;
		}
	}
	public static int b(int i){
		if(i >= 0 && i <= 20){
			int b[]= {3493,3011,6881,5413,2144, 1728,8383,2970,8226,2396,4106,9201,9582,7412, 4091,7291,1747,9922,4647,6070,9946};
			return b[i];
			}
		return -1;
		}
	public static void c(int i){
	}
}