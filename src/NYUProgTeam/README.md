

### Sample Code of Standard Input:

####Java
```java
import java.io.*;  
import java.util.*;  
public class Main  
{
  public static void main (String args[]) throws Exception
  {
    Scanner cin = new Scanner(System.in);
    int a = cin.nextInt(), b = cin.nextInt();
    System.out.println(a + b);
  }
}
```
####C++
```C++
#include <iostream>
using namespace std;
int main()
{
  int a,b;
  cin >> a >> b;
  cout << a + b << endl;
  return 0;
}
```
###Judge's Verdicts
Depending on whether your solution is correct or not, the judge will reply with a verdict after you submit your program. A verdict can be one of the following:

- Accepted: Your program has produced correct answers on all test data, you have successfully solved the problem! \o/
- Wrong Answer: Your program's output on some test data is wrong. This is a common case as most things don't go as smoothly as we expect, do they? :( Typically, you may have a bug in your code. Just debug carefully and fix it. However it is also possible that your algorithm is wrong. That is, you are solving the task in a wrong way.
- Time Limit Exceeded: Your solution is not efficient enough and did not finish in the given time limit. Most programming problems at Progteam are about algorithms. In this case you must find a faster algorithm for this task! Efficiency is a key factor of the problems you see at Progteam. So always think about a solution's complexity before you go ahead and code it!
- Runtime Error: Your program did not terminate normally and aborted on error. This most of the time could be a segfault of accessing prohibited memory, e.g. array index out of bound. On some judges if you allocate too much memory, you might also get this error. Other possibilities include divide-by-zero, stack overflow, etc.