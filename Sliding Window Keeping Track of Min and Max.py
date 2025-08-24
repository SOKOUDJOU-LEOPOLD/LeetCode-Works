'''
Yes 👍 — what you wrote here is the classic way of solving this type of problem efficiently. Let me break it down:

🔑 Core idea

You’re maintaining a sliding window (l..r).

To keep track of maximum and minimum in the current window, you use monotonic deques:

maxDeque: strictly decreasing (front is the max).

minDeque: strictly increasing (front is the min).

Each time you move r forward:

Push nums[r] into both deques (maintaining monotonicity).

Check if the condition max - min <= limit is still valid. If not, shrink from the left until it holds.

The max length is updated at each step.

This gives O(n) time complexity since each element enters and leaves each deque at most once.
This is the standard optimal solution for problems where you need the max and min of a sliding window in amortized constant time.

📌 Does this work for all similar problems?

It works whenever you have:

A sliding window where you need to track the min/max efficiently.

Conditions of the form:

max - min <= some_limit

or “window is valid if max <= threshold”

or “window is valid if min >= threshold”

Typical problems:

[LC 1438. Longest Continuous Subarray With Absolute Diff ≤ Limit] ← your exact problem

[LC 239. Sliding Window Maximum]

[LC 480. Sliding Window Median] (though median requires two heaps instead)

[LC 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit] (Medium)

Range queries in streaming data.

🚀 Why it’s classic

It avoids recomputing min/max by brute force (O(n^2)) or heaps with deletions (O(n log n)).

Monotonic deque is the go-to trick for sliding windows with min/max.

✅ Your implementation is spot on.
✅ It’s the classic and optimal solution (O(n)).
✅ And yes — it generalizes to almost all sliding window problems where min/max is needed.

'''

# LC 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit. (Medium) 


from collections import deque

class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        maxLen = 0
        l = 0
        maxDeque, minDeque = deque(), deque()  # monotonic queues

        for r in range(len(nums)):
            print(r)
            # maintain decreasing deque for max
            while maxDeque and nums[r] > maxDeque[-1]:
                maxDeque.pop()
            maxDeque.append(nums[r])
            print("maxDeque: ", maxDeque)

            # maintain increasing deque for min
            while minDeque and nums[r] < minDeque[-1]:
                minDeque.pop()
            minDeque.append(nums[r])
            print("minDeque: ",minDeque)

            # shrink window if condition breaks
            while maxDeque[0] - minDeque[0] > limit:
                if nums[l] == maxDeque[0]:
                    maxDeque.popleft()
                if nums[l] == minDeque[0]:
                    minDeque.popleft()
                l += 1

            maxLen = max(maxLen, r - l + 1)

        return maxLen
