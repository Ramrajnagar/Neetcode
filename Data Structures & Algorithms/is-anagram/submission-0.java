class Solution {
    public boolean isAnagram(String s, String t) {
        //first checking that both length is different if yesss then bhai wah to hoga hii nhiii wese hiii
        if(s.length()!=t.length()){
            return false;
        }
        int  charcount[]= new int[26];     //apn lower case ke liye hi bna rahe hai abhi
        //basically aapne ko s and t me char ki freq check karni hai and s se incre karna hai
        //and t me dicrement karna hai agar last me kuch nhiii bachta to ye anagram hoga agar
        // bachta hai to ye anagram nhii hoga
        for(int i=0;i<s.length(); i++){
            charcount[s.charAt(i)-'a']++;//increment freq of that character
            charcount[t.charAt(i)-'a']--;

        }
        for(int num:charcount){
            if(num!=0){
                return false;
            }
        }
        return true;


    }
}
