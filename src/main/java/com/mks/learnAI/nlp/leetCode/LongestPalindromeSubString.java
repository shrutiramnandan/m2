package com.mks.learnAI.nlp.leetCode;


class LongestPalindromeSubString {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("abccbcdes"));
    }

    static String longestPalindrome(String s){
        String res = "";
        for (int ax = 0; ax < s.length(); ax++){
            int orbit = 1;
            int lenght = 1;
            while(ax - orbit >= 0 && ax + orbit < s.length()){
                if(s.charAt(ax - orbit) == s.charAt(ax + orbit)){
                    orbit++;
                    lenght +=2;
                }else{
                    break;
                }
            }
            if(lenght > res.length()){
                int si = ax - lenght/2;
                res = s.substring(si, si + lenght);
            }
        }

        for (int ax = 0; ax < s.length(); ax++){
            int orbit = 1;
            int lenght = 0;
            while(ax - orbit +1 >= 0 && ax + orbit < s.length()){
                if(s.charAt(ax - orbit +1) == s.charAt(ax + orbit)){
                    orbit++;
                    lenght +=2;
                }else{
                    break;
                }
            }
            if(lenght > res.length()){
                int si = ax - lenght/2 + 1;
                res = s.substring(si, si + lenght);
            }
        }
        return res;
    }
}