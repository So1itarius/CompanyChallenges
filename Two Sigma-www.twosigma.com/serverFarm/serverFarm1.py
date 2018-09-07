import unittest

def massive_part(servers, jobs, j):
    output = []
    s = servers
    servers = j + servers
    while j < len(jobs):
        output.append(jobs[j])
        j = j + 1
        if j == servers:
            break
    if j > s:
        output = sorted(output, key=lambda point: (point[0], point[1]))
    return output


def special_sort(h, h1):
    g = []
    while len(h1) > 0:
        g.append(
            [min(h, key=lambda point: (point[0], point[1], point[-1]))[0] +
             max(h1, key=lambda point: (point[0], -point[-1]))[0],
             min(h, key=lambda point: (point[0], point[1], point[-1]))[1:],
             max(h1, key=lambda point: (point[0], -point[-1]))[1]])
        h.remove(min(h, key=lambda point: (point[0], point[1], point[-1])))
        h1.remove(max(h1, key=lambda point: (point[0], -point[1])))
    return sorted(g, key=lambda point: (point[1]))


def merge(lst, res):
    for el in lst:
        merge(el, res) \
            if isinstance(el, list) else res.append(el)
    return res


def handler(q3):
    q4 = []
    i = 0
    while i != len(q3):
        q6 = []
        a = q3[i]
        p = merge(a, q6)
        q4.append(p)
        i = i + 1
    return q4


def serverFarm(jobs, servers):
    f = []
    k = 0
    y = 0
    a1 = []
    for i in jobs:
        f.append([i, k])
        k = k + 1
    b = sorted(f, key=lambda point: (-point[0], point[1]))
    a = massive_part(servers, b, 0)
    i = 0
    while i < len(a):
        a1.append([a[i][0], y, a[i][1]])
        y = y + 1
        i = i + 1
    i = servers
    r = [0 for x in range(servers)]
    if servers < len(jobs):
        while i < len(jobs):
            c = massive_part(servers, b, i)
            for j in handler(a1):
                r[j[1]] = j
            q = special_sort(a1, c)
            a1 = q
            i = i + servers
            for j in handler(q):
                r[j[1]] = j
    else:
        r = a1
    r1 = []
    for i in r:
        r1.append(i[2:])
    i = len(r)
    while i != servers:
        r1.append([])
        i = i + 1
    return r1


class Unittest(unittest.TestCase):

    def test1_serverFarm(self):
        jobs = [15, 30, 15, 5, 10]
        servers = 3
        result = serverFarm(jobs, servers)
        self.assertEqual(result, [[1], [0, 4], [2, 3]])

    def test2_serverFarm(self):
        jobs = [15, 2, 14, 14, 14, 258]
        servers = 8
        result = serverFarm(jobs, servers)
        self.assertEqual(result, [[5], [0], [2], [3], [4], [1], [], []])

    def test3_serverFarm(self):
        jobs = []
        servers = 8
        result = serverFarm(jobs, servers)
        self.assertEqual(result, [[], [], [], [], [], [], [], []])

    def test4_serverFarm(self):
        jobs = [4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4]
        servers = 2
        result = serverFarm(jobs, servers)
        self.assertEqual(result, [[0, 2, 4, 6, 8, 10, 12], [1, 3, 5, 7, 9, 11]])

    def test5_serverFarm(self):
        jobs = [8, 7, 15, 15, 13, 6, 18, 4, 16, 1, 2, 19, 2, 15, 18, 6, 20, 16, 10, 7, 3, 7, 9, 7, 12, 1, 16, 15, 7, 12,
                20, 17, 17, 4, 20, 15, 20, 6, 15, 3, 5, 17, 5, 5, 19, 17, 4, 15, 2, 7]
        servers = 9
        result = serverFarm(jobs, servers)
        self.assertEqual(result,
                         [[16, 26, 22, 0, 40, 10], [30, 2, 35, 49, 39], [34, 3, 38, 5, 33], [36, 13, 47, 15, 46],
                          [11, 8, 4, 23, 7, 48], [44, 17, 24, 19, 42, 9], [6, 41, 29, 21, 43, 25],
                          [14, 45, 18, 1, 37, 12], [31, 32, 27, 28, 20]])

if __name__ == "__main__":
    unittest.main()
