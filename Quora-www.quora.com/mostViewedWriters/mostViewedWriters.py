import unittest


def Function1(a, topicIds, answerIds):
    v = []
    j = 0
    i = 0
    while (j != len(topicIds)):
        while (i != len(topicIds[j])):
            if topicIds[j][i] == a:
                v.append(answerIds[j])
            i = i + 1
        i = 0
        j = j + 1
    return v


def sumfunction(v, v1):
    i = 0
    a = len(v1)
    while (i != len(v1)):
        if (v[0] == v1[i][0]):
            v1.append([v[0], v1.pop(i)[1] + v[1]])
            return v1
        i = i + 1
    if len(v1) == 0 or a == len(v1):
        v1.append(v)
    return v1


def Function2(v, views):
    j = 0;
    i = 0;
    k = 0
    v1 = []
    while (j != len(v)):
        while (i != len(v[j])):
            while (k != len(views)):
                if v[j][i] == views[k][0]:
                    sumfunction(views[k][1:], v1)
                k = k + 1
            i = i + 1
            k = 0
        i = 0
        j = j + 1
    output = sorted(v1, key=lambda point: (-point[1], point[0]))
    return output


def finalfunc(topicIds, answerIds, views):
    Set = set()
    v = []
    for j in topicIds:
        for i in j:
            Set.add(i)
    for item in sorted(Set):
        v.append(Function1(item, topicIds, answerIds))
    v1 = []
    for i in v:
        v1.append(Function2(i, views))
    return v1


class Unittest(unittest.TestCase):

    def test_finalfunc(self):
        topicIds = [[1, 2, 3], [2, 3, 4], [1, 4], [2, 3]]
        answerIds = [[6, 4], [1, 2], [5], [3]]
        views = [[2, 1, 2], [6, 3, 5], [3, 3, 0], [5, 1, 1], [4, 2, 3], [1, 4, 2]]
        result = finalfunc(topicIds, answerIds, views)
        topicIds = [[1, 2, 3]]
        answerIds = [[1]]
        views = [[1, 5, 3]]
        result1 = finalfunc(topicIds, answerIds, views)
        topicIds = [[], [], [1, 2], [], [2, 3]]
        answerIds = [[], [4], [6, 7, 8], [3], [1, 2]]
        views = [[7, 3, 2], [3, 1, 10], [1, 10, 10], [4, 8, 3], [6, 1, 1], [2, 1, 0], [8, 10, 1]]
        result2 = finalfunc(topicIds, answerIds, views)
        topicIds = [[555, 666, 777], [8, 1, 239], [239, 566, 1000]]
        answerIds = [[1, 2, 3], [239, 567], [566, 30, 8]]
        views = [[1, 18, 5], [239, 23, 37], [567, 23, 0], [566, 1, 23], [30, 18, 18], [8, 7, 20], [3, 239, 1],
                 [2, 18, 1]]
        result3 = finalfunc(topicIds, answerIds, views)
        self.assertEqual(result,
                         [[[3, 5], [2, 3], [1, 1]], [[3, 5], [2, 3], [1, 2], [4, 2]], [[3, 5], [2, 3], [1, 2], [4, 2]],
                          [[1, 3], [4, 2]]])
        self.assertEqual(result1, [[[5, 3]], [[5, 3]], [[5, 3]]])
        self.assertEqual(result2, [[[3, 2], [1, 1], [10, 1]], [[10, 11], [3, 2], [1, 1]], [[10, 10], [1, 0]]])
        self.assertEqual(result3, [[[23, 37]], [[23, 37]], [[23, 37], [1, 23], [7, 20], [18, 18]], [[18, 6], [239, 1]],
                                   [[1, 23], [7, 20], [18, 18]], [[18, 6], [239, 1]], [[18, 6], [239, 1]],
                                   [[1, 23], [7, 20], [18, 18]]])


if __name__ == "__main__":
    unittest.main()
