

def countValidWords(s:str)->int:
    # check length > 3
    def checkLength(word):
        return len(word) >= 3

    # check only alphanumerics
    def checkAlphanumeric(word):
        return word.isalnum()
    # check atleast 1 vowels
    def checkVowel(word):
        vowels = {"a","e","i","o","u"}
        for vowel in vowels:
            if vowel in word:
                return True
        return False
    # check atleast 1 consonant
    def checkConsonant(word):
        vowels = {"a","e","i","o","u"}
        for char in word:
            if char not in vowels:
                return True
        return False
    # traverse the string
    words = s.split(" ")
    counter = 0
    for word in words:
        if checkLength(word) and checkAlphanumeric(word) and checkVowel(word) and checkConsonant(word):
            counter += 1
    
    return counter

# Test 1:
s = "This is Form16 submis$ion date"
print(countValidWords(s))