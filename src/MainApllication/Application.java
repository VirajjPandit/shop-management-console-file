package MainApllication;

	import java.io.IOException;
	import java.util.Scanner;
    import ProductManagement.Product_Management;
    import UserManagement.User_Management;
   

    public class Application {
    	public static void main(String [] args) throws IOException {
    		Scanner S = new Scanner (System.in);
    		boolean Canikeeprunnningtheprogram = true;
    		

    		System.out.println("...>>> WELCOME TO SHOP MANEGEMENT SYSTEM <<<...");
    		System.out.println("\n");
    		System.out.println("Enter the UserName :");
    		String UserName = S.nextLine();
    		System.out.println("Enter the Password");
    		String Password = S.nextLine();
    		
    		if(!User_Management.LoginProcess(UserName ,Password)) {
    			System.out.println("Login Failed Program closed");
    			return;
    		}
    		while(Canikeeprunnningtheprogram) {
    			System.out.println("...>>> WELCOME TO SHOP MANEGEMENT SYSTEM <<<...");
    			System.out.println("1.User Mangement");
    			System.out.println("2.Shop Mangement");
    			System.out.println("3.Quit");
    			
    			int optionselectbyUser =S.nextInt();
    			int OptionSelectByUser = S.nextInt();

    			if (OptionSelectByUser == 1) {
    				User_Management.User_Mangement();

    			} else if (OptionSelectByUser == 2) {
    				Product_Management.ProductMangement();

    			} else if (OptionSelectByUser == 3) {
    				System.out.println("!...Program Closed...!");
    				Canikeeprunnningtheprogram = false;
    			}
    		}
    	}

    }
		