package leetcode;

/**
 * https://leetcode.com/problems/multiply-strings/
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative. 
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
        		return "0";
        }

        List<Integer> result = new ArrayList<Integer>();

        for(int i=0; i<num1.length(); i++){
        		List<Integer> tmpList = new ArrayList<Integer>();
        		for(int j=0; j<i; j++){
        			tmpList.add(0);
        		}

        		multiply(tmpList, num2, Integer.parseInt(Character.toString(num1.charAt(num1.length()-1-i))));
        		result = merge(result, tmpList);
        }

        return toString(result);
     }

     private List<Integer> merge(List<Integer> list1, List<Integer> list2){
     	
     	int i = 0;
     	List<Integer> result = new ArrayList<Integer>();

     	int carring = 0;
     	while(i < list1.size() || i < list2.size()){

     		int n1 = i < list1.size() ? list1.get(i) : 0;
     		int n2 = i < list2.size() ? list2.get(i) : 0;

     		int sum = n1+n2+carring;
     		result.add(sum % 10);
     		carring = sum / 10;

     		i++;
     	}

     	if(carring > 0){
     		result.add(carring);
     	}

     	return result;

     }

     private void multiply(List<Integer> result, String nums, int n){
     	int carring = 0;

     	for(int i=nums.length()-1; i>=0; i--){

     		int r = n * Integer.parseInt(Character.toString(nums.charAt(i))) + carring;

     		result.add(r%10);
     		carring = r / 10;
     	}

     	if(carring > 0){
     		result.add(carring);
     	}

     }

     private String toString(List<Integer> list){
     	StringBuilder sb = new StringBuilder();

     	for(int i=list.size() - 1; i>=0; i--){
     		sb.append(list.get(i));
     	}

     	return sb.toString();
     }
}