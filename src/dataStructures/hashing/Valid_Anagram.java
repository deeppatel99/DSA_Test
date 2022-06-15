package dataStructures.hashing;

import java.lang.reflect.Array;
import java.util.HashMap;

public class Valid_Anagram {
    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";
        boolean success = true;

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);
            if(!hashMap.containsKey(ch)){
                success = false;
            }else if(hashMap.get(ch) == 1){
                hashMap.remove(ch);
            }else {
                hashMap.put(ch, hashMap.get(ch) - 1);
            }
        }

        if (success){
            System.out.println("Strings are anagram");
        }else {
            System.out.println("Not an anagram");
        }
    }
}
