For the purposes of this problem, suppose that Quora has n questions, and question i takes ti time to read. 
Some questions are related to each other. If we connect related questions by edges, we get an undirected graph such that there exists exactly one path from any question to another. In other words, the graph of related questions is a tree.

Every time Steve reads a question, he will see a list of questions that are directly related to it and will navigate at random to one that he hasn't read yet (all related questions have an equal chance of being viewed). Steve will stop reading once there are no unread related questions left.

Given the number of related questions n, an array that contains the estimated reading time for each question t, and an array containing the pairs of related questions edges, which question should we show to Steve first so that we minimize his total expected reading time? It is guaranteed that there is one unique question that is optimal.

Here's how the total expected time for question i with q related questions is calculated:

-Take the time ti that it will take Steve to read this question;

-Recursively calculate the expected_timej for each related question j without considering the ith question;

-Add to ti the sum of expected_timej for each j, divided by q, i.e. the answer will be equal to ti + sum(expected_timej) / q.
