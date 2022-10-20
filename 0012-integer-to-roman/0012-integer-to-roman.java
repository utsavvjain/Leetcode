class Solution {
    public String intToRoman(int num) {
        TreeMap<Integer,String> map=new TreeMap<>();
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");        
        Stack<String> stk=new Stack<>();
        int i=1;
        StringBuilder sb;
        while(num>0){
            int x=(num%10)*i;
            num=num/10;
            i=i*10;
            sb=new StringBuilder();
            if(x==4) stk.push("IV");
            else if(x==9) stk.push("IX");
            else if(x==40) stk.push("XL");
            else if(x==90) stk.push("XC");
            else if(x==400) stk.push("CD");
            else if(x==900) stk.push("CM");
            else{
                while(x>0){
                    if(map.containsKey(x)) {
                        sb.append(map.get(x));
                        break;
                    }
                    sb.append(map.floorEntry(x).getValue());
                    x-=map.floorKey(x);
                }
            }
            stk.push(sb.toString());
        }
        sb=new StringBuilder();
        while(!stk.isEmpty()) sb.append(stk.pop());
        return sb.toString();
    }
}