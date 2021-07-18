Input Ideas

--------------------------------------------------------------------------------

For this one, the numbers represent the ports, starting from 0 and going to n,
in this case, being equal to 9.

  0 1 2 3 4 5 6 7 8 9
0 0 0 0 1 0 0 0 0 0 0
1 0 0 0 0 1 0 0 0 0 0
2 0 0 0 0 0 1 0 0 0 0
3 0 0 0 0 0 0 1 0 0 0
4 0 0 0 0 0 0 1 0 0 0
5 0 0 0 0 0 0 1 0 0 0
6 0 0 0 0 0 0 0 1 0 0
7 0 0 0 0 0 0 0 0 1 0
8 0 0 0 0 0 0 0 0 0 1
9 0 0 0 0 0 0 0 0 0 0

Note that a row that is all 0 always marks the end of the workflow.

This reads like the adjacency graphs from the lecture slides, so 0 is connected to 3, 1 is connected to 4, 2 is connected to 5, and so on.  In this case, we have modeled WD, so we can identify where the mean primitive workflow is located, since 3, 4, and 5 are all connected to 6, the output of the mean workflow.

Following this, the user needs to write a lot of things for us, including the types of all ports, including associated values if necessary.

0 Int 3
1 Int 5
2 Int 4
Mean
Sqrt

From my initial understanding, this should be all the user has to give us, since we know that all those data product inputs are connected to the ports of mean, which they do specify, and then there's only one output of mean, so the next thing is square root, and then we are done.  Due to the information we already know about the primitive workflows, the types can all be inferred.

The final file would look like this:

X 0 1 2 3 4 5 6 7 8 9
0 0 0 0 1 0 0 0 0 0 0
1 0 0 0 0 1 0 0 0 0 0
2 0 0 0 0 0 1 0 0 0 0
3 0 0 0 0 0 0 1 0 0 0
4 0 0 0 0 0 0 1 0 0 0
5 0 0 0 0 0 0 1 0 0 0
6 0 0 0 0 0 0 0 1 0 0
7 0 0 0 0 0 0 0 0 1 0
8 0 0 0 0 0 0 0 0 0 1
9 0 0 0 0 0 0 0 0 0 0

0 Int 3
1 Int 5
2 Int 4

Mean
Sqrt

I believe this could work, but I'll try a different example, like workflow WA.

X 0 1 2 3 4 5
0 0 1 0 0 0 0
1 0 0 1 0 0 0
2 0 0 0 1 0 0
3 0 0 0 0 1 0
4 0 0 0 0 0 1
5 0 0 0 0 0 0

0 Bool true

Not
Increment

In this case, it might seem difficult to understand where exactly the primitive workflows are located, since we seem to have a very basic matrix on our hands, but it shouldn't be, since we know that there's only 1 input.  This means that 0 being connected to 1 makes sense, and 1 has to be the input port of our first workflow, Not.  Then, there's only one path for anything to take after that, and it's easy to see how the ports line up.

Overall, this idea seems like it might work.  I will explore this method further in a separate branch, in which I only try to read from the file and see if I can get the appropriate data.
