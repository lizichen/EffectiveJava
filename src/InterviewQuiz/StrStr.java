package InterviewQuiz;


public class StrStr {
    public static void main(String[] args){
        String source = "abcdabcdefg";
        String target = "bcd";
        System.out.println("index: " + strStr(source, target));
    }

    public static int strStr(String source, String target) {

        int sourceLength = source.length();
        int targetLength = target.length();
        if(sourceLength < targetLength || sourceLength == 0 || targetLength == 0)
        {
            return -1;
        }

        for(int i=0; i<sourceLength; i++)
        {
            int foundIndex = 0;
            int currentSourceIndex = i;
            for(int j=0; j<targetLength; j++)
            {
                if(target.charAt(j) == (source.charAt(currentSourceIndex)))
                {
                    currentSourceIndex++;
                }
                else
                {
                    break;
                }
                if(j == targetLength-1)
                {
                    foundIndex = 1;
                }
            }
            if(foundIndex == 1)
            {
                return i;
            }
        }

        return -2;
    }

}


