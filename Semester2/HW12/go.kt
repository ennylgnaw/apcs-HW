Lynne Wang
APCS2 pd1
HW #12: __+3R|\/|1|\|4|_  1|_|_|\|3$$__
2018-03-02

0. Multiple class definitions in a single .java file are allowed so long as
only one class is given a "public" or "private" tag (the file must be named
after this class). These extra classes are only accessible within the file.

1. Command line arguments are processed in the main method; the args of a
string array. The inputted strings are parsed into ints (so long as the
user enters in valid inputs).

2. If no command line arguments are given, the default values will be called:
size 8 board and time delay of 500 milliseconds.

3. The recursion makes it so that every number from the size of the array, n,
to n^2 will be printed. It is not necessary for the animation; you could
just print out values from a hardcoded array and have time delays between
printing or you could use iteration to go through a range of values.

4. When I run this, I expect to see an 8 by 8 board with a moat of -1's.
Inside the 8 by 8 board positions should have 0's, which will be updated
every 500 milliseconds with a larger number. The board should start with
n and end with n^2.

5. I expect this to run 500 * (n^2 - n + 1) milliseconds, plus a little more
when you take into account initialization in the beginning. The run time should
be O(n^2).

6. ANSI stands for American National Standards Institute. This organization
creates standards for the computer industry. ANSI escape codes, in particular,
have standardized codes to control output (location, color, etc.) in terminals.

7. My expectations met my observations rather closely. Howeber, the boards
ended at n^2 + 1 instead. Also, numbers were always placed randomly, meaning
there'd be spaces that were changed multiple times and spaces that weren't
changed at all.

8. I might adapt this framework to animate a probing for a Knight's tour. The
number printed out would correspond to the nth move the knight has made, and
the animation would continue until all spots on the board were filled. The
knight would not move randomly, however, and it would not land on a position
that it had already landed on.

Algo:
1) Check to see if all spots on the board have been traversed.
2) If spots all traversed, print solution
3) Start at a point on the perimeter of the board.
4) If spots not all traversed, from the most recent knight position,
   a) make another move with the knight if moves can be made (knight can
      make 8 moves).
   b) If moves can't be made, remove the knight from the current position
      and try other moves.
   c) If no paths can be found, return false. If the first item we
      placed on the board returns false, no solutions exist.