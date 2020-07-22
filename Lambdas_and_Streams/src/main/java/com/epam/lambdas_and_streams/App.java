package com.epam.lambdas_and_streams;

/**
 * Hello world!
 *
 */
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;

@FunctionalInterface
interface Palindrome{
	void ListOfPalindrome(List<String> list);
}
public class App implements Palindrome
{
	
	static boolean isPalin(String s)
	{
		return IntStream.range(0, s.length() / 2).noneMatch(i -> s.charAt(i) != s.charAt(s.length() - i - 1));
	}
	public void ListOfPalindrome(List<String> list)
	{
		System.out.println("Palindromes are :");
		Predicate<String> p = (s)->isPalin(s);
		for (String st:list) 
		{
            if (p.test(st)) 
                System.out.println(st); 
        } 
	}
	final static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
    	boolean flag=false;
    	while(true) {
    		System.out.println("Press 1 to Find Average of n numbers");
    		System.out.println("Press 2 to get required manipulated Strings");
    		System.out.println("Press 3 to print Palindromes from the given list of strings");
    		System.out.println("Enter 0 to exit");
    		int n=sc.nextInt();
    		int siz;
    		if(n > 3 || n < 0) {
    			System.out.println("Enter valid option");
    			App.main(null);
    		}
    		switch(n) {
    			case 1:
    			{
    				System.out.printf("Enter list size to get average of given numbers: ");
    		    	siz=sc.nextInt();
    		    	List<Integer> list=new ArrayList<>();
    		    	System.out.println("Enter list of numbers:");
    		    	for(int i=0;i<siz;i++)
    		    	{
    		    		System.out.printf("\nEnter %dth number: ",i+1);
    		    		list.add(sc.nextInt());
    		    	}
    		        ListAverage avg = new ListAverage();
    		        System.out.printf("\nThe average of given %d numbers is : %.2f\n",siz,avg.avg(list));
    		        System.out.println("****************************************************************************************************************");
    		        break;
    			}
    			case 2:{
    				System.out.println("Enter the number of string: ");
    				siz=sc.nextInt();
    				sc.nextLine();
    				List<String> list=new ArrayList<>();
    				System.out.println("Enter list of Strings:");
    				for(int i=0;i<siz;i++)
    		    	{
    		    		System.out.printf("\nEnter %dth string: ",i+1);
    		    		list.add(sc.nextLine());
    		    	}
    				ManipulateString man = new ManipulateString();
    				list=man.stringManipulate(list);
    				System.out.println("The String with required Conditions are:");
    				for(int i=0;i<list.size();i++)
    				{
    					System.out.println(list.get(i));
    				}
    				System.out.println("****************************************************************************************************************");
    				break;
    			}
    			case 3:{
    				System.out.println("Enter the number of string: ");
    				siz=sc.nextInt();
    				sc.nextLine();
    				List<String> list=new ArrayList<>();
    				for(int i=0;i<siz;i++)
    		    	{
    		    		System.out.printf("\nEnter %dth string: ",i+1);
    		    		list.add(sc.nextLine());
    		    	}
    				App p=new App();
    		        p.ListOfPalindrome(list);
    		        System.out.println("****************************************************************************************************************");
    				break;
    			}
    			default:
    				flag=true;
    				break;
    		}
    		if(flag) return;
    	}
    }
}
