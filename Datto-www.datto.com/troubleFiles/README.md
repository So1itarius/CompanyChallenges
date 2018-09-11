Backing up files is a pretty straightforward process most of the time, but it can get much more complicated when you are backing up to the cloud. Let's assume that Datto backs up files in the cloud in batches. This works well until new files are added to the queue while a batch is already in the process of being backed up. We call these files trouble files, and identifying them is important when it comes to optimizing backup efficiency.

You are given an array, files, representing all files that need a backup, where:

-files[i][0] is the time a file was added to the backup queue;

-files[i][1] is the size of the file.

You are also given a sorted array, backups, representing multiple completed backups.

backups[i] is the time the ith backup was started. Each backup only backs up files that were not backed up or marked as trouble by the previous backups. If a backup started or finished at the same moment a file was added, assume that appending the new file to the queue occurred first. You can also assume that the time it takes to back up a list of files is equal to the sum of the sizes of those files.

Your goal is to calculate the number of trouble files for each completed backup, to estimate how severely they impacted the efficiency of the backup.
