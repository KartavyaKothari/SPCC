import java.util.*;
class lr {
	static int j=0;
	static String[] ret(String s[],int n) {
		String answer[] = new String[10];
		for(int i = 0;i < n;i++) {
			String curr = s[i];
			String[] spl = curr.split("->");
			String ter = spl[0];
			String handles = spl[1];
			String handle[] = handles.split("\\|");
			String old_prod = "",new_prod = "";
			int isChanged = 0;
			for(String t : handle) {
				if(t.startsWith(ter)) {
					isChanged = 1;
					String alpha = t.substring(1,t.length());
					new_prod = ter + "'->" + alpha + ter + "'|eps";
					old_prod = ter + "->";
					for(String t1 : handle) {
						if(!t1.equals(t)) {
							old_prod = old_prod + t1 + ter + "'|";
						}
					}
					old_prod = old_prod.substring(0,old_prod.length()-1);
				}
			}
			if(isChanged == 0)
				answer[j++] = curr;
			else {
				answer[j++] = old_prod;
				answer[j++] = new_prod;
			}
		}	
		return answer;
	}
	public static void main(String ar[])
	{
		int i,n;
		Scanner sc = new Scanner(System.in);
		String production[] = new String[10];
		System.out.print("Enter number of production: ");
		n = sc.nextInt();
		sc.nextLine();
		for(i = 0;i < n;i++)
		{
			System.out.print("Enter production " + (i+1) + ": ");
			production[i] = sc.nextLine();
		}
		String s[] = ret(production,n);
		System.out.println("After removing left recurrsion:");
		for(i = 0;i < j;i++)
		{
			System.out.print(s[i] + "\n");
		}
	}
}