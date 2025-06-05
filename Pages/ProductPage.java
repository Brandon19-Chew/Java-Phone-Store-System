
package Pages;

import Modules.Product.addcategory;
import Modules.Product.addproduct;
import Modules.Product.deletecategory;
import Modules.Product.deleteproduct;
import Modules.Product.displaycategory;
import Modules.Product.displayproduct;
import Utility.SystemInput;


public class ProductPage extends BasePage {
    
    
    @Override
    public void displayMenu(){
        
        do{
            
            System.out.println("+=======================================+");
            System.out.println("|				  	|");
            System.out.println("|	1.Add New Product	  	|");
            System.out.println("|	2.Product List   	  	|");
            System.out.println("|	3.Delete Product	  	|");
            System.out.println("|				  	|");            
            System.out.println("|=======================================|");
            System.out.println("|				  	|");           
            System.out.println("|	4.Add New Category	  	|");
            System.out.println("|	5.Category List 	  	|");
            System.out.println("|	6.Delete Category	  	|");            
            System.out.println("|	0.Exit			  	|");
            System.out.println("|				  	|");
            System.out.println("+=======================================+");

            action = SystemInput.inputForSwtich();

            switch(action){
                
                case 1 -> addproduct.addProduct();

                case 2 -> displayproduct.displayAllProduct();

                case 3 -> deleteproduct.deleteCategory();

                case 4 -> addcategory.addNewCategory();
               
                case 5 -> displaycategory.displayAllCategories();
              
                case 6 -> deletecategory.deleteSelectedCategory();
             
                default -> System.out.println("The digit is invalid, please enter again."); 
                
                case 0 -> {return;}
            }
        
        
        }while(action != 0);
        

    }
    
}
