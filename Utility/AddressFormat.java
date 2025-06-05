
package Utility;

public class AddressFormat {

    public static String[] splitAddressLine(String storeAddress){
        
        String[] storeAddressArray = new String[3];     

                //split store address
        String[] parts = storeAddress.split(", ");
        
        switch(parts.length){
            case 4 -> { storeAddressArray[0] = parts[0] +"," +  parts[1] + ",";
                        storeAddressArray[1] = parts[2] + ",";
                        storeAddressArray[2] = parts[3];
            }
            case 5 -> { storeAddressArray[0] = parts[0] +"," +  parts[1] + "," + parts[2] + ",";
                        storeAddressArray[1] = parts[3] + ",";
                        storeAddressArray[2] = parts[4];
            }
        }
        
        return storeAddressArray;
        
    }    
    
}
