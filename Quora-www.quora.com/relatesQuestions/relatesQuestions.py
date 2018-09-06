import unittest
import time


def RecursivFunc(i, t, d, r, edges):
    get = d.get
    q = len(get(i))
    r.add(i)
    lenr = len(r)
    lent = len(t)
    if lenr != 1 and q > 1:
        q = q - 1
    if i != lent:
        q1 = get(i)
        sum = 0
        for j in q1:
            if j not in r:
                sum = sum + RecursivFunc(j, t, d, r, edges)
        return t[i] + sum / q
    else:
        return t[i]


def relatedQuestions(n, t, edges):
    if n == 1:
        return 0
    a = []
    d = {}
    a1 = []
    update = d.update
    get = d.get
    copy = a.copy
    clear = a.clear
    from functools import reduce
    append = a.append
    len_edges = len(edges)
    len_edgesj = len(edges[0])
    k = 0
    j = 0
    merge = lambda lst: reduce(lambda a, b: a.extend(merge(b)) or a if isinstance(b, list) else a.append(b) or a, lst,
                               [])
    while j != len_edges:
        while k != len_edgesj:
            if k == 1:
                if get(edges[j][k]) is not None:
                    append(get(edges[j][k]))
                append(edges[j][k - 1])
                # print(a)
                update([(edges[j][k], merge(copy()))])
                clear()
            elif k == 0:
                if get(edges[j][k]) is not None:
                    append(get(edges[j][k]))
                append(edges[j][k + 1])
                update([(edges[j][k], merge(copy()))])
                clear()
            k = k + 1
        j = j + 1
        k = 0
    r = set()
    append = a1.append
    lent = len(t)
    i = 0
    clear = r.clear
    while i != lent:
        append(RecursivFunc(i, t, d, r, edges))
        clear()
        i = i + 1
    return a1.index(min(a1))


class Unittest(unittest.TestCase):

    def test_relatedQuestions(self):
        n = 10
        t = [9, 2, 7, 14, 4, 26, 21, 18, 39, 33]
        edges = [[2, 7], [0, 9], [3, 5], [4, 7], [0, 2], [8, 5], [3, 6], [2, 1], [5, 0]]
        result = relatedQuestions(n, t, edges)
        n = 5
        t = [2, 2, 1, 2, 2]
        edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
        result1 = relatedQuestions(n, t, edges)
        n = 5
        t = [2, 1, 13, 1, 12]
        edges = [[3, 0], [3, 2], [4, 1], [3, 1]]
        result2 = relatedQuestions(n, t, edges)
        n = 5
        t = [3, 11, 3, 18, 3]
        edges = [[3, 1], [4, 2], [0, 3], [4, 1]]
        result3 = relatedQuestions(n, t, edges)
        n = 10
        t = [9, 2, 7, 14, 4, 26, 21, 18, 39, 33]
        edges = [[2, 7], [0, 9], [3, 5], [4, 7], [0, 2], [8, 5], [3, 6], [2, 1], [5, 0]]
        result4 = relatedQuestions(n, t, edges)
        import random
        n = 900
        t = [random.randint(0, 5000) for i in range(n)]
        edges = []
        for i in range(n - 1):
            edges.append([i, i + 1])
        start_time = time.time()
        relatedQuestions(n, t, edges)
        r = time.time() - start_time
        print(r)
        self.assertEqual(result, 2)
        self.assertEqual(result1, 2)
        self.assertEqual(result2, 3)
        self.assertEqual(result3, 4)
        self.assertEqual(result4, 2)
        self.assertLess(r, 1.4)


if __name__ == "__main__":
    unittest.main()
