'''
242. Valid Anagram
Solved
Easy
Topics
conpanies icon
Companies
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
'''
def isAnagram(s: str, t: str) -> bool:
    # Sort both strings and compare
    return sorted(s) == sorted(t)

if __name__ == "__main__":
    import sys
    input = sys.stdin.read
    data = input().splitlines()
    s = data[0].strip()
    t = data[1].strip()
    print(isAnagram(s, t))