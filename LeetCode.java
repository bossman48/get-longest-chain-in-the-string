import java.util.LinkedList;
import java.util.List;

public class LeetCode {

    public static String longestCommonPrefix(String[] strs){
        int firstWordLength = strs[0].length();
        List<String> result = new LinkedList<String>();
        String tempString="";
        int counter=0;
        for(int i=0;i<firstWordLength;i++){
            for(int j=1;j<strs.length;j++){
                char tempChar=strs[0].charAt(i);
                if(strs[j].indexOf(tempChar)>=0){
                    counter++;
                }
                else{
                    counter=0;
                }

            }
            if(counter==strs.length-1){
                tempString+=strs[0].charAt(i);
                counter=0;
                if(i==firstWordLength-1){
                    result.add(tempString);
                }
            }
            else{
                counter=0;
                if(tempString.length()>0)
                    result.add(tempString);
                tempString="";
            }
        }

        //check all list which has longest chain
        int highestchain=0;
        if(result.size()>0){
            int highestChainLenght=result.get(0).length();
            for(int i=1;i<result.size();i++){
                if(highestChainLenght<result.get(i).length()){
                    highestchain=i;
                    highestChainLenght=result.get(i).length();
                }
            }
            return result.get(highestchain);
        }
        else{
            return "";
        }

    }


    public static void main(String []args) {
        System.out.println("Hello World"); // prints Hello World
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));

        String[] strs2 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs2));

        String[] strs3 = {"flowerasd","flowasd","flightasd"};
        System.out.println(longestCommonPrefix(strs3));
    }



}
