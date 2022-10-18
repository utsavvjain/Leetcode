class Solution {
    public String countAndSay(int n) {
        StringBuilder sb=new StringBuilder();
        if(n==1) return "1";
        if(n==2) return "11";
        sb.append("11");
        for(int i=3;i<=n;i++){
            int count;
            StringBuilder t=new StringBuilder();
            char c=' ';
            for(int j=0;j<sb.length();j++){
                c=sb.charAt(j);
                count=1;
                while(j<sb.length()-1 && sb.charAt(j)==sb.charAt(j+1)) {
                    count++;
                    j++;
                }
                t.append(""+count+""+c);
            }
            sb=t;
        }
        return sb.toString();
    }
}