package ws1;
import java.util.Arrays; // Array.equals(array1, array2)

public class Palindrome {
	public static void main(String[] args){
		if(args.length > 0){ 
			for(String str : args){
				Stack stack = new Stack(str.length()); //call Stack constructor and reference it as stack
			
				
				for(int i = 0; i < str.length(); ++i){
					stack.push(str.charAt(i));
				}
				
				boolean palindrome = true;
				// reverse stack string using pop and push to reverse
				while(!stack.isEmpty()){ 
					for(int i = 0; i < str.length(); ++i){
						if((str.charAt(i)) == (stack.pop())){
							palindrome = true;
						}else
							palindrome = false;
					}
				}
				
				// comparing two arrays whether palindrome or not 
				if(palindrome){
					System.out.println("This is Palindrome!");
				}else{
					System.out.println("This is NOT Palindrome!");
				}				
			}
		}else{
			System.out.println("No commend line arguments found!");
		}
	}
}
