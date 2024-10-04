

def max_fish_caught(fish, baits):
    fish_size = len(fish)
    baits_size = len(baits)
    #sorting baits and fish in descending order
    baits.sort(reverse = True)
    fish.sort(reverse = True)

    #defining total fish caught and pointer
    total_fish=0
    pf = 0

    for bait in baits:
        times = 0
        while pf < fish_size and times < 3:
            if bait < fish[pf]:
                pf +=1 
                total_fish +=1
                times += 1
            else:
                break

    return total_fish

