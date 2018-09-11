import unittest


def troubleFiles(files, backups):
    a = []
    copy_queue = []
    errors = []
    er1 = []
    output = []
    logEandC = []
    for i in backups:
        for j in files:
            if j[0] <= i and (j not in logEandC):
                a.append(j)
        copy_queue = a.copy()
        s = [sum(i) for i in zip(*copy_queue)]
        a.clear()
        if len(copy_queue) != 0:
            for j in files:
                if j[0] <= i + s[1] and (j not in copy_queue) and (j not in logEandC):
                    errors.append(j)
        er1 = errors.copy()
        output.append(len(er1))
        logEandC = logEandC + er1 + copy_queue
        errors.clear()
    return output


class Unittest(unittest.TestCase):

    def test1_troubleFiles(self):
        files = [[461618501, 3], [461618502, 1], [461618504, 2], [461618506, 5], [461618507, 6]]
        backups = [461618501, 461618502, 461618504, 461618505, 461618506]
        result = troubleFiles(files, backups)
        self.assertEqual(result, [2, 0, 0, 0, 1])

    def test2_troubleFiles(self):
        files = [[461618500, 7], [461618500, 1], [461618505, 9], [461618510, 4], [461618515, 5], [461618518, 9]]
        backups = [461618504, 461618509]
        result = troubleFiles(files, backups)
        self.assertEqual(result, [2, 0])

    def test3_troubleFiles(self):
        files = [[461618504, 2]]
        backups = [461618501, 461618502, 461618504, 461618505, 461618506]
        result = troubleFiles(files, backups)
        self.assertEqual(result, [0, 0, 0, 0, 0])

    def test4_troubleFiles(self):
        files = [[461618501, 3], [461618502, 1], [461618504, 2], [461618506, 5], [461618507, 6]]
        backups = [461618504]
        result = troubleFiles(files, backups)
        self.assertEqual(result, [2])


if __name__ == "__main__":
    unittest.main()
