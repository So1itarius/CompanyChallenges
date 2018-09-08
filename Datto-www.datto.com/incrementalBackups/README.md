One of the easiest ways to back up files is with an incremental backup. This method only backs up files that have changed since the last backup.

You are given a list of changes that were made to the files in your database, where for each valid i, changes[i][0] is the timestamp of the time the change was made, and changes[i][1] is the file id.

Knowing the timestamp of the last backup lastBackupTime, your task is to find the files which should be included in the next backup. Return the ids of the files that should be backed up as an array sorted in ascending order.
