On Quora, a question can have a variety of user-submitted answers. These questions are assigned topic tags to improve discoverability, and views are tracked at the answer level to identify the top answers and surface them in the the feed and search results.

More specifically:

-A user can write an answer to a question;

-A question can have multiple answers;

-A question can be assigned multiple topics;

For example, the question "How many software engineers work at Google as of 2017?" is tagged with the topics "Silicon Valley", "Google", and "Software Engineering".

-An answer can get views.

The Most-Viewed Writers for a given topic are the top 10 Quora users whose answers to questions tagged with that topic are viewed the most. (When fewer than 10 users have submitted answers to questions tagged with a particular topic, the Most-Viewed Writers for that topic would include all the users who have contributed answers, regardless of whether or not their answers have any views.) An answer must belong to a question that is tagged with a given topic to be considered to be within that topic.
Given this system, compute the Most Viewed Writers for each topic, ordered from the smallest topic_id to the largest one. If two users have the same number of views, the user with the smaller user_id should come first.

For a specific topic_id, the set of Most-Viewed Writers should be returned in the following format:

<user_id_1> <views_1>

<user_id_2> <views_2>

...

<user_id_N> <views_N>

where:

1)user_id_i is the ID of the ith user in the set;

2)views_i is the total number of views the user gets across all their answers in that topic;

3)Note that views_i may be equal to 0. If a user posted an answer that didn't get any views, they can still be included in the Most Viewed Writers list if there are fewer than 10 users who have contributed answers for that topic;

4)N is the number of Most Viewed Writers for the topic topic_id.
