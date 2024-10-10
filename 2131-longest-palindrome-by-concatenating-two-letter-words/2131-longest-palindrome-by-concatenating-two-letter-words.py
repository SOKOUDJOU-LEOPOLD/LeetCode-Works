from collections import Counter
class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        #create dictionary
        dicto = Counter(words)
        # print(dicto)
        
       #sort dictionary with respect ot length
        sorted_items = sorted(dicto.items(), key=lambda kv: -kv[1])
        # print(sorted_items)
        flag=True # keep track if we took the longest doubles odd
        total = 0
        for item in sorted_items:
            # print(dicto)
            # print("*** item :: ", item)
            #if reverse exist
            reverse = item[0][1]+item[0][0]
            # print(reverse)
            if reverse in dicto:
                # print("reverse in dictionary: ",reverse)
                # print(dicto[reverse])
                size = min(dicto[item[0]], dicto[reverse])
                # print("minimum word and reverse size: ", size)
                #if we have word and reverse
                if reverse != item[0]:
                    # print("reverse is diff from word")
                    total += (size*2)
                    # if size%2 == 0:
                    #     total += (size*2)
                    # else:
                    #     total += (size*2)
                    dicto[reverse] = 0
                    # print("dicto[reverse] becomes 0")
                #if we have double i.e. reverse == word
                else:
                    # print("reverse is equal to word")
                    # finding 1st double count that is odd
                    if dicto[item[0]]%2 !=0:
                        if flag:
                            total += dicto[item[0]]
                            flag = False
                        else:
                            total += dicto[item[0]]-1
                    #if double is even
                    else:
                        total += dicto[item[0]]                
            #if no reverse
            else:
                continue
        
        return total*2     







            







        