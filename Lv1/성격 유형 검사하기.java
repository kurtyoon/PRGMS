class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int scoreR = 0, scoreT = 0, scoreC = 0, scoreF = 0, scoreJ = 0, scoreM = 0, scoreA = 0, scoreN = 0;
        
        for (int i = 0; i < survey.length; i++) {
            String sur = survey[i];
            String type = "";
            
            if (choices[i] > 4) type = sur.substring(1, 2);
            else type = sur.substring(0, 1);
            
            int score = Math.abs(choices[i] - 4);
            
            switch (type) {
                case "R": scoreR += score; break;
                case "T": scoreT += score; break;
                
                case "C": scoreC += score; break;
                case "F": scoreF += score; break;
                    
                case "M": scoreM += score; break;
                case "J": scoreJ += score; break;
                
                case "N": scoreN += score; break;
                case "A": scoreA += score; break;
            }
        }
        String a = "", b = "", c = "", d = "";
        if (scoreT > scoreR) a = "T";
        else a = "R";
        
        if (scoreF > scoreC) b = "F";
        else b = "C";
        
        if (scoreM > scoreJ) c = "M";
        else c = "J";
        
        if (scoreN > scoreA) d = "N";
        else d = "A";
        
        answer = a+b+c+d;
        return answer;
    }
}